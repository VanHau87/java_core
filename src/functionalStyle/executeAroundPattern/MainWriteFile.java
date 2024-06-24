package functionalStyle.executeAroundPattern;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import functionalStyle.executeAroundPattern.MainReadFile.AddressRecord;
import models.Pair;

public class MainWriteFile {

	public static void main(String[] args) {
		String READ_PATH = "E:/eclipse-workspace/java_core/coding_problem/src/dataFiles/addresses.txt";
		Pair<List<AddressRecord>, int[]> datas = getData(READ_PATH);
		List<AddressRecord> addresses =  datas.getFirst();
		int[] lengths = datas.getSecond();
		String format = String.format("| %%%dd | %%-%ds | %%%ds |", lengths[0], lengths[1], lengths[2]);
		try {
			String WRITE_PATH = "E:/eclipse-workspace/java_core/coding_problem/src/dataFiles/out-addresses.txt";
			Path path = Paths.get(WRITE_PATH);
			Path parents = path.getParent();
			if (Files.notExists(parents)) {
				Files.createDirectories(parents);
				System.out.println(String.format("Create folders %s successfully", parents));
			}
			if(Files.notExists(path)) {
				Files.createFile(path);
				System.out.println(String.format("Create file %s successfully", path.getFileName()));
			}
			WriteFileUtils.execute(WRITE_PATH, writer -> {
				for (AddressRecord address : addresses) {
					String line = String.format(format, address.id(), address.province(), address.region());
					writer.write(line);
					writer.newLine();
				}
				return null;
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private static Pair<List<AddressRecord>, int[]> getData(String path) {
		try {
			List<AddressRecord> rs = ReadFileUtils.execute(path, reader -> {
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
			int[] lengths = fieldLengths(rs);
			return new Pair<>(rs, lengths);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	private static int[] fieldLengths(List<AddressRecord> addresses) {
		int[] lengths = new int[3];
        for (AddressRecord address : addresses) {
            lengths[0] = Math.max(lengths[0], address.id().toString().length());
            lengths[1] = Math.max(lengths[1], address.province().length());
            lengths[2] = Math.max(lengths[2], address.region().length());
        }
        return lengths;
    }
}
