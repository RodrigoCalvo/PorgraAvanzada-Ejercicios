package ejercicio;

public class Circulo extends Figura {
	private double radio;
	private Punto centro;
	
	
	public Circulo(double radio, Punto centro) throws Exception
	{
		if(radio <= 0)
		{
			throw new Exception("El radio debe ser mayor a 0");
		}
		this.radio = radio;
		this.centro = centro;
	}
		
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	@Override
	public boolean puntoPertenece(Punto p1)	
	{
		if(centro.distanciaHasta(p1)<= radio)
			return true;
		else
			return false;
	}	

	@Override
	public boolean intersecta(Circulo c1){
		double distanciaEntreCentros = this.centro.distanciaHasta(c1.centro);
		
		if(distanciaEntreCentros > c1.radio + this.radio)
			return false;
		else
			return true;
	}
	@Override
	public boolean intersecta(Rectangulo r1){
		Punto centroRectangulo = r1.centroRectangulo();

		double distanciaEntreCentrosEnX = this.centro.distanciaHastaEnX(centroRectangulo);		
		double distanciaEntreCentrosEnY = this.centro.distanciaHastaEnY(centroRectangulo);
		
		if(distanciaEntreCentrosEnX <= this.radio + r1.ladoMedioXRectangulo()
		  && distanciaEntreCentrosEnY <= this.radio + r1.ladoMedioYRectangulo())
			return true;
		else
			return false;
	}

	@Override
	public Circulo getFigura() {
		return this;
	}
}
