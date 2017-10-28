package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import grafos.MatrizSimetrica;


public class TestGrafo {

	@Test
	public void creoVectorTest() {
		MatrizSimetrica m1 = new MatrizSimetrica(5);
		m1.setPos(1, 2);
		Assert.assertEquals(true, m1.getPos(1, 2));
		
	}

}
