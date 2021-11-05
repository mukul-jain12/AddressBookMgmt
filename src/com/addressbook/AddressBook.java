package com.addressbook;

import java.util.*;

public class AddressBook {
	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
		
		MultipleAddressBooks multiAddressBook = new MultipleAddressBooks();
		
		while (true) {
			System.out.println("Enter \n 1. Add new AddressBook\n 2. Add contact in AddressBook\n " +
					"3. Edit the contact in AddressBook\n 4. Delete the contact in AddressBook\n 5. Delete the AddressBook\n " +
					"6. Print the AddressBook\n 7. Print the contacts in AddressBook\n 0. Exit Applcation");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				multiAddressBook.addAddressBook();
				break;
			case 2:
				multiAddressBook.addContact();
				break;
			case 3:
				multiAddressBook.editContactInBook();
				break;
			case 4:
				multiAddressBook.deleteContactInBook();
				break;
			case 5:
				multiAddressBook.deleteAddressBook();
				break;
			case 6:
				multiAddressBook.printBook();
				break;
			case 7:
				multiAddressBook.printContactsInBook();
				break;
			case 0:
				System.out.println("Exit Application");
				System.exit(0);
				break;
			default:
				System.out.println("Enter the wrong input");
			}
		}
	}
}