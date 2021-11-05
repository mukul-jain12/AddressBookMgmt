package com.addressbook;

public class PersonInformation {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private long mobileNumber;
	private String emailId;

	public PersonInformation() {

	}

	public PersonInformation(String firstName, String lastName, String address, String city, String state, int zipCode, long mobileNumber, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public long getMobileNo() {
		return mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	@Override
	public String toString() {
		return "{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zipCode=" + zipCode +
				", mobileNo=" + mobileNumber +
				", emailId='" + emailId + '\'' +
				'}';
	}
}
