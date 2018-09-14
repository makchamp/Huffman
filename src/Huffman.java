//Makram Adaime 40033315
//352 Assignment 3
//Submitted June 16th 2018

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Huffman {

	public static void main(String[] args) {
		
		File textFile = new File(args[0]);
		BufferedReader input = null;
		
		
		try {
			
			input = new BufferedReader(new FileReader((textFile)));
			
		}catch(FileNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
		
		int[] freqTable = new int[256];  // ASCII 0-255 Index(key) determines the ASCII character, value determines frequency. 
		
		
		int x;
		char ASCII;
		
		int order = 0;  				 // A counter to keep track of the order of occurrence of each character
		
		int[] occurenceTable = new int[256];  			// Holds the order in which each character appears in text
		
		int first;
		
	// Reading the characters from the input file and adding their frequencies to the frequency table array. 	
	
	try {	
		
		x = input.read();
		first = x;
		
		while(x != -1){
			
			ASCII = (char) x;
			freqTable[(int) ASCII]++;
			
		if (occurenceTable[(int) ASCII] == 0 ) {
			
			occurenceTable[(int) ASCII] = order;
			order++;
		}
		
			x = input.read();		
		}

		occurenceTable[first] = 0;
		input.close();
	
	}catch(NullPointerException e) {
		
		System.out.println(e.getMessage());
	}
	catch(IOException e) {
		
		System.out.println(e.getLocalizedMessage());
	}
	
		int[] keysTemp = new int[256];  // The keys array will hold all integer keys of the characters. The key represents the ASCII character.
										//  I can use the key to access the representing character's frequency from the frequency table array in constant time. 
									 	// I use a temporary array as it might not be filled with all the 255 ASCII characters and might need to be resized.
		
		
		int counter = 0;  //To fill the keysTemp array from index 0. Also used to determine the size of the actual keys array.
		
		//Storing all the character integer keys in the keysTemp array.
		
		for (int i = 0; i < freqTable.length; i++) {
			
		    if (freqTable[i] > 0) {
		    	
		       // System.out.println("Key: " + i + ". Frequency of " + (char) i + ": " + freqTable[i]);        
		        keysTemp[counter] = i;
		        counter++;
		        
		    }
		}
		
		//Creating the actual keys array 
	
		int[] keys = new int[counter];
	
		for(int i = 0; i<counter; i++) {
	
			if(keysTemp[i] > 0)
				keys[i] = keysTemp[i];
							
		}	
		keysTemp = null;
		
	
		// Creating a priority queue
		
		PriorityQueue pq = new PriorityQueue(new HuffmanTrieNode[(keys.length*2)], (keys.length*2), 0);
		
		
		
		// Creating all the huffman trie leaf nodes and adding them to the priority queue. 
		
		for(int i = 0; i<keys.length; i++) {
			
				
			
			pq.add(new HuffmanCodingTrie.LeafNode((char)keys[i], freqTable[keys[i]], occurenceTable[keys[i]]));		
				
		}

		System.out.println("Initial queue: ");
		pq.printQueue();
		System.out.println();
			
		String[] charEncodings = new String[order+1];
		char[] characters = new char[order+1];

		
		
		HuffmanCodingTrie huffman = new HuffmanCodingTrie(pq, order);

		
		String toEncode = "malls are great places to shop; i can find everything i need under one roof.";
		String encoding = "";
		
		
		huffman.encode(encoding, huffman.root, characters, charEncodings);
		
		System.out.println("Character encodings: ");
	
		for(int i=0; i<=order; i++) {
		
			
			System.out.println(charEncodings[i] != null ? "char: " + characters[i] + " encoding: " + charEncodings[i] : "");
			
	
		}
		
		String code = "";
		
		for(int i=0; i <toEncode.length(); i++) {
			
			char c = toEncode.charAt(i);
			
			for(int j =0; j<characters.length; j++) {
				
				if(c == characters[j]) {
					
					code += charEncodings[j];
					
				}
				
			}	
		}
		
		byte[] ascii = toEncode.getBytes(StandardCharsets.US_ASCII);
		
		System.out.println("\n" + toEncode);
		System.out.println("Encoding: " + code);
		System.out.println("Huffman number of bits: " + code.length());
		System.out.println("ASCII number of bits: " + ascii.length*8);
		
	}

}
