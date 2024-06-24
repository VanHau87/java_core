package functionalStyle.executeAroundPattern;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface FileProcessor<T> {
	T process(BufferedReader reader) throws IOException;
}
