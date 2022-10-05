package anotaciones.calculadora;

public class Calculadora {

	@FunctionalInterface // Ayuda a que no se incluyan mas funciones en el codigo
	interface Matematicas {

		public double operacion(double x, double y);
		
		//public void mensaje(String mensaje);

	}

	public static void main(String[] args) {

		Matematicas o = (x, y) -> x + y; // Double::compare
		System.out.println("Suma: " + o.operacion(2, 3));
		
		o = (x, y) -> x * y;
		System.out.println("Producto: " + o.operacion(2, 3));

	}
}
