package org.iesvdm.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Pedido;
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
public class PedidosDAOImpl implements PedidosDAO {

	// JdbcTemplate se inyecta por el constructor de la clase automaticamente
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Pedido> getAll() {

		List<Pedido> listPed = jdbcTemplate.query("SELECT * FROM pedido",
				(rs, rowNum) -> new Pedido(rs.getInt("id"), rs.getDouble("total"), rs.getString("fecha"),
						rs.getInt("id_cliente"), rs.getInt("id_comercial")));

		log.info("Devueltos {} registros.", listPed.size());

		return listPed;
	}

}
