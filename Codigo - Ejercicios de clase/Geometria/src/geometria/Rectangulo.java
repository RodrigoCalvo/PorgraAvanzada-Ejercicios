package geometria;


public class Rectangulo extends Figura {
	private Punto p1;
	private Punto p2;
	
	public Rectangulo(Punto p1, Punto p2) throws Exception{
		
		if (p1.getX() == p2.getX() || p1.getY() == p2.getY())
			throw new Exception("El rectangulo no tiene superficie");

		if(p1.getX() > p2.getX() || p2.getY() > p1.getY())
			throw new Exception("p1 debe ser superior e izquierdo a p2");
		
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public boolean puntoPertenece(Punto punto)	
	{
		if(punto.getX() >= this.p1.getX() && punto.getX() <= this.p2.getX()
		&& punto.getY() <= this.p1.getY() && punto.getY() >= this.p2.getY())
			return true;
		else
			return false;
	}	
	

	@Override
	public boolean intersecta(Rectangulo r1){
		if
		(
			this.puntoPertenece(r1.p1) || this.puntoPertenece(r1.p2)
			|| this.puntoPertenece(new Punto(r1.p1.getX(), r1.p2.getY()))
			|| this.puntoPertenece(new Punto(r1.p2.getX(), r1.p1.getY()))
			|| r1.puntoPertenece(this.p1)|| r1.puntoPertenece(this.p2)
			|| r1.puntoPertenece(new Punto(this.p1.getX(), this.p2.getY()))
			|| r1.puntoPertenece(new Punto(this.p2.getX(), this.p1.getY()))
		)
			return true;
		else
			return false;
	}

	@Override
	public boolean intersecta(Circulo c1){
		Punto centroRectangulo = this.centroRectangulo();

		double distanciaEntreCentrosEnX = c1.getCentro().distanciaHastaEnX(centroRectangulo);		
		double distanciaEntreCentrosEnY = c1.getCentro().distanciaHastaEnY(centroRectangulo);
		
		if(distanciaEntreCentrosEnX <= c1.getRadio() + this.ladoMedioXRectangulo()
		  && distanciaEntreCentrosEnY <= c1.getRadio() + this.ladoMedioYRectangulo())
			return true;
		else
			return false;
	}
	
	public Punto centroRectangulo(){
		double x = (this.p2.getX() - this.p1.getX()) /2;
		double y = (this.p1.getY() - this.p2.getY()) /2;
		Punto centroRectangulo = new Punto(this.p2.getX() - x, this.p1.getY() - y);
		
		return centroRectangulo;
	}
	
	public double ladoMedioXRectangulo(){
		return (this.p2.getX() - this.p1.getX()) /2;
	}
	public double ladoMedioYRectangulo(){
		return (this.p1.getY() - this.p2.getY()) /2;
	}

	@Override
	public Rectangulo getFigura() {
		return this;
	}
}
