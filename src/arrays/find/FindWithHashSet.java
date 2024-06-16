package arrays.find;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

public class FindWithHashSet {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("###,###,###.##");
		String target = "string59999992";
		long startTime = System.nanoTime();
		Set<String> set = new HashSet<>();
        for (int i = 0; i < 60_000_000; i++) {
            set.add("string" + i);
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken to insert data into HashSet: " + df.format(endTime - startTime) + " ns");
        startTime = System.nanoTime();
        boolean exists = set.contains(target);
        endTime = System.nanoTime();
        System.out.println("Time taken to check existence: " + df.format(endTime - startTime) + " ns");
        System.out.println("Exists: " + exists);
	}

}
