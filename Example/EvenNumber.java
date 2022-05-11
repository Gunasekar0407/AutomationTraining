package Example;

import java.util.Scanner;

public class EvenNumber {
	public static void main(String[] args) {
		try (Scanner obj = new Scanner(System.in)) {
			int a;
			System.out.println("enter the number");
			a = obj.nextInt();
			int rev = 0;
			if (a % 2 == 0) {
				System.out.println("the given num " + a + " is even");
				while (a != 0) {
					rev = rev * 10 + a % 10;
					a = a / 10;

				}
				System.out.println("Reverse number is" + rev);
			} else {
				System.out.println("the given num " + a + " is odd");
			}
		}
	}
}
