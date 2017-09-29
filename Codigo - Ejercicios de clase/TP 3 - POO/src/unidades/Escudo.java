package unidades;

public class Escudo extends UnidadDecorator{
	
	 public Escudo (Elemento guerrero){
		  this.elemento = guerrero;
		 }
		 
	 @Override
	 public double getDaño() {
	  return this.elemento.getDaño();
	 }
	 @Override
	 public double getEnergia() {
	  return this.elemento.getEnergia();
	 }
	 
	 @Override
	 public double getDefensa() {
		 return this.elemento.getDefensa() + 0.4;
	 }

}
