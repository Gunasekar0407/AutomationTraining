package Example;

public class DayOne {
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int b[][] = { { 11, 12, 13 }, { 14, 15, 16 }, { 17, 18, 19 } };
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				System.out.print(a[i][j] + b[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
