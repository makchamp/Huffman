//Makram Adaime 40033315
//352 Assignment 3
//Submitted June 16th 2018

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SplayTree {

	
	public static void main(String[] args) {
		
		SplayBST splayTree = new SplayBST();
		File ops = new File(args[0]);
		Scanner input = null;
		int opCount = 0;                //For traversal output
		String op;						//To store operation type
		int value;						//To store the number value
								
		
		
		try {
		
		input = new Scanner(new FileInputStream(ops));
		}
		catch(FileNotFoundException e) {
			
			System.out.println(e.getLocalizedMessage());
		}
		

			while(input.hasNextLine()) {
				
				op = input.nextLine();
				value = Integer.parseInt(op.substring(1, op.length()));
				op = op.substring(0,1);
				
				
				
				if(op.equals("a")) {
						
					opCount++;
					splayTree.add(value);
					if(opCount == Integer.parseInt(args[1])) {
						System.out.println("Traversal at: " + opCount);
						splayTree.postOrder(splayTree.root());
						System.out.println("\nZigZigs: " + splayTree.getZigZig() + " ZigZags: " + splayTree.getZigZag() + " Compares: " + splayTree.comparisons());
							
					}
									}
				
				if(op.equals("f")) {
					
					opCount++;
					splayTree.find(splayTree.root, value);
					if(opCount == Integer.parseInt(args[1])) {
						System.out.println("Traversal at: " + opCount);
						splayTree.postOrder(splayTree.root());
						System.out.println("\nZigZigs: " + splayTree.getZigZig() + " ZigZags: " + splayTree.getZigZag() + " Compares: " + splayTree.comparisons());
						
					
					}
					
				}
				
				if(op.equals("r")) {
					
					opCount++;
				SplayBST.SplayNode n = splayTree.find(splayTree.root, value);
					
				if(n != null)
					//splayTree.remove(n);
				
					if(opCount == Integer.parseInt(args[1])) {
						System.out.println("Traversal at: " + opCount);
						splayTree.postOrder(splayTree.root());
						System.out.println("\nZigZigs: " + splayTree.getZigZig() + " ZigZags: " + splayTree.getZigZag() + " Compares: " + splayTree.comparisons());
					}
								
				}
				
			}
			
			input.close();
		
	
	
		
		
		
	}
	
}
