//-----------------------------------------------------
// Title: Programming Assignment 2 - Question 1 Merge.java
// Author: Burak Güçlü
// Description: This class is used for applying Merge sort.
//-----------------------------------------------------

public class Merge {
	private static boolean less(Comparable v, Comparable w) {
		// --------------------------------------------------------
		// Summary: This method is being used for checking if the first
		// parameter is less than the second one.
		// Precondition: Comparable v is an array object that can be compared,
		// Comparable w is also an array object that can be compared.
		// Postcondition: It returns a number that represents the result
		// of comparison.
		// --------------------------------------------------------
		return v.compareTo(w) > 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		// --------------------------------------------------------
		// Summary: This method is being used for exchanging the places
		// of two elements in the array.
		// Precondition: Comparable a is an array object that can be compared,
		// i and j are integer that represents the places of the elements.
		// Postcondition: It changes the items' places in the array a.
		// --------------------------------------------------------
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static Comparable[] aux; // Creating auxiliary array for merging.

	public static void sort(Comparable[] a) {
		// --------------------------------------------------------
		// Summary: This method is being used for sorting the items in the array
		// in increasing order by using an auxiliary array to compare with.
		// Inside of the method, it uses the other sort method.
		// Precondition: Comparable a is an array object that can be compared.
		// Postcondition: It sorts the array a in increasing order.
		// --------------------------------------------------------
		aux = new Comparable[a.length]; // Allocate space just once.
		sort(a, 0, a.length - 1);
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].
		// --------------------------------------------------------
		// Summary: This method is being used for merging the items in the array
		// by checking their values.
		// Precondition: Comparable a is an array object that can be compared.
		// lo, mid and hi are integers for keeping the value of the places in the array.
		// Postcondition: It merges the two array.
		// --------------------------------------------------------
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
	}

	private static void sort(Comparable[] a, int lo, int hi) { // Sort a[lo..hi].
		// --------------------------------------------------------
		// Summary: This method is being used for sorting the items in the array
		// in increasing order. It is a recursive method, since it calls itself.
		// Precondition: Comparable a is an array object that can be compared.
		// lo and hi are integers for keeping the value of the places in the array.
		// Postcondition: It sorts the array a in increasing order.
		// --------------------------------------------------------
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid); // Sort left half.
		sort(a, mid + 1, hi); // Sort right half.
		merge(a, lo, mid, hi); // Merge results (code on page 271).
	}
}