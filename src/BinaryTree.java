//Makram Adaime 40033315
//352 Assignment 3
//Submitted June 16th 2018

public class BinaryTree<T> {
	
	protected T root;
	protected int size;
	
	public BinaryTree(){
		
		
	}
	
	public T root() {
		
		return root;
	}
	
	public int size() {
		
		return size;
	}

	public boolean isEmpty() {
		
		return root == null;
	}



	public void setRoot(T root) {
		this.root = root;
	}


	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}
