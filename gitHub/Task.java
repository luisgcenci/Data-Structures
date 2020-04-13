public class Task implements Comparable<Task>{	
	private String name;
	private Long duration;
	private Long deadline;

	public Task(String name, long deadline, long duration){
		this.name = name;		
		this.duration = duration;
		this.deadline = deadline;
	}

	public long getDeadline(){
		return this.deadline.longValue();
	}

	public long getDuration(){
		return this.duration.longValue();
	}

	public String getName(){
		return this.name;
	}

	@Override
	public int compareTo(Task other){
		return this.deadline.compareTo(other.getDeadline());
	}

	@Override
	public String toString(){
		return "Name:" + name + ", duration:" + duration 
						+ ", deadline:" + deadline; 
	}
}