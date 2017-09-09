package ejercito;

public class Avioneta extends Unidad {
	private final static double VOLUMEN_MAX = 500;
	private final static double PESO_MAX = 3000;
	private final static double DISTANCIA_MIN = 500;
	private final static double DISTANCIA_MAX = 1700;

	private double PesoCargado;	
	private double VolumenCargado;
	
	@Override
	protected boolean puedoCargar(Armamento armamento) {
		if(armamento.getVolumen() + VolumenCargado > VOLUMEN_MAX)
			return false;
		if( armamento.getPeso() + PesoCargado > PESO_MAX)
			return false;
		if( armamento.getDistancia() > DISTANCIA_MAX)
			return false;
		if( armamento.getDistancia() < DISTANCIA_MIN)
			return false;
		
		return true;
	}
	@Override
	protected void cargo(Armamento armamento) {
		PesoCargado += armamento.getPeso();
		VolumenCargado += armamento.getVolumen();		
	} 
}
