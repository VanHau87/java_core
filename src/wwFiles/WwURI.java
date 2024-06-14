package wwFiles;

import java.net.URI;
import java.net.URISyntaxException;

/*
 * Khi làm việc với tài nguyên trên không gian mạng
 * nó hỗ trợ các giao thức mạng như HTTP, HTTPS, FTP, và các giao thức khác
 * */
public class WwURI {

	public static void main(String[] args) throws InterruptedException {
		//từ constructor
		try {
			URI uriFromConstructor = new URI("https://www.baeldung.com/articles");
			System.out.println(uriFromConstructor);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		//dùng create method
		URI uriFromCreate = URI.create("https://www.baeldung.com/articles");
		System.out.println(uriFromCreate);
	}
	
}
