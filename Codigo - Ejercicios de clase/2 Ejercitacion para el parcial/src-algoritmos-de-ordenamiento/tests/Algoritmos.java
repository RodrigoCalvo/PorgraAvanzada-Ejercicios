package tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import algoritmos.*;
import comparadores.IntegerComparador;

public class Algoritmos {
	private ArrayList<Integer> aOrdenar;
	private ArrayList<Integer> ordenado;
	private IntegerComparador comparador;
	long startTime, endTime, duration;
	
    @Before
    public void preparar() {
		aOrdenar = new ArrayList<Integer>();		
		aOrdenar.add(2);
		aOrdenar.add(95);
		aOrdenar.add(4);
		aOrdenar.add(65);
		aOrdenar.add(6);
		aOrdenar.add(7);
		aOrdenar.add(99);
		aOrdenar.add(4);
		aOrdenar.add(7);
		aOrdenar.add(6);
		aOrdenar.add(4);
		aOrdenar.add(3);
		aOrdenar.add(56);
		aOrdenar.add(23);
		aOrdenar.add(5);
		
		
		ordenado = new ArrayList<Integer>();		
		ordenado.add(2);		
		ordenado.add(3);		
		ordenado.add(4);		
		ordenado.add(4);		
		ordenado.add(4);		
		ordenado.add(5);		
		ordenado.add(6);		
		ordenado.add(6);		
		ordenado.add(7);		
		ordenado.add(7);		
		ordenado.add(23);		
		ordenado.add(56);		
		ordenado.add(65);	
		ordenado.add(95);	
		ordenado.add(99);
		
		comparador = new IntegerComparador();
    }
	
	@Test
	public void newTest() {
		startTime = System.nanoTime();
		Assert.assertEquals(ordenado, new Seleccion<Integer>(aOrdenar, comparador).ordenar());
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Seleccion:		" + duration + "		nanosegundos");
		
		startTime = System.nanoTime();
		Assert.assertEquals(ordenado, new Burbujeo<Integer>(aOrdenar, comparador).ordenar());
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Burbujeo:		" + duration + "		nanosegundos");

		startTime = System.nanoTime();
		Assert.assertEquals(ordenado, new Insercion<Integer>(aOrdenar, comparador).ordenar());
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Insercion:		" + duration + "		nanosegundos");

		startTime = System.nanoTime();
		Assert.assertEquals(ordenado, new Shell<Integer>(aOrdenar, comparador).ordenar());
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Shell: 			" + duration + "		nanosegundos");
		
		startTime = System.nanoTime();
		Assert.assertEquals(ordenado, new QuickSort<Integer>(aOrdenar, comparador).ordenar());
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("QuickSort:		" + duration + "		nanosegundos");
		
		startTime = System.nanoTime();
		Assert.assertEquals(ordenado, new Merge<Integer>(aOrdenar, comparador).ordenar());
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Fusion:			" + duration + "		nanosegundos");		
	}

}
