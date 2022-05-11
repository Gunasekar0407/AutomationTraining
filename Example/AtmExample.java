package Example;

import java.util.Scanner;

public class AtmExample {

	public static void main(String args[])
    {
        int balance = 5000, withdraw, deposit, money;
       try (// char Guna;
		Scanner sc = new Scanner(System.in)) {
			while (true) {

			    System.out.println("ATM");

			        System.out.println("Welcome Guna");

			        System.out.println("enter 1 for Withdraw");


			        System.out.println("enter 2 for Deposit");

			        System.out.println("enter 3 for Check Balance");

			        System.out.print("Choose the operation you want to perform:");

			        money = sc.nextInt();
			        switch (money) {
			            case 1:
			                System.out.print("Enter money to be withdrawn:");

			                withdraw = sc.nextInt();

			                if (balance >= withdraw) {
			                    balance = balance - withdraw;
			                    System.out.println("collect money and remove your card");
			                    System.out.println("Balance : " + balance);
			                } else {
			                    System.out.println("Insufficient Balance " +
			                            "remove the card");
			                    System.out.println("Balance : " + balance);
			                }
			                System.out.println("");
			                break;

			            case 2:

			                System.out.print("Enter money to be deposited:");

			                deposit = sc.nextInt();

			                balance = balance + deposit;
			                System.out.println("successfully deposited");
			                System.out.println("Balance : " + balance);
			                System.out.println("");
			                break;

			            case 3:
			                System.out.println("Balance : " + balance);
			                System.out.println("");
			                break;
}

			}
		}

    }
}