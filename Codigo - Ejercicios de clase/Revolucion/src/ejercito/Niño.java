package ejercito;

public class Niño extends Unidad {
	private final static int CANTIDAD_MAXIMA = 2;
	private final static double PESO_MAXIMO = 120;
	
	private int CantidadDeArmas;
	private double PesoTotal;
	public int getCantidadDeArmas() {
		return CantidadDeArmas;
	}
	public void setCantidadDeArmas(int cantidadDeArmas) {
		CantidadDeArmas = cantidadDeArmas;
	}
	public double getPesoTotal() {
		return PesoTotal;
	}
	public void setPesoTotal(double pesoTotal) {
		PesoTotal = pesoTotal;
	}
	
	@Override
	protected boolean puedoCargar(Armamento armamento) {
		if(CantidadDeArmas == CANTIDAD_MAXIMA)
			return false;
		
		if(armamento.getPeso() + PesoTotal > PESO_MAXIMO)
			return false;
		
		return true;
	}
	@Override
	protected void cargo(Armamento armamento) {
		CantidadDeArmas++;
		PesoTotal += armamento.getPeso();
	}
}
