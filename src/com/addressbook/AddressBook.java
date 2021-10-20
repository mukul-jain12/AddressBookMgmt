//address book management system

package com.addressbook;

import java.util.Scanner;

public class AddressBook {
	public static void main(String[] args) {
		
		System.out.println("Welcome to the AddressBook Management System");
		Scanner sc = new Scanner(System.in);
		Contact contact = new Contact();
		
		//menu to select option
		while (true) {
			System.out.println("Enter \n 1 To add The contact \n 2 To edit the contact \n 3 To delete contact \n 4 To display contact \n 0 To exit");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					contact.addContact();
					break;
				case 2:
					contact.editContact();
					break;
				case 3:
					contact.deleteContact();
					break;
				case 4:
					contact.displayContact();
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
