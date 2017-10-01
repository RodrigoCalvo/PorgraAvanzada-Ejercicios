package juego;

import java.util.Random;

public class JavaIsComing implements Jugador {
	Resultado resultadoAnterior;
	Forma formaDelOtro;
	
	@Override
	public Forma jugar() {
		if(resultadoAnterior == null)
			return Forma.PAPEL;
		
		if(resultadoAnterior == Resultado.GANADOR) {
			if(formaDelOtro == Forma.PIEDRA) {
				//nuevaFormaDelOtro = Forma.PAPEL;
				return Forma.TIJERA;
			}else if (formaDelOtro == Forma.PAPEL) {
				//nuevaFormaDelOtro = Forma.TIJERA;
				return Forma.PIEDRA;
			}else if(formaDelOtro == Forma.TIJERA) {
				//nuevaFormaDelOtro = Forma.PIEDRA;
				return Forma.PAPEL;
			}
		}else if (resultadoAnterior == Resultado.PERDEDOR) {
			if(formaDelOtro == Forma.PIEDRA) {
				//nuevaFormaDelOtro = Forma.PIEDRA;
				return Forma.PAPEL;
			}else if (formaDelOtro == Forma.PAPEL) {
				//nuevaFormaDelOtro = Forma.PAPEL;
				return Forma.TIJERA;
			}else if(formaDelOtro == Forma.TIJERA) {
				//nuevaFormaDelOtro = Forma.TIJERA;
				return Forma.PIEDRA;
			}			
		}
		else {
			if(formaDelOtro == Forma.PIEDRA) {
				//nuevaFormaDelOtro = Forma.PAPEL;
				return Forma.TIJERA;
			}else if (formaDelOtro == Forma.PAPEL) {
				//nuevaFormaDelOtro = Forma.TIJERA;
				return Forma.PIEDRA;
			}else if(formaDelOtro == Forma.TIJERA) {
				//nuevaFormaDelOtro = Forma.PIEDRA;
				return Forma.PAPEL;
			}			
		}
		
		//Default, no sale nunca.
		return Forma.PAPEL;
	}

	@Override
	public void resultado(Resultado resultado, Forma formaDelOtro) {
		this.resultadoAnterior = resultado;
		this.formaDelOtro = formaDelOtro;
	}

	@Override
	public String getNombre() {
		return "Java is coming";
	}

}
