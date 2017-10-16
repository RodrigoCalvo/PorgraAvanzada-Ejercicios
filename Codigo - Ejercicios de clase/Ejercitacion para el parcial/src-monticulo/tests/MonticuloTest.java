package tests;

import java.util.Arrays;

import comparadores.IntegerComparador;
import monticulo.Monticulo;
import org.junit.Assert;
import org.junit.Test;

public class MonticuloTest {

	@Test
	public void testDeAlta() {		
		IntegerComparador comparator = new IntegerComparador();
		Monticulo<Integer> monti = new Monticulo<Integer>(1, comparator);
		Integer[] resultado = new Integer[] {null, 7, 5, 6, 1, 4, 2};
		
		monti.agregar(1);
		monti.agregar(2);
		monti.agregar(4);
		monti.agregar(5);
		monti.agregar(6);
		monti.agregar(7);
		
		Assert.assertEquals(resultado, monti.getVector().toArray());
		
		monti.agregar(80);
		resultado = new Integer[] {null, 80, 5, 7, 1, 4, 2, 6};
		Assert.assertEquals(resultado, monti.getVector().toArray());
		
		
		monti.sacar();
		resultado = new Integer[] {null, 7, 5, 6, 1, 4, 2};
		Assert.assertEquals(resultado, monti.getVector().toArray());
	}

	@Test
	public void testDeBaja() {		
		IntegerComparador comparator = new IntegerComparador();
		Monticulo<Integer> monti = new Monticulo<Integer>(0, comparator);
		Integer[] resultado = new Integer[] {null, 1, 2, 4, 5, 6, 7};
		
		monti.agregar(1);
		monti.agregar(2);
		monti.agregar(4);
		monti.agregar(5);
		monti.agregar(6);
		monti.agregar(7);
		
		Assert.assertEquals(resultado, monti.getVector().toArray());
		
		monti.agregar(80);
		monti.agregar(0);
		monti.agregar(79);
		resultado = new Integer[] {null, 0, 1, 4, 2, 6, 7, 80, 5, 79};
		Assert.assertEquals(resultado, monti.getVector().toArray());

		monti.sacar();
		resultado = new Integer[]  {null, 1, 2, 4, 79, 6, 7, 80, 5};
		Assert.assertEquals(resultado, monti.getVector().toArray());
	}
}
