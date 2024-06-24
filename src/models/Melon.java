package models;

import java.util.Objects;

public class Melon {
	private String type;
	private int weight;
	
	public Melon() {
	}
	
	public Melon(String type, int weight) {
		this.type = type;
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Melon [type=" + type + ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Melon other = (Melon) obj;
		return Objects.equals(type, other.type) && weight == other.weight;
	}
	
}
