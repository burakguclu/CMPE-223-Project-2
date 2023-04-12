//-----------------------------------------------------
// Title: Programming Assignment 2 - Question 1 Main.java
// Author: Burak Güçlü
// Description: This class is used for applying the steps
// in the assignment step by step. It uses some sorting 
// algorithms -some of them modified- to put the arrays
// into a specific order.
//-----------------------------------------------------

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int numbers[] = readFilesInt("integers.txt");
		// To reach the integers in the txt file, I used readFiles method which is
		// already given for us. But I modified it to read integers specifically.

		int n = numbers.length;
		Integer[] arr = new Integer[n];
		// Since we are working with Comparable classes, it is necessary to use Wrapper
		// class instead of integer type.

		for (int i = 0; i < n; i++) {
			// This for loop is being used for filling the array with integers coming from
			// the txt file.
			arr[i] = numbers[i];
		}

		// ------------ Step 1 is started here. ------------
		System.out.println("Integers are reading from the integers.txt file, the array is:");
		printArray(arr);
		Insertion.sort(arr);
		// We are expected to use Insertion sort to sort the integers in increasing
		// order.

		System.out.println("The array has been sorted in increasing order by using the insertion sort algorithm:");
		printArray(arr);
		System.out.println("Step 1 has been completed.");
		System.out.println();
		// ------------ Step 1 is done here. ------------

		// ------------ Step 2 is started here. ------------
		System.out.println(
				"The array of integers that has been sorted in decreasing order by using the insertion sort algorithm:");
		Insertion.decreasingSort(arr);
		// I used the modified version of Insertion sort to sort the integers in
		// decreasing order.

		printArray(arr);
		System.out.println("Step 2 has been completed.");
		System.out.println();
		// ------------ Step 2 is done here. ------------

		double numbersDouble[] = readFilesDouble("doubles.txt");
		// To reach the doubles in the txt file, I used readFiles method which is
		// already given for us. But I modified it to read doubles specifically.

		int n2 = numbersDouble.length;
		Double[] arrDouble = new Double[n2];
		// Since we are working with Comparable classes, it is necessary to use Wrapper
		// class instead of integer type.

		for (int i = 0; i < n2; i++) {
			// This for loop is being used for filling the array with integers coming from
			// the txt file.
			arrDouble[i] = numbersDouble[i];
		}

		// ------------ Step 3 is started here. ------------
		System.out.println("Doubles are reading from the doubles.txt file, the array is:");
		printArray(arrDouble);
		Insertion.sort(arrDouble);
		// We are expected to use Insertion sort to sort the doubles in increasing
		// order.

		System.out.println(
				"The array of double values has been sorted in increasing order by using the insertion sort algorithm:");
		printArray(arrDouble);
		System.out.println("Step 3 has been completed.");
		System.out.println();
		// ------------ Step 3 is done here. ------------

		int newNumbers[] = readFilesInt("integers.txt");
		int n3 = newNumbers.length;
		Integer[] newArr = new Integer[n];
		for (int i = 0; i < n; i++) {
			newArr[i] = newNumbers[i];
		}
		// Since we need to sort the same array with merge sort this time, the integers
		// are read again using the same method.

		// ------------ Step 4 is started here. ------------
		System.out.println("The original array is:");
		printArray(newArr);
		Merge.sort(newArr);
		// We are expected to use Merge sort to sort the integers in descending order.
		// It is a modified version of Merge sort. Initially it was sorting in ascending
		// order. Now, it sorts in descending order.

		System.out.println(
				"The array of integer values has been sorted in descending order by using the merge sort algorithm is:");
		printArray(newArr);
		System.out.println("Step 4 has been completed.");
		System.out.println();
		// ------------ Step 4 is done here. ------------

		// ------------ Step 5 is started here. ------------
		Route[] routes = new Route[10];
		// I created a Route array with 10 elements.

		routes[0] = new Route("Ankara", "Antalya");
		routes[1] = new Route("Ankara", "Istanbul");
		routes[2] = new Route("Istanbul", "Antalya");
		routes[3] = new Route("Antalya", "Izmir");
		routes[4] = new Route("Izmir", "Antalya");
		routes[5] = new Route("Izmir", "Ankara");
		routes[6] = new Route("Antalya", "Ankara");
		routes[7] = new Route("Ankara", "Izmir");
		routes[8] = new Route("Istanbul", "Izmir");
		routes[9] = new Route("Istanbul", "Ankara");
		// ------------ Step 5 is done here. ------------

		// ------------ Step 6 is started here. ------------
		Quick.sort(routes);
		// We are expected to sort the Routes objects with respect to their source and
		// destinations.

		for (int i = 0; i < routes.length; i++)
			System.out.println(routes[i].source() + " " + routes[i].destination());
		// Writing sorted elements

		System.out.println();
		System.out.println("Step 6 has been completed.");
		// ------------ Step 6 is done here. ------------

		// ------------ Step 7 is started here. ------------
		// I just modified the Quick.java which now includes a decreasing order option.
		// ------------ Step 7 is done here. ------------

		// ------------ Step 8 is started here. ------------
		// In part 8, we are asked to modify recursive Quick sort method to work with it
		// until the depth becomes 0, after that Merge sort will be used.
		// int depth = (int) (2 * Math.log(routes.length));
		// Question expects a depth which is approximately 2logN.

		// Quick.decreasingSort(routes, depth);
		// I used the modified version of Quick sort which has a integer parameter as
		// depth and sorts the array in descending order.

		// for (int i = 0; i < routes.length; i++)
		// 	System.out.println(routes[i].source() + " " + routes[i].destination());
		// ------------ Step 8 is done here. ------------
	}

	private static int[] readFilesInt(String file) {
		// --------------------------------------------------------
		// Summary: This method is being used for reading the integers
		// from a txt file.
		// Precondition: file is a String which represents the path to
		// txt file including integers in it.
		// Postcondition: It returns an integer array which includes
		// all the integer elements in the txt file.
		// --------------------------------------------------------
		try {
			File f = new File(file);
			Scanner s = new Scanner(f);
			int n = 0;

			while (s.hasNextInt()) { // This while loop counts the number of elements in the file.
				n++;
				s.nextInt();
			}
			int S[] = new int[n];

			Scanner s1 = new Scanner(f);

			for (int i = 0; i < S.length; i++) // This for loop adds the integers into the array.
				S[i] = s1.nextInt();

			return S;

		} catch (Exception e) {
			return null;
		}
	}

	private static double[] readFilesDouble(String file) {
		// --------------------------------------------------------
		// Summary: This method is being used for reading the doubles
		// from a txt file.
		// Precondition: file is a String which represents the path to
		// txt file including doubles in it.
		// Postcondition: It returns an double array which includes
		// all the double elements in the txt file.
		// --------------------------------------------------------
		try {
			File f = new File(file);
			Scanner s = new Scanner(f);
			int n = 0;

			while (s.hasNextDouble()) {// This while loop counts the number of elements in the file.
				n++;
				s.nextDouble();
			}
			double S[] = new double[n];

			Scanner s1 = new Scanner(f);

			for (int i = 0; i < S.length; i++)// This for loop adds the integers into the array.
				S[i] = s1.nextDouble();

			return S;

		} catch (Exception e) {
			return null;
		}
	}

	public static void printArray(Integer[] arr)
	// --------------------------------------------------------
	// Summary: This method is being used for printing all the
	// integer elements in the given array.
	// Precondition: arr is Integer array which includes integer
	// elements in it.
	// Postcondition: It prints all the integers in the given array.
	// --------------------------------------------------------

	{
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void printArray(Double[] arr)
	// --------------------------------------------------------
	// Summary: This method is being used for printing all the
	// double elements in the given array.
	// Precondition: arr is Double array which includes double
	// elements in it.
	// Postcondition: It prints all the doubles in the given array.
	// --------------------------------------------------------
	{
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}