
public class ArrayUnbndSortedQueue<T extends Comparable> extends ArrayUnbndQueue<T>{
	
	  public void enqueue(T element)
	  // Adds element to the rear of this queue.
	  {  
	    if (numElements == queue.length) 
	      enlarge();
	    
	  

	    rear = (rear + 1) % queue.length;
	    queue[rear] = element;
	    numElements = numElements + 1;
	    
		boolean finished = false;
		int counter;
		while(!finished){
			counter = 0;
			for(int i = 0; i<queue.length-1; i++){	
				T temp1 = queue[i];
				T temp2 = queue[i+1];
				if(0 < temp1.compareTo(temp2)){
					queue[i] = temp2;
					queue[i+1] = temp1;
					counter++;
				}
			}
			if(counter==0){
				finished = true;
			}
		}
	    
	    queue[rear] = queue[queue.length-1];
	    
	  }
	  
	  
	  private void enlarge()
	  // Increments the capacity of the queue by an amount 
	  // equal to the original capacity.
	  {
	    // create the larger array
	    T[] larger = (T[]) new Object[queue.length + origCap];
	    
	    // copy the contents from the smaller array into the larger array
	    int currSmaller = front;
	    for (int currLarger = 0; currLarger < numElements; currLarger++)
	    {
	      larger[currLarger] = queue[currSmaller];
	      currSmaller = (currSmaller + 1) % queue.length;
	    }
	    
	    // update instance variables
	    queue = larger;
	    front = 0;
	    rear = numElements - 1;
	  }

}
