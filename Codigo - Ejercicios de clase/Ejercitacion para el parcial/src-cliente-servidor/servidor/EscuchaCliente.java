package servidor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

public class EscuchaCliente extends Thread {
	
    private Socket socket;  
    private DataInputStream entradaDatos;
    private DataOutputStream salidaDatos;
    
    private String nick;
    private String salaID ="";
    
	public EscuchaCliente(Socket socket) {
		this.socket = socket;
		
		try {
			
			salidaDatos = new DataOutputStream(socket.getOutputStream());		
			entradaDatos = new DataInputStream(socket.getInputStream());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
	
		try {
			
			//salidaDatos.writeUTF("BIENVENIDO AL CHAT");
			String cadenaLeida = (String) entradaDatos.readUTF();
			
			while (true) {
				String[] comando = cadenaLeida.split("\\|");
				
				if (comando[2].equals("/conectar")) {
					this.nick = comando[0];
					this.salaID = comando[1];
				}			
				else if (comando[2].equals("/salas")) {					
					salidaDatos.writeUTF("Salas: " + Arrays.toString(Servidor.getSalas().toArray()));
				}
				else if(comando[2].startsWith("#")) {
					String sala = comando[2].replace("#", "");
					
					if (!Servidor.getSalas().contains(sala))
						Servidor.getSalas().add(sala);
					
					this.salaID = sala;
					salidaDatos.writeUTF("Entraste en la sala: " + sala);
				}		
				else if (comando[2].equals("/salir")) {		
					salidaDatos.writeUTF("Saliste de la sala: " + this.salaID);
					
					this.salaID = "";					
					
					salidaDatos.writeUTF("Salas: " + Arrays.toString(Servidor.getSalas().toArray()));
					
				}
				else {
					for (EscuchaCliente conectado : Servidor.getClientesConectados()) {
						if (conectado.salaID.equals(this.salaID) && !conectado.nick.equals(this.nick))
							conectado.salidaDatos.writeUTF(this.nick + " : " + comando[2]);
					}
					
					
				}
				
				System.out.println("Recibí: " + cadenaLeida);
				
				cadenaLeida = (String) entradaDatos.readUTF();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
    
    
}
