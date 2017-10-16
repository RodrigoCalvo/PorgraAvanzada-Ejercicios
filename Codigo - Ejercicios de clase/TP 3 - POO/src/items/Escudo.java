package items;

import unidades.*;

public class Escudo extends UnidadDecorator  {
	public Escudo(Unidad unidad) {
		super(unidad);
	}	

	/**
	 * Metodo predilecto para atacar unidades. Usar este ya que indica como deben hacerse las cosas.
	 * @param unidad a la que vamos a atacar
	 * @return devuelve si se pudo atacar o no.
	 */
	@Override
	public double calcularDa�oQueMeInfligen(double da�o) {
		da�o = this.unidad.calcularDa�oQueMeInfligen(da�o);
		if(da�o < 0)
			return 0;
		else
			da�o = da�o*0.6;
		
		return da�o;
	}
}
