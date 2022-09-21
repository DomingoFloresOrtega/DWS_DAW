package horario;

import java.util.Scanner;

public class Practica2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el dia de la semana");
		String opcion = teclado.nextLine();
		
		switch(opcion) {
			case "Lunes":
				System.out.println("Tienes programacion");
				break;
			case "Martes":
				System.out.println("Tienes programacion");
				break;
			case "Miercoles":
				System.out.println("Tienes entornos de desarrollo");
				break;
			case "Jueves":
				System.out.println("Tienes programacion");
				break;
			case "Viernes":
				System.out.println("Tienes bases de datos");
				break;
			case "Sabado":
			case "Domingo":
				System.out.println("Descanso");
				break;
			default:
				System.out.println("No ha escrito un dia");
				break;
		};
	}

}
