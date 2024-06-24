package records;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainRecords {

	public static void main(String[] args) {
		/*
		MelonRecord melonr = new MelonRecord("Cantaloupe", 2600);
		System.out.println(melonr.type());
		System.out.println(melonr.weight());
		*/
		
		/*
		MelonR1 mr1 = new MelonR1("canonical constructor", 209);
		System.out.println(mr1.type());
		System.out.println(mr1.weight());
		*/
		
		/*
		MelonReassign reassign = new MelonReassign("Cantaloupe", 2000, Units.KG);
		System.out.println(reassign);
		*/
		
		/*
		List<String> retails = new ArrayList<>();
		Map<Integer, String> wholesale = new HashMap<>();
		int[] prices = new int[10];
		for (int i = 0; i < 10; i++) {
			retails.add("Retail " + i);
			wholesale.put(i, "Wholesale " + i);
			prices[i] = i;
		}
		MarketRecord marketRecord = new MarketRecord(wholesale, retails, prices);
		
		Map<Integer, String> wholesaleMap = marketRecord.wholesale();
		
		for (Map.Entry<Integer, String> entry : wholesaleMap.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			System.out.println(key + ", " + val);
		}
		wholesaleMap.put(11, "Wholesale 11");
		
		List<String> retailList = marketRecord.retails();
		for (String string : retailList) {
			System.out.println(string);
		}
		retailList.add("Retail 11");
		
		int[] priceArray = marketRecord.price();
		priceArray[0] = 100;
		for (int i : priceArray) {
			System.out.println(i);
		}
		int[] price = marketRecord.price();
		for (int i : price) {
			System.out.println(i);
		}
		*/
		MultipleCnt ctn1 = new MultipleCnt();
		MultipleCnt ctn2 = new MultipleCnt("Melon");
		MultipleCnt ctn3 = new MultipleCnt(23.34f);
		MultipleCnt ctn4 = null;
		List<MultipleCnt> cnts = Arrays.asList(ctn1, ctn2, ctn3, ctn4);
		//System.out.println(ctn1.compareTo(ctn2));
		//System.out.println(ctn2.compareTo(ctn4));
		cnts.sort(Comparator.nullsLast(MultipleCnt.cpmByType));
		for (MultipleCnt multipleCnt : cnts) {
			System.out.println(multipleCnt);
		}
		
	}

}
