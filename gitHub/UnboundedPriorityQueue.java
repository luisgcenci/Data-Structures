
import java.util.*;

public class UnboundedPriorityQueue<T> {
    

    //ArrayList to handle priorityQueue 
    private ArrayList <Task> unboundedPriorityQueue;

    //Keep track of the root
    Task root;

    //To be used to compare currentTask and currentTask's parent (or currentTaks's children) (when queue or dequeue  is happening)
    Task currentTask;
    Task parentTask;
    Task temp;
    Task leftChildTask;
    Task rightChildTask;

    //keep track of size of the list
    int size;

    //index to keep track of the 
    int index;

    public UnboundedPriorityQueue(){

        //create a new list
        unboundedPriorityQueue = new ArrayList<Task>();

        //make size 0
        size = 0;
        
        //make index "null"
        index = -1;
    }

    public ArrayList<Task> getUnbondedPriorityQueue(){
    
        //return list
        return this.unboundedPriorityQueue;
    }

    public void enqueue(Task task){

        //increase size
        size++;

        //increase index
        index++;

        //check if it's the first element being added
        if (size == 0){
            //add task to arraylist
            unboundedPriorityQueue.add(task);
            //make tast the root
            this.root = task;
        }

        else{
            
            //add task to ArrayList
            unboundedPriorityQueue.add(task);

            //get task that just got queued 
            currentTask = unboundedPriorityQueue.get(index);

            //get the parent of this task
            int parentIndex = (index - 1) / 2;
            parentTask = unboundedPriorityQueue.get(parentIndex);

            //make our list a min heap by: (while current task is smaller than its parent, switch them up)
            while (currentTask.compareTo(parentTask) < 0){
                
                //temporary save parentTask to temp
                temp = parentTask;

                //Switch up parentTask and currentTask
                parentTask = currentTask;
                currentTask = temp;
                
                //update parentIndex
                parentIndex = (parentIndex - 1) / 2;
                
                //update parentTask
                parentTask = unboundedPriorityQueue.get(parentIndex);

                //check if currentTask has become the root
                if (currentTask == parentTask){
                    
                    //update the root if it is
                    this.root = currentTask;
                    //break loop
                    break;
                }
            }
        }
    }

    public boolean isEmpty(){
        if (this.unboundedPriorityQueue.size() == 0){
            return true;
        }
    
        return false;
    }

    public Task dequeue(){
        
        //get root of the list
        Task taskTobeDequeued = this.root;

        /**swith last task and the root task up */
        
        //save root to a temp
        this.temp = this.root;

        //make root the last Task
        this.root = this.unboundedPriorityQueue.get(size - 1);

        //set last task to the root (saved in temp)
        this.unboundedPriorityQueue.set(size - 1, this.temp);

        //decreament size and index
        size--;
        index--;

        /**rearrange our list to a min heap*/

        //index Of Task Being Rearrenged
        int indexTBR = 0;
        parentTask = this.root;
        leftChildTask = unboundedPriorityQueue.get(2 * indexTBR + 1);
        rightChildTask = unboundedPriorityQueue.get(2 * indexTBR + 2);

        //while task being rearrenged is bigger than it's children
        while ( ((parentTask.compareTo(leftChildTask)) > 0) || ((parentTask.compareTo(rightChildTask)) > 0) ){

            //if the left child has a bigger value than the right child, swich task being rearrenged with the left child
            if ( (leftChildTask.compareTo(rightChildTask)) > 0){
                this.temp = this.parentTask;
                this.parentTask = leftChildTask;
                this.leftChildTask = this.temp;

                //update index of task being rearrenged
                indexTBR = (2 * indexTBR + 1);
            }
            
            //if the right child has a bigger value than the left child, swich task being rearrenged with the right child
            else{
                this.temp = this.parentTask;
                this.parentTask = rightChildTask;
                this.rightChildTask = this.temp;

                //update index of task being rearrenged
                indexTBR = (2 * indexTBR + 2);

            }

            //update left and right child
            leftChildTask = unboundedPriorityQueue.get(2 * indexTBR + 1);
            rightChildTask = unboundedPriorityQueue.get(2 * indexTBR + 2);
        }

        return taskTobeDequeued;
    }
}