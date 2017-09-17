package trabajoPractico;

public class Polinomio {
	private int grado ;
	private double [] coeficientes;
	//La posicion 0 del arreglo de coeficientes contiene el coeficiente de grado n 
	//y la posicion n contiene al termino independiente .
	
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
	
	public double evaluarProgDinamica (double x ) { 
		double [] resultados = new double[coeficientes.length];
	
		resultados[grado] = 1;
		
		for (int i = grado - 1; i >= 0; i--) {			
			resultados[i] = x * resultados[i+1];
		}	
		
		double resultado = 0;
		
		for (int j = 0; j <= this.grado; j++) {
			resultado += coeficientes[j] * resultados[j];
		}
		
		return resultado;
	}
	
	public double evaluarMejorada (double x ) { 
		
		double [] resultados = new double[coeficientes.length];
		
		resultados[grado] = 1;
		double resultado = this.coeficientes[this.grado];		
		
		for (int i = grado - 1; i >= 0; i--) {			
			resultados[i] = x * resultados[i+1];
			
			resultado += coeficientes[i] * resultados[i];
		}		
		
		
		return resultado;
	}
	
	
	double evaluarPow (double x ) { 
		return 0;
	}
	// y a sugerencia de Lucas P
	public double evaluarHorner ( double x ) { 
		
		double resultado = this.coeficientes[0];
		
        for (int i = 1; i <= grado; i++)
        	resultado = this.coeficientes[i] + (x * resultado);
        
        return resultado;
	}
}