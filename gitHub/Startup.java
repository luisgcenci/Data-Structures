import java.util.List;

public class Startup{
	public static void usage(){
		System.out.println("Usage: ");
		System.out.println("\t java Startup <input_file_path>");
	}

	public static void main(String[] args){
		if(args.length == 0){
			System.out.println("Missing required parameter!");
			usage();
			return;
		}

		List<Task> tasksList = FileInputReader.readTasksInfo(args[0]);
		
		Scheduler scheduler = new Scheduler();
		scheduler.scheduleTasks(tasksList);
		long totalLag = scheduler.dispatchTasks();
		System.out.println("Total lag (behind expected schedule): " + totalLag);
	}
}