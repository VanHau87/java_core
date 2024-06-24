package functionalStyle.executeAroundPattern;

import java.io.IOException;

@FunctionalInterface
public interface FileProcessor<T, R> {
	R process(T resource) throws IOException;
}
