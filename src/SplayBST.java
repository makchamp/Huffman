//Makram Adaime 40033315
//352 Assignment 3
//Submitted June 16th 2018

public class SplayBST extends BinaryTree<SplayBST.SplayNode>{


	private int zigZag;
	private int zigZig;
	private int comparisons;

	public SplayBST() {
		
	}
	
	

public void add(int value) {
	
	if(root == null) {
		
		root = new SplayNode(value, null, null);
		size++;
		return;
	}
		
	SplayNode t = root;
	SplayNode node = new SplayNode(value, null, null);
	
 // Adding a new node iteratively 
	
	while(t != null) {
		
		if(t.leftChild == null && value < t.value ) {
			
			t.leftChild = node;
			node.parent = t;
			size++;
			
			
		}
			else if (t.rightChild == null & value > t.value) {
			
				t.rightChild = node;
				node.parent = t;
				size++;
				
		}
			else if (value < t.value)
				t = t.leftChild;
				else 
					t = t.rightChild;
				
	}	
	
		
		splay(node);
	
	
	
}
	
	public void remove(SplayNode node) {
		
		if(root == null)
			return;
		
		SplayNode r = node.rightChild;
		SplayNode l = node.leftChild;
		
		if(node == root) {
			
			if(r != null && l != null) { 
				
				
				
									
			}
		
			
		}
		 	
		
	}
	
	public SplayNode find(SplayNode node, int value) {
		
		if(node == null) {
			return null;
		}
		
		if (node.value == value) {
			comparisons++;
			splay(node);
			return node;
		}
		if(root.leftChild != null && value < node.value) {
			comparisons++;
			return find(node.leftChild, value);
			
		}	
		
		if (node.rightChild != null && value > node.value) {
			comparisons++;
			return find(node.rightChild, value);
		}
			
		

	return null;
	}
	
	public void splay(SplayNode node) {
			
				
	while(node.parent != null) {
		
		SplayNode g = node.parent.parent;
		SplayNode p = node.parent;
		SplayNode c = node;
	
		
		if(g == null)
			return;
		
		SplayNode pL = p.leftChild;
		SplayNode gL = g.leftChild;	
		SplayNode pR = p.rightChild;
		SplayNode gR = g.rightChild;
		
		if(gR == p  && pR == c) {          	 // Case 1: ZigZig from right to left   c/p/g
			
			leftZigZig(p);
			leftZigZig(c);
			zigZig++;
			comparisons += 2;
			
			}	
		
			
		else if(gL == p  && pL == c) {           // Case 2: ZigZig from left to right g\p\c
			
			rightZigZig(p);
			rightZigZig(c);
			zigZig++;
			comparisons += 2;
			
		}	
		
		
		else if(gL == p  && pR == c) {          	  // Case 3: ZigZag  left-right  g/p\c

			leftZigZag(p);
			rightZigZig(c);
			zigZag++;
			comparisons += 2;
			
			}									  
		
		else if (gR == p  && pL == c) {          	  // Case 4: ZigZag  right-left  g\p/c
			
			
			rightZigZag(p);
			leftZigZig(c);		
			zigZag++;
			comparisons += 2;
			
			}					
		
	}
	
		
}
	
	private void rightZigZig(SplayNode node) {                              
		
	SplayNode p = node;									 
	SplayNode g = node.parent;	                              
	
	                                                                          
	g.leftChild = p.rightChild;                   // 1. First, I make the left child of the grandparent node point to right child of the parent. 
		
		if(p.rightChild != null)														
			p.rightChild.parent = g;  			  // 2. Then, I make the parent of that same node point to it's new parent (the old grandparent)
		                                                                                                    
		p.rightChild = g;						 // 3. Then,  I make the old grandparent the right child of the parent node and point it to it's new parent  
		
				
	if(g == root) 						         // 4. Finally, I link back to the rest of the tree (link parent pointer first then left child)
		root = p;
	
	else if (g.parent.rightChild == g){	
				comparisons++;
			g.parent.rightChild = p; 			
		}
	else if (g.parent.leftChild == g) {
			comparisons++;
			g.parent.leftChild = p;
	}
	p.parent = g.parent;
	g.parent = p; 
}
	
	private void leftZigZig(SplayNode node) {
		
		SplayNode p = node;									 
		SplayNode g = node.parent;	                              
		                              
		g.rightChild = p.leftChild;
		
			if(p.leftChild != null)														
				p.leftChild.parent = g;  				
			                                                                                                    
			p.leftChild = g;				 
	
		if(g == root) 							
			root = p;	
		
	else if (g.parent.rightChild == g){	
			comparisons++;
			g.parent.rightChild = p; 			
		}
	else if (g.parent.leftChild == g) {
			comparisons++;
			g.parent.leftChild = p;
	}
	p.parent = g.parent;
	g.parent = p; 

																				   	
	}
	
private void leftZigZag(SplayNode node) {                              
	
	SplayNode p = node;									 
	SplayNode c = node.rightChild;	                              
	
	                                                                          
		p.rightChild = c.leftChild;                  
		
		if(c.leftChild != null)														
			c.leftChild.parent = p;  				
		                                                                                                    
		c.leftChild = p;
		
	if(c.parent == root) {								
		root = c;	
		c.parent = p.parent;
	}	
	else {
		
		c.parent = p.parent;
		p.parent.leftChild = c;
	
	}
	p.parent = c;
	
	
												   
}
	
private void rightZigZag(SplayNode node) {                             
	
	SplayNode p = node;									 
	SplayNode c = node.leftChild;	                              
	
	                                                                          
		p.leftChild = c.rightChild;                  
		
		if(c.rightChild != null)														
			c.rightChild.parent = p;  				
		                                                                                                    
		c.rightChild = p;
		
	if(c.parent == root) {								
		root = c;	
		c.parent = p.parent;
	}	
	else {
		
		c.parent = p.parent;
		p.parent.rightChild = c;
	
	}
	p.parent = c;
																			   
}

	
	public void postOrder(SplayNode node) {
		
		if(node == null)
			return;
		
		postOrder(node.leftChild);
		postOrder(node.rightChild);
		    
		System.out.print(node.value + " ");
				
	}

	

	
	public int getZigZag() {
		return zigZag;
	}


	public int getZigZig() {
		return zigZig;
	}
	
	public int comparisons() {
		
		return comparisons;
	}



	
public class SplayNode implements BinaryTreeNode, Comparable<SplayNode>{
	
	private int value;
	private SplayNode leftChild;
	private SplayNode rightChild;
	private SplayNode parent;
	
	
	public SplayNode(){
		
		
	}
	
	public SplayNode(int value, SplayNode leftChild, SplayNode rightChild) {
		
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
			
	}
	
	
	
	public boolean isLeaf() {
		return rightChild == null && leftChild == null;
	}
	

	public int compareTo(SplayNode o) {
		
		if (this.value > o.value)
			return 1;
		else if (this.value < o.value)
			return -1;
		else 
			return 0;
		
		
	}


	public String toString() {
		return "SplayNode value=" + value;
	}
	
	
	public SplayNode leftChild() {
		
		return leftChild;
	}
	
	public SplayNode rightChild() {
		
		return rightChild;
	}
	
	public SplayNode parent() {
		
		return parent;
	}
	

	
	
}



	

}
