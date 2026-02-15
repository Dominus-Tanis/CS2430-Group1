package project1CS2430;

import java.util.Arrays;

/*
 * Runs four algorithms on each permutation, and records:
 * Algorithm name
 * The unsorted array used
 * Number of comparisons
 */
public class Main {

	public static void main(String[] args) {
		/*Change this to adjust how large the arrays to be sorted are.
		 *Assignment requires to gather data on: (dataLength)n = 4, 6, 8
		 */ 
		int dataLength = 8;
		
		int[] arry; //Stores the data to sort
		
		//====================
		//QUICK SORT
		//====================
		System.out.println("Running Quick Sort"); //Terminal Feedback
		arry = ArrayGenerator.firstPermutation(dataLength); //Start with clean array
		do {
			Sorter.quickSort(Arrays.copyOf(arry, dataLength)); //Perform Sort
		}
		while(ArrayGenerator.findNextPermutation(arry));//Repeat until no new permutation 

		//====================
		//SHAKER SORT
		//====================
		System.out.println("Running Shaker Sort"); //Terminal Feedback
		arry = ArrayGenerator.firstPermutation(dataLength); //Start with clean array
		do {
			Sorter.shakerSort(Arrays.copyOf(arry, dataLength)); //Perform Sort
		}
		while(ArrayGenerator.findNextPermutation(arry));//Repeat until no new permutation
		
		//====================
		//HEAP SORT
		//====================
		System.out.println("Running Heap Sort"); //Terminal Feedback
		arry = ArrayGenerator.firstPermutation(dataLength); //Start with clean array
		do {
			//Sorter.heapSort(Arrays.copyOf(arry, dataLength)); //Perform Sort
		}
		while(ArrayGenerator.findNextPermutation(arry));//Repeat until no new permutation
		
		//====================
		//MERGE SORT
		//====================
		System.out.println("Running Merge Sort"); //Terminal Feedback
		arry = ArrayGenerator.firstPermutation(dataLength); //Start with clean array
		do {
			//Sorter.mergeSort(Arrays.copyOf(arry, dataLength)); //Perform Sort
		}
		while(ArrayGenerator.findNextPermutation(arry));//Repeat until no new permutation

	}

}
