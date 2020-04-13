
import java.util.*;

public class UnboundedPriorityQueue<T> {
    

    //ArrayList to handle priorityQueue 
    private ArrayList <Task> unboundedPriorityQueue;

    //Keep track of the root
    Task root;

    //To be used to compare currentTask and currentTask's parent
    Task currentTask;
    Task parentTask;
    Task temp;

    //index to keep track of arrayList size and can be used to get an element by the index too
    int index;

    public UnboundedPriorityQueue(){

        unboundedPriorityQueue = new ArrayList<Task>();
        
        //make index "null"
        index = -1;
    }

    public ArrayList<Task> getUnbondedPriorityQueue(){
        
        return this.unboundedPriorityQueue;
    }

    public void enqueue(Task task){

        //check if it's the first element being added
        if (index == -1){
            //add task to arraylist
            unboundedPriorityQueue.add(task);
            //make tast the root
            this.root = task;
            //increase index
            index++;
        }

        else{
            
            //add task to ArrayList
            unboundedPriorityQueue.add(task);
            //increase index;
            index++;

            //get task that just got queued 
            currentTask = unboundedPriorityQueue.get(index);

            //get the parent of this task
            int parentIndex = (index - 1) / 2;
            parentTask = unboundedPriorityQueue.get(parentIndex);

            //while current task is bigger than its parent, switch them u
            while (currentTask.compareTo(parentTask) > 0){
                
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
}