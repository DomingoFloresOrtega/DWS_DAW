package genericos.ejercicios.ejercicio4;

public class MatrizInt {
	public static void main(String[] args) {
		Integer[][] matriz = new Integer[4][2];
		int contador = 1;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = contador;
				contador++;
				System.out.println("Matriz [" + i + "]" + "[" + j + "] = " + matriz[i][j]);
			}
		}
		
		System.out.println("=================");
		System.out.println("Matriz [1][2] = " + matriz[1][1]);
	}
}
