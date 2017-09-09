package util;



import org.junit.Assert;
import org.junit.Test;

import ejercito.*;

public class Ni�oTest {

	@Test
	public void testPuedeEquiparArmaLiviana() {
		Armamento arma = new Armamento(20);
		
		Ni�o ni�o = new Ni�o();
		
		Assert.assertTrue(ni�o.equipar(arma));
	}
	@Test
	public void testPuedeEquiparArmaPesada() {
		Armamento arma = new Armamento(200);
		
		Ni�o ni�o = new Ni�o();
		
		Assert.assertFalse(ni�o.equipar(arma));
	}
	@Test
	public void testPuedeEquipar2ArmasLivianas() {
		Armamento arma = new Armamento(20);
		Armamento arma2 = new Armamento(40);
		
		Ni�o ni�o = new Ni�o();

		Assert.assertTrue(ni�o.equipar(arma));		
		Assert.assertTrue(ni�o.equipar(arma2));
	}
	@Test
	public void testPuedeEquipar2ArmasPesadas() {
		Armamento arma = new Armamento(80);
		Armamento arma2 = new Armamento(40);
		
		Ni�o ni�o = new Ni�o();

		Assert.assertTrue(ni�o.equipar(arma));		
		Assert.assertTrue(ni�o.equipar(arma2));
	}
	@Test
	public void testPuedeEquipar2ArmasPesadasQueSePasanDePeso() {
		Armamento arma = new Armamento(80);
		Armamento arma2 = new Armamento(41);
		
		Ni�o ni�o = new Ni�o();

		Assert.assertTrue(ni�o.equipar(arma));		
		Assert.assertFalse(ni�o.equipar(arma2));
	}
	@Test
	public void testPuedeEquipar3ArmasLivianas() {
		Armamento arma = new Armamento(20);
		Armamento arma2 = new Armamento(40);
		Armamento arma3 = new Armamento(60);
		
		Ni�o ni�o = new Ni�o();

		Assert.assertTrue(ni�o.equipar(arma));		
		Assert.assertTrue(ni�o.equipar(arma2));	
		Assert.assertFalse(ni�o.equipar(arma3));
	}
	@Test
	public void testPuedeEquipar3ArmasPesadas() {
		Armamento arma = new Armamento(2000);
		Armamento arma2 = new Armamento(40000);
		Armamento arma3 = new Armamento(6000);
		
		Ni�o ni�o = new Ni�o();

		Assert.assertFalse(ni�o.equipar(arma));		
		Assert.assertFalse(ni�o.equipar(arma2));	
		Assert.assertFalse(ni�o.equipar(arma3));
	}

}
