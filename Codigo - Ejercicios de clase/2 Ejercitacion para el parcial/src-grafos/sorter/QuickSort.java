package sorter;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSort <T> extends Ordenador<T> {
	
	public QuickSort(ArrayList<T> aOrdenar, Comparator<T> comparador) {
		super(aOrdenar, comparador);
	}

	@Override
	public ArrayList<T> realizarOrdenamiento() {
		if (super.aOrdenar == null || super.aOrdenar.size() == 0){
            return super.aOrdenar;
        }
        quicksort(0, super.aOrdenar.size() - 1);
        
        return super.aOrdenar;
	}
	
	private void quicksort(int low, int high) {
        int i = low, j = high;
        T pivot = super.aOrdenar.get(low + (high-low)/2);

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (super.comparador.compare(super.aOrdenar.get(i), pivot) < 0) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (super.comparador.compare(super.aOrdenar.get(j), pivot) > 0) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
            	intercambiar(i, j);
                i++;
                j--;
            }
        }
        
        // recursividad
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void intercambiar(int i, int j) {
        T temp = super.aOrdenar.get(i);
        super.aOrdenar.set(i, super.aOrdenar.get(j));
        super.aOrdenar.set(j, temp);
    }
}
