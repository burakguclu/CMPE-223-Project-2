//-----------------------------------------------------
// Title: Programming Assignment 2 - Question 2 SortingAlgorithmTester.java
// Author: Burak Güçlü
// Description: This class is used for testing the  
// different sorting algorithms and making experimental 
// analyzing of their behaviors.
//-----------------------------------------------------

import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithmTester {

	public static void main(String[] args) {

		String[] sortOptions = { "Selection", "Insertion", "Merge", "Quick" };
		// I created different sort options in an array so that I can reach them by just
		// using their index.

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a seed to create random generated values :");
		int seed = input.nextInt();
		System.out.println("Seed : " + seed);
		Random random = new Random(seed);
		// To create an array with different numbers, we use random method with seed
		// value.

		int[] size = { 250, 1000, 4000, 16000, 64000 };
		// I created "size" array with the sizes we are given, in order to use them in
		// the for loop.

		for (int a = 0; a < size.length; a++) {
			// This for loop is used for working with different size values.

			Integer[] arr = new Integer[size[a]];
			// Array created with the chosen size value.

			System.out.println("Input size: " + size[a]);
			for (int i = 0; i < size[a]; i++)
				arr[i] = random.nextInt();
			// Putting numbers, which are created randomly, into the array one by one.

			for (int b = 0; b < sortOptions.length; b++) {
				// This for loop is used for working with different sorting options. It works
				// with the "sortOptions" array which is created earlier.

				System.out.println();
				System.out.println("Sort option: " + sortOptions[b]);
				// Showing which sorting algorithm is working now.

				System.out.println("Random");
				// Firstly, sorting algorithm works with the array which is random ordered.

				// Long[] times1 = new Long[3];
				for (int j = 0; j < 3; j++) {
					// Long t1 = System.currentTimeMillis(); // Keeping the starting time.

					Method.Method(arr, sortOptions[b]);
					// Calling the method that is used for picking an sorting
					// algorithm to work with.

					// Long t2 = System.currentTimeMillis(); // Keeping the ending time.

					// 	times1[j] = t2 - t1;
					// By taking the difference between starting and ending times, it finds the
					// runtime.
				}
				// Insertion.sort(times1);
				// System.out.println("Time: " + times1[1]);
				// To find an accurate result for our measurements, we use median of 3 results.

				Merge.sort(arr);
				// Since the next part needs an ascending ordered integer array, program sorts
				// the array as needed.

				System.out.println("Ascending");
				// Secondly, sorting algorithm works with the array which is ascending ordered.

				// Long[] times2 = new Long[3];
				for (int j = 0; j < 3; j++) {
					// Long t1 = System.currentTimeMillis(); // Keeping the starting time.

					Method.Method(arr, sortOptions[b]);
					// Calling the method that is used for picking an sorting
					// algorithm to work with.

					// Long t2 = System.currentTimeMillis(); // Keeping the ending time.

					// times2[j] = t2 - t1;
					// By taking the difference between starting and ending times, it finds the
					// runtime.
				}
				// Insertion.sort(times2);
				// System.out.println("Time: " + times2[1]);
				// Again, to find an accurate result for our measurements, we use median of 3
				// results.

                reverseOrder(arr);
				// Since the next part needs a descending ordered integer array, this method
				// reverse the order of already sorted array.

				System.out.println("Descending");
				// Finally, sorting algorithm works with the array which is descending ordered.

				// Long[] times3 = new Long[3];
				for (int j = 0; j < 3; j++) {
					// Long t1 = System.currentTimeMillis(); // Keeping the starting time.

					Method.Method(arr, sortOptions[b]);
					// Calling the method that is used for picking an sorting
					// algorithm to work with.

					// Long t2 = System.currentTimeMillis(); // Keeping the ending time.

					// times3[j] = t2 - t1;
					// By taking the difference between starting and ending times, it finds the
					// runtime.
				}
				// Insertion.sort(times3);
				// System.out.println("Time: " + times3[1]);
				// Again, to find an accurate result for our measurements, we use median of 3
				// results.

				StdRandom.shuffle(arr);
				// In this part, the inner loop is done for the current number, so it will
				// change the sorting option. To avoid providing an ordered array for the next
				// algorithm, I use shuffle method to make it randomly distributed.
			}
		}
	}
	
	public static Integer[] reverseOrder(Integer[] arr) {
		// --------------------------------------------------------
		// Summary: This method is being used for reversing the order
		// of the Integer arr given in the parameter.
		// Precondition: arr is Integer array which includes some
		// integers in it.
		// Postcondition: It returns the same array in the reverse order.
		// --------------------------------------------------------

		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i]; // Keeping a temporary integer to save data.
			arr[i] = arr[arr.length - 1 - i]; // Changing the integers' places from beginning and end.
			arr[arr.length - 1 - i] = temp; // Putting the temp number into other place.
		}
		return arr;
	}
	
}