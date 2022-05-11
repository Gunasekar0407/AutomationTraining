package ArrayList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class OrderProcessor {
	Scanner scan = new Scanner(System.in);
	//int bookCount;
	//ArrayList<Book> booklist = new ArrayList<>(bookCount);

	public ArrayList<Book> getOrderFromTheCustomer() {
		int bookCount;
		ArrayList<Book> booklist = new ArrayList<>();
		try {	
			System.out.println("Enter the Book Count");
			bookCount = scan.nextInt();
			for (int count = 0; count < bookCount; count++) {
				booklist.add(getBookDataFromTheCustomer());
			}
		} catch (InputMismatchException exception) {
			System.out.println("Enter Integer Value");
		}return booklist;
	}

	public Book getBookDataFromTheCustomer() {
		int id, quantity;
		String name, author, publisher;
		System.out.println("Enter the Id");
		id = scan.nextInt();
		System.out.println("Enter the Quantity");
		quantity = scan.nextInt();
		System.out.println("Enter the Name");
		name = scan.next();
		System.out.println("Enter the Author");
		author = scan.next();
		System.out.println("Enter the Publisher");
		publisher = scan.next();
		Book bookdetails = new Book(id, quantity, name, author, publisher);
		return bookdetails;
	}

	public void printOrderDetails(ArrayList<Book> booklist) {
		for (Book printDetails : booklist) {
			System.out.println("Book Id: " + printDetails.id);
			System.out.println("Book Quantity: " + printDetails.quantity);
			System.out.println("BookName: " + printDetails.name);
			System.out.println("Author Name: " + printDetails.author);
			System.out.println("Publisher Name: " + printDetails.publisher);
		}
	}

}
