
import org.junit.*;
import static org.junit.Assert.*;

public class TestUnboundedPriorityQueue {

    UnboundedPriorityQueue testQueue;
    Task first;
    Task second;
    Task third;

    @Before
    public void setUp(){
        testQueue = new UnboundedPriorityQueue();
        first = new Task ("Buy Bread", 100, 10);
        second = new Task ("Buy carrots", 80, 30);
        third = new Task ("Buy Almond MIlk", 150, 5);
    }

    @Test
    public void testQueue(){
        testQueue.enqueue(first);
        System.out.println(testQueue.toString());
        //assertEquals("\nParent:first Children: null null", testQueue.toString());
    }

}