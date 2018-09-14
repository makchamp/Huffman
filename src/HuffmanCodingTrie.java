//Makram Adaime 40033315
//352 Assignment 3
//Submitted June 16th 2018

public class HuffmanCodingTrie extends BinaryTree<HuffmanCodingTrie.InternalNode>{
	
	private int order;
	private static int count = 0;
		
	public HuffmanCodingTrie(PriorityQueue pq, int order) {
		
		this.order = order;
		root = buildTrie(pq);
	
		
	}

	
	// Returns a formed internal nodes from the two smallest nodes in the priority queue;
	
	public InternalNode buildTrie(PriorityQueue pq) {
		
		InternalNode intNode = null; 
		
		while(pq.length() > 1) {
			
			HuffmanTrieNode min1 = pq.removeMin();
			HuffmanTrieNode min2 = pq.removeMin();
				
			//System.out.println(min1.weight() + " " +  min2.weight());
				
			if(min1.weight() == min2.weight()) {
				
				if(min1.occurenceOrder() < min2.occurenceOrder()) {
					
					intNode = new InternalNode(min1.weight()+min2.weight() , order++, min2, min1);
				}
				else
					 intNode = new InternalNode(min1.weight()+min2.weight() , order++ , min1, min2);		 	
			}
			else if (min1.weight() < min2.weight()) {
				
				intNode = new InternalNode(min1.weight()+min2.weight() , order++ , min1, min2);
			}
			else if (min2.weight() > min1.weight())
				intNode = new InternalNode(min1.weight()+min2.weight() , order++ , min2, min1);

			
			// System.out.println(intNode.weight());
					 
			pq.add(intNode);
			size = order-1;
				
			
		}
		
		
		
		return intNode;
	}

	
		
	public int treeWeight() {
		
		return root.weight();
	}
	
	public void encode(String encoding, InternalNode n, char[] characters, String[] charEncodings) {
		
		if(n == null) 
			return;
 	 
		if(n.leftChild != null && !n.leftChild.isLeaf()) 
			encode(encoding + 0, (InternalNode)n.leftChild, characters, charEncodings);
		
		 if(n.rightChild != null && !n.rightChild.isLeaf())
			encode(encoding + 1,  (InternalNode)n.rightChild, characters, charEncodings);
		
		 if(n.leftChild != null && n.leftChild.isLeaf()) {
			
			
				LeafNode i = (LeafNode)n.leftChild;
				
			
				characters[count] = i.ASCII;
				charEncodings[count] = encoding+0;
				count++;

		}
		if(n.rightChild != null && n.rightChild.isLeaf()) {
			
			LeafNode i = (LeafNode)n.rightChild;
			
			characters[count] = i.ASCII;
			charEncodings[count] = encoding+1;
			count++;
			
		}
		
		
		
}
		
	
	

	
	
	public static class LeafNode extends HuffmanTrieNode{
		
		private char ASCII;
		
		
		
		public LeafNode() {
			super();
		
		}

		
		public LeafNode(char ASCII, int weight, int occurenceOrder) {
			super(weight, occurenceOrder);
			this.ASCII = ASCII;
		}

		public boolean isLeaf() {
			return true;
		}

		
		public boolean isRoot() {
			return false;
		}
		
		
		public char getChar() {
			
			return ASCII;
		}
		
		
		public String toString() {
			return  "char= " + ASCII + " " + super.toString() ;
		}
		

	}	
	
	
	
	
	
	public static class InternalNode extends HuffmanTrieNode{
		

		private HuffmanTrieNode leftChild;
		private HuffmanTrieNode rightChild;
		
	
		public InternalNode() {
			
		}



		public InternalNode(int weight, int occurenceOrder, HuffmanTrieNode leftChild, HuffmanTrieNode rightChild) {
			super(weight, occurenceOrder);
			this.leftChild = leftChild;
			this.rightChild = rightChild; 
			
		}



		public boolean isLeaf() {
			return false;
		}

	
		public HuffmanTrieNode leftChild() {
			
			return leftChild;
		}
		
		public HuffmanTrieNode rightChild() {
			
			return rightChild;
		}
		
	public String toString() {
			return   super.toString();
	}
	

	
	}
	
		
}



