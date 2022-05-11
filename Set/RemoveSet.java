package Set;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class RemoveSet {
	Scanner scan = new Scanner(System.in);

	public void removeFunctionOne() {
		System.out.println("Enter the Count Of Data Input");
		try {
		int count1 = scan.nextInt();		
		Set<String> hashSet = new HashSet<String>();
		for (int data = 0; data < count1; data++) {
			System.out.println("Enter the Data inputs");
			hashSet.add(scan.next());
		}
		System.out.println("Enter the Data which need to be removed");
		System.out.println("Removing values :" + hashSet.remove(scan.next()));
		System.out.println("Data After Removal" + hashSet);
		}
		catch (InputMismatchException exception) {
			System.out.println("Enter the Integer and String Values Correctly");
		}
	}

	public void removeFunctionTwo() {
		System.out.println("Enter the Count Of Data Input");
		try {
		int count2 = scan.nextInt();
		Set<String> hashSet = new HashSet<String>();
		for (int data = 0; data < count2; data++) {
			System.out.println("Enter the Data inputs");
			hashSet.add(scan.next());
		}
		System.out.println("Removing values :" + hashSet.removeAll(hashSet));
		System.out.println("All Datas are Removed" + hashSet);
	}
		catch (InputMismatchException exception) {
			System.out.println("Enter the Integer and String Values Correctly");
		}}

	public void removeFunctionThree() {
		System.out.println("Enter the Count Of Data Input");
		try {
		int count2 = scan.nextInt();
		Set<String> hashSet = new HashSet<String>();
		for (int data = 0; data < count2; data++) {
			System.out.println("Enter the Data inputs");
			hashSet.add(scan.next());
		}
		hashSet.clear();
		System.out.println("All Datas are Removed" + hashSet);
	} 	
		catch (InputMismatchException exception) {
		System.out.println("Enter the Integer and String Values Correctly");
	}}

	public static void main(String[] args) {
		RemoveSet removeSet = new RemoveSet();
		removeSet.removeFunctionOne();
		removeSet.removeFunctionTwo();
		removeSet.removeFunctionThree();
	}
}
