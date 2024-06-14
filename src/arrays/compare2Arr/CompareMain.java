package arrays.compare2Arr;

import java.util.Arrays;
import java.util.Comparator;

import models.Person;
import models.PersonData;

public class CompareMain {
	public static Person[] people = PersonData.dataForPeople();
	
	public static void main(String[] args) {
		Person[] p1 = getData(0, 12);
		Person[] p2 = getData(12, people.length);
		System.out.println("Check Equals");
		boolean isEqual = Arrays.equals(p1, p2);
		System.out.println(isEqual);
		boolean isEqualByCpm = Arrays.equals(p1, p2, Person.byAddress);
		System.out.println(isEqualByCpm);
		
		int[] integers1 = {4, 3};
		int[] integers2 = {3, 4};
		System.out.println(Arrays.equals(integers1, integers2));
	}
	public static Person[] getData(int from, int to) {
		int length = to - from;
		Person[] persons = new Person[length];
		for (int i = 0; i < length; i++) {
			persons[i] = people[from+i];
		}
		return persons;
	}
	
}
