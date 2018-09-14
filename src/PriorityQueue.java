///Makram Adaime 40033315
//352 Assignment 3
//Submitted June 16th 2018

public class PriorityQueue{
	
	private HuffmanTrieNode[] heap;
	private int maxSize;		 //The total size of the heap 
	private int length; 		//The number of nodes currently in the priority queue
	

	public PriorityQueue() {
		
		heap = null;
		maxSize = 0;
		length = 0;
		
	}


	public PriorityQueue(HuffmanTrieNode[] heap, int size, int n) {
		
		this.heap = heap;
		this.maxSize = size;
		this.length = n;
	}
	
	public boolean isEmpty() {
		
		return length == 0;
	}
	
	public boolean isLeaf(int k) {
		
		return (k >= k/2) && (k < length);
			
	}

	
	
public HuffmanTrieNode removeMin() {
		
		
		HuffmanTrieNode temp = heap[1];
		heap[--maxSize] = heap[1];
		heap[1] = heap[length];
		heap[length] = null;
	
		
		length--;
		minHeapify();
	
		int x = length;
		
		//while(x > 1 && heap[x].compareTo(heap[x/2]) < 0 )
		
	while(x > 1 && heap[x].compareTo(heap[x/2]) == -1 ) {
			
		//Swap
			
			HuffmanTrieNode temp2 = heap[x];
			heap[x] = heap[x/2];
			heap[x/2] = temp2;
			
			x = x/2;
			
		}
		
		
	return temp;
}
	
	//The heap will be built using the add() method

	public void add(HuffmanTrieNode node) {
		

		heap[++length] = node;
		
		int x = length;
		

		while(x > 1 && heap[x].compareTo(heap[x/2]) == -1 ) {
			
		//Swap
			
			HuffmanTrieNode temp = heap[x];
			heap[x] = heap[x/2];
			heap[x/2] = temp;
			
			x = x/2;
			
		}
		
		
	}
	
	//Swaps with the last node and reduces n by one;
	
	
	
	
	public void minHeapify() {
		
		int len = length;
		
		for(int i = (len/2); i >=1; i--) {  
			
			 while(i <= len) {
				
				int leftChild = 2*i ;
				int rightChild = 2*i+1;
				int min= i;
				
				if (leftChild < len && heap[leftChild].compareTo(heap[i]) == -1) {

					min = leftChild;		
				}
				
				if (rightChild < len && heap[rightChild].compareTo(heap[i]) == -1) {
					
					min = rightChild;		
				}
			
					
				if (i != min) {
					
					HuffmanTrieNode temp = heap[i];
					heap[i] = heap[min];
					heap[min] = temp;	
					i = min;
				}
				else
					break;
			
			 }
				
		  }
  		
	}
	
	
	
	public void printQueue() {
		
		for(HuffmanTrieNode i : heap) {
	
			if (i != null)
			System.out.println(i);
			
		}
		
	}


	public int length() {
		return length;
	}


}
