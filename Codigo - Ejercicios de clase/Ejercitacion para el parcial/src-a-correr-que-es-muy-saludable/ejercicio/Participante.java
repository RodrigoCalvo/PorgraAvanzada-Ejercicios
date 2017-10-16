package ejercicio;

public class Participante {
	private int numero;
	private Categoria categoria;
	private Sexo sexo;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Participante(int numero, Categoria categoria, Sexo sexo) {
		super();
		this.numero = numero;
		this.categoria = categoria;
		this.sexo = sexo;
	}
	
}
