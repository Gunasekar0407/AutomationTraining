package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class InsertionSet {
	public void hashSet() {
		HashSet<String> set = new HashSet<String>();
		set.add("Cycle");
		set.add("Bike");
		set.add("Car");
		set.add("Van");
		set.add("Bus");
		System.out.println("Insertion Order of HashSet" + set);
	}

	public void linkedHashSet() {
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("Cycle");
		set.add("Bike");
		set.add("Car");
		set.add("Van");
		set.add("Bus");
		System.out.println("Insertion Order of LinkedHashSet" + set);
	}

	public void treeset() {
		TreeSet<String> set = new TreeSet<String>();
		set.add("Cycle");
		set.add("Bike");
		set.add("Car");
		set.add("Van");
		set.add("Bus");
		System.out.println("Insertion Order of TreeSet" + set);
		System.out.println("Descending Order" + set.descendingSet());
	}

	public static void main(String[] args) {
		InsertionSet insertionSet = new InsertionSet();
		insertionSet.hashSet();
		insertionSet.linkedHashSet();
		insertionSet.treeset();
	}
}
