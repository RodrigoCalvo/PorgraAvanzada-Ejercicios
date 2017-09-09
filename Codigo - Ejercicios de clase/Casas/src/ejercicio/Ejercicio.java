package ejercicio;

public class Ejercicio {

	public static void main(String[] args) {
		for(long j = 8; j <= Long.MAX_VALUE; j++) {
			long length = j;
			
			double aux = Math.sqrt((length*length + length) /2);
			if(aux % 1 == 0)
				System.out.println((int)aux);
			//else
				//System.out.println(-1);		
		}
	}
}
