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
        first = new Task ("Buy Bread", 50, 10);
        second = new Task ("Buy carrots", 80, 30);
        third = new Task ("Buy Almond MIlk", 150, 5);
    }

    @Test
	/*
	 * Tests toString, enqueue, and dequeue
	 */
    public void testQueue(){
		
		//Tests printing queue with 1 task as well as testing enqueue
        testQueue.enqueue(third);
        assertEquals(third.toString() + "\n", testQueue.toString());
		
		//Tests printing queue with 2 tasks, and tests that the "second" item is first
		//even though it was added second.
		testQueue.enqueue(second);
		assertEquals(second.toString() + "\n" + third.toString() + "\n", testQueue.toString());
		
		//Tests printing queue with 3 tasks, and tests the order of tasks.
		testQueue.enqueue(first);
		assertEquals(first.toString() + "\n" + second.toString() + "\n" + third.toString() + "\n", testQueue.toString());
		
		//Tests printing queue with 2 tasks after one has been dequeued. As 
		//well as testing that the correct order is maintained.
		testQueue.dequeue();
		assertEquals(second.toString() + "\n" + third.toString() + "\n", testQueue.toString());
		
		//Tests printing queue with 1 tasks after one has been dequeued. As 
		//well as testing that the correct order is maintained.
		testQueue.dequeue();
		assertEquals(third.toString() + "\n", testQueue.toString());
		
		//Tests printing queue with 0 tasks after one has been dequeued. As 
		//well as testing that the correct order is maintained.
		testQueue.dequeue();
		assertEquals("", testQueue.toString());
    }
	
	@Test
	/*
	 * Tests isEmpty, enqueue, and dequeue
	 */
	public void isEmpty(){
		
		//Tests an empty queue
		assertTrue(testQueue.isEmpty());
		
		//Tests a queue with one item
		testQueue.enqueue(third);
		assertFalse(testQueue.isEmpty());
		
		//Tests an empty queue from the result of a dequeue
		testQueue.dequeue();
		assertTrue(testQueue.isEmpty());
		
		//Tests a "full" queue
		testQueue.enqueue(first);
		testQueue.enqueue(second);
		testQueue.enqueue(third);
		assertFalse(testQueue.isEmpty());
		
		//Tests an empty queue from multiple dequeue
		testQueue.dequeue();
		testQueue.dequeue();
		testQueue.dequeue();
		assertTrue(testQueue.isEmpty());
		
		
	}

}