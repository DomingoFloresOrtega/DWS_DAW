package es.iesvegademijas.genericos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.mapping.Map;

public class Bag<T> {
	
	List<T> lista;
	
	public Bag() {
		lista = new ArrayList<>();
	}
	
	public void add(T e) {
		lista.add(e);
	}
	
	public void add(T e, int n) {
		 for (int i = 0; i < n; i++){
			 lista.add(e);
		 }
	}
	
	public int getCount(T e) {
		int contador = 0;
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) == e) {
				contador++;
			}
		}
		
		return contador;
	}
	
	public void remove(T e) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) == e) {
				lista.remove(i);
			}
		}
	}
	
	public void remove (T e, int n) {
		int contador = n;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) == e) {
				if (contador != 0) {
					lista.remove(e);
					contador--;
				}
			}
		}
	}
	
	public int size() {
		return lista.size();
	}
	
	public Set uniqueSet() {
		Set<T> listaSet = new TreeSet();
		
		for (T t : lista) {
			listaSet.add(t);
		}
		
		return listaSet;
	}
	
	@Override
	public String toString() {
		for (T t : lista) {
			return (String) t;
		}
		
		return "";
	}
}
