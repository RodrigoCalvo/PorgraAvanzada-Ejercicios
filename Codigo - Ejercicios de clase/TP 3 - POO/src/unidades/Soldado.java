package unidades;



public class Soldado extends Unidad {


	private static final int RANGO_MINIMO = 0;
	private  static final int RANGO_MAXIMO = 0;
	private double defensa = 0;
	private double energia = 100;
	private double salud = 200;
	private double daño = 10;
	
	
	
	 @Override
	 public double getDaño() {
	  return 10;
	 }
	 @Override
	 public double getEnergia() {
	  return 100;
	 }
	 
	 @Override
	 public double getDefensa() {
		 return 0;
	 }
	
	public boolean puedoAtacar() {
		if(this.salud == 0)
			return false;
		if(this.energia == 0)
			return false;
		
		return true;
	}

}
