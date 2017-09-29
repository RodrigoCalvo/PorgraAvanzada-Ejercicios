package unidades;



public class Soldado extends Unidad {


	private final int rango = 0;
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
	
	protected boolean puedoAtacar() {
		if(this.salud == 0)
			return false;
		if(this.energia == 0)
			return false;
		
		return true;
	}

}
