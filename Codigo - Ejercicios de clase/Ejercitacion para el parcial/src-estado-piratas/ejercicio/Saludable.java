package ejercicio;

public class Saludable extends EstadoPirata {
	private int cantGrog = 0;
	
	
	public Saludable() {
		ataque = 5;
		defensa = 2;
	}

	@Override
	public EstadoPirata beberGrog() {
		cantGrog++;				
		
		if (cantGrog == 3) 
			return new Escorbuto();						
		
		return this;
	}

	@Override
	public EstadoPirata beberJugo() {
		return new HiperSaludable();		
	}

}
