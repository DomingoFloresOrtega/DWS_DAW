package genericos.ejercicios.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class Pila<T> {
	
	private List<T> lista;
	
	public Pila() {
		this.lista = new LinkedList<T>();
	}
	
	public Pila(List<T> lista) {
		this.lista = lista;
	}
	
	public boolean estaVacia() {
		return lista.isEmpty();
	}
	
	public T extraer() {
		return lista.removeLast();
	}
	
	public T primero() {
		return lista.get(0);
	}
	
	public T aniadir() {
		lista.add(new Object());
	}
	
	public void toString() {
		System.out.println(lista.toString());
	}
}
