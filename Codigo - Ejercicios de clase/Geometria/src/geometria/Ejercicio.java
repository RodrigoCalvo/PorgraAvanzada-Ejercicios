package geometria;

public class Ejercicio {

	public static void main(String[] args) {
		
		try {
			//Punto p2= new Punto(4, 4);   
			Punto p2= new Punto(2, 2);
			
			Circulo c1 = new Circulo(3, new Punto(4,4));
			
			boolean res =c1.puntoPertenece(p2);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
