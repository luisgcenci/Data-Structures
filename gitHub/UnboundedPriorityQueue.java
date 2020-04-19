import java.util.*;

public class UnboundedPriorityQueue<T> {
	
    //Using MinHeap to handle priorityQueue 
    private MinHeap <Task> unboundedPriorityQueue;

    public UnboundedPriorityQueue(){
        //create a new queue
        unboundedPriorityQueue = new MinHeap<Task>();
    }

	public UnboundedPriorityQueue(int initSize){
        //create a new queue of a specified size
        unboundedPriorityQueue = new MinHeap<Task>(initSize);
    }

	//Add an element to the queue
    public void enqueue(Task task){
        unboundedPriorityQueue.insert(task);
    }
	
	//Remove an element from the queue and return it
    public Task dequeue(){
		return unboundedPriorityQueue.remove();
    }
	
	//Return true if queue is empty, false otherwise
	public boolean isEmpty(){
        return unboundedPriorityQueue.isEmpty();
    }
}
