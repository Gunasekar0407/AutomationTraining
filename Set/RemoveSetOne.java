package Set;

import java.util.HashSet;
import java.util.Set;

public class RemoveSetOne {
	Set<String> hashSet = new HashSet<String>();

	public void firstRemovalMethod() {
		hashSet.add("Cycle");
		hashSet.add("Bike");
		hashSet.add("Car");
		hashSet.add("Van");
		hashSet.add("Bus");
		System.out.println("Removing values :" + hashSet.remove("Apple"));
		System.out.println("Data After Removal" + hashSet);
	}

	public void secondRemoveMethod() {
		hashSet.add("Cycle");
		hashSet.add("Bike");
		hashSet.add("Car");
		hashSet.add("Van");
		hashSet.add("Bus");
		System.out.println("Removing values :" + hashSet.removeAll(hashSet));
		System.out.println("All Datas are Removed" + hashSet);
	}

	public void thirdRemoveMethod() {
		hashSet.add("Cycle");
		hashSet.add("Cycle");
		hashSet.add("Car");
		hashSet.add("Van");
		hashSet.add("Bus");
		hashSet.clear();
		System.out.println("All Datas are Removed" + hashSet);
	}

	public static void main(String[] args) {
		RemoveSetOne removeSetOne = new RemoveSetOne();
		removeSetOne.firstRemovalMethod();
		removeSetOne.secondRemoveMethod();
	}

}
