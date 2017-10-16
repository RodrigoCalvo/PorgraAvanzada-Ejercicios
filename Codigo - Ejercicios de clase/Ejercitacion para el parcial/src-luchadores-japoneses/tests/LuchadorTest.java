package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ejercicio.Torneo;

public class LuchadorTest {

	@Test
	public void test() {
		String folder = "src-luchadores-japoneses/";
		Torneo torneo = new Torneo(folder, "entrada.in");
		
		torneo.Preparar();
		torneo.GuardarResultado();
	}

}
