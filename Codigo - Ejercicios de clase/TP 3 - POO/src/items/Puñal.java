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
		if(this.unidad.getDa�o() == 10.0 || this.unidad.getDa�o() == 9 || this.unidad.getDa�o() == 5 || this.unidad.getDa�o() == 4.5 || this.unidad.getDa�o() == 25 || this.unidad.getDa�o() == 22.5 ||this.unidad.getDa�o() == 50 ||this.unidad.getDa�o() == 45 )
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
