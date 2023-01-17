package org.iesvdm.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Cliente;
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

		List<Stat> listStat = jdbcTemplate.query("SELECT AVG(p.id) as media, COUNT(p.id) as suma, MAX(p.id) as maximo, MIN(p.id) as minimo, c.id FROM pedido p JOIN comercial c ON p.id_comercial = c.id WHERE p.id_comercial = ? GROUP BY c.id",
				(rs, rowNum) -> new Stat(rs.getInt("id"), rs.getInt("suma"), rs.getDouble("media"), rs.getInt("maximo"), rs.getInt("minimo")), id);

		log.info("Devueltos {} registros.", listStat.size());

		return listStat;
	}
	
	@Override
	public List<Stat> getStatsMax(int id) {

		List<Stat> listStatMax = jdbcTemplate.query("SELECT id FROM pedido WHERE total = (SELECT MAX(total) FROM pedido WHERE id_comercial = ?);",
				(rs, rowNum) -> new Stat(rs.getInt("id"), 1, 2.5, 2, 2), id);

		log.info("Devueltos {} registros.", listStatMax.size());

		return listStatMax;
	}
	
	@Override
	public List<Stat> getStatsMin(int id) {

		List<Stat> listStatMin = jdbcTemplate.query("SELECT id FROM pedido WHERE total = (SELECT MIN(total) FROM pedido WHERE id_comercial = ?);",
				(rs, rowNum) -> new Stat(rs.getInt("id"), 1, 2.5, 2, 2), id);

		log.info("Devueltos {} registros.", listStatMin.size());

		return listStatMin;
	}
	
	@Override
	public List<Cliente> getStatsClientes(int id) {

		List<Cliente> listStatCli = jdbcTemplate.query("SELECT * FROM cliente c JOIN pedido p ON c.id = p.id_cliente WHERE p.id_comercial = ? ORDER BY p.total DESC;",
				(rs, rowNum) -> new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("ciudad"), rs.getInt("categoría")), id);

		log.info("Devueltos {} registros.", listStatCli.size());

		return listStatCli;
	}

}
