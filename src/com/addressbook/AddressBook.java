//address book management system

package com.addressbook;

import java.util.Scanner;

public class AddressBook {
	public static void main(String[] args) {
		
		System.out.println("Welcome to the AddressBook Management System");
		Scanner sc = new Scanner(System.in);
		Contact contact = new Contact();
		
		while (true) {
			System.out.println("Enter \n 1 To add The contact \n 0 To exit");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					contact.addContact();
					break;
				case 0:
					System.out.println("Exit from application");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid input");
					continue;
			}
		}
	}
}
