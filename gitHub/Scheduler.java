import java.util.List;

public class Scheduler{
	UnboundedPriorityQueue<Task> queue;

	public Scheduler(){
		queue = new UnboundedPriorityQueue<>();
	}

	public void scheduleTasks(List<Task> taskList){		
		for(Task task: taskList){
			queue.enqueue(task);
		}
	}

	public long dispatchTasks(){
		long startTime = 0;
		long completionTime = 0;
		long totalLag = 0;
		Task task = null;
		while(!queue.isEmpty()){
			task = queue.dequeue();
			completionTime = HardWorker.completeTask(task, startTime);
			if(completionTime > task.getDeadline()){
				totalLag += completionTime - task.getDeadline();
			}

			startTime = completionTime;
		}
		return totalLag;
	}
}