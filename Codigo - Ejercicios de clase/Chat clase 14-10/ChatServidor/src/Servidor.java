import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
 
	
	public static ArrayList<EscuchaCliente> getClientesConectados() {
		return clientesConectados;
	}

	public static void setClientesConectados(ArrayList<EscuchaCliente> clientesConectados) {
		Servidor.clientesConectados = clientesConectados;
	}

	public static ArrayList<String> getSalas() {
		return salas;
	}

	public static void setSalas(ArrayList<String> salas) {
		Servidor.salas = salas;
	}

	private static ArrayList<EscuchaCliente> clientesConectados = new ArrayList<>();
	private static ArrayList<String> salas = new ArrayList<>();
	
    public static void main(String[] args) {
        int puerto = 12344;
        int maximoConexiones = 10; 
        ServerSocket servidor = null; 
        Socket socket = null;        
        
        try {
            // Se crea el serverSocket
            servidor = new ServerSocket(puerto, maximoConexiones);
            
            // Bucle infinito para esperar conexiones
            while (true) {
                System.out.println("Servidor a la espera de conexiones.");
                socket = servidor.accept();
                System.out.println("Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");                
                
                EscuchaCliente cc = new EscuchaCliente(socket);
                cc.start();
                clientesConectados.add(cc);
            }
            
        } catch (IOException ex) {
        	System.out.println("Error: " + ex.getMessage());
            
        } finally {
            try {
            	
                socket.close();
                servidor.close();
                
            } catch (IOException ex) {
            	
            	System.out.println("Error al cerrar el servidor: " + ex.getMessage());
                
            }
        }
    }
}