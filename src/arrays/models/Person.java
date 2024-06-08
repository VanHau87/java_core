package arrays.models;

import java.time.LocalDate;
import java.util.Comparator;

public class Person {
	private String cccd;
	private String name;
	private LocalDate dob;
	private String address;
	public Person() {
	}
	
	public Person(String cccd) {
		this.cccd = cccd;
	}

	public Person(String cccd, String name, LocalDate dob, String address) {
		this.cccd = cccd;
		this.name = name;
		this.dob = dob;
		this.address = address;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static Comparator<Person> byCccd = Comparator.comparing(Person::getCccd);
	public static Comparator<Person> byAddress = Comparator.comparing(Person::getAddress);
}
