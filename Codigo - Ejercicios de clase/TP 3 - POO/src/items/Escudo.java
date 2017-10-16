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
	public double calcularDañoQueMeInfligen(double daño) {
		daño = this.unidad.calcularDañoQueMeInfligen(daño);
		if(daño < 0)
			return 0;
		else
			daño = daño*0.6;
		
		return daño;
	}
}
