package cliente;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	private static Socket socket;
	
	private static EscribeCliente escribeCliente;
	
	public static void main(String[] args) {
		
		
        try {
            socket = new Socket("localhost", 12344);
        } catch (UnknownHostException ex) {
        	System.out.println("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
        } catch (IOException ex) {
        	System.out.println("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
        }
		
        DataInputStream entradaDatos = null;
        DataOutputStream salidaDatos = null;
        String mensaje;
        
        try {
        	
            entradaDatos = new DataInputStream(socket.getInputStream());
            salidaDatos = new DataOutputStream(socket.getOutputStream());
            
    		System.out.println("Ingresá tu nick");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));            
            String nick = br.readLine();
            
            Comando comando = new Comando();
            comando.setNick(nick);
            comando.setMensaje("/conectar");
            salidaDatos.writeUTF(comando.toString());
            
            escribeCliente = new EscribeCliente(socket, entradaDatos, salidaDatos, comando);
            escribeCliente.start();
            
        } catch (IOException ex) {
        	System.out.println("Error al crear el stream de entrada: " + ex.getMessage());
        } catch (NullPointerException ex) {
        	System.out.println("El socket no se creo correctamente. ");
        }
        
        boolean conectado = true;
        
        while (conectado) {
        	
            try {
            	
                mensaje = entradaDatos.readUTF();
                System.out.println(mensaje);
                
            } catch (IOException ex) {
            	System.out.println("Error al leer del stream de entrada: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
            	System.out.println("El socket no se creo correctamente. ");
                conectado = false;
            }
            
        }
	}

}
