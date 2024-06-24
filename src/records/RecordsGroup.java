package records;

public class RecordsGroup {
	/* chính thức phát hành trong Java 16 */
	/*
	 * It will only serve the purpose of carrying this data around your program. 
	 * */
	/*
	 * có 2 loại constructor: canonical constructor và compact constructor
	 * */
	public record MelonRecord(String type, float weight) {}
	/*
	 * Constructor: 
	 * 		Record tự động tạo ra một public constructor.
	 * 		Tên gọi: Canonical Constructor
	 * 		Là constructor chính của record, nhận tất cả các thành phần làm tham số và khởi tạo chúng.
	 * Fields: 
	 * 		Các fields của một Record là bất biến (immutable) sau khi được khởi tạo. tức là:
	 * 		- private final fields
	 * 		- no setters
	 * 		- getters: type(), weight()
	 * Tự động tạo các methods:
	 * 		- equals
	 * 		- hashcode
	 * 		- toString
	 * Phù hợp cho các kiểu data đơn giản
	 * */
}
