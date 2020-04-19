import org.junit.*;
import static org.junit.Assert.*;

public class TestMinHeap {

    MinHeap testHeap;
    Task first;
    Task second;
    Task third;

    @Before
    public void setUp(){
        testHeap = new MinHeap();
        first = new Task ("Buy Bread", 50, 10);
        second = new Task ("Buy carrots", 80, 30);
        third = new Task ("Buy Almond MIlk", 150, 5);
    }
	
	@Test
	/*
	 * Tests toString, insert, and remove
	 */
    public void testHeap(){
		
		//Tests printing minHeap with 1 task as well as testing insert
        testHeap.insert(third);
        assertEquals(third.toString() + "\n", testHeap.toString());
		
		//Tests printing minHeap with 2 tasks, and tests that the "second" item is first
		//even though it was added second.
		testHeap.insert(second);
		assertEquals(second.toString() + "\n" + third.toString() + "\n", testHeap.toString());
		
		//Tests printing minHeap with 3 tasks, and tests the order of tasks.
		testHeap.insert(first);
		assertEquals(first.toString() + "\n" + second.toString() + "\n" + third.toString() + "\n", testHeap.toString());
		
		//Tests printing minHeap with 2 tasks after one has been removed. As 
		//well as testing that the correct order is maintained.
		testHeap.remove();
		assertEquals(second.toString() + "\n" + third.toString() + "\n", testHeap.toString());
		
		//Tests printing minHeap with 1 tasks after one has been removed. As 
		//well as testing that the correct order is maintained.
		testHeap.remove();
		assertEquals(third.toString() + "\n", testHeap.toString());
		
		//Tests printing minHeap with 0 tasks after one has been removed. As 
		//well as testing that the correct order is maintained.
		testHeap.remove();
		assertEquals("", testHeap.toString());
    }
	
	@Test
	/*
	 * Tests isEmpty, insert, and remove
	 */
	public void isEmpty(){
		
		//Tests an empty heap
		assertTrue(testHeap.isEmpty());
		
		//Tests a heap with one item
		testHeap.insert(third);
		assertFalse(testHeap.isEmpty());
		
		//Tests an empty heap from the result of a remove
		testHeap.remove();
		assertTrue(testHeap.isEmpty());
		
		//Tests a "full" heap
		testHeap.insert(first);
		testHeap.insert(second);
		testHeap.insert(third);
		assertFalse(testHeap.isEmpty());
		
		//Tests an empty heap from multiple remove
		testHeap.remove();
		testHeap.remove();
		testHeap.remove();
		assertTrue(testHeap.isEmpty());
		
		
	}
}