package unidades;

public class Arquero {
	
	private final static int RANGO_MINIMO = 2;
	private final static int RANGO_MAXIMO = 5;
	private int cant_flechas;
	private int salud;
	private int daño = 5;
	
	public Arquero() {
		super();
		this.cant_flechas = 20;
		this.salud = 50;
	}
	
	protected boolean puedoAtacar() {
		if(this.salud == 0)
			return false;
		if(this.cant_flechas <=6)
			return false;
		
		return true;
	}
	
	
	
}
