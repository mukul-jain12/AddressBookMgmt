package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class MultipleAddressBooks {
	PersonInformation person = new PersonInformation();
	List<PersonInformation> contactList = new ArrayList<>();
	HashMap<String, Contact> contactService = new HashMap<>();

	public void addAddressBook() {
		System.out.println("Enter Name of new Address Book: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (contactService.containsKey(bookName)) {
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBook();
		} else {
			Contact contact = new Contact();
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
		Scanner scanner = new Scanner(System.in);
		String newContact = scanner.nextLine();
		Contact addressBook = contactService.get(newContact);
		if (addressBook == null) {
			System.out.println("No address book with this name");

		} else {
			contactService.get(newContact).addContact();
		}
	}

	public void editContactInBook() {
		System.out.println("Enter Name to Edit Address Book: ");
		Scanner scanner = new Scanner(System.in);
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
		Scanner scanner = new Scanner(System.in);
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
		Scanner scanner = new Scanner(System.in);
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
}
