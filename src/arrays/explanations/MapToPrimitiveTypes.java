package arrays.explanations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MapToPrimitiveTypes {
	/*
	 * The mapToInt, mapToDouble, and mapToLong functions in the Java Stream API perform the opposite function of boxed().
	 * Specifically, these functions convert object streams to primitive type streams (IntStream, DoubleStream, LongStream).
	 * */
	public static void main(String[] args) {
		convertToIntStream();
		convertToDoubleStream();
		convertToLongStream();
	}
	public static void convertToIntStream() {
		/*
		 * mapToInt(mapper): mapper convert T -> int
		 * mapToInt: Convert Stream<T> to IntStream
		 * */
		
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		IntStream intStream = integerList.stream() //Stream<Integer>
				.mapToInt(Integer::intValue); //IntStream
		intStream.forEach(System.out::println);
	}
	public static void convertToDoubleStream() {
		/*
		 * mapToDouble(mapper): mapper convert T -> double
		 * mapToDouble: Convert Stream<T> to DoubleStream
		 * */
		
		List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
		DoubleStream doubleStream = doubleList.stream() //Stream<Double>
				.mapToDouble(Double::doubleValue); //DoubleStream
		doubleStream.forEach(System.out::println);
	}
	public static void convertToLongStream() {
		/*
		 * mapToLong(mapper): mapper convert T -> long
		 * mapToLong: Convert Stream<T> to LongStream
		 * */
		List<Long> longList = Arrays.asList(1L, 2L, 3L, 4L, 5L);
		LongStream longStream = longList.stream()
				.mapToLong(Long::longValue);
		longStream.forEach(System.out::println);
	}
}
