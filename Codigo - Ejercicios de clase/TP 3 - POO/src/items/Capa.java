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
		
		if(this.unidad.getEnergia()<=50)
			return this.unidad.getEnergia()*2; 
		
		else {
			
				return this.unidad.getEnergia() + (100 - this.unidad.getEnergia());
			}
	}	
}
