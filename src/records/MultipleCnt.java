package records;

import java.util.Comparator;

/*
 * Comparable: Dùng để định nghĩa thứ tự tự nhiên của các đối tượng
 * 			   phải triển khai phương thức compareTo
 * 			   Mỗi lớp chỉ có thể có một thứ tự tự nhiên
 * */
public record MultipleCnt(String type, float weight) implements Comparable<MultipleCnt>{
	private static final String DEFAULT_MELON_TYPE = "Crenshaw";
	private static final float DEFAULT_MELON_WEIGHT = 1000;
	public MultipleCnt() {
		this(DEFAULT_MELON_TYPE, DEFAULT_MELON_WEIGHT);
	}
	public MultipleCnt(String type) {
		this(type, DEFAULT_MELON_WEIGHT);
	}
	public MultipleCnt(float weight) {
		this(DEFAULT_MELON_TYPE, weight);
	}
	@Override
	public int compareTo(MultipleCnt o) {
		if (o == null) {
			return 1;
		}
		var result =this.type.compareTo(o.type);
		if (result == 0) {
			result = Float.compare(this.weight, o.weight);
		}
		return result;
	}
	//dùng comparator:
	/*
	 * Comparator: là 1 functional interface
	 * Dùng để định nghĩa thứ tự tùy chỉnh
	 * khi cần sắp xếp theo nhiều tiêu chí khác nhau hoặc khi bạn không thể thay đổi lớp nguồn.
	 * có thể có nhiều Comparator cho cùng một lớp
	 * mỗi Comparator định nghĩa một tiêu chí sắp xếp khác nhau.
	 * */
	static Comparator<MultipleCnt> cpmByType = Comparator.comparing(cnt -> cnt.type(), Comparator.nullsFirst(Comparator.naturalOrder()));
	static Comparator<MultipleCnt> cpmByWeight = Comparator.comparing(cnt -> cnt.weight());
	static Comparator<MultipleCnt> cpmByWeightThenByType = cpmByWeight.thenComparing(cpmByType);
	/*
	 * với Comparator: có 2 cách sử lý null value
	 * 		1. Comparator.nullsFirst(Comparator<T> comparator)
	 * 		2. Comparator.nullsLast(Comparator<T> comparator)
	 * */
}
