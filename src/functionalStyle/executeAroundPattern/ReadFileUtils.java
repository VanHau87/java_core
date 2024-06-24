package functionalStyle.executeAroundPattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUtils {
	
	public static <T> T execute(String filePath, FileProcessor<T> processor) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			return processor.process(reader);
		} catch (IOException  e) {
			throw new IOException("Error processing file: " + filePath, e);
		}
	}
}
