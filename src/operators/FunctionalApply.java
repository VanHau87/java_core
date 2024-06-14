package operators;

import java.util.Arrays;
import java.util.function.Function;

import models.Melon;
import models.MelonData;

public class FunctionalApply {
	/*
	 * Function<T, R> là một functional interface đại diện cho một hàm
	 * 	nhận vào 1 tham số kiểu T và trả về một kết quả kiểu R
	 * */
	
	public static void main(String[] args) {
		Melon[] melons = MelonData.dataForMelons();
		//solution 1: call functional with apply method
		/* String[] melonTypes = callWithApply(onlyAbstractMethod(), melons);*/
		//solution 2: call without apply method
		String[] melonTypes = callWithoutApply(onlyAbstractMethod(), melons);
		for (String type : melonTypes) {
			System.out.println(type);
		}
		
	}
	public static Function<Melon, String> onlyAbstractMethod() {
		Function<Melon, String> onlyType = melon -> melon.getType();
		return onlyType;
	}
	public static String[] callWithApply(Function<Melon, String> mapper, Melon[] melons) {
		return Arrays.stream(melons)
				//Function<T, R> nó có 1 phương thức trừu trượng: R apply(T t);
					.map(melon -> mapper.apply(melon))
					.toArray(String[]::new);
	}
	public static String[] callWithoutApply(Function<Melon, String> mapper, Melon[] melons) {
		return Arrays.stream(melons).map(mapper).toArray(String[]::new);
	}
}
