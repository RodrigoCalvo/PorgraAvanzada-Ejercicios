package unidades;



public class Soldado extends Unidad {
	private final int rango = 0;
	private int energia;
	private int salud;
	private int daño = 10;
	
	
	public Soldado() {
		super();
		this.energia = 100;
		this.salud = 200;
	}
	
	protected boolean puedoAtacar() {
		if(this.salud == 0)
			return false;
		if(this.energia == 0)
			return false;
		
		return true;
	}

}
