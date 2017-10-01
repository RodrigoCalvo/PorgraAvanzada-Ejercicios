package juego;

import java.util.Random;

public class RandomJuegador  implements Jugador {
	Resultado resultadoAnterior;
	Forma formaDelOtro;
	
	@Override
	public Forma jugar() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(3);
		
		if(randomInt == 0)
			return Forma.PIEDRA;
		else if(randomInt == 1)
			return Forma.PAPEL;
		else
			return Forma.TIJERA;
	}

	@Override
	public void resultado(Resultado resultado, Forma formaDelOtro) {
		this.resultadoAnterior = resultado;
		this.formaDelOtro = formaDelOtro;
	}

	@Override
	public String getNombre() {
		return "Random";
	}
}
