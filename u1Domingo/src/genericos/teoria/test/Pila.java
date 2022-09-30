package genericos.teoria.test;

import java.util.LinkedList;
import java.util.List;

import genericos.ejercicios.ejercicio2.IPila;

public class Pila<T> implements IPila<T>{
	
	private LinkedList<T> lista;
	
	public Pila() {
		this.lista = new LinkedList<T>();
	}
	
	public Pila(LinkedList<T> lista) {
		this.lista = lista;
	}
	
	public boolean estaVacia() {
		return lista.isEmpty();
	}
	
	public T extraer() {
		return lista.poll();
	}
	
	public T primero() {
		return lista.get(0);
	}
	
	public void aniadir(T t) {
		lista.push(t);
	}
	
	public String toString() {
		return lista.toString();
	}
	
	public static void main(String[] args) {
		Pila<String> pila = new Pila<>();
		
		pila.aniadir("HOLA");
		pila.aniadir("Adios");
		pila.aniadir("Regresar");
		
		System.out.println(pila);
		
		// Extraemos
		System.out.println("Extraigo " + pila.extraer());
		
		pila.aniadir("Vuelvo");
		System.out.println(pila);
	}
}
