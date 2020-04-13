public class HardWorker{

	public static long completeTask(Task task, long startTime){
		long endTime = startTime + task.getDuration();
		
		System.out.printf("[%4d] %s STARTED\n", startTime, task.getName());
		System.out.printf("[%4d] %s ENDED", endTime, task.getName());
		
		if(endTime > task.getDeadline()){
			System.out.println(", behind schedule by " + (endTime - task.getDeadline()));
		}else{
			System.out.println(", completed in time");
		}
		return startTime + task.getDuration();
	}
}