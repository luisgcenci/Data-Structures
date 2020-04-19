import java.util.*;

public class UnboundedPriorityQueue<T extends Comparable> {
	
    //Using MinHeap to handle priorityQueue 
    private MinHeap <T> unboundedPriorityQueue;

    public UnboundedPriorityQueue(){
        //create a new queue
        unboundedPriorityQueue = new MinHeap<T>();
    }

	public UnboundedPriorityQueue(int initSize){
        //create a new queue of a specified size
        unboundedPriorityQueue = new MinHeap<T>(initSize);
    }

	//Add an element to the queue
    public void enqueue(T task){
        unboundedPriorityQueue.insert(task);
    }
	
	//Remove an element from the queue and return it
    public T dequeue(){
		return unboundedPriorityQueue.remove();
    }
	
	//Return true if queue is empty, false otherwise
	public boolean isEmpty(){
        return unboundedPriorityQueue.isEmpty();
    }
	
	//Return the tasks of the priorityQueue in string form.
	public String toString(){
		return unboundedPriorityQueue.toString();
	}
}