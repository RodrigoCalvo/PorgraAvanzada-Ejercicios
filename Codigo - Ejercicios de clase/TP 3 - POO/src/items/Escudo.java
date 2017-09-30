package items;

import unidades.Unidad;

public class Escudo extends UnidadDecorator  {

	public Escudo(Unidad unidad) {
		super(unidad);
	}


	@Override
	public double calcularDañoQueMeInflinjen(double daño) {
		daño = this.unidad.calcularDañoQueMeInflinjen(daño);
		if(daño < 0)
			return 0;
		
		daño = daño*0.6;
		
		return daño;
	}
}
