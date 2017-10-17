package ejercicio;

public abstract class Figura {
	public abstract Figura getFigura();
	
	public abstract boolean puntoPertenece(Punto p1);	
	public abstract boolean intersecta(Rectangulo r1);
	public abstract boolean intersecta(Circulo c1);	
}
