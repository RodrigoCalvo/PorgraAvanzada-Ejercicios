package cliente;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


    
public class EscribeCliente extends Thread {
	

	private Socket socket;  
    private DataInputStream entradaDatos;
    private DataOutputStream salidaDatos;
    private Comando comando;
	
	public EscribeCliente(Socket socket, DataInputStream entradaDatos, DataOutputStream salidaDatos, Comando comando) {

		this.socket = socket;
		this.entradaDatos = entradaDatos;
		this.salidaDatos = salidaDatos;
		this.comando = comando;
	}

	@Override
	public void run() {
		try {
			
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String mensaje = br.readLine();
		
        while (true) {
        	if (!mensaje.equals("")) {
        	
        		comando.setMensaje(mensaje);
        	
        		if(comando.getMensaje().startsWith("#")) {
        			String sala = comando.getMensaje().replace("#", "");
				
					comando.setSalaID(sala);
				}
				salidaDatos.writeUTF(comando.toString());
        	}
			mensaje = br.readLine();
        }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

    
}
