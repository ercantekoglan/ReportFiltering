import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileOperations {

	public List<Cars> readFile(String fileName) {

		BufferedReader br = null;
		List<Cars> modelList = new LinkedList<>();

		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = null;
			br.readLine();

			while ((line = br.readLine()) != null) {
				String[] lineArray = line.split(",");
				modelList.add(new Cars(lineArray[0], lineArray[1]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return modelList;
	}

}
