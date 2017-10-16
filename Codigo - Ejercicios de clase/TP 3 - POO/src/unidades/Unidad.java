package unidades;

import mapa.Ubicacion;

public interface Unidad {

	public double getDa�o();
	public double getEnergia();
	public double getDefensa();
	public double getSalud();
	public int getCant_flechas();
	public int getCaballoRebelde();
	public Ubicacion getUbicacion();

	public void tomaPocion();
	public void recarga();
	
	public default Boolean atacar(Unidad unidad) {
		if(this.puedoAtacar(unidad)) {
			this.ataca(unidad);
			unidad.meAtacanCon(unidad.calcularDa�oQueMeInflinjen(this.getDa�o()));			
			return true;
		}
		return false;
	}
	public default double calcularDa�oQueMeInflinjen(double da�o) {
		da�o = da�o - getDefensa();
		if(da�o < 0)
			return 0;
		
		return da�o;
	}
	public default double calcularGastoDeEnergia() {
		return -this.getEnergia()*0.1;
	}
	
	public boolean puedoAtacar(Unidad unidad);
	public void ataca(Unidad unidad);	
	public void meAtacanCon(double da�o);
}
