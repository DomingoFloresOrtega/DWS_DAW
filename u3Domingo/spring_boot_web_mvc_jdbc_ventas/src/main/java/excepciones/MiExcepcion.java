package excepciones;

public class MiExcepcion extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MiExcepcion() {
		super("Mensaje de mi excepcion...");
	}
}
