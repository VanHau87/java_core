package functionalStyle.executeAroundPattern;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileUtils {
	public static <R> R execute(String path, FileProcessor<BufferedWriter, R> processor) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
			return processor.process(writer);
		} catch (IOException e) {
			throw new IOException("Error processing file: " + path, e);
		}
	}
}
