package unidades;

public class Capa extends UnidadDecorator {
	
	
	 public Capa (Unidad guerrero){
		  this.unidad = guerrero;
		 }
	 @Override
	 public double getDaño() {
	  return this.unidad.getDaño() * 0.9;
	 }
	 @Override
	 public double getEnergia() {
	  return this.unidad.getEnergia() *2;
	 }
	 
	 @Override
	 public double getDefensa() {
		 return this.unidad.getDefensa();
	 }

}
