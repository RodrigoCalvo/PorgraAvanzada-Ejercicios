package items;

import unidades.*;

public class Escudo extends UnidadDecorator  {

	public Escudo(Unidad unidad) {
		super(unidad);
	}

	

	@Override
	public double calcularDañoQueMeInflinjen(double daño) {
		/*
		daño = this.unidad.calcularDañoQueMeInflinjen(daño);
		if(daño < 0)
			return 0;
		else if(daño == 5 || daño == 10 || daño == 25 || daño == 50 || daño == 8 || daño == 13 || daño == 28 || daño == 53 || daño == 4.5 || daño == 9 || daño == 22.5 || daño == 45 || daño == 7.2 || daño == 11.700000000000001 || daño == 25.2 || daño == 47.7 || daño == 7.5 || daño == 12 || daño == 25.5 || daño == 48)
			daño = daño*0.6;
		
		return daño;
		*/
		daño = this.unidad.calcularDañoQueMeInflinjen(daño);
		if(daño < 0)
			return 0;

		daño = daño*0.6;
		
		return daño;
	}
}
