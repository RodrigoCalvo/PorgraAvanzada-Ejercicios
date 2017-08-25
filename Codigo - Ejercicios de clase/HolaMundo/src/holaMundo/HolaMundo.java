package holaMundo;

import java.util.UUID;

public class HolaMundo {

	public static void main(String[] args) {
		System.out.print("Hola mundo 2");
		System.out.println("Hola mundo 2");
		System.out.println();
		System.out.println();
		
		do
		{			  
			System.out.println(UUID.randomUUID().toString());
		}
		while(true);
	}

}
