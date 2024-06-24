package functionalStyle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FiltersExample {
	record FilterRecord(Integer id, String orderCode, LocalDate date, Integer customerId, Integer agentId, Integer amount) {}
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
	public static void main(String[] args) {
		String pathString = "E:\\eclipse-workspace\\java_core\\coding_problem\\src\\dataFiles\\orders.txt";
		List<FilterRecord> datas = getDatas(pathString);
		
		/*LocalDate start = LocalDate.parse("2024-04-01");
		LocalDate end = LocalDate.parse("2024-04-30");*/
		List<FilterRecord> afterFilter = datas.stream().filter(data -> isDateInMonth.apply(data.date, Month.JANUARY)).toList();
		for (FilterRecord filterRecord : afterFilter) {
			System.out.println(filterRecord);
		}
	}
	public static List<FilterRecord> getDatas(String pathString) {
		Path path = Paths.get(pathString);
		if (Files.notExists(path)) {
			return null;
		}
		try (Stream<String> lines = Files.lines(path)){
			Predicate<String> isNotEmpty = line -> !line.trim().isEmpty();
			return lines.filter(isNotEmpty)
				.map(mapper)
				.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	static Function<String, FilterRecord> mapper = string -> {
		String[] fields = string.trim().split("\\t");
		int i = 0;
		Integer id = Integer.valueOf(fields[i++]);
		String orderCode = fields[i++];
		LocalDate date = LocalDate.parse(fields[i++], formatter);
		Integer cusId = Integer.valueOf(fields[i++]);
		Integer agentId = Integer.valueOf(fields[i++]);
		Integer amount = parseFromString(fields[i]);
		return new FilterRecord(id, orderCode, date, cusId, agentId, amount);
	};
	static boolean isDateBetween(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return (date.isEqual(startDate) || date.isAfter(startDate)) &&
               (date.isEqual(endDate) || date.isBefore(endDate));
    }
	static BiFunction<LocalDate, Month, Boolean> isDateInMonth = (date, month) -> {
		if (date == null || month == null) {
            return false;
        }
		return date.getMonth() == month;
	};
	static Integer parseFromString(String number) {
		if (number == null || number.isEmpty()) {
            return 0;
        }
		try {
			String cleanedString = number.replaceAll("[,\\.\\s]", "");
			return Integer.parseInt(cleanedString);
		} catch (Exception e) {
			return 0;
		}
	}
}
