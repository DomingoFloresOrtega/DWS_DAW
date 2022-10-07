package genericos.ejercicios.ejercicio7;

public abstract class Main<E> implements Operable<E> {
	E resultado;
	
	public E sumar(E o) {
		resultado = o;
		return resultado;
	}
	public E restar(E o) {
		return resultado;
	}
	public E multiplicar(E o) {
		return resultado;
	}
	public E dividir(E o) {
		return resultado;
	}
}
