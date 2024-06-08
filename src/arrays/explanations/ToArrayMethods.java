package arrays.explanations;

import java.util.Arrays;
import java.util.List;

public class ToArrayMethods {

	public static void main(String[] args) {
		withoutParameter();
		withParameter();
		withPrimitiveStream();
	}
	public static void withoutParameter() {
		List<String> list = Arrays.asList("a", "b", "c");
		/*
		 * This is the default version and is not specific to any data type.
		 * When no return type is specified, the default return type is an Object array.
		 * */
		Object[] array = list.toArray();
		System.out.println(Arrays.toString(array));
	}
	
	/*
	 * When working with Stream, in some cases, we do not need to pass parameters to the toArray() function,
	 * but this function still knows the return data type and size of the array.
	 * */
	/*
	 * When you use Stream<T>, the toArray() method cannot know in advance the size of the array or
	 * the specific type of array you want to create, 
	 * so it requires an array constructor like toArray(T[]: :new) to create an array of a specific type.
	 * */
	/*
	 * When you use IntStream, LongStream, or DoubleStream, 
	 * these streams are specialized for primitive types (int, long, double). 
	 * Therefore, toArray() methods in these streams can automatically create primitive arrays (int[], long[], double[]) 
	 * without the need for an array constructor.
	 * */
	public static void withPrimitiveStream() {
		//IntStream, LongStream, DoubleStream
		int[] a = new int[] {2,1,7,0,21,15,18,20};
		int[] oddArray = Arrays.stream(a) //IntStream
				.filter(number -> number%2 == 0) //IntStream
				.toArray(); //int[]
		System.out.println(Arrays.toString(oddArray));
	}
	
	public static void withParameter() {
		List<String> list = Arrays.asList("a", "b", "c");
		/*
		 * Parameter is an array constructor
		 * Allows you to specify the type of the returned array
		 * It has the same size as the stream or collection.
		 * */
		String[] array = list.toArray(String[]::new);
		System.out.println(Arrays.toString(array));
	}
	
}
