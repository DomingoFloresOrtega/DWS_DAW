package anotaciones.teoria;

public class Anotaciones {
	
	@Override // Anotacion para herencia
	public boolean estaVacia(String mensaje) {
		return true;
	}
	
	@SuppressWarnings // Ignora advertencias especificas
	public boolean estaVacia2(String mensaje) {
		return true;
	}
}
