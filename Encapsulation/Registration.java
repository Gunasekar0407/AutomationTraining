package Encapsulation;

import java.util.Scanner;

public class Registration {
	Scanner scan = new Scanner(System.in);

	public void display() {

		Student s = new Student();
		System.out.println("Student Name");
		s.setName(scan.next());
		System.out.println("Student Phonenumber:");
		s.setAdmissionId(scan.nextInt());
		System.out.println("Student Admission Id:");
		s.setPhoneNumber(scan.nextInt());
		System.out.println("Student Email Id:");
		s.setEMail(scan.next());
		System.out.println("Student Name: " + s.getName());
		System.out.println("Student Phonenumber: " + s.getAdmissionId());
		System.out.println("Student Admission Id: " + s.getPhoneNumber());
		System.out.println("Student Email Id: " + s.getEMail());
	}

	public static void main(String[] args) {
		Registration registration = new Registration();
		registration.display();
	}
}
