package util;

import org.junit.Assert;
import org.junit.Test;

import ejercito.*;

public class AvionetaTest {


	@Test
	public void testPuedeEquipar() {
		Armamento armamento = new Armamento(500, 3000, 1700);
		Avioneta avioneta = new Avioneta();
		Assert.assertTrue(avioneta.equipar(armamento));
	}
	
	@Test
	 public void testPuedeEquiparObjetivoMuyLejos() {
		Armamento armamento = new Armamento(500, 3000, 1701);
		Avioneta avioneta = new Avioneta();
		Assert.assertFalse(avioneta.equipar(armamento));
	}
	@Test
	 public void testPuedeEquiparObjetivoMuyCercanos() {
		Armamento armamento = new Armamento(500, 3000, 499);
		Avioneta avioneta = new Avioneta();
		Assert.assertFalse(avioneta.equipar(armamento));
	}
	@Test
	public void testPuedeEquiparArmaMuyGrande() {
		Armamento armamento = new Armamento(500, 3001, 1700);
		Avioneta avioneta = new Avioneta();
		Assert.assertFalse(avioneta.equipar(armamento));
	}
	@Test
	public void testPuedeEquiparMuchoVolumen() {
		Armamento armamento = new Armamento(501, 3000, 1700);
		Avioneta avioneta = new Avioneta();
		Assert.assertFalse(avioneta.equipar(armamento));
	}
	
	@Test
	public void testPuedeEquipar2ArmasPeroSePasaElvolumen() {
		Armamento arma = new Armamento(300, 1500, 1700);
		Armamento arma2 = new Armamento(300, 1500, 1700);
		Avioneta avioneta = new Avioneta();
		
		Assert.assertTrue(avioneta.equipar(arma));
		Assert.assertFalse(avioneta.equipar(arma2));
	}
	@Test
	public void testPuedeEquiparMuchasArmasDePocoVolumenYPocoPeso() {
		Armamento arma = new Armamento(0.0000005, 1, 1700);
		Armamento arma2 = new Armamento(0.0000005, 1, 1700);
		Armamento arma3 = new Armamento(0.0000005, 1, 1700);
		Armamento arma4 = new Armamento(0.0000005, 1, 1700);
		Armamento arma5 = new Armamento(0.0000005, 1, 1700);
		Armamento arma6 = new Armamento(0.0000005, 1, 1700);
		Armamento arma7 = new Armamento(0.0000005, 1, 1700);
		Armamento arma8 = new Armamento(0.0000005, 1, 1700);
		Armamento arma9 = new Armamento(0.0000005, 1, 1700);
		Avioneta avioneta = new Avioneta();

		Assert.assertTrue(avioneta.equipar(arma));
		Assert.assertTrue(avioneta.equipar(arma2));
		Assert.assertTrue(avioneta.equipar(arma3));
		Assert.assertTrue(avioneta.equipar(arma4));
		Assert.assertTrue(avioneta.equipar(arma5));
		Assert.assertTrue(avioneta.equipar(arma6));
		Assert.assertTrue(avioneta.equipar(arma7));
		Assert.assertTrue(avioneta.equipar(arma8));
		Assert.assertTrue(avioneta.equipar(arma9));
		
	}
	@Test
	public void testPuedeEquipar2ArmasPeroUnaTieneMuchaDistancia() {
		Armamento arma = new Armamento(200, 1500, 1700);
		Armamento arma2 = new Armamento(300, 1500, 1701);
		Avioneta avioneta = new Avioneta();
		
		Assert.assertTrue(avioneta.equipar(arma));
		Assert.assertFalse(avioneta.equipar(arma2));		
	}
	@Test
	public void testPuedeEquipar2ArmasPeroSePasaElPeso() {
		Armamento arma = new Armamento(200, 1501, 1700);
		Armamento arma2 = new Armamento(300, 1500, 1700);
		Avioneta avioneta = new Avioneta();
		
		Assert.assertTrue(avioneta.equipar(arma));
		Assert.assertFalse(avioneta.equipar(arma2));
	}
	

}
