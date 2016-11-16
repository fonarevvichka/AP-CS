//********************************************************************
//  Sorts.java       Author:
//
//  A collection of methods for sorting Arrays.
//********************************************************************
package com.company;
 public class Sorts {
    
	private static int[] temp;
	
	public static int Insertion(int[] list) {
		for (int n = 1; n < list.length; n++) {
			// Save the next element to be inserted:
			int listTemp = list[n];
			// Going backward from list[n-1], shift elements to the
			// right until you find an element list[i] <= aTemp:
			int i = n;
			while (i > 0 && listTemp < list[i-1]) { // everytime it goes back through the list untill it reaches a part that is already correct
				list[i] = list[i-1];				// this allows it to check for new errors caused by the first switch of the loop
				i--;
			}
			
			// Insert the saved element after a[i]:
			list[i] = listTemp;
			
			// Increment n (accomplished by n++ in the for loop).
		}
		
        return 0;
    }
    public static int Selection(int[] list) {
		for (int n = list.length; n > 1; n--) {
			// Find the index iMax of the largest element
			//   among list[0], ..., list[n-1]:
			
			int iMax = 0;
			for (int i = 1; i < n; i++) {
				if (list[i] > list[iMax])
					iMax = i; //it goes through the list looking for a largest value and once it finds it it writes it to a new loop
			}
			
			swap (list, iMax, n-1);
			
			// int listTemp = list[iMax];
			// list[iMax] = list[n-1];
			// list[n-1] = listTemp;
			
			// Decrement n (accomplished by n-- in the for loop).
		}
        return 0;
    }
    public static int Merge(int[] list, int from, int middle, int to) {
		temp = new int[list.length];
		int i = from, j = middle + 1, k = from;
		
		// While both arrays have elements left unprocessed:
		while (i <= middle && j <= to) {
			if (list[i] < list[j]) {
				temp[k] = list[i];   // Or simply temp[k] = a[i++];
				i++;
			}
			else {
				temp[k] = list[j];
				j++;
			}
			k++;
		}
		//the above section sorts each half
		
		// Copy the tail of the first half, if any, into temp:
		while (i <= middle) {
			temp[k] = list[i];     // Or simply temp[k++] = a[i++]
			i++;
			k++;
		}
		
		// Copy the tail of the second half, if any, into temp:
		while (j <= to) {
			temp[k] = list[j];     // Or simply temp[k++] = a[j++]
			j++;
			k++;
		}
		
		// Copy temp back into a
		for (k = from; k <= to; k++)
			list[k] = temp[k];
		return 0;
    }
	public static int mergeSort(int[] list, int from, int to) {
		// this sort individually sorts two halves of the list and then combines them by comparing the lements of each sequantially.
		if (to - from < 2) {       // Base case: 1 or 2 elements
			if (to > from && list[to] < list[from]) {
				int listTemp = list[to];  // swap a[to] and a[from]
				list[to] = list[from];
				list[from] = listTemp;
			}
		}
		else {                     // Recursive case
			int middle = (from + to) / 2;
			mergeSort(list, from, middle);
			mergeSort(list, middle + 1, to);
			Merge(list, from, middle, to);
		}
		return 0;
	}
    public static int QuickSort(int[] list, int from, int to) {
		if (from >= to)
			return 0;
		//take a center value and use it as a pivot putting everything lower and higher (hence pivot) repeat on fromed sections recusvily untill sorting is achieved
		// Choose pivot list[p]:
		int p = from;
		// The choice of the pivot location may vary:
		//   you can also use p = from or p = to or use 
		//   a fancier method, say, the median of the above three.
		
		// Partition:
		
		int i = from; // it uses the pivot point to compare all values to, and places
					  // those that are smaller switch with the first value of the uncorrected list, thi socntniues until every value has been a pivot
		int j = to;
		while (i <= j) {
			if (list[i] <= list[p])
				i++;
			else if (list[j] >= list[p])
				j--;
			else {
				swap (list, i, j);
				i++;
				j--;
			}
		}
		
		// Finish partitioning:
		
		if (p < j) {   // place the pivot in its correct position
			swap (list, j, p);
			p = j;
		}
		else if (p > i) {
			swap (list, i, p);
			p = i;
		}
		
		// Sort recursively:
		QuickSort(list, from, p - 1);
		QuickSort(list, p + 1, to);
		
		return 0;
	}
    public static int QuickMid(int[] list) {
    
		return 0;
    }
	public static int QuickRandom(int[] list) {
    
		return 0;
    }
    private static void swap (int[] list, int a, int b) {
        int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
    }
}