package maps;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.Jdbc;

public class ComputeIfPresentMain {
	/*
	 * name: computeIfPresent
	 * functions: tính toán một giá trị mới cho một khóa đã tồn tại trong MAP
	 * condition: chỉ khi khóa đó có mặt và giá trị tương ứng với khóa đó khác null
	 * */
	
	/*
	 * syntax: 
	 * 		V computeIfPresent(key, remappingFunction)
	 * 		V computeIfPresent(K, BiFunction<? super K,? super V,? extends V>)
	 * */
	
	/*
	 * Mô tả hoạt động:
	 * 		khóa không tồn tại trong map hoặc giá trị của khóa đó là null
	 * 			computeIfPresent không làm gì cả và trả về null.
	 * 		khóa tồn tại trong map và giá trị hiện tại của nó khác null
	 * 			computeIfPresent sẽ áp dụng hàm remappingFunction cho Entry<Key,Value>
	 * */
	
	/*
	 * Mô tả hoạt động của remappingFunction:
	 * 	BiFunction<? super K,? super V,? extends V> remappingFunction
	 * 		Nếu remappingFunction trả về một giá trị không null, giá trị đó sẽ được gán làm giá trị mới cho key trong map.
	 * 		Nếu remappingFunction trả về null, entry đó sẽ bị xóa.
	 * */
	public static void main(String[] args) {
		
		String jdbcUrl = getJdbcUrl();
		System.out.println(jdbcUrl);
		
		/*
		Map<String, Jdbc> map = readDataForJdbc(FILE_PATH);
		//Tham số đầu tiên: là kiểu data của MAP; tham số thứ 2 là value tương ứng với key
		//Tham số thứ 3, kiểu trả về phải giống với tham số thứ 2, do function này update giá trị của value
		BiFunction<String, Jdbc, Jdbc> awsCloud = (k,v) -> {
			v.setDatabaseName("AWS_database_cloud");
			return v;
		};
		Jdbc jdbc = map.computeIfPresent("PostgreSQL", awsCloud);
		System.out.println();
		System.out.println(jdbc.toString());
		*/
	}
	public static String getJdbcUrl() {
		Map<String, String> map = new HashMap<>();
		map.put("postgresql", "127.0.0.1:5432");
		map.put("mysql", "192.168.0.50:3306");
		map.put("cassandra", "192.168.1.5:9042");
		map.put("informix", null);//không compute
		BiFunction<String, String, String> bf = (k,v) -> "jdbc:" + k + "://" + v + "/customers_db";
		
		String url = map.computeIfPresent("informix", bf);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			System.out.println("key: " + key + ", value: " + val);
		}
		return url;
	}
	public static Map<String, Jdbc> readDataForJdbc() {
		String FILE_PATH = 
				"E:/eclipse-workspace/java_core/coding_problem/src/dataFiles/dataForJdbc.txt";
		try (Stream<String> lines = Files.lines(
				Paths.get(FILE_PATH), StandardCharsets.UTF_8)){
			return lines
					.map(line -> createJdbc(line))
					.collect(Collectors.toMap(Jdbc::getDms, jdbc -> jdbc));
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	private static Jdbc createJdbc(String line) {
		String[] elements = line.split(",");
		Jdbc jdbc = new Jdbc();
		int i = 0;
		jdbc.setDms(elements[i++]);
		jdbc.setIpAddress(elements[i++]);
		jdbc.setPort(elements[i++]);
		jdbc.setDatabaseName(elements[i]);
		return jdbc;
	}
}
