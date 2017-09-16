package trabajoPractico;

public class Polinomio {
	private int grado ;
	private double [] coeficientes;
	//La posicion del arreglo de coeficients con tiene el coeficiente de grado n y la
	//posicion n contiene al termino independiente.
	
	public Polinomio (double[] coeficientes) throws Exception{
		if(coeficientes.length <= 0)
			throw new Exception("Especifique al menos un coeficiente");
					
		this.coeficientes = coeficientes;
		grado = coeficientes.length -1;
		
	}
	public double evaluarMSucesivas (double x) { 
		//Arranco con el termino indepentiende.
		double resultado = this.coeficientes[this.grado];			
		
		for(int i = 0; i < this.grado; i++) {
			double aux = x;
			for(int j = 1; j < this.grado - i; j++) {
				aux*=x;
			}
			resultado += aux * this.coeficientes[i];
		}	
		
		return resultado;
	}
	
	double evaluarRecursiva (double x) {
		return 0;
	}
	double evaluarRecursivaPar (double x ) { 
		return 0;
	}
	double evaluarProgDinamica (double x ) { 
		return 0;
	}
	double evaluarMejorada (double x ) { 
		return 0; 
	}
	double evaluarPow (double x ) { 
		return 0;
	}
	// y a sugerencia de Lucas P
	double evaluarHorner ( double x ) { 
		return 0;
	}
}