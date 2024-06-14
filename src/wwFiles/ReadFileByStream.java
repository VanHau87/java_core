package wwFiles;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Files cung cấp ba phương thức chính để đọc nội dung của tệp: lines, readAllLines, và readAllBytes
 * */
public class ReadFileByStream {
	record OrderRecord(String order, int amount, LocalDate salesDate) {}
	Function<String, OrderRecord> orderMapper = line -> {
		String[] properties = line.split(" ");
		String order = properties[0];
		int amount = Integer.valueOf(properties[3]);
		LocalDate date = LocalDate.parse(properties[4], DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		return new OrderRecord(order, amount, date);
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * syntax: 
	 * 		Files.lines(Path path)
	 * 		Files.lines(path, StandardCharsets.UTF_8)
	 * xử lý từng dòng của tệp một cách tuần tự và tận dụng các tính năng của Stream API.
	 * Phù hợp cho các tệp lớn vì không tải toàn bộ tệp vào bộ nhớ
	 * Linh hoạt và tiết kiệm bộ nhớ, sử dụng khi xử lý tuần tự các dòng
	 * */
	
}
