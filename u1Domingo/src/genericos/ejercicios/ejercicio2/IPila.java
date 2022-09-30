package genericos.ejercicios.ejercicio2;

public interface IPila<T> {
	
	public boolean estaVacia();
	
	/**
	 * Devuelve y elimina el primer elemento
	 * 
	 * @return primer elemento
	 */
	
	public T extraer();
	
	/**
	 * Devuelve el primer elemento
	 * 
	 * @return primer elemento
	 */
	
	public T primero();
	
	public void aniadir(T t);
}
