package unidades;

public class Lancero extends Unidad{
	private final static int RANGO_MINIMO = 1;
	private final static int RANGO_MAXIMO = 3;
	private int salud;
	private int daño = 25;
	
	public Lancero() {
		super();
		this.salud = 150;
	}
	
	protected boolean puedoAtacar() {
		if(this.salud == 0)
			return false;		
		return true;
	}
	
	
}
