package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import exception.IlegalDirectionException;
import exception.NumeroparException;
import model.Cuadrado;

class CuadradoTest {
	
	private Cuadrado c;
	
	private void setupEscenario1() {
		
		c = new Cuadrado (0);
	}
	
	private void setupEscenario2() {
		
		c = new Cuadrado (2);
	}
	
	private void setupEscenario3() {
		
		c = new Cuadrado (3);
	}
	
	private void setupEscenario4() {
		
		c = new Cuadrado (5);
		
	}

	@Test
	void testGenerarCuadrado() {
		
		setupEscenario1();
		int[][] m = c.getMatriz();
		assertNull("El cuadrado esta null", m);	
	}

	@Test
	void testGenerarCuadradoPar() throws NumeroparException {
		setupEscenario2();
		
		int[][] m = c.getMatriz();
		
		assertNull("La matriz es nula", m);
	}
	
	@Test
	void testGenerarCuadradoImpar() {
		
		setupEscenario3();
		
		int[][] m = c.getMatriz();
		
		assertNotNull("La matriz se genera correctamente", m);	
	}
	
	@Test
	void testGenerarCuadradoM() throws IlegalDirectionException {
		
		setupEscenario4();
		c.generarCuadradoMag(c.SO, c.arriba);	
		fail("Se esperaba excepcion IlegalDirectionException");
		
		}
	
	
}
