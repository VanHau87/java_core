package arrays.find;

import java.util.Arrays;
import java.util.Comparator;

public class FindMethods {
	public static <T> boolean containsElement(T[] arr, T toContain) {
		return Arrays.stream(arr).anyMatch(e -> e.equals(toContain));
	}
	public static <T> boolean containElementBy(T[] arr, T toContain, Comparator<T> c) {
		return Arrays.stream(arr).anyMatch(e -> c.compare(e, toContain) == 0);
	}
}
