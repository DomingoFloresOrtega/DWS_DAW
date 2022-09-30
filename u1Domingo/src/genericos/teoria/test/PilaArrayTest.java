package genericos.teoria.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PilaArrayTest {

	@Test
	void testPilaArray() {
		Pila pila = new Pila();
		
		assertEquals(true, pila instanceof Pila);
	}

	@Test
	void testEstaVacia() {
		Pila pila = new Pila();
		
		if (pila.estaVacia() == true) {
			System.out.println("Test correcto");
		}
	}

	@Test
	void testExtraer() {
		Pila pila = new Pila();
		
		pila.aniadir("Hola");
		
		pila.extraer();
		
		if (pila.estaVacia() == true) {
			System.out.println("Test correcto");
		}
	}

	@Test
	void testPrimero() {
		Pila pila = new Pila();
		
		pila.aniadir("Primero");
		pila.aniadir("Adios");
		
		if (pila.primero().equals("Adios")) {
			System.out.println("Todo correcto");
		}
		
	}

	@Test
	void testAniadir() {
		Pila pila = new Pila();
		
		pila.aniadir("2");
		
		assertEquals("2",pila.primero());
		
	}

}
