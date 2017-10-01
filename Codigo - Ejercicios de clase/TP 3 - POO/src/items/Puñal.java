package items;

import unidades.*;


public class Puñal extends UnidadDecorator{

	public Puñal(Unidad unidad) {
		super(unidad);
	}
	

	

	/*@Override
	public double getDaño() {
		return this.unidad.getDaño() + 3;
	}
	@Override
	public double getDefensa() {
		return this.unidad.getDefensa() - 3;
	}*/
	
	
	

	
	@Override
	public double getDaño() {
		if(this.unidad.getDaño() == 10.0 || this.unidad.getDaño() == 9 || this.unidad.getDaño() == 5 || this.unidad.getDaño() == 4.5 || this.unidad.getDaño() == 25 || this.unidad.getDaño() == 22.5 ||this.unidad.getDaño() == 50 ||this.unidad.getDaño() == 45 )
			return this.unidad.getDaño() + 3;
		
		else
			return this.unidad.getDaño();
		
		
	}
	
	@Override
	public double getDefensa() {
		
		if(this.unidad.getDefensa() == 0)
			return this.unidad.getDefensa() - 3;		
		
		else
			return this.unidad.getDefensa();

	}
}
