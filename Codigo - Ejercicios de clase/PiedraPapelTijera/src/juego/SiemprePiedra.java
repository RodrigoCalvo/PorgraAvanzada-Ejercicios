package juego;

public class SiemprePiedra  implements Jugador {
	Resultado resultadoAnterior;
	Forma formaDelOtro;
	
	@Override
	public Forma jugar() {
		return Forma.PIEDRA;
	}

	@Override
	public void resultado(Resultado resultado, Forma formaDelOtro) {
		this.resultadoAnterior = resultado;
		this.formaDelOtro = formaDelOtro;
	}

	@Override
	public String getNombre() {
		return "Siempre Piedra";
	}
}
