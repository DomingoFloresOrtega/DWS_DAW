package calculadoraprecios;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		double baseImponible, precioTotal;
		String tipoIva = "";
		String codPromo = "";
		
		System.out.println("Introduzca la base imponible:");
		baseImponible = teclado.nextDouble();
		
		// Limpio buffer
		teclado.nextLine();
		
		if (baseImponible > 0) {
			System.out.println("Introduzca el tipo de IVA (general, reducido o superreducido):");
			tipoIva = teclado.nextLine();
			
			if (tipoIva != " ") {
				System.out.println("Introduzca el código promocional (nopro, mitad, meno5 o 5porc):");
				codPromo = teclado.nextLine();
			}
		}
		
		// Cerramos Scanner
		teclado.close();
		
		System.out.println("===================");
		System.out.println("Base imponible --> " + baseImponible);
		System.out.println("IVA (" + tiposIva(tipoIva) + ") --> " + tiposIvas(tipoIva, baseImponible));
		precioTotal = (baseImponible + tiposIvas(tipoIva, baseImponible));
		System.out.println("Precio con IVA --> " + precioTotal);
		System.out.println("Cód. promo. (" + codPromo + ") --> -" + tiposPromo(codPromo, precioTotal));
		System.out.println("TOTAL " + (precioTotal-tiposPromo(codPromo, precioTotal)));

	}
	
	// Tipos de IVA
	public static String tiposIva(String tipoIva) {
		if (tipoIva.equalsIgnoreCase("general")) {
			return "21%";
		} else if (tipoIva.equalsIgnoreCase("reducido")) {
			return "10%";
		} else if (tipoIva.equalsIgnoreCase("superreducido")) {
			return "4%";
		}
		
		return "";
	}
	
	public static double tiposIvas(String tipoIva, double baseImponible) {
		if (tipoIva.equalsIgnoreCase("general")) {
			return baseImponible*21 / 100;
		} else if (tipoIva.equalsIgnoreCase("reducido")) {
			return baseImponible*10 / 100;
		} else if (tipoIva.equalsIgnoreCase("superreducido")) {
			return baseImponible*4 / 100;
		}
		
		return 0;
	}
	
	// Tipos de promo
	public static double tiposPromo(String tipoPromo, double precio) {
		double valor = 0;
		
		if (tipoPromo.equalsIgnoreCase("nopro")) {
			valor = 0;
		} else if (tipoPromo.equalsIgnoreCase("mitad")) {
			valor = (precio / 2);
		} else if (tipoPromo.equalsIgnoreCase("meno5")) {
			valor = 5;
		} else if (tipoPromo.equalsIgnoreCase("5porc")){
			valor = 0.5;
		}
		
		return valor;
	}

}
