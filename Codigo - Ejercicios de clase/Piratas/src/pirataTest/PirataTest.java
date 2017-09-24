package pirataTest;
import pirata.*;

import org.junit.Assert;
import org.junit.Test;


import pirata.EstadoPirata;

public class PirataTest {

	@Test
	public void testbeber() {
		Pirata garfio = new Pirata(new Saludable());
		System.out.println(garfio.toString());
		
		Assert.assertEquals(5, garfio.getAtaque());
		garfio.beberGrog();		
		garfio.beberGrog();
		garfio.beberGrog();
		Assert.assertEquals(2, garfio.getAtaque());
		garfio.beberGrog();
		Assert.assertEquals(2, garfio.getAtaque());
		
		garfio.beberJugo();		
		Assert.assertEquals(5, garfio.getAtaque());
		garfio.beberJugo();
		Assert.assertEquals(10, garfio.getAtaque());
		garfio.beberJugo();
		Assert.assertEquals(10, garfio.getAtaque());
		garfio.beberGrog();
		Assert.assertEquals(5, garfio.getAtaque());
	
	}
	@Test
	public void testAtacar() {
		Pirata Garfio = new Pirata(new Saludable());
		Pirata JackSparrow = new Pirata(new Escorbuto());
		
		Assert.assertEquals(0, Garfio.getPuntos());		
		
		Garfio.atacar(JackSparrow);
		
		Assert.assertEquals(5, Garfio.getPuntos());
		
		JackSparrow.beberJugo();
		Garfio.atacar(JackSparrow);
		Assert.assertEquals(8, Garfio.getPuntos());
		
		JackSparrow.beberJugo();
		Garfio.atacar(JackSparrow);
		
		Assert.assertEquals(15, Garfio.getPuntos());
	}

}
