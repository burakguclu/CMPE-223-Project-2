//-----------------------------------------------------
// Title: Programming Assignment 2 - Question 1 Route.java
// Author: Burak Güçlü
// Description: This class is used for creating Route
// objects with two String element source and destination.
//-----------------------------------------------------

public class Route implements Comparable<Route> {
	private final String source;
	private final String destination;

	public Route(String s, String d) {
		// --------------------------------------------------------
		// Summary: This is a constructor method which is being used for creating
		// initial Route objects.
		// Precondition: s is a String that is used for initializing source,
		// d is a String that is used for initializing destination.
		// Postcondition: It creates a Route object with given parameters.
		// --------------------------------------------------------
		source = s;
		destination = d;
	}

	public String source() {
		// --------------------------------------------------------
		// Summary: This is a getter class for reaching the data in the class.
		// Postcondition: It returns source value.
		// --------------------------------------------------------
		return source;
	}

	public String destination() {
		// --------------------------------------------------------
		// Summary: This is a getter class for reaching the data in the class.
		// Postcondition: It returns destination value.
		// --------------------------------------------------------
		return destination;
	}

	public int compareTo(Route that) {
		// --------------------------------------------------------
		// Summary: This method is used for comparing two Route object with respect
		// to their source and destination alphabetically.
		// Precondition: that is Route object which is used for comparing with
		// data selected.
		// Postcondition: It returns a number that respresent the
		// result of comparison.
		// --------------------------------------------------------
		if (this.source.compareTo(that.source) > 0)
			return +1;
		if (this.source.compareTo(that.source) < 0)
			return -1;
		if (this.destination.compareTo(that.destination) > 0)
			return +1;
		if (this.destination.compareTo(that.destination) < 0)
			return -1;
		return 0;
	}

	public String toString() {
		// --------------------------------------------------------
		// Summary: This method is used for writing the data in as String
		// Postcondition: It returns a String as expected.
		// --------------------------------------------------------
		return source + "/" + destination;
	}
}
