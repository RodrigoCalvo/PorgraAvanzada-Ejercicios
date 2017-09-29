package unidades;

public class Arquero extends Unidad {
	
	

	private final static int RANGO_MINIMO = 2;
	private final static int RANGO_MAXIMO = 5;
	private int cant_flechas = 20;
	private double energia = 0;
	private double defensa = 0;
	private double salud = 50;
	private double daño = 5;
	
	@Override
	 public double getDaño() {
	  return 5;
	 }
	 @Override
	 public double getEnergia() {
	  return 0;
	 }
	 
	 @Override
	 public double getDefensa() {
		 return 0;
	 }
	
	public boolean puedoAtacar() {
		if(this.salud == 0)
			return false;
		if(this.cant_flechas == 0)
			return false;
		
		return true;
	}
	
	
	
}
