package geometria;

import java.util.LinkedList;

public class Ejercicio {

	public static void main(String[] args) throws Exception {
		LinkedList<Figura> figuras = new LinkedList<>();
		
		figuras.add(new Circulo(1, new Punto(2, 2)));
		figuras.add(new Rectangulo(new Punto(2, 5), new Punto(4, 2)));
		figuras.add(new Rectangulo(new Punto(2, 5), new Punto(4, 2)));

		figuras.add(new Circulo(1, new Punto(8, 2)));
		figuras.add(new Rectangulo(new Punto(8, 5), new Punto(10, 2)));

		LinkedList<LinkedList<Figura>> figurasAgrupadas = new LinkedList<>();
		
		for(Figura figura : figuras){
			boolean meintersectoconalguien = false;
			
			for(LinkedList<Figura> figuraAgrupada : figurasAgrupadas){
				
				for(Figura _figAgrupada : figuraAgrupada){
					
					if (_figAgrupada.getClass() == Circulo.class){
						if(figura.getClass() == Circulo.class){
							if(((Circulo)_figAgrupada).intersecta((Circulo)figura)){
								figuraAgrupada.add(figura);
								meintersectoconalguien = true;
							}
						}else if(figura.getClass() == Rectangulo.class){
							if(((Circulo)_figAgrupada).intersecta((Rectangulo)figura)){
								figuraAgrupada.add(figura);
								meintersectoconalguien = true;			
								break;					
							}
						}
					}else if (_figAgrupada.getClass() == Rectangulo.class){
						if(figura.getClass() == Circulo.class){
							if(((Rectangulo)_figAgrupada).intersecta((Circulo)figura)){
								figuraAgrupada.add(figura);
								meintersectoconalguien = true;			
								break;					
							}
						}else if(figura.getClass() == Rectangulo.class){
							if(((Rectangulo)_figAgrupada).intersecta((Rectangulo)figura)){
								figuraAgrupada.add(figura);
								meintersectoconalguien = true;		
								break;						
							}
						}
					}
				}
			}
			
			if(!meintersectoconalguien)
			{
				LinkedList<Figura> aux = new LinkedList<>();
				aux.add(figura);
				figurasAgrupadas.add(aux);
			}
		}

		for(LinkedList<Figura> figuraAgrupada : figurasAgrupadas){
			System.out.println(figuraAgrupada.size());
		}		
	}
}
