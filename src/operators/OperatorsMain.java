package operators;

public class OperatorsMain {

	public static void main(String[] args) {
		int r1 = UnaryOperators.doubleValue.applyAsInt(3);
		System.out.println(r1);
		int r2 = UnaryOperators.x2AndMinusOne.applyAsInt(3);
		System.out.println(r2);
		int r3 = UnaryOperators.x3AndMinusOne.applyAsInt(3);
		System.out.println(r3);
		int r4 = UnaryOperators.x2Andx3AndMinusOne.applyAsInt(3);
		System.out.println(r4);
	}

}
