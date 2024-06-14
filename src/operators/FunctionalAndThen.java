package operators;

import java.util.Arrays;
import java.util.function.Function;

import models.Person;
import models.PersonData;

public class FunctionalAndThen {
	/*
	 * Function<T, R> là một Functional Interface chuẩn trong Java, 
	 * đại diện cho một hàm nhận một tham số và trả về một kết quả.
	 * Nó có một phương thức trừu tượng duy nhất là apply
	 * và một số phương thức mặc định (default methods).
	 * */
	
	/*
	 * default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)
	 * 		Kết hợp hàm sau khi áp dụng hàm hiện tại.
	 * 		thứ tự gọi: từ trái sang phải
	 * */
	public static void main(String[] args) {
		Person[] persons = PersonData.dataForPeople();
		String[] names = onlyName(defaultAfter(), persons);
		for (String name : names) {
			System.out.println(name);
		}
	}
	public static Function<Person, String> defaultAfter() {
		Function<Person, String> getOnlyName = person -> person.getName();
		Function<String, String> lower = string -> string.toLowerCase();
		Function<String, String> getSurname = string -> {
			String[] words = string.split("\\s+");
			return words[0];
		};
		//andThen -> after: functional bên ngoài sẽ được gọi trước
													//1             2                3
		Function<Person, String> finalResult = getOnlyName.andThen(lower).andThen(getSurname);
		return finalResult;
	}
	public static String[] onlyName(Function<Person, String> after, Person[] persons) {
		return Arrays.stream(persons).map(after).toArray(String[]::new);
	}
}
