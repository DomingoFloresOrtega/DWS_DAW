package buclenumeros;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean salir = true;
		Scanner teclado = new Scanner(System.in);
		int numero = 0, contadorImpares = 0, maxPar = 0, mediaImpares = 0, contador = 0;
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		do {
			System.out.println("Introduzca numero:");
			numero = teclado.nextInt();
			
			// Si el numero es negativo saldra del programa
			if (numero < 0) {
				salir = false;
			} else {
				array.add(numero);
			}
			
			// Si el numero es impar
			if ((numero % 2) == 1) {
				mediaImpares =+ numero;
				contadorImpares++;
			} else if (numero > maxPar) {
				maxPar = numero;
			}
			
			// Contador de control
			if (numero > 0) {
				contador++;
			}
			
			// Cerramos Scanner
			teclado.close();
			
		} while(salir);
		
		// Si esta correcto, analizamos
		if (contador > 0) {
			System.out.println("=====================");
			System.out.println("Se han introducido " + array.size() + " numeros");
			System.out.println("La media de los impares es " + (mediaImpares/contadorImpares*1.0));
			System.out.println("El numero par maximo es " + maxPar);
			System.out.println("=====================");
		} else {
			System.out.println("No se han introducido valores");
		}
	}

}
