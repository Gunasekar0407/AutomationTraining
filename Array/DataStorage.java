package Array;

public class DataStorage {
	private int lengthOfTheArray;
	private int unsortedArray[];
	private int arraySortedInAscendingOrder[];
	private int arraySortedInDescendingOrder[];

	public int getLengthOfTheArray() {
		return lengthOfTheArray;
	}

	public void setLengthOfTheArray(int lengthOfTheArray) {
		this.lengthOfTheArray = lengthOfTheArray;
	}

	public int[] getUnsortedArray() {
		return unsortedArray.clone();
	}

	public void setUnsortedArray(int unsortedArray[]) {
		this.unsortedArray = unsortedArray;
	}

	public int[] getArraySortedInAscendingOrder() {
		return arraySortedInAscendingOrder.clone();
	}

	public void setArraySortedInAscendingOrder(int arraySortedInAscendingOrder[]) {
		this.arraySortedInAscendingOrder = arraySortedInAscendingOrder;
	}

	public int[] getArraySortedInDescendingOrder() {
		return arraySortedInDescendingOrder;
	}

	public void setArraySortedInDescendingOrder(int arraySortedInDescendingOrder[]) {
		this.arraySortedInDescendingOrder = arraySortedInDescendingOrder;
	}
}
