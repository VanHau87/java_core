package operators;

import java.util.function.IntUnaryOperator;

public class UnaryOperators {
	/*
	 * IntUnaryOperator: is a functional interface. 
	 * 		It has a single abstract method 
	 * 			applyAsInt(int operand), it returns an int value
	 * 		Default methods:
	 * 			IntUnaryOperator andThen(IntUnaryOperator after):
	 * 				performs the current operation followed by the after operation.
	 * 			IntUnaryOperator compose(IntUnaryOperator before):
	 * 				performs the before operation then the current operation.
	 * */
	public static IntUnaryOperator doubleValue = x -> x * 2;
	public static IntUnaryOperator trippleValue = x -> x * 3;
	public static IntUnaryOperator minusOne = x -> x - 1;
	public static IntUnaryOperator x2AndMinusOne = doubleValue.andThen(minusOne);
	public static IntUnaryOperator x3AndMinusOne = trippleValue.andThen(minusOne);
	public static IntUnaryOperator x2Andx3AndMinusOne = doubleValue.andThen(trippleValue).andThen(minusOne);
}
