package unidades;

public class Puñal extends UnidadDecorator{
	
	 public Puñal (Unidad guerrero){
		  this.unidad = guerrero;
		 }
	 
	 @Override
	 public double getDaño() {
	  return this.unidad.getDaño()  +3;
	 }
	 @Override
	 public double getEnergia() {
	  return this.unidad.getEnergia() ;
	 }
	 
	 @Override
	 public double getDefensa() {
		 return this.unidad.getDefensa() -3;
	 }

}
