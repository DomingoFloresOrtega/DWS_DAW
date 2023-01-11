package org.iesvdm.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Stat;
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
public class StatsDAOImpl implements StatsDAO {

	// JdbcTemplate se inyecta por el constructor de la clase automaticamente
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Stat> getStats(int id) {

		List<Stat> listPed = jdbcTemplate.query("SELECT AVG(p.id) as media, SUM(p.id) as suma, MAX(p.id) as maximo, MIN(p.id) as minimo, c.id FROM pedido p JOIN comercial c ON p.id_comercial = c.id WHERE p.id_comercial = ? GROUP BY c.id",
				(rs, rowNum) -> new Stat(rs.getInt("id"), rs.getInt("suma"), rs.getDouble("media"), rs.getInt("maximo"), rs.getInt("minimo")), id);

		log.info("Devueltos {} registros.", listPed.size());

		return listPed;
	}

}
