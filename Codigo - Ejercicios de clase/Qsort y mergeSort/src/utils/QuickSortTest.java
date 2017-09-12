package utils;

import static org.junit.Assert.*;
import quicksort.Quicksort;
import org.junit.Test;

public class QuickSortTest {

	@Test
	public void test() {
		int[] arr = new int[10];
		
		arr[0] = 90;
		arr[1] = 80;
		arr[2] = 70;
		arr[3] = 60;
		arr[4] = 50;
		arr[5] = 40;
		arr[6] = 30;
		arr[7] = 20;
		arr[8] = 10;
		arr[9] = 1;
		
		Quicksort sort = new Quicksort();
		
		System.out.println(arr);
		arr = sort.sort(arr);
		System.out.println(arr);
	}

}
