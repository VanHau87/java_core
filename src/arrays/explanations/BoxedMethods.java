package arrays.explanations;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class BoxedMethods {

	/*
	 * The boxed() function in the Java Stream API can wrap all primitive data types such as:
	 * int, double, and long into corresponding objects (Integer, Double, Long).
	 * */
	public static void main(String[] args) {
		intBoxedInteger();
		doubleBoxedDouble();
		longBoxedLong();
	}
	public static void intBoxedInteger() {
		//IntStream.boxed(): convert IntStream into Stream<Integer>
		IntStream intStream = IntStream.of(11, 21, 3, 45, 50, 12, 8, 0);
		List<Integer> integers = intStream
				.boxed() //IntStream -> Stream<Integer>
				.toList();
		System.out.println(integers);
	}
	public static void doubleBoxedDouble() {
		//DoubleStream.boxed(): convert DoubleStream into Stream<Double>
		DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5);
		List<Double> doubles = doubleStream
				.boxed() //DoubleStream -> Stream<Double>
				.toList();
		System.out.println(doubles);
	}
	public static void longBoxedLong() {
		//LongStream.boxed(): convert LongStream into Stream<Long>
		LongStream longStream = LongStream.of(1L, 2L, 3L, 4L, 5L);
		List<Long> longs = longStream
				.boxed() //LongStream -> Stream<Long>
				.toList();
		System.out.println(longs);
	}
}
