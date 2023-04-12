//-----------------------------------------------------
// Title: Programming Assignment 2 - Question 1 Quick.java
// Author: Burak Güçlü
// Description: This class is used for applying Quick sort.
//-----------------------------------------------------

public class Quick {
	private static boolean less(Comparable v, Comparable w) {
		// --------------------------------------------------------
		// Summary: This method is being used for checking if the first
		// parameter is less than the second one.
		// Precondition: Comparable v is an array object that can be compared,
		// Comparable w is also an array object that can be compared.
		// Postcondition: It returns a number that represents the result
		// of comparison.
		// --------------------------------------------------------
		return v.compareTo(w) < 0;
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

	private static int partition(Comparable[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
		// --------------------------------------------------------
		// Summary: This method is being used for dividing the array into two part
		// and makes the sorting quicker by checking elements from the both sides.
		// Precondition: Comparable a is an array object that can be compared.
		// lo and hi are integers for keeping the value of the places in the array.
		// Postcondition: It returns a number that can be chosen as a pivot and puts it
		// in a appropriate place in the array.
		// --------------------------------------------------------
		int i = lo, j = hi + 1; // left and right scan indices
		Comparable v = a[lo]; // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, and exchange.
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j); // Put v = a[j] into position
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}

	public static void sort(Comparable[] a) {
		// --------------------------------------------------------
		// Summary: This method is being used for sorting the items in the array
		// in increasing order by using an auxiliary array to compare with.
		// Inside of the method, it uses the other sort method.
		// Precondition: Comparable a is an array object that can be compared.
		// Postcondition: It sorts the array a in increasing order.
		// --------------------------------------------------------
		StdRandom.shuffle(a); // Eliminate dependence on input.
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		// --------------------------------------------------------
		// Summary: This method is being used for sorting the items in the array
		// in increasing order. It is a recursive method, since it calls itself.
		// Precondition: Comparable a is an array object that can be compared.
		// lo and hi are integers for keeping the value of the places in the array.
		// Postcondition: It sorts the array a in increasing order.
		// --------------------------------------------------------
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi); // Partition (see page 291).
		sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
		sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
	}

	private static boolean more(Comparable v, Comparable w) {
		// --------------------------------------------------------
		// Summary: This method is being used for checking if the first
		// parameter is more than the second one.
		// Precondition: Comparable v is an array object that can be compared,
		// Comparable w is also an array object that can be compared.
		// Postcondition: It returns a number that represents the result
		// of comparison.
		// --------------------------------------------------------
		return v.compareTo(w) > 0;
	}

	private static int decreasingPartition(Comparable[] a, int lo, int hi) {
		// --------------------------------------------------------
		// Summary: This method is being used for dividing the array into two part
		// and makes the sorting quicker by checking elements from the both sides.
		// Precondition: Comparable a is an array object that can be compared.
		// lo and hi are integers for keeping the value of the places in the array.
		// Postcondition: It returns a number that can be chosen as a pivot and puts it
		// in a appropriate place in the array.
		// --------------------------------------------------------
		int i = lo, j = hi + 1; // left and right scan indices
		Comparable v = a[lo]; // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, and exchange.
			while (more(a[++i], v))
				if (i == hi)
					break;
			while (more(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j); // Put v = a[j] into position
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}

	public static void decreasingSort(Comparable[] a, int depth) {
		// --------------------------------------------------------
		// Summary: This method is being used for sorting the items in the array
		// in decreasing order by using an auxiliary array to compare with.
		// Inside of the method, it uses the other sort method.
		// Precondition: Comparable a is an array object that can be compared.
		// depth is an integer to execute this method for specific time.
		// Postcondition: It sorts the array a in decreasing order.
		// --------------------------------------------------------
		StdRandom.shuffle(a); // Eliminate dependence on input.
		decreasingSort(a, 0, a.length - 1, depth);
	}

	private static void decreasingSort(Comparable[] a, int lo, int hi, int depth) {
		// --------------------------------------------------------
		// Summary: This method is being used for sorting the items in the array
		// in decreasing order. It is a recursive method, since it calls itself.
		// Precondition: Comparable a is an array object that can be compared.
		// lo and hi are integers for keeping the value of the places in the array.
		// depth is an integer to execute this method for specific time.
		// Postcondition: It sorts the array a in decreasing order.
		// --------------------------------------------------------
		if (hi <= lo)
			return;
		if (depth == 0)
			Merge.sort(a);
		else {
			int j = decreasingPartition(a, lo, hi); // Partition (see page 291).
			decreasingSort(a, lo, j - 1, depth); // Sort left part a[lo .. j-1].
			decreasingSort(a, j + 1, hi, depth); // Sort right part a[j+1 .. hi].
			depth--;
		}
	}
}