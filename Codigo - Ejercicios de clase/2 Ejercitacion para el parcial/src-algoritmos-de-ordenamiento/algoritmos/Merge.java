package algoritmos;

import java.util.ArrayList;
import java.util.Comparator;

public class Merge<T> extends Ordenador<T> {
	
	public Merge(ArrayList<T> aOrdenar, Comparator<T> comparador) {
		super(aOrdenar, comparador);
	}

	private ArrayList<T> aux;
	
	@Override
	public ArrayList<T> realizarOrdenamiento() {
		aux = new ArrayList<T>(super.aOrdenar.size());
		
		for(int i = 0; i < super.aOrdenar.size(); i++)
			aux.add(null);
		
		mergesort(0, super.aOrdenar.size() - 1);
		
		return super.aOrdenar;
	}


    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            aux.set(i, super.aOrdenar.get(i));
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (comparador.compare(aux.get(i), aux.get(j)) <= 0) {
            	super.aOrdenar.set(k, aux.get(i));
                i++;
            } else {
            	super.aOrdenar.set(k, aux.get(j));
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
        	super.aOrdenar.set(k, aux.get(i));
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
}
