//Makram Adaime 40033315
//352 Assignment 3
//Submitted June 16th 2018

public class HuffmanTrieNode implements BinaryTreeNode, Comparable<HuffmanTrieNode>{
	
	private int weight;
	private int occurenceOrder;

	
	
	public HuffmanTrieNode() {
		
	}

	public HuffmanTrieNode(int weight, int occurence) {
		
		this.weight = weight;
		this.occurenceOrder = occurence;
	}

	public boolean isLeaf() {
		return this.isLeaf();
	}
	
	
	public int weight() {
		
		return weight;
	}
	
	public int occurenceOrder() {
		
		return occurenceOrder;
	}
	
	public String toString() {
		return "weight= " + weight + " occurenceOrder= " + occurenceOrder;
	}
	
	
	
 // Compares the weight of the nodes
	public int compareTo(HuffmanTrieNode o) {
		
		
		if (this.weight > o.weight)
			return 1;
		else if (this.weight < o.weight)
			return -1;
		else 
			return 0;
		
	}

	
	
	
	
	
	

}
