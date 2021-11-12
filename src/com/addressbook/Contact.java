package com.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Contact {
	Scanner scanner = new Scanner(System.in);

	PersonInformation person = new PersonInformation();
	static List<PersonInformation> contactList = new ArrayList<>();

	public void addContact() {
		System.out.println("Enter the number of contacts you want to enter");
		int number = scanner.nextInt();

		for (int i = 0; i < number; i++) {
			System.out.println("Enter the contact details of person ");
			createContact();
		}
	}

	//creating contact
	public void createContact() {
		boolean found = false;

		System.out.println("Enter First Name : ");
		String firstName = scanner.next();

		//checked duplicate name in the address book
		for (int j = 0; j < contactList.size(); j++) {

			List<String> names = contactList.stream().map(PersonInformation::getFirstName).collect(Collectors.toList());

			for ( int k = 0; k < names.size(); k++)  {
				if(names.get(j).equals(firstName)) {
					found = true;
					break;
				}
			}
		}
		if (found == true) {
			System.out.println("Person Name is already in the address book!");
		}
		else {
			System.out.println("Enter Last Name : ");
			String lastName = scanner.next();
			System.out.println("Enter Address : ");
			String address = scanner.next();
			System.out.println("Enter City : ");
			String city = scanner.next();
			System.out.println("Enter State : ");
			String state = scanner.next();
			System.out.println("Enter ZipCode : ");
			int zipCode = scanner.nextInt();
			System.out.println("Enter Mobile Number : ");
			long mobileNumber = scanner.nextLong();
			System.out.println("Enter EmailId : ");
			String emailId = scanner.next();
			person = new PersonInformation(firstName, lastName, address, city, state, zipCode, mobileNumber, emailId);
			contactList.add(person);
			System.out.println(contactList);
		}
	}

	//edit contact in the address book
	public void editContact() {
		System.out.println("Enter the first name of person to edit contact");
		String editName = scanner.next();
		boolean edited = false;

		//check the person information using first name
		for (int i = 0; i < contactList.size(); i++) {
			String name = contactList.get(i).getFirstName();
			if (name.equalsIgnoreCase(editName)) {
				contactList.remove(person);
				createContact();
				edited = true;
				break;
			}
		}
		if (!edited) {
			System.out.println("enter name is incorrect");
		}
	}

	//delete contact details from address book
	public void deleteContact() {
		System.out.println("Enter the first name of person to delete contact");
		String deleteName = scanner.next();
		int i = 0;

		for ( ;i < contactList.size(); i++) {
			String name = contactList.get(i).getFirstName();
			if (name.equalsIgnoreCase(deleteName)) {
				break;
			}
		}
		if (i < contactList.size()) {
			contactList.remove(i);
			System.out.println("Contact Deleted");
		}else {
			System.out.println("Contact not find");
		}
	}
	
	//search contact by city name
	public void searchByCity(String city) {
		List<PersonInformation> collect = contactList.stream().filter(p -> p.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
		for (PersonInformation contact : collect) {
			System.out.println("Search result: " + contact);
		}
	}

	//search contact by state name
	public void searchByState(String state) {
		List<PersonInformation> collect = contactList.stream().filter(p -> p.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
		for (PersonInformation contact : collect) {
			System.out.println("Search result: " + contact);
		}
	}

	//count contact by city name
	public void countByCity(String cityName) {
		long count = contactList.stream().filter(g -> g.getCity().equalsIgnoreCase(cityName)).count();
		System.out.println("Total Number of Contact from '" + cityName + "' city is " + count);
	}
	
	//count contact by state name
	public void countByState(String stateName) {
		long count1 = contactList.stream().filter(g -> g.getState().equalsIgnoreCase(stateName)).count();
		System.out.println("Total Number of Contact from '" + stateName + "' state is" + count1);
	}
}