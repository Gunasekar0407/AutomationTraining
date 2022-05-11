package String;

import java.util.Scanner;

public class Palindrome {
	 public void checkPalindrome(){
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter the string");
	        String string =scanner.next();
	        String reverse = "";

	        for(int value = string.length()-1;value>=0;value--){
	            reverse = reverse+string.charAt(value);
	        }
	        if(string.equals(reverse)){
	            System.out.println("Given string is Palindrome: True");
	        }
	        else{
	            System.out.println("The given string is palindrome: False");
	        }
	    }
}
