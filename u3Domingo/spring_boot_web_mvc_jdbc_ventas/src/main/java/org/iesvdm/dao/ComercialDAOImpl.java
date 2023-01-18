package org.iesvdm.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Comercial;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
// Utilizo lombok para generar el constructor
@AllArgsConstructor
public class ComercialDAOImpl implements ComercialDAO {

	// JdbcTemplate se inyecta por el constructor de la clase automaticamente
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(Comercial comercial) {
		String sqlInsert = """
				INSERT INTO comercial (nombre, apellido1, apellido2, comisión)
				VALUES  (     ?,         ?,         ?,       ?)
				  """;

		KeyHolder keyHolder = new GeneratedKeyHolder();

		// Con recuperación de id generado
		int rows = jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
			int idx = 1;
			ps.setString(idx++, comercial.getNombre());
			ps.setString(idx++, comercial.getApellido1());
			ps.setString(idx++, comercial.getApellido2());
			ps.setBigDecimal(idx++, comercial.getComision());
			return ps;
		}, keyHolder);

		comercial.setId(keyHolder.getKey().intValue());

		log.info("Insertados {} registros.", rows);

	}

	@Override
	public List<Comercial> getAll() {

		List<Comercial> listCom = jdbcTemplate.query("SELECT * FROM comercial",
				(rs, rowNum) -> new Comercial(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getBigDecimal("comisión")));

		log.info("Devueltos {} registros.", listCom.size());

		return listCom;
	}

	@Override
	public Optional<Comercial> find(int id) {
		Comercial com = jdbcTemplate.queryForObject("SELECT * FROM comercial WHERE id = ?",
				(rs, rowNum) -> new Comercial(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getBigDecimal("comisión")),
				id);

		if (com != null) {
			return Optional.of(com);
		} else {
			log.info("Comercial no encontrado.");
			return Optional.empty();
		}
	}

	@Override
	public void update(Comercial comercial) {
		int rows = jdbcTemplate.update("""
				UPDATE comercial SET
								nombre = ?,
								apellido1 = ?,
								apellido2 = ?,
								comisión = ?
						WHERE id = ?
				""", comercial.getNombre(), comercial.getApellido1(), comercial.getApellido2(), comercial.getComision(), 
				comercial.getId());

		log.info("Update de Comercial con {} registros actualizados.", rows);

	}

	@Override
	public void delete(int id) {
		int rows = jdbcTemplate.update("DELETE FROM comercial WHERE id = ?", id);
		
		log.info("Delete de Comercial con {} registros eliminados.", rows);

	}

}
