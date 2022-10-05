package genericos.ejercicios.ejercicio5;

import genericos.ejercicios.ejercicio1.Pila;

public interface ColeccionSimpleGenerica<T> {
	
	Pila p = new Pila();
	
	public default boolean estaVacia() {
		if (p.estaVacia() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public default T extraer() {
		return (T) p.extraer();
	}
	
	public default T primero() {
		return (T) p.primero();
	}
	public default void aniadir(T objeto) {
		p.aniadir(objeto);
	}
}
