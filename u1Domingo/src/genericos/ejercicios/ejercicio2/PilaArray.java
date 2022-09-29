package genericos.ejercicios.ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;

import genericos.ejercicios.ejercicio1.Pila;

public abstract class PilaArray<T> implements IPila<T>{

	private T [] array;
	private int contador;
	
	public PilaArray() {
		this.array = (T[])new Object[0];
	}
	
	@Override
	public boolean estaVacia() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public T extraer() {
		// TODO Auto-generated method stub
		if (contador > 0) {
			T t = array[contador];
			array = Arrays.copyOf(array, --contador);
			return t;
		} else {
			return null;
		}
	}
	
	@Override
	public T primero() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void aniadir(T t) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
