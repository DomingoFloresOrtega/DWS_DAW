package calculadornotas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean salir = true;
		
		do {
			try {
				Scanner teclado = new Scanner(System.in);
				
				System.out.println("Introduzca la nota del control 1:");
				double nota1 = teclado.nextDouble();
				
				System.out.println("Introduzca la nota del control 2:");
				double nota2 = teclado.nextDouble();
				
				salir = estaAprobado(nota1, nota2);
			} catch (InputMismatchException ime) {
				System.out.println("Ha introducido un valor incorrecto");
			}
		} while (salir);
	}
	
	public static boolean estaAprobado(double nota1, double nota2) {
		Scanner teclado = new Scanner(System.in);
		boolean salir = true;
		double media = (nota1 + nota2) / 2;
		
		if (media >= 5){
			System.out.println("Tu nota de programación es: " + media);
		} else{
			System.out.println("¿Cuál ha sido el resultado de la recuperación? (apto/no apto)");
			String resultadoRecu = teclado.nextLine();
			
			if (resultadoRecu.equalsIgnoreCase("apto")) {
				System.out.println("Tu nota de programación es 5");
			} else {
				System.out.println("Tu nota de programación es: " + media);
			}
			
		}
		
		return false;
	}

}
