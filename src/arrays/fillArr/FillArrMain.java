package arrays.fillArr;

import java.util.Arrays;

public class FillArrMain {

	public static void main(String[] args) {
		int[] a1 = new int[5];
		Arrays.fill(a1, 1);
		
		System.out.println(Arrays.toString(a1));
		int[] a2 = new int[10];
		Arrays.setAll(a2, index -> {
			if (index == 0) {
				return a2[index];
			} else {
				return a2[index -1] + 1;
			}
		});
		System.out.println(Arrays.toString(a2));
	}

}
