package arrays.find;

import java.util.UUID;

import arrays.models.Melon;
import arrays.models.MelonData;
import arrays.models.Person;
import arrays.models.PersonData;

public class MainFind {
	public static Melon[] allMelons = MelonData.dataForMelons();
	public static Person[] people = PersonData.dataForPeople();
	public static void main(String[] args) {
		//printUUID();
		Person p = new Person("c1d518a1-f1c1-4552-8729-c29cb39ebd49");
		boolean result = FindMethods.containElementBy(people, p, Person.byCccd);
		System.out.println(result);
	}
	public static void printUUID() {
		for (int i = 0; i < 100; i++) {
			System.out.println(UUID.randomUUID());
		}
	}
}
