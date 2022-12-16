package org.iesvdm.genericos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Queue<T> {
	List<T> lista;
	
	public Queue() {
		lista = new ArrayList<>();
	}
	
	public void enqueue(T e) {
		 lista.add(e);
	}
	
	public void dequeue(T e) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) == e) {
				lista.remove(i);
			}
		}
	}
	
	public T front() {
		return lista.get(0);
	}
	
	public T rear() {
		return lista.get(lista.size()-1);
	}
	
	public boolean vacío() {
		return lista.isEmpty();
	}
}
