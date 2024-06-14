package maps;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import exceptionUtils.InvalidDataException;
import models.Jdbc;

public class ComputeIfAbsent {
	/*
	 * name: computeIfAbsent
	 * syntax: 	V computeIfAbsent(key, mappingFunction)
	 * 			V computeIfAbsent(K, Function<? super K, ? extends V>)
	 * 			với K kiểu đầu vào của mappingFunction, V là kiểu đầu ra. trong trường hợp của 1 map thì V là value tương ứng với key K
	 * computeIfAbsent sẽ thực hiện các bước sau:
	 * 		1. Kiểm tra xem khóa có tồn tại trong map không.
	 * 		2. Nếu khóa không tồn tại hoặc giá trị hiện tại là null, áp dụng mappingFunction để tính toán giá trị mới.
	 * */
	/*
	 * Mô tả hoạt động của mappingFunction:
	 * 	Function<? super K, ? extends V> mappingFunction
	 * 		Nếu mappingFunction trả về một giá trị khác null, thêm khóa và giá trị mới vào map.
	 * 		Nếu mappingFunction trả về null, map vẫn giữ nguyên như cũ, mappingFunction sẽ không làm gì map cả.
	 * */
	public static void main(String[] args) {
		Map<String, Jdbc> map = readDataForJdbc();
		map.put("Saga", null);
		/*
		map.computeIfAbsent("Saga", k -> {
			Jdbc jdbc = new Jdbc();
			jdbc.setDms(k);
			return jdbc;
		});
		*/
		map.computeIfAbsent("Saga", k -> null);
		for (Map.Entry<String, Jdbc> entry : map.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue() != null ? entry.getValue().toString() : "";
			System.out.println(key + ": " + val);
		}
	}
	public static Map<String, Jdbc> readDataForJdbc() {
		String FILE_PATH = 
				"E:/eclipse-workspace/java_core/coding_problem/src/dataFiles/dataForJdbc.txt";
		try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH), StandardCharsets.UTF_8)){
			return lines.map(generateJdbc).collect(Collectors.toMap(Jdbc::getDms, jdbc -> jdbc));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return new HashMap<>();
	}
	private static Jdbc createJdbc(String line) {
		try {
			String[] elements = line.split(",");
			Jdbc jdbc = new Jdbc();
			int i = 0;
			jdbc.setDms(elements[i++]);
			jdbc.setIpAddress(elements[i++]);
			jdbc.setPort(elements[i++]);
			jdbc.setDatabaseName(elements[i]);
			return jdbc;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Jdbc();
		}
	}
	private static Function<String, Jdbc> generateJdbc = line -> createJdbc(line);
}
