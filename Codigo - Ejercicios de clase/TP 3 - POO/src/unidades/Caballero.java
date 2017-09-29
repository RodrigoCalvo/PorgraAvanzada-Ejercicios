package unidades;

public class Caballero extends Unidad{
	
	private final static int RANGO_MINIMO = 1;
	private final static int RANGO_MAXIMO = 2;
	private double salud = 200;
	private double energia = 0;
	private double defensa = 0;
	private int cant_ataques = 0;
	private double daño = 50;
	
	
	@Override
	 public double getDaño() {
	  return 50;
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
		if(this.cant_ataques == 3)
			return false;
		
		return true;
	}
	

}
