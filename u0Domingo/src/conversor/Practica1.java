package conversor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Practica1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca la cantidad de euros que quiere convertir");
		double euros = Double.valueOf(teclado.nextLine());
		teclado.close();
		
		BigDecimal cantidadPts = new BigDecimal(10000);
		BigDecimal factor = new BigDecimal(166.386f);
		BigDecimal total = BigDecimal.valueOf(euros).divide(factor,7,RoundingMode.HALF_UP); // Otra opcion es poner %.7f en SYSOUT
		
		System.out.println("Cantidad total: " + total.setScale(7,RoundingMode.HALF_UP).toPlainString());
		
	}

}