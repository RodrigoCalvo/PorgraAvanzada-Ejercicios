package test;
import unidades.*;

import org.junit.Assert;
import org.junit.Test;



public class testeo {

	@Test
	public void test() {
		
		Unidad arquero = new Arquero();
		arquero = new Capa(arquero);
		System.out.println(arquero.getDa�o());
	}
}
