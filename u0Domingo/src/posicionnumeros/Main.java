package posicionnumeros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int numero, digito;
		Scanner teclado = new Scanner(System.in);
		
		try {
			// Pido numero
			System.out.println("Introduzca un numero:");
			numero = teclado.nextInt();
			
			// Pido digito
			System.out.println("Introduzca un digito:");
			digito = teclado.nextInt();
			
			posicionDigito(numero, digito);
			
		} catch (InputMismatchException ime) {
			System.out.println("Numero erroneo");
		}

	}
	
	public static void posicionDigito(int numero, int digito) {
		char[] numeroC;
		char numeroCh;
		String numeroSt;
		
		// Paso de int a string
		numeroSt = String.valueOf(numero);
		
		// Paso de int a char
		numeroCh = Integer.toString(digito).charAt(0);
		
		// Convierto String en array Char
		numeroC = numeroSt.toCharArray();
		
		// Recorro array
		for (int i = 0; i < numeroC.length; i++) {
			char numeroCom = numeroSt.charAt(i);
			
			// Compruebo
			if (numeroCom == numeroCh) {
				System.out.println("El digito ocupa el " + (i+1) +" lugar");
			}
		}
	}
}
