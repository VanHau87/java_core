package functionalStyle.executeAroundPattern;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * hàm String.format(String format, Object... args) có 2 thành phần:
 * 		format: Chuỗi định dạng chứa các chỉ dẫn định dạng.
 * 		args: Một hoặc nhiều đối số sẽ được chèn vào chuỗi định dạng
 * 		Các chỉ dẫn định dạng bắt đầu bằng dấu % và kết thúc bằng một ký tự chỉ định kiểu dữ liệu
 * */

/*
 * 	%[flags][width][.precision]conversion
 * 		flag: - để căn trái, + để thêm dấu dương, 0 để thêm số 0 ở phía trước 1 number
 * 		width: Độ rộng tối thiểu của trường
 * 		.precision: Số chữ số sau dấu thập phân
 * 		conversion: Ký tự chỉ định kiểu dữ liệu (ví dụ: d, f, s, t).
 * */
public class MainReadFile {
	record AddressRecord(Integer id, String province, String region) {}
	public static void main(String[] args) {
		String FILE_PATH = "E:/eclipse-workspace/java_core/coding_problem/src/dataFiles/addresses.txt";
		try {
			int[] lengths = new int[3];
			List<AddressRecord> rs = ReadFileUtils.execute(FILE_PATH, reader -> {
				List<AddressRecord> addresses = new ArrayList<>();
				String line;
				while ((line = reader.readLine()) != null) {
					String[] fields = line.trim().split("\\t");
					int i = 0;
					Integer id = Integer.valueOf(fields[i++]);
					String province = fields[i++];
					String region = fields[i++];
					addresses.add(new AddressRecord(id, province, region));
				}
				return addresses;
			});
			updateFieldLengths(rs, lengths);
			printAddresses(rs, lengths);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void updateFieldLengths(List<AddressRecord> addresses, int[] lengths) {
        for (AddressRecord address : addresses) {
            lengths[0] = Math.max(lengths[0], address.id.toString().length());
            lengths[1] = Math.max(lengths[1], address.province.length());
            lengths[2] = Math.max(lengths[2], address.region.length());
        }
    }
	private static void printAddresses(List<AddressRecord> addresses, int[] lengths) {
        String format = String.format("| %%%dd | %%-%ds | %%%ds |", lengths[0], lengths[1], lengths[2]);
        for (AddressRecord address : addresses) {
            System.out.println(String.format(format, address.id, address.province, address.region));
        }
    }
}
