package ejercicio;

public class HiperSaludable extends EstadoPirata {
	
	public HiperSaludable() {
		ataque = 10;
		defensa = -2;
	}

	@Override
	public EstadoPirata beberGrog() {
		return new Saludable();	
	}

	@Override
	public EstadoPirata beberJugo() {
		return this;
	}

}
