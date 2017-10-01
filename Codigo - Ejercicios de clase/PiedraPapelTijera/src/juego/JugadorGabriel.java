package juego;

public class JugadorGabriel implements Jugador {

	private Resultado ultimoResultado;
	private Forma ultimaFormaRival;
	private int piedrasSeguidasRival;
	private int papelesSeguidasRival;
	private int tijerasSeguidasRival;
	
	private int piedrasSeguidasMias;
	private int papelesSeguidosMias;
	private int tijerasSeguidasMias;
	
	@Override
	public Forma jugar() {
		
		if(Resultado.EMPATE == ultimoResultado && ultimaFormaRival == Forma.PIEDRA) {
			if(papelesSeguidosMias < tijerasSeguidasMias)
				return Forma.PAPEL;
			else return Forma.TIJERA;
		}
		
		if(Resultado.EMPATE == ultimoResultado && ultimaFormaRival == Forma.PAPEL) {
			if(tijerasSeguidasMias < piedrasSeguidasMias)
				return Forma.TIJERA;
			else return Forma.PIEDRA;
		}
		
		if(Resultado.EMPATE == ultimoResultado && ultimaFormaRival == Forma.TIJERA) {
			if(papelesSeguidosMias < tijerasSeguidasMias)
				return Forma.PAPEL;
			else return Forma.TIJERA;
		}
		
		
		if( Forma.PIEDRA == ultimaFormaRival.PIEDRA ){
			reiniciarContadores(papelesSeguidasRival, tijerasSeguidasRival);
			piedrasSeguidasRival++;		
		}
		if( Forma.PAPEL == ultimaFormaRival.TIJERA ){
			reiniciarContadores(piedrasSeguidasRival, tijerasSeguidasRival);
			papelesSeguidasRival++;			
		}
		if( Forma.TIJERA == ultimaFormaRival.TIJERA ){
			reiniciarContadores(piedrasSeguidasRival, papelesSeguidasRival);
			tijerasSeguidasRival++;
		}		
		
		if( piedrasSeguidasRival >= 3 ){
			reiniciarContadores(tijerasSeguidasMias, piedrasSeguidasMias);
			papelesSeguidosMias++;
			return Forma.PAPEL;
		}
		if( papelesSeguidasRival >= 3 ){
			reiniciarContadores(tijerasSeguidasMias, piedrasSeguidasMias);
			papelesSeguidosMias++;
			return Forma.TIJERA;
		}
		if(tijerasSeguidasRival >= 3) {
			reiniciarContadores(papelesSeguidosMias, tijerasSeguidasMias);
			piedrasSeguidasMias++;
			return Forma.PIEDRA;
		}
		
		reiniciarContadores(tijerasSeguidasMias, papelesSeguidosMias);
		piedrasSeguidasMias++;
		return Forma.PIEDRA;
	}

	@Override
	public void resultado(Resultado resultado, Forma formaDelOtro) {
		this.ultimoResultado = resultado;
		this.ultimaFormaRival = formaDelOtro;
	}

	@Override
	public String getNombre() {
		return "Gaby";
	}
	
	public void reiniciarContadores(int c1, int c2) {
		c1 = 0;
		c2 = 0;
	}

}
