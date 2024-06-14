package operators;

import java.util.function.BiFunction;

import models.Melon;

public class BiFunctionIF {
	/*
	 * BiFunction là một functional interface
	 * Nó đại diện cho một hàm nhận hai tham số đầu vào và trả về một kết quả
	 * Nó có ba tham số kiểu (T, U, và R):
	 * 		T: Kiểu của tham số đầu tiên.
	 * 		U: Kiểu của tham số thứ hai.
	 * 		R: Kiểu của kết quả trả về.
	 * */
	
	/*
	 * Phương thức trừu tượng: R apply(T t, U u)
	 * Phương thức mặc định: 
	 * 		andThen(Function<? super R,? extends V> after):
	 * 		sau khi áp dụng hàm hiện tại sẽ áp dụng thêm một hàm after.
	 * */
	
	public static BiFunction<Melon, Integer, Melon> updateWeight = (m, adjust) -> {
		int weight = m.getWeight();
		m.setWeight(weight + adjust);
		return m;
	};
}
