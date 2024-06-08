package arrays.sort;

import java.util.Arrays;
import java.util.Collections;

public class PrimitiveTypes {

	public static void main(String[] args) {
		int[] intergers = new int[] {3,5,1,8,12,3,31,11,1,4,33,5,6,7,42,17,18};
		sortAsceding(intergers);
		System.out.println();
		sortDesceding(intergers);
	}
	public static void sortAsceding(int[] a) {
		// Sort the array
		Arrays.sort(a);
		//This function directly changes the input array and does not create a new array.
		for (int i : a) {
			System.out.print(i + ", ");
		}
	}
	public static void sortDesceding(int[] a) {
		/*
		 * Step 1: convert int -> Integer
		 * Step 2: Arrays.sort + Comparator.reverseOrder()
		 * */
		Integer[] integers = Arrays.stream(a) //Create IntStream
					.boxed() //IntStream -> Stream<Integer>
					.toArray(Integer[]::new);
		Arrays.sort(integers, Collections.reverseOrder());
		/*
		 * Convert back to int array if needed
		 * */
		int[] ints = Arrays.stream(integers)
					.mapToInt(Integer::intValue)
					.toArray();
		for (int i : ints) {
			System.out.print(i + ", ");
		}
	}
}
