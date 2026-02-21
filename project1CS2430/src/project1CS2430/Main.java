package project1CS2430;

import java.nio.file.Paths;
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
		int dataLength = 4;
		
		int[] arry; //Stores the data to sort
		//Sorter.dataFile = Paths.get("project_1_data.txt");
		//====================
		//QUICK SORT
		//====================
		Sorter.newReport();
		System.out.println("Running Quick Sort"); //Terminal Feedback
		arry = ArrayGenerator.firstPermutation(dataLength); //Start with clean array
		do {
			Sorter.quickSort(Arrays.copyOf(arry, dataLength)); //Perform Sort
		}
		while(ArrayGenerator.findNextPermutation(arry));//Repeat until no new permutation 
		
		Sorter.reports.sort(null);
		System.out.println("Best 10");
		for(int i = 0; i < 10; i++ ) {
			System.out.println("" + Arrays.toString(Sorter.reports.get(i).arry) + " " + Sorter.reports.get(i).count);
		}
		System.out.println("Worst 10");
		
		Sorter.reports.reversed();
		for(int i = 0; i < 10; i++ ) {
			System.out.println("" + Arrays.toString(Sorter.reports.get(Sorter.reports.size() - i -1).arry) + " " + Sorter.reports.get(Sorter.reports.size() - i-1).count);
		}

		//====================
		//SHAKER SORT
		//====================

		Sorter.newReport();
		System.out.println("Running Shaker Sort"); //Terminal Feedback
		arry = ArrayGenerator.firstPermutation(dataLength); //Start with clean array
		do {
			Sorter.shakerSort(Arrays.copyOf(arry, dataLength)); //Perform Sort
		}
		while(ArrayGenerator.findNextPermutation(arry));//Repeat until no new permutation

		System.out.println("Best 10");
		Sorter.reports.sort(null);
		for(int i = 0; i < 10; i++ ) {
			System.out.println("" + Arrays.toString(Sorter.reports.get(i).arry) + " " + Sorter.reports.get(i).count);
		}

		System.out.println("Worst 10");
		Sorter.reports.reversed();
		for(int i = 0; i < 10; i++ ) {
			System.out.println("" + Arrays.toString(Sorter.reports.get(Sorter.reports.size() - i -1).arry) + " " + Sorter.reports.get(Sorter.reports.size() - i-1).count);
		}
		//====================
		//HEAP SORT
		//====================
		Sorter.newReport();
		System.out.println("Running Heap Sort"); //Terminal Feedback
		arry = ArrayGenerator.firstPermutation(dataLength); //Start with clean array
		do {
			Sorter.heapSort(Arrays.copyOf(arry, dataLength)); //Perform Sort
		}
		while(ArrayGenerator.findNextPermutation(arry));//Repeat until no new permutation

		System.out.println("Best 10");
		Sorter.reports.sort(null);
		for(int i = 0; i < 10; i++ ) {
			System.out.println("" + Arrays.toString(Sorter.reports.get(i).arry) + " " + Sorter.reports.get(i).count);
		}

		System.out.println("Worst 10");
		Sorter.reports.reversed();
		for(int i = 0; i < 10; i++ ) {
			System.out.println("" + Arrays.toString(Sorter.reports.get(Sorter.reports.size() - i -1).arry) + " " + Sorter.reports.get(Sorter.reports.size() - i-1).count);
		}
		//====================
		//MERGE SORT
		//====================
		Sorter.newReport();
		System.out.println("Running Merge Sort"); 
		arry = ArrayGenerator.firstPermutation(dataLength); 
		do {
		    Sorter.mergeSort(Arrays.copyOf(arry, dataLength)); // Fixed call
		}
		while(ArrayGenerator.findNextPermutation(arry));

		System.out.println("Best 10");
		Sorter.reports.sort(null);
		for(int i = 0; i < 10; i++ ) {
			System.out.println("" + Arrays.toString(Sorter.reports.get(i).arry) + " " + Sorter.reports.get(i).count);
		}

		System.out.println("Worst 10");
		Sorter.reports.reversed();
		for(int i = 0; i < 10; i++ ) {
			System.out.println("" + Arrays.toString(Sorter.reports.get(Sorter.reports.size() - i -1).arry) + " " + Sorter.reports.get(Sorter.reports.size() - i-1).count);
		}
	}

}

