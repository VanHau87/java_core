package functionalStyle.executeAroundPattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUtils {
	
	/*
	 * Execute Around Pattern: Đảm bảo rằng các tài nguyên được thiết lập và dọn dẹp đúng cách xung quanh một hành động chính
	 * */
	public static <R> R execute(String filePath, FileProcessor<BufferedReader, R> processor) throws IOException {
		//action phụ
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			return processor.process(reader); //hàm process là action chính, có thể dùng strategy pattern
		} catch (IOException  e) {
			throw new IOException("Error processing file: " + filePath, e);
		}
	}
}
