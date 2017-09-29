package unidades;

public class Lancero extends Unidad{
	private final static int RANGO_MINIMO = 1;
	private final static int RANGO_MAXIMO = 3;
	private double salud = 150;
	private double energia = 0;
	private double defensa = 0;
	private double daño = 25;
	
	@Override
	 public double getDaño() {
	  return 25;
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
		return true;
	}
	
	
}
