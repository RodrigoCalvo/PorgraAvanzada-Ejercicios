package algoritmos;

import java.util.Arrays;

import grafo.MatrizSimetrica;

public class Prim {
	MatrizSimetrica matrizSimetrica;

	public Prim(MatrizSimetrica matrizSimetrica) {
		this.matrizSimetrica = matrizSimetrica;
	}
	
	public void doPrim() {
		int V = this.matrizSimetrica.getMatrizSize();
		
		int[] parent = new int[V]; 	// Array to store constructed MST
		int[] key = new int[V];   // Key values used to pick minimum weight edge in cut
	    boolean[] mstSet = new boolean[V];  // To represent set of vertices not yet included in MST
	 
	     // Initialize all keys as INFINITE
	    for (int i = 0; i < V; i++) {
	    	key[i] = Integer.MAX_VALUE;
	    	mstSet[i] = false;
	    }
	 
	     // Always include first 1st vertex in MST.
	     key[V-1] = 0;     // Make key 0 so that this vertex is picked as first vertex
	     parent[V-1] = -1; // First node is always root of MST 
	 
	     // The MST will have V vertices
	     for (int count = 0; count < V-1; count++)
	     {
	        // Pick the minimum key vertex from the set of vertices
	        // not yet included in MST
	        int u = minKey(key, mstSet);
	 
	        if(u < 1)
	        	continue;
	        
	        // Add the picked vertex to the MST Set
	        mstSet[u] = true;
	 
	        // Update key value and parent index of the adjacent vertices of
	        // the picked vertex. Consider only those vertices which are not yet
	        // included in MST
	        for (int v = 0; v < V; v++) {
	 
	           // graph[u][v] is non zero only for adjacent vertices of m
	           // mstSet[v] is false for vertices not yet included in MST
	           // Update the key only if graph[u][v] is smaller than key[v]
        		if (this.matrizSimetrica.getPos(u, v) > 0 && mstSet[v] == false && this.matrizSimetrica.getPos(u, v) <  key[v]) {
	        	  	parent[v]  = u; 
	             	key[v] = this.matrizSimetrica.getPos(u, v);
	          	}
	        }
        	System.out.println(Arrays.toString(key));
	     }
	}
	// A utility function to find the vertex with minimum key value, from
	// the set of vertices not yet included in MST
	private int minKey(int[] key, boolean[] mstSet)
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = 0;
		int V = this.matrizSimetrica.getMatrizSize();
	 
		for (int v = 0; v < V; v++) {
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		}
	     
	   return min_index;
	}
}
