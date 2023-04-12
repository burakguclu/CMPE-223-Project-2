//-----------------------------------------------------
// Title: Programming Assignment 2 - Question 2 Method.java
// Author: Burak Güçlü
// Description: This class is includes three different methods
// which are used for choosing which algorithm will be used
// to sort the array and also finding the smallest
// pairwise difference in the sorted array.
//-----------------------------------------------------

import java.util.Scanner;

public class Method {

	public static void Method(Integer[] arr, String option) {
		// --------------------------------------------------------
		// Summary: This method is being used for choosing the sorting
		// algorithm and finding the smallest pairwise difference
		// in the sorted array.
		// Precondition: arr is Integer array which includes some
		// integers in it. option is a String variable which is
		// used for deciding which sorting will be used.
		// Postcondition: It writes the smallest pairwise difference.
		// --------------------------------------------------------

		option = option.toLowerCase();
		// In order to make an accurate comparison in the switch statement, I make all
		// letters in the algorithm options lower.

		switch (option) {
		// I used swtich-case statement to decide which algorithm will be used for
		// sorting.

		case "selection":
			Selection.sort(arr); // It uses the sort method in the Selection class.
			pairwiseDifference(arr); // It finds the smallest pairwise difference in the sorted array.
			break;
		case "insertion":
			Insertion.sort(arr); // It uses the sort method in the Insertion class.
			pairwiseDifference(arr); // It finds the smallest pairwise difference in the sorted array.
			break;
		case "merge":
			Merge.sort(arr); // It uses the sort method in the Merge class.
			pairwiseDifference(arr); // It finds the smallest pairwise difference in the sorted array.
			break;
		case "quick":
			Quick.sort(arr); // It uses the sort method in the Quick class.
			pairwiseDifference(arr); // It finds the smallest pairwise difference in the sorted array.
			break;
		default:
			System.out.println("Enter a valid sorting algorithm");
			// If the chosen sorting algorithm does not matches with the provided ones,
			// program writes this message.
		}
	}

	public static void pairwiseDifference(Integer[] arr) {
		// --------------------------------------------------------
		// Summary: This method is being used for finding the smallest pairwise
		// difference in the sorted array.
		// Precondition: arr is Integer array which includes some
		// integers in it.
		// Postcondition: It writes the smallest pairwise difference and the numbers
		// which were taken to find this difference.
		// --------------------------------------------------------
		int index1 = 0;
		int index2 = 1;
		int min = Math.abs(arr[index2] - arr[index1]);
		// Difference may be negative number, so we have to use Math.abs() method to
		// find an accurate result.

		for (int i = 1; i < arr.length - 1; i++) {
			// This for loop travels along the array and search for the smallest pairwise
			// difference.
			// Its complexity is O(n), since it just visits all the elements once.

			int temp = Math.abs(arr[i + 1] - arr[i]);
			if (temp < min) { // If the new result is less then min result, exchange them.
				min = temp;
				index1 = i;
				index2 = i + 1;
				// Indexes are picked for showing the numbers in the next step.
			}
		}

		System.out.print(min);
		// The smallest pairwise difference.

		System.out.print(" [" + arr[index1] + " " + arr[index2] + "]");
		// Two numbers which is used for finding the smallest pairwise difference.

		System.out.println();

	}

//	public static void main(String[] args) {
//		Integer[] arr = { 113, 23, 1, 109, 4, 102, 7, 105, 100, 107 };
//		// We are given this numbers to work with.
//
//		Scanner input = new Scanner(System.in);
//		StdOut.println("Enter the sort you want to use:");
//		// Asking the user which sorting algorithm he or she wants to use.
//
//		String sortingType = input.next(); // Taking the answer.
//		sortingType = sortingType.toLowerCase(); // To avoid mismatches with the options.
//
//		Method(arr, sortingType);
//
//	}
}
