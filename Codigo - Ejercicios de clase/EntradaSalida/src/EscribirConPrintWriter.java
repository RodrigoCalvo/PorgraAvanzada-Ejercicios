
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

// esto es un ejemplo minimo para  grabar sus datos en un archivo  de texto
public class EscribirConPrintWriter {

	public static void main(String[] args)	throws IOException {
		
		//String miPath = "\\gus\\programas\\workspace\\";
		String miPath = "";
		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath+"salida.out"));  //  preparo el arch de salida
	     
	    int z=50;
	    String s="dni:";
	    salida.println(s);      
		salida.println(" "+z); 
		salida.print(true);
		salida.println(UUID.randomUUID());
		salida.write("lol");
		salida.close(); //esto escribe : dni: 50

	}

}
