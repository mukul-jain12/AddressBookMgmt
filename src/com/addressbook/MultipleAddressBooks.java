package com.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBooks {
	Scanner scanner = new Scanner(System.in);

	Contact contact = new Contact();
	PersonInformation person = new PersonInformation();
	List<PersonInformation> contactList = new ArrayList<>();
	HashMap<String, Contact> contactService = new HashMap<>();

	public void addAddressBook() {
		System.out.println("Enter Name of new Address Book: ");
		String bookName = scanner.next();
		if (contactService.containsKey(bookName)) {
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBook();
		} else {
			contactService.put(bookName, contact);
			System.out.println("press 1 if you want to add another book.");
			int newBook = scanner.nextInt();
			if (newBook == 1) {
				addAddressBook();
			}
		}
	}

	public void addContact() {
		System.out.println("Enter the name of Address book to add the contact.");
		String newContact = scanner.nextLine();
		Contact addressBook = contactService.get(newContact);
		if (addressBook != null) {
			contactService.get(newContact).addContact();
		}
		else {
			System.out.println("No address book with this name");
		}
	}

	public void editContactInBook() {
		System.out.println("Enter Name to Edit Address Book: ");
		String editBookName = scanner.next();
		if (contactService.containsKey(editBookName)) {
			contactService.get(editBookName).editContact();
		} else {
			System.out.println("AddressBook doesn't exist!!");
			editContactInBook();
		}
	}

	public void deleteAddressBook() {
		System.out.println("Enter Name to Delete Address Book: ");
		String bookName = scanner.next();
		if (contactService.containsKey(bookName)) {
			contactService.remove(bookName);
		} else {
			System.out.println("AddressBook doesn't exist!!");
			deleteAddressBook();
		}
	}

	public void deleteContactInBook() {
		System.out.println("Enter Name to delete the contacts from Address Book : ");
		String bookName = scanner.next();
		if (contactService.containsKey(bookName)) {
			contactService.get(bookName).deleteContact();
		} else {
			System.out.println("AddressBook doesn't exist!!");
			deleteContactInBook();
		}
	}

	public void printBook() {
		System.out.println("Address Book Programs are: ");
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

	public void printContactsInBook() {
		int countContact = 1;
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			System.out.println(countContact + " " + entry.getValue().contactList);
			countContact++;
		}
		System.out.println(" ");
	}

	//search contacts using city or state name
	public void searchContacts() {
		while (true) {
			System.out.println("Enter\n 1. By city\n 2. By state\n 0. for previous menu");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter city: ");
				String city = scanner.nextLine();
				contact.searchByCity(city);
				break;
			case 2:
				System.out.println("Enter state: ");
				String state = scanner.nextLine();
				contact.searchByState(state);
				break;
			case 0:
				return;
			default:
				System.out.println("Entered choice is incorrect!.. please enter correct choice");
			}
		}
	}

	//count number of contacts in all address books using city or state name
	public void countContacts() {
		while (true) {
			System.out.println("Enter\n 1. By city\n 2. By state\n 0. for previous menu");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter city: ");
				String city = scanner.nextLine();
				contact.countByCity(city);
				break;
			case 2:
				System.out.println("Enter state: ");
				String state = scanner.nextLine();
				contact.countByState(state);
				break;
			case 0:
				return;
			default:
				System.out.println("Entered choice is incorrect!.. please enter correct choice");
			}
		}
	}
}
