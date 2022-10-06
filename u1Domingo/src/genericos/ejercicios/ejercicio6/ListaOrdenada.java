package genericos.ejercicios.ejercicio6;

import java.util.ArrayList;

public abstract class ListaOrdenada<E extends Comparable<E>> {
	
	ArrayList<E> lista = new ArrayList<E>();
	
	public ListaOrdenada(Comparable<E> e) {
		this.lista = lista;
	}
	
	public void add (E o) {
		lista.add(o);
	}
	
	public int size() {
		return lista.size();
	}
	
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	
	public boolean remove(E o) {
		return lista.remove(o);
	}
	
	public int indexOf(E o) {
		return lista.indexOf(o);
	}
	
	public String toString() {
		return lista.toString();
	}
}
