package records;

public record MelonR1(String type, float weight) {
	//canonical constructor
	/*
	public MelonR1(String type, float weight) {
		if (type == null) {
			throw new IllegalArgumentException("The melon's type cannot be null");
		}
		if (type.trim().isEmpty()) {
			throw new IllegalArgumentException("The melon's type cannot be empty");
		} if (weight < 200 || weight > 1500) {
			throw new IllegalArgumentException("The melon's weight must be between 200 and 1500 grams");
		}
		//must assign value
		this.type = type;
		this.weight = weight;
	}
	*/
	
	//compact constructor
	public MelonR1 {
		if (type == null) {
			throw new IllegalArgumentException("The melon's type cannot be null");
		}
		if (type.trim().isEmpty()) {
			throw new IllegalArgumentException("The melon's type cannot be empty");
		} if (weight < 200 || weight > 1500) {
			throw new IllegalArgumentException("The melon's weight must be between 200 and 1500 grams");
		}
		// Không cần gán
		/*
			this.type = type;
			this.weight = weight;
		*/
		//vì trình biên dịch tự động làm điều này
		/*Since the compiler knows the list of given components, it can accomplish its job from this compact constructor*/
	}
}
