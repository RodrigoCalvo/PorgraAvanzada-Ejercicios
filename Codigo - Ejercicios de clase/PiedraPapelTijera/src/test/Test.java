package test;

import static org.junit.Assert.*;

import java.util.Random;

import juego.Forma;
import juego.JavaIsComing;
import juego.JugadorGabriel;
import juego.RandomJuegador;
import juego.Resultado;
import juego.SiemprePiedra;

public class Test {

	@org.junit.Test
	public void test() {
		JavaIsComing java = new JavaIsComing();
		JavaIsComing java2 = new JavaIsComing();
		JugadorGabriel gabriel = new JugadorGabriel();
		RandomJuegador random = new RandomJuegador();
		SiemprePiedra siemprePiedra = new SiemprePiedra();
		
		int cantidadDeVecesquejavagano = 0;
		int cantidadDeVecesquejavaperdio = 0;
		int empates = 0;
		int cantidadDeJuegos = 10000;
		
		for(int i = 0; i<10000;i++) {
			Forma formaDeJava = java.jugar();
			Forma FormaContrincante = java2.jugar();
			
			Resultado resultadoDeJava = formaDeJava.jugarCon(FormaContrincante);
			
			if(resultadoDeJava == Resultado.GANADOR)
				cantidadDeVecesquejavagano++;
			else if (resultadoDeJava == Resultado.PERDEDOR)
				cantidadDeVecesquejavaperdio++;
			else
				empates++;
			
			java.resultado(resultadoDeJava, FormaContrincante);
			java2.resultado(resultadoDeJava.contraria(), formaDeJava);
		}
		
		System.out.println("% de ganados: " + (cantidadDeVecesquejavagano*100)/cantidadDeJuegos);
		System.out.println("% de ganados: " + (cantidadDeVecesquejavaperdio*100)/cantidadDeJuegos);
		System.out.println("% de empates: " + (empates*100)/cantidadDeJuegos);
	}

}
