package ejercito;

public class Vieja extends Unidad {
	private final static double VOLUMEN_MAXIMO = 1;
	private final static double DISTANCIA = 700;
	
	private double VolumenCargado;
	
	@Override
	protected boolean puedoCargar(Armamento armamento) {
		if(armamento.getDistancia() > DISTANCIA)
			return false;
		
		if(armamento.getVolumen() + VolumenCargado > VOLUMEN_MAXIMO)
			return false;
				
		return true;
	}

	@Override
	protected void cargo(Armamento armamento) {
		VolumenCargado += armamento.getVolumen();
	}
}
