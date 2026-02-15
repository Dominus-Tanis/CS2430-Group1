package project1CS2430;

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
		
		//Run Quick Sort
		arry = ArrayGenerator.firstPermutation(dataLength); //Start with clean array
		while(ArrayGenerator.findNextPermutation(arry)) {//Repeat until no new permutation 
			Sorter.quickSort(arry);
		}

		//Run Shaker Sort
		arry = ArrayGenerator.firstPermutation(dataLength); //Start with clean array
		while(ArrayGenerator.findNextPermutation(arry)) {//Repeat until no new permutation 
			Sorter.shakerSort(arry);
		}
		
		//Run Heap Sort
		arry = ArrayGenerator.firstPermutation(dataLength); //Start with clean array
		while(ArrayGenerator.findNextPermutation(arry)) { //Repeat until no new permutation 
			//Sorter.heapSort(arry, ?, ?);
		}
		
		//Run Merge Sort
		arry = ArrayGenerator.firstPermutation(dataLength); //Start with clean array
		while(ArrayGenerator.findNextPermutation(arry)) {//Repeat until no new permutation 
			//Sorter.mergeSort(arry);
		}

	}

}
