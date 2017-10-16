package items;



import unidades.Unidad;

public class Capa extends UnidadDecorator  {

	public Capa(Unidad unidad) {
		super(unidad);
	}
	
	
	
	@Override
	public double getDaño() {
		return this.unidad.getDaño() * 0.9;
	}
	


	@Override
	public double getEnergia() {
		return this.unidad.getEnergia() + this.unidad.getEnergia();		
	}
	

	@Override
	public double calcularGastoDeEnergia() {
		return this.unidad.calcularGastoDeEnergia()/2;
	}
}
