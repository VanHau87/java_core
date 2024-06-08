package arrays.sort.impl;

import java.util.Arrays;
import java.util.Comparator;

import arrays.models.CpmMelons;
import arrays.models.Melon;
import arrays.models.MelonData;

public class SortMelonImpl {
	public static Melon[] melons = MelonData.dataForMelons();
	public static void main(String[] args) {
		sortMelons(melons, CpmMelons.cpmTypeThenWeightAsc);
		printConsole(melons);
	}
	public static void sortMelons(Melon[] melons, Comparator<Melon> comparator) {
		Arrays.sort(melons, comparator);
	}
	public static void printConsole(Melon[] melons) {
		for (Melon melon : melons) {
			System.out.println(melon);
		}
	}
}
