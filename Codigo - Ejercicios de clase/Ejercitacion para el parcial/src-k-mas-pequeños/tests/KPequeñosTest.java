package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ejercicio.KPeque�os;

public class KPeque�osTest {

	@Test
	public void test() {
		KPeque�os k = new KPeque�os("src-k-mas-peque�os/", "entrada.in");
		
		k.preparar();
		k.GuardarResultado();
	}

}
