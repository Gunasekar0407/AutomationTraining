package Example;

import java.util.Scanner;

public class EvenAdd {
	 public static void main(String []args)
	    {
	        int number , i = 2, even = 0;
	        try (Scanner sc = new Scanner(System.in)) {
				System.out.println("enter the number=");
				number=sc.nextInt();
			}
	        while(i<=number)
	        {
	           even=even + i;
	           i = i + 2;
	        }
	        System.out.println("sum of even number up to "+number+ "=" +even);
	    }
}
