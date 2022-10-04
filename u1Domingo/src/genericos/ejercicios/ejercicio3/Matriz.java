package genericos.ejercicios.ejercicio3;

/**
 * 
 * @author domingo
 *
 * @param <T>
 */

public class Matriz<T> {
	
	private T[][] matriz;
	
	public Matriz(int fila, int columna) {
		this.matriz = (T[][]) new Object[fila][columna];
	}
	
	public void setMatriz(int fila, int columna, T elemento) {
		matriz[fila][columna] = elemento;
	}
	
	public T getMatriz(int fila, int columna) {
		return matriz[fila][columna];
	}
	
	public void columnas() {
		
	}
	
	public void filas() {
		
	}
	
	public String toString() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				return (String) matriz[i][j];
			}
		}
		
		return " ";
	}
}
