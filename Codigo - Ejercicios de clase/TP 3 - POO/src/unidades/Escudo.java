package unidades;

public class Escudo extends UnidadDecorator{
	
	 public Escudo (Unidad guerrero){
		  this.unidad = guerrero;
		 }
		 
	 @Override
	 public double getDa�o() {
	  return this.unidad.getDa�o();
	 }
	 @Override
	 public double getEnergia() {
	  return this.unidad.getEnergia();
	 }
	 
	 @Override
	 public double getDefensa() {
		 return this.unidad.getDefensa() + 0.4;
	 }

}
