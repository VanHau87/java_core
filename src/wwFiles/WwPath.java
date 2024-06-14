package wwFiles;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * 1 đối tượng của Path đại diện cho 1 đường dẫn đến 1 tệp, hoặc 1 thư mục
 * Path làm việc với các tệp/thư mục trên hệ thống cục bộ hoặc các tệp chia sẻ qua mạng nội bộ LAN
 * */
public class WwPath {
	/*
	 * Path trong Java NIO (New I/O) được thiết kế để thay thế và cải thiện các chức năng của File trong Java IO cũ.
	 * Java NIO (New I/O) giới thiệu từ Java 7
	 * Path cung cấp một API linh hoạt và mạnh mẽ hơn, và kết hợp với lớp Files, 
	 * nó có thể thực hiện hầu hết mọi thao tác với file
	 * */
	
	/*
	 * có nhiều cách để tạo 1 Path:
	 * 		Paths.get("path/to/file")
	 * 		Path.of("path/to/file")
	 * */
	
	/*
	 * Kiểm tra sự tồn tại của tệp và thư mục:
	 * 		Files.exists 
	 * 		Files.notExists
	 * */
	
	/*
	 * Tạo, xóa và di chuyển tệp/thư mục
	 * 		Files.createFile
	 * 		Files.createDirectory
	 * 		Files.delete
	 * 		Files.move
	 * 		Files.copy
	 * */
	
	/*
	 * Đọc và ghi dữ liệu
	 * 		Files.readAllBytes
	 * 		Files.readAllLines
	 * 		Files.write
	 * */
	
	/*
	 * Lấy thông tin thuộc tính tệp
	 * 		Files.getAttribute
	 * 		Files.setAttribute
	 * 		Files.getLastModifiedTime
	 * 		Files.size
	 * */
	
	/*
	 * Theo dõi thay đổi thư mục
	 * 		WatchService
	 * */
	
	public static void main(String[] args) {
		System.out.println(getFileDelimiter());
		//các tác vụ có thể làm với Path
		
		//1. tạo 1 Path
		Path root = Paths.get("E:/eclipse-workspace/java_core/coding_problem");
		/*
		 * root: Nó không tương đương trực tiếp với một tệp (file) hay thư mục mà chỉ là một biểu diễn của đường dẫn đó
		 * có nghĩa là một đối tượng Path có thể đại diện cho một tệp/thư mục tồn tại hoặc không tồn tại
		 * do đó cần phải đi kiểm tra
		 * */
		
		
		Path relativePath = relativeToCurrentFolder();
		//Kết hợp các đường dẫn
		Path absolutePath = root.resolve(relativePath);
		if (Files.exists(absolutePath)) {
			System.out.println(absolutePath);
		} else {
			System.out.println("File does not exist");
		}
		//Trích xuất các thành phần của đường dẫn
		System.out.println(absolutePath.getFileName());
		System.out.println(absolutePath.getParent());
		//kiểm tra so sánh
		boolean isAbsolute = absolutePath.isAbsolute();
		boolean endsWith = absolutePath.endsWith("dataForJdbc.txt");//re-check
		System.out.println("isAbsolute: " + isAbsolute + ", endWith txt: " + endsWith);
	}
	public static String getFileDelimiter() {
		/*return FileSystems.getDefault().getSeparator();*/
		//another way
		return File.separator;
	}
	/*tạo Path*/
	public static Path relativeToFileStoreRoot() {
		/*
		 * The current FILE STORE root (such as: C:/, D:/, E:/) must start with the file delimiter
		 * 		it will look like: E:\src\dataFiles\dataForJdbc.txt
		 * */
		return Paths.get("/src/dataFiles/dataForJdbc.txt");
	}
	public static Path relativeToCurrentFolder() {
		/*
		 * A path relative to the current folder, the path should not start with the file delimiter
		 * 		it will look like:
		 * 		E:\eclipse-workspace\java_core\coding_problem\src\dataFiles\dataForJdbc.txt
		 * */
		return Paths.get("src/dataFiles/dataForJdbc.txt");
	}
}
