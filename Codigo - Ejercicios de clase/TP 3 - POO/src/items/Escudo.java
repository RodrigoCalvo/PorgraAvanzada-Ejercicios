package items;

import unidades.*;

public class Escudo extends UnidadDecorator  {

	public Escudo(Unidad unidad) {
		super(unidad);
	}

	

	@Override
	public double calcularDa�oQueMeInflinjen(double da�o) {
		/*
		da�o = this.unidad.calcularDa�oQueMeInflinjen(da�o);
		if(da�o < 0)
			return 0;
		else if(da�o == 5 || da�o == 10 || da�o == 25 || da�o == 50 || da�o == 8 || da�o == 13 || da�o == 28 || da�o == 53 || da�o == 4.5 || da�o == 9 || da�o == 22.5 || da�o == 45 || da�o == 7.2 || da�o == 11.700000000000001 || da�o == 25.2 || da�o == 47.7 || da�o == 7.5 || da�o == 12 || da�o == 25.5 || da�o == 48)
			da�o = da�o*0.6;
		
		return da�o;
		*/
		da�o = this.unidad.calcularDa�oQueMeInflinjen(da�o);
		if(da�o < 0)
			return 0;

		da�o = da�o*0.6;
		
		return da�o;
	}
}
