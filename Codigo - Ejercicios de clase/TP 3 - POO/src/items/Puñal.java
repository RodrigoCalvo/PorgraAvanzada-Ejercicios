package items;

import unidades.Unidad;

public class Pu�al extends UnidadDecorator{

	public Pu�al(Unidad unidad) {
		super(unidad);
	}
	
	

	/*@Override
	public double getDa�o() {
		return this.unidad.getDa�o() + 3;
	}
	@Override
	public double getDefensa() {
		return this.unidad.getDefensa() - 3;
	}
	
	*/
	
	@Override
	public double getDa�o() {
		if(this.pu�al == false)
			return this.unidad.getDa�o() + 3;
		else 
			return this.unidad.getDa�o();
		}

	
	@Override
	public double getDefensa() {
			this.pu�al = true;
			return this.unidad.getDefensa() - 3;

	}
}
