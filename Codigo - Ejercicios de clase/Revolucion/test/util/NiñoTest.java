package util;



import org.junit.Assert;
import org.junit.Test;

import ejercito.*;

public class NiñoTest {

	@Test
	public void testPuedeEquiparArmaLiviana() {
		Armamento arma = new Armamento(20);
		
		Niño niño = new Niño();
		
		Assert.assertTrue(niño.equipar(arma));
	}
	@Test
	public void testPuedeEquiparArmaPesada() {
		Armamento arma = new Armamento(200);
		
		Niño niño = new Niño();
		
		Assert.assertFalse(niño.equipar(arma));
	}
	@Test
	public void testPuedeEquipar2ArmasLivianas() {
		Armamento arma = new Armamento(20);
		Armamento arma2 = new Armamento(40);
		
		Niño niño = new Niño();

		Assert.assertTrue(niño.equipar(arma));		
		Assert.assertTrue(niño.equipar(arma2));
	}
	@Test
	public void testPuedeEquipar2ArmasPesadas() {
		Armamento arma = new Armamento(80);
		Armamento arma2 = new Armamento(40);
		
		Niño niño = new Niño();

		Assert.assertTrue(niño.equipar(arma));		
		Assert.assertTrue(niño.equipar(arma2));
	}
	@Test
	public void testPuedeEquipar2ArmasPesadasQueSePasanDePeso() {
		Armamento arma = new Armamento(80);
		Armamento arma2 = new Armamento(41);
		
		Niño niño = new Niño();

		Assert.assertTrue(niño.equipar(arma));		
		Assert.assertFalse(niño.equipar(arma2));
	}
	@Test
	public void testPuedeEquipar3ArmasLivianas() {
		Armamento arma = new Armamento(20);
		Armamento arma2 = new Armamento(40);
		Armamento arma3 = new Armamento(60);
		
		Niño niño = new Niño();

		Assert.assertTrue(niño.equipar(arma));		
		Assert.assertTrue(niño.equipar(arma2));	
		Assert.assertFalse(niño.equipar(arma3));
	}
	@Test
	public void testPuedeEquipar3ArmasPesadas() {
		Armamento arma = new Armamento(2000);
		Armamento arma2 = new Armamento(40000);
		Armamento arma3 = new Armamento(6000);
		
		Niño niño = new Niño();

		Assert.assertFalse(niño.equipar(arma));		
		Assert.assertFalse(niño.equipar(arma2));	
		Assert.assertFalse(niño.equipar(arma3));
	}

}
