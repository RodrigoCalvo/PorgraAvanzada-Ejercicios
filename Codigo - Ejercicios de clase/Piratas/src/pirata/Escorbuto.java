package pirata;

public class Escorbuto extends EstadoPirata {
	
	public Escorbuto() {
		ataque = 2;
		defensa = 0;
	}

	@Override
	public EstadoPirata beberGrog() {
		return this;
	}

	@Override
	public EstadoPirata beberJugo() {
		return new Saludable();		
	}

}
