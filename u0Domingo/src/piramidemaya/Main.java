package piramidemaya;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("=== PINTAR PIRAMIDE MAYA ===");
		// Pido altura
		System.out.println("Introduzca la altura de la piramide: ");
		int altura = teclado.nextInt();
		
		// Paso altura por parametro
		pintarPiramide(altura);
		

	}
	
	public static void pintarPiramide(int altura) {
		// Creo piramide
		for (int i = 1; i <= altura; i++) {
			System.out.println();
			for (int j = altura; j > i; j--) {
				System.out.print(" ");
			}
			
			for (int j = altura - i; j < altura; j++) {
				System.out.print("*");
			}
			
			if (i % 2 == 1) {
				System.out.print("****");
			} else {
				System.out.print("    ");
			}
			
			for (int j = altura-i; j < altura; j++) {
				System.out.print("*");
			}
		}
		System.out.println();
	}

}
