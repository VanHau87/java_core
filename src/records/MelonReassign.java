package records;

public record MelonReassign(String name, float weight, Units unit) {
	//canonical constructor
	/*
	public MelonReassign(String name, float weight, Units unit) {
		if (name == null) {
			throw new IllegalArgumentException("Melon's name cann't be null");
		}
		if (name.trim().isEmpty()) {
			throw new IllegalArgumentException("Melon's name cann't be empty");
		}
		if (unit == null) {
			throw new IllegalArgumentException("Melon's unit cann't be null");
		}
		this.name = name;
		switch (unit) {
			case KG -> this.weight = weight;
			case HG -> this.weight = weight/10;
			case DAG -> this.weight = weight/100;
			case G -> this.weight = weight/1000;
			default -> throw new IllegalArgumentException("Must be unit type");
		}
		if (this.weight < 200 || this.weight > 2000) {
			throw new IllegalArgumentException("Melon's weight must be between 200KG and 2000KG. Current: " + this.weight);
		}
		this.unit = unit;
	}
	*/
	//compact
	public MelonReassign {
		if (name == null) {
			throw new IllegalArgumentException("Melon's name cann't be null");
		}
		if (name.trim().isEmpty()) {
			throw new IllegalArgumentException("Melon's name cann't be empty");
		}
		if (unit == null) {
			throw new IllegalArgumentException("Melon's unit cann't be null");
		}
		switch (unit) {
			case KG -> weight = weight/1;
			case HG -> weight = weight/10;
			case DAG -> weight = weight/100;
			case G -> weight = weight/1000;
			default -> throw new IllegalArgumentException("Must be unit type");
		}
		if (weight < 200 || weight > 2000) {
			throw new IllegalArgumentException("Melon's weight must be between 200KG and 2000KG. Current: " + weight);
		}
	}
}
