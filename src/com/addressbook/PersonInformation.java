package com.addressbook;

public class PersonInformation {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String  phonenumber;
	private String email;


	//information construction
	public PersonInformation(String firstName,String lastName,String address,String city,String state,String zip2,String  phoneNumber2,String email)
	{
		this.firstName= firstName;
		this.lastName= lastName;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip2;
		this.phonenumber=phoneNumber2;
		this.email=email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String  getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String  phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ContactPerson [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", phonenumber=" + phonenumber + ", email=" + email
				+ "]";
	}
}
