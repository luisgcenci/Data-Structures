import java.util.*;

public class MinHeap<T extends Comparable> {
	private ArrayList<T> heap;
	private int size;
	private int index;
	
	//Initialize instance variables and initial heap size.
	public MinHeap(){
		heap = new ArrayList<T>(11);
		index = 0;
		size = 0;
	}
	
	//Initialize instance variables and initial heap size to user specifications.
	public MinHeap(int initSize){
		heap = new ArrayList<T>(initSize);
		index = 0;
		size = 0;
	}
	
	//Add an element to the min heap
	public void insert(T element){
		//Element is always added at end, so the index is the current size of min heap.
		index = size;
		//If minheap is empty
		if (size == 0){
			//add element to "head" of minheap
			heap.add(element);
			} else {
				heap.add(element);
					  // While index element is smaller than the parent element, swap them.
				while((heap.get(index).compareTo(heap.get(index/2)) < 0)){
					// If new element is smaller than the parent element, swap them.
					Collections.swap(heap, index, index/2);
					// Keep making comparisions up tree until a parent is smaller than index element.
					index = index/2;
				}
			}
		size++;
	}
	
	public T remove(){
		//Store the element being removed to return later.
		T returnElement = heap.get(0);
		
		//Swap the root, or the element to be removed, and the deepest level's rightmost node
		Collections.swap(heap, 0, size - 1);
		//Remove said element and decrement size.
		heap.remove(--size);
		
		//If root has at least 2 children(in other words has 3+ elements), check them both.
		if (size > 2){
			//While the root is larger than either the right OR left child.
			while(heap.get(1).compareTo(heap.get(0)) < 0 || heap.get(2).compareTo(heap.get(0)) < 0){
			
				//If right child is smaller than root, swap them.
				if(heap.get(2).compareTo(heap.get(0)) < 0){
					Collections.swap(heap, 0, 2);
				}
				
				//If left child is smaller than root, swap them.
				if(heap.get(1).compareTo(heap.get(0)) < 0){
					Collections.swap(heap, 0, 1);
				}
			}
		}
		
		//If root only has 1 child(or 2 elements), check that child.
		if (size == 2){
			if(heap.get(1).compareTo(heap.get(0)) < 0){
				Collections.swap(heap, 0, 1);
			}
		}
		
		// Return the root
		return returnElement;
	}
	
	public boolean isEmpty(){
		//If the root has no size, it is empty.
		if(this.size == 0)
			return true;
		return false;
	}
	
	/* This is not a functioning method, but was included in the diagram.
	public boolean isFull(){
		if(this.size == 0)
			return true;
		return false;
	}*/
	
	public String toString(){
		String outputString = "";
			//Checks every parent, and prints its children. The last parent being the 
			//last element divided by 2
			for (index = 0; index <= ((size-1)/2); index++) { 
				outputString = outputString + ("\nParent:" + heap.get(index) + " Children: " + heap.get(2*index) + " " + heap.get((2*index)+1)); 
			}
		return outputString;
	}
}
    