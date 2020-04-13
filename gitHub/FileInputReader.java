import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class FileInputReader{
	private static final String COMMENT_LINE_MARKER = "//";

	public static List<Task> readTasksInfo(String filePath){
		BufferedReader reader = null;
		List<Task> taskList = new ArrayList<>();
		try{
			reader = new BufferedReader(new FileReader(new File(filePath)));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		try{
			String line = null;
			while((line = reader.readLine())!= null){				
				if(line.startsWith(COMMENT_LINE_MARKER)) continue;
				//System.out.println(line);
				Task task = parseLine(line.trim());				
				taskList.add(task);				
			}
			// close the file
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return taskList;
	}

	private static Task parseLine(String line){
		String[] values = line.split(" ");
		if(values.length < 3){
			throw new IllegalArgumentException("Description of a task in the input file does not have three required parts: " + line);
		}
		return new Task(values[0], Long.parseLong(values[1]), Long.parseLong(values[2]));
	}
}