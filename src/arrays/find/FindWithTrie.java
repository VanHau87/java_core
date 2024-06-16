package arrays.find;

import java.text.DecimalFormat;

public class FindWithTrie {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("###,###,###.##");
        String target = "string9999999";

        // Chuyển mảng thành Trie
        long startTime = System.nanoTime();
        Trie trie = new Trie();
        for (int i = 0; i < 40_000_000; i++) {
            trie.insert("string" + i);
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken to insert array into Trie: " + df.format(endTime - startTime) + " ns");
        // Kiểm tra sự tồn tại của chuỗi trong Trie
        startTime = System.nanoTime();
        boolean exists = trie.search(target);
        endTime = System.nanoTime();
        System.out.println("Time taken to check existence: " + df.format(endTime - startTime) + " ns");
        System.out.println("Exists: " + exists);
	}

}
