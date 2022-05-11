package Array;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraySorter {
	DataStorage dataStorage = new DataStorage();

	void getTheArrayElements() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the length of Array");
		try {
			dataStorage.setLengthOfTheArray(scanner.nextInt());
			System.out.println("Enter the Array Elements");
			int array[] = new int[dataStorage.getLengthOfTheArray()];
			for (int count = 0; count < dataStorage.getLengthOfTheArray(); count++) {
				array[count] = scanner.nextInt();
			}
			dataStorage.setUnsortedArray(array);
			System.out.println("Length of the Array:" + dataStorage.getLengthOfTheArray());
			System.out.println("Unsorted Array");
			for (int count = 0; count < dataStorage.getLengthOfTheArray(); count++) {
				System.out.print(array[count]);
				System.out.print(" ");
			}
			System.out.println();
		} catch (InputMismatchException inputError) {
			System.out.println("Only Enter Integer Value");
			System.exit(0);
		}
	}

	void sortTheArrayInAscendingOrder() {
		int unSortedArray[] = dataStorage.getUnsortedArray();
		for (int count1 = 0; count1 < dataStorage.getLengthOfTheArray(); count1++) {
			for (int count2 = count1 + 1; count2 < dataStorage.getLengthOfTheArray(); count2++) {
				int temp = 0;
				if (unSortedArray[count1] > unSortedArray[count2]) {
					temp = unSortedArray[count1];
					unSortedArray[count1] = unSortedArray[count2];
					unSortedArray[count2] = temp;
				}
			}
		}
		dataStorage.setArraySortedInAscendingOrder(unSortedArray);
	}

	void sortTheArrayInDescendingOrder() {
		int unSortedArray[] = dataStorage.getArraySortedInAscendingOrder();
		for (int count1 = 0; count1 < dataStorage.getLengthOfTheArray() / 2; count1++) {
			int temp = unSortedArray[count1];
			unSortedArray[count1] = unSortedArray[dataStorage.getLengthOfTheArray() - count1 - 1];
			unSortedArray[dataStorage.getLengthOfTheArray() - count1 - 1] = temp;
		}
		dataStorage.setArraySortedInDescendingOrder(unSortedArray);
	}

	void displayTheArraySortedInAscendingOrder() {
		int array1[] = dataStorage.getArraySortedInAscendingOrder();
		System.out.println("Array Sorted in Ascending Order");
		for (int count3 = 0; count3 < dataStorage.getLengthOfTheArray(); count3++) {
			System.out.print(array1[count3]);
			System.out.print(" ");
		}
		System.out.println();
	}

	void displayTheArraySortedInDescendingOrder() {
		int array2[] = dataStorage.getArraySortedInDescendingOrder();
		System.out.println("Array Sorted in Descending Order");
		for (int count3 = 0; count3 < dataStorage.getLengthOfTheArray(); count3++) {
			System.out.print(array2[count3]);
			System.out.print(" ");
		}
		System.out.println();
	}
}
