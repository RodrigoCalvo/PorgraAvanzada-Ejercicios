package items;

import unidades.Unidad;

public class Capa extends UnidadDecorator  {

	public Capa(Unidad unidad) {
		super(unidad);
	}
	
	@Override
	public double getDa�o() {
		return this.unidad.getDa�o()*0.9;
	}

	@Override
	public double getEnergia() {
		return this.unidad.getEnergia()*2; 
	}
}
