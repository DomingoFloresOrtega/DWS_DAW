package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//La anotación @Data de lombok proporcionará el código de: 
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")
public class Pedido {
	
	private int id;
	private double total;
	private String fecha;
	private int idCliente;
	private int idComercial;
	private String nombreCliente;
	private String ape1Cliente;
	private String ape2Cliente;
	
}
