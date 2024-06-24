package records;

import java.util.List;
import java.util.Map;

public record MarketRecord(Map<Integer, String> wholesale, List<String> retails, int[] price) {
	/*Để đảm bảo tính bất biết của các components như: List, Map */
	/*
	 * tạo các bản sao bất biến của List và Map để đảm bảo rằng chúng không thể thay đổi sau khi được khởi tạo.
	 * */
	public MarketRecord {
		wholesale = Map.copyOf(wholesale);
		retails = List.copyOf(retails);
		price = price.clone();
	}
	//với array, phải thêm getter
	public int[] price() {
		return price.clone();
	}
}
