package unidades;

public class Caballero {
	
	private final static int RANGO_MINIMO = 1;
	private final static int RANGO_MAXIMO = 2;
	private int salud;
	private int cant_ataques = 0;
	private int daño = 50;
	
	public Caballero() {
		super();
		this.salud = 200;
	}
	
	
	protected boolean puedoAtacar() {
		if(this.salud == 0)
			return false;
		if(this.cant_ataques == 3)
			return false;
		
		return true;
	}
	

}
