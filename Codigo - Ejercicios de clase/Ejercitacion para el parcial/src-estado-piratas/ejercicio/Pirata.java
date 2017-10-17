package ejercicio;


public class Pirata
{
	private int puntos = 0;
	
	private EstadoPirata estado;
	
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public EstadoPirata getEstado() {
		return estado;
	}

	public void setEstado(EstadoPirata estado) {
		this.estado = estado;
	}
	
	public Pirata(EstadoPirata estado) {		
		this.estado = estado;		
	}
	
	public void beberJugo() {
		this.estado = estado.beberJugo();
	}
	
	public void beberGrog() {
		this.estado = estado.beberGrog();
	}
	
	public int getAtaque() {
		return estado.ataque;
	}

	public int getDefensa() {
		return estado.defensa;
	}

	
	public void atacar(Pirata p)	{				
		this.puntos += this.getAtaque() - p.getDefensa();
	}


	@Override
	public String toString() {
		return "Pirata [ataque=" + estado.ataque + ", defensa=" + estado.defensa + ", puntos=" + puntos + ", estado=" + estado
				+  "]";
	}
	
	

}
