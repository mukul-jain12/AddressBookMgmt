package com.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultipleAddressBooks {
	Scanner scanner = new Scanner(System.in);

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
				searchByCity(city);
				break;
			case 2:
				System.out.println("Enter state: ");
				String state = scanner.nextLine();
				searchByState(state);
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
				countByCity(city);
				break;
			case 2:
				System.out.println("Enter state: ");
				String state = scanner.nextLine();
				countByState(state);
				break;
			case 0:
				return;
			default:
				System.out.println("Entered choice is incorrect!.. please enter correct choice");
			}
		}
	}

	//search contact by state name
	public void searchByState(String state) {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			List<PersonInformation> contactListByState = entry.getValue().contactList;
			List<PersonInformation> collect = contactListByState.stream().filter(p -> p.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
			for (PersonInformation contactsss : collect) {
				System.out.println("Search result: " + contactsss);
			}
		}
		System.out.println(" ");
	}

	//search contact by city name
	public void searchByCity(String city) {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			List<PersonInformation> contactListByCity = entry.getValue().contactList;
			List<PersonInformation> collect = contactListByCity.stream().filter(p -> p.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
			for (PersonInformation contact : collect) {
				System.out.println("Search result: " + contact);
			}
		}
	}

	//count contact by city name
	public void countByCity(String cityName) {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			List<PersonInformation> contactListByCity = entry.getValue().contactList;
			long countContactsByCity = contactListByCity.stream().filter(g -> g.getCity().equalsIgnoreCase(cityName)).count();
			System.out.println("Total Number of Contact from '" + cityName + "' city is " + countContactsByCity);
		}
	}

	//count contact by state name
	public void countByState(String stateName) {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			List<PersonInformation> contactListByState = entry.getValue().contactList;
			long countContactsByState = contactListByState.stream().filter(g -> g.getState().equalsIgnoreCase(stateName)).count();
			System.out.println("Total Number of Contact from '" + stateName + "' state is" + countContactsByState);
		}
	}

	public void sortByName(){
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			List<PersonInformation> contactListByState = entry.getValue().contactList;
			List<PersonInformation> list = contactListByState.stream().collect(Collectors.toList());
			list.stream().sorted((g1, g2) -> ((String)g1.getFirstName()).compareTo(g2.getFirstName())).forEach(contact -> System.out.println(contact));
		}
	}

	//print name of address books
	public void printBook() {
		System.out.println("Address Book Programs are: ");
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

	public void printContactsInBook() {
		for (Map.Entry<String, Contact> entry : contactService.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			System.out.println(entry.getValue().contactList);
		}
		System.out.println(" ");
	}
}
