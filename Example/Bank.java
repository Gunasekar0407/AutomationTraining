package Example;

import java.util.Scanner;

public class Bank {
	 public static void main(String[]args)
	    {
	     int withdraw,deposit;
	    int  balance=30000;
	        try (Scanner bank = new Scanner(System.in)) {
				withdraw=bank.nextInt();
				System.out.println("enter the amount to withdraw");
				System.out.println("check the balance");
				balance=bank.nextInt();
				System.out.println("enter the amount to be deposited");
				deposit=bank.nextInt();
			}
	        balance=balance - withdraw;
	        deposit=balance+deposit;
	        switch(4)
	        {
	            case 1:
	                System.out.println("enter the amount to withdraw");
	                if(balance>withdraw)
	                {
	                    System.out.println("please collect the money");
	                    balance=balance - withdraw;
	                }else
	                {
	                    System.out.println("insuffient ballance");
	                }
	                System.out.println("");
	                break;
	            case 2:
	                System.out.println("enter the amount to be deposited");
	                balance=balance+deposit;
	                System.out.println("");
	                break;
	            case 3:
	                System.out.println("check the balance");
	                System.out.println("balance:"+balance);
	                System.out.println("");
	                break;
	            case 4:
	                System.exit(0);
	        }
	    }
	}
