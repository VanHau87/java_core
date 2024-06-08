package arrays.maths;

import java.util.Arrays;

import arrays.models.CpmMelons;
import arrays.models.Melon;
import arrays.models.MelonData;

public class MaxMinAvgMain {
	
	public static Melon[] allMelons = MelonData.dataForMelons();
	
	public static void main(String[] args) {
		Melon maxMelon = Arrays.stream(allMelons).max(CpmMelons.cpmWeightAsc).orElseThrow();
		System.out.println(maxMelon);
		Melon minMelon = Arrays.stream(allMelons).min(CpmMelons.cpmWeightAsc).orElseThrow();
		System.out.println(minMelon);
		
	}

}
