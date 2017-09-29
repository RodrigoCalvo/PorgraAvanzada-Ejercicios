package unidades;

public class Pu�al extends UnidadDecorator{
	
	 public Pu�al (Unidad guerrero){
		  this.unidad = guerrero;
		 }
	 
	 @Override
	 public double getDa�o() {
	  return this.unidad.getDa�o()  +3;
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
