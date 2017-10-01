package items;

import unidades.*;


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
	}*/
	
	
	

	
	@Override
	public double getDa�o() {
		if(this.unidad.getDefensa() == 0)
			return this.unidad.getDa�o() + 3;
		
		else
			return this.unidad.getDa�o();
		
		
	}
	
	@Override
	public double getDefensa() {
		
		if(this.unidad.getDefensa() == 0)
			return this.unidad.getDefensa() - 3;		
		
		else
			return this.unidad.getDefensa();

	}
}
