package wwFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import exceptionUtils.CreatePathException;

public class WwFiles {
	/*
	 * Files là một lớp tiện ích trong gói java.nio.file cung cấp các phương thức tĩnh để thao tác với tệp và thư mục. 
	 * Nó bao gồm các phương thức để tạo, sao chép, di chuyển, xóa, và đọc/ghi dữ liệu vào tệp.
	 * */
	
	//một số tính năng của Files
	
	public static void main(String[] args) {
		/* Tạo, sao chép, di chuyển và xóa tệp/thư mục */
		Path path = Paths.get("E:/eclipse-workspace/java_core/coding_problem/src/dataFiles/dataForOrders.txt");
		//lấy folders
		Path parent = path.getParent();
		//kiểm tra folder có tồn tại chưa, nếu chưa tạo mới
		if (Files.notExists(parent)) {
			try {
				Files.createDirectories(parent);
			} catch (IOException e) {
				throw new CreatePathException("Failed to create directories: " + e.getMessage());
			}
		}
		//kiểm tra file tồn tại chưa, nếu chưa tạo mới
		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				throw new CreatePathException("Failed to create file: " + e.getMessage());
			}
		}
		
	}

}
