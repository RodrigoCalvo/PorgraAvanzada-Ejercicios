package util;



import org.junit.Assert;
import org.junit.Test;
import ejercito.*;

public class ViejaTest {

	@Test
	public void testPuedeEquipar() {
		Armamento arma = new Armamento(0.200, 200);
		Vieja vieja = new Vieja();
		
		Assert.assertTrue(vieja.equipar(arma));
	}
	
	@Test
	public void testPuedeEquiparObjetivoMuyLejos() {
		Armamento arma = new Armamento(0.200, 701);
		Vieja vieja = new Vieja();
		
		Assert.assertFalse(vieja.equipar(arma));
	}
	@Test
	public void testPuedeEquiparObjetivoMuyGrande() {
		Armamento arma = new Armamento(1.1, 700);
		Vieja vieja = new Vieja();
		
		Assert.assertFalse(vieja.equipar(arma));
	}
	@Test
	public void testPuedeEquipar2Armas() {
		Armamento arma = new Armamento(0.8, 700);
		Armamento arma2 = new Armamento(0.1, 700);
		Vieja vieja = new Vieja();
		
		Assert.assertTrue(vieja.equipar(arma));
		Assert.assertTrue(vieja.equipar(arma2));
	}
	@Test
	public void testPuedeEquipar2ArmasPeroSePasaElvolumen() {
		Armamento arma = new Armamento(0.8, 700);
		Armamento arma2 = new Armamento(0.3, 700);
		Vieja vieja = new Vieja();
		
		Assert.assertTrue(vieja.equipar(arma));
		Assert.assertFalse(vieja.equipar(arma2));
	}
	@Test
	public void testPuedeEquiparMuchasArmas() {
		Armamento arma = new Armamento(0.0000005, 700);
		Armamento arma2 = new Armamento(0.0000005, 700);
		Armamento arma3 = new Armamento(0.0000005, 700);
		Armamento arma4 = new Armamento(0.0000005, 700);
		Armamento arma5 = new Armamento(0.0000005, 700);
		Armamento arma6 = new Armamento(0.0000005, 700);
		Armamento arma7 = new Armamento(0.0000005, 700);
		Armamento arma8 = new Armamento(0.0000005, 700);
		Armamento arma9 = new Armamento(0.0000005, 700);
		Vieja vieja = new Vieja();

		Assert.assertTrue(vieja.equipar(arma));
		Assert.assertTrue(vieja.equipar(arma2));
		Assert.assertTrue(vieja.equipar(arma3));
		Assert.assertTrue(vieja.equipar(arma4));
		Assert.assertTrue(vieja.equipar(arma5));
		Assert.assertTrue(vieja.equipar(arma6));
		Assert.assertTrue(vieja.equipar(arma7));
		Assert.assertTrue(vieja.equipar(arma8));
		Assert.assertTrue(vieja.equipar(arma9));
	}

}
