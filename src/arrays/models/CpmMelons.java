package arrays.models;

import java.util.Comparator;

public class CpmMelons{
	public static Comparator<Melon> cpmWeightAsc = (m1, m2) -> Integer.compare(m1.getWeight(), m2.getWeight());
	public static Comparator<Melon> cpmWeightDesc = (m1, m2) -> Integer.compare(m2.getWeight(), m1.getWeight());
	public static Comparator<Melon> cpmTypeAsc = (m1, m2) -> Comparator.comparing(Melon::getType).compare(m1, m2);
	public static Comparator<Melon> cpmTypeDesc = (m1, m2) -> Comparator.comparing(Melon::getType).compare(m2, m1);
	public static Comparator<Melon> cpmTypeThenWeightAsc = cpmTypeAsc.thenComparing(cpmWeightAsc);
	public static Comparator<Melon> cpmTypeThenWeightDesc = cpmTypeAsc.thenComparing(cpmWeightDesc);
}
