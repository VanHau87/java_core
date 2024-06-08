package maps;

import java.util.HashMap;
import java.util.Map;

public class DefaultValue {
	public static final String DEFAULT_HP = "69:89.31.226:27017";
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("postgresql", "127.0.0.1:5432");
		map.put("mysql", "192.168.0.50:3306");
		map.put("cassandra", "192.168.1.5:9042");
		String hp1 = map.getOrDefault("derby", DEFAULT_HP);
		System.out.println(hp1);
	}

}
