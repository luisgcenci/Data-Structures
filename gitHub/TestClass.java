
public class TestClass {

    public static void main (String[]args){

        UnboundedPriorityQueue testQueue;
        Task first;
        Task second;
        Task third;
    
        testQueue = new UnboundedPriorityQueue();
        first = new Task ("Buy Bread", 100, 10);
        second = new Task ("Buy carrots", 80, 30);
        third = new Task ("Buy Almond MIlk", 150, 5);
    
        testQueue.enqueue(first);
        System.out.println(testQueue.toString());

    }
    


}