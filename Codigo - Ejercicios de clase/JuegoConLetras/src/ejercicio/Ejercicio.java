package ejercicio;

import java.util.Arrays;


public class Ejercicio {

	public static void main(String[] args) {
		SopaDeLetra sopita = new SopaDeLetra("entrada.in");
		/*
		for (int i = 0; i < sopita.getSopaDeLetras().length; i++) {					
			System.out.println(Arrays.toString(sopita.getSopaDeLetras()[i]));			
		}
		*/
		long startTime, endTime, duration = 0, cantidad=5;

		for(int i = 0; i< cantidad; i++)
		{
			startTime = System.nanoTime();
			sopita.prepararResultado();
			endTime = System.nanoTime();
			duration += (endTime - startTime);
		}
		System.out.println("prepararResultado: 			" + duration/cantidad + " nanosegundos");

		sopita = new SopaDeLetra("entrada.in");
		duration = 0;
		for(int i = 0; i< cantidad; i++)
		{
			startTime = System.nanoTime();
			sopita.prepararResultadoOptimizado();
			endTime = System.nanoTime();
			duration += (endTime - startTime);
		}
		System.out.println("prepararResultadoOptimizado: 		" + duration/cantidad + " nanosegundos");

	}

}
