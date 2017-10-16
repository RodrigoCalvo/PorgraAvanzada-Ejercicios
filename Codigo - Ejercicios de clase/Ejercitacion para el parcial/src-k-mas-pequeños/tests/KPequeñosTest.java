package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ejercicio.KPequeños;

public class KPequeñosTest {

	@Test
	public void test() {
		KPequeños k = new KPequeños("src-k-mas-pequeños/", "entrada.in");
		
		k.preparar();
		k.GuardarResultado();
	}

}
