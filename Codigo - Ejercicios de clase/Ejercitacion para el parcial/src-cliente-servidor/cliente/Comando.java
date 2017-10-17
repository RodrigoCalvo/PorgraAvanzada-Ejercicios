package cliente;

public class Comando {
	private String nick;
	private String salaID = "general";
	private String mensaje;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getNick() {
		return nick;
	}
	@Override
	public String toString() {
		return nick + "|" + salaID + "|" + mensaje;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getSalaID() {
		return salaID;
	}
	public void setSalaID(String salaID) {
		this.salaID = salaID;
	}
	
	
}
