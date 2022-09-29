package genericos.ejercicios.ejercicio2;

public interface IPila<T> {
	
	public boolean estaVacia();
	
	/**
	 * Devuelve el primer elemento
	 * 
	 * @return primer elemento
	 */
	
	public T extraer();
	
	public T primero();
	
	public void aniadir(T t);
	
	public String toString();
}
