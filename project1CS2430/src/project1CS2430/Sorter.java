package project1CS2430;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Sorter {
	/*
	 * Stores the number of comparisons from a sort 
	 */
	public static long count = 0;
	/**
	 * Stores the file name for the data report file
	 * This is a path so could be rerouted to another folder but will normally create at the project's directory
	 */
	public static Path dataFile = Paths.get("project_1_data.txt");
	
	//======================================
	// Report Writing
	// =====================================
	
	/**
	 * Using the stored file path, this method appends the given int array to the stored file.
	 * Limited AI was used for this method (quick lookup on how Files usage)
	 * 
	 * Now testing the following array:
	 * [array]
	 * 
	 * @param dataFile Where the file path is stored.
	 * @param arrayData The array you wish to append to the report file.
	 * @author SpencerJPeck
	 */
	private static void appendReport(int[] arrayData) {
		try {
			StringBuilder sb = new StringBuilder(); //Create format to send to File writer
			sb.append("\nNow testing the following array:\n[ "); // Add message Data
			for (int i = 0; i < arrayData.length; i++) { //Add Array Data
				sb.append(arrayData[i]);
				if (i < arrayData.length - 1) sb.append(", ");
			}
			sb.append(" ]");

			Files.write(dataFile, sb.toString().getBytes(), StandardOpenOption.APPEND); //Write data to file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Using the stored file path, this method appends the given string to be labeled as a sort method
	 * and the number of counts the sort took to the stored file.
	 * 
	 * Using: sortMethod. Comparisons: count.
	 * @param dataFile Where the file path is stored.
	 * @param sortMethod
	 * @param count
	 * @author SpencerJPeck
	 */
	private static void appendReport(String sortMethod, long count) {
		try {
			StringBuilder sb = new StringBuilder();//Create format to send to File writer
			sb.append("\nUsing: "+ sortMethod + ".\nComparisons: " + count+ ".\n");// Add message Data
			Files.write(dataFile, sb.toString().getBytes(), StandardOpenOption.APPEND); //Write data to file
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

    // ============================================================
    // Mike (Heapsort Implementation) recent changes: added heapStart method and modified heapSort
    // ============================================================
    
    static void heapSort(int[] arr, int n, int i) {
//    	System.out.println("printing heapsort..."); // p.c.
//    	System.out.println("n="+n+", i="+i); // p.c.
        // largest is set to i to setup the variable for comparisons later
//    	System.out.println(i); // p.c.
        int largest = i;

        // left index = 2*i + 1
        int left = 2 * i + 1;
//        System.out.println(left); // p.c.

        // right index = 2*i + 2
        int right = 2 * i + 2;
//        System.out.println(right); // p.c.
        
        // if left subtree is bigger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
//            System.out.println("left child is larger: "+arr[largest]); // p.c.
        }
        // if right subtree is bigger than root
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
//            System.out.println("right child is larger: "+arr[largest]); // p.c.
        }

        //if the root got replaced by a child node, set new largest and run again
//        System.out.println("largest is not root"); // p.c.
        if (largest != i) {
//        	System.out.println("largest does not equal i, "+arr[largest]+", "+arr[i]); // p.c.
            
        	int temp = arr[i];
//            System.out.println("printing temp = arr[i]"+arr[i]); // p.c.
            
        	arr[i] = arr[largest];
//            System.out.println("printing arr[i] = arr[largest]"+arr[i]); // p.c.
            
            arr[largest] = temp;
//            System.out.println("printing arr[largest] = temp"+arr[largest]); // p.c.

//            System.out.println("heapsort recursing..."); // p.c.
//            System.out.println("i = largest"); // p.c.
          
            heapSort(arr, n, largest);
//            System.out.println(""); // p.c.
        }
        // printed for clarity
//        else {
//        	System.out.println("largest did equal i, "+arr[largest]+", "+arr[i]); // p.c.
//       	System.out.println(""); // p.c.
//        }
        }
    
    // this method calls heapSort multiple times to fully sort the array in a max heap
    // heapStart should be used when calling for a heapsort as this method will call heapSort multiple times and then return the sorted array
    public static int[] heapStart(int[] arr) {
        int n = arr.length;
//      System.out.println("i = n / 2 - 1, and n = array.length"); // p.c.
        
        for (int i = n / 2 - 1; i >= 0; i--) {
//        	System.out.println("i = " + i + ", n = " + n + "."); // p.c.
//        	System.out.println("printing current array..."); // p.c.
//        	for(int z = 0; z < arr.length; z++) // p.c.
//            	System.out.print(arr[z]+" "); // p.c.
//        	System.out.println(""); // p.c.
        	
        	heapSort(arr, n, i);
        }
        // move root to the end of the array
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSort(arr, i, 0);
        }
        System.out.println("Heapsort Done");
        return arr; // returns sorted array, which can be stored into a variable calling this function
        }

 // ============================================================
    // Andrew (Mergesort Implementation)
    // ============================================================
    /**
     * Sorts arrays with mergesort algorithm
     * based on geeksforgeeks implementation
     * https://www.geeksforgeeks.org/dsa/merge-sort/
     * edited by 
     * @author Andrew Clark
     */
    
 // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r){
    	if (arr == null || arr.length == 0) {
            return;
        }
    	count = 0; // Reset Counter
        appendReport(arr); // Write array data to file 
        mergeSort(arr, 0, arr.length - 1);
        appendReport("Merge Sort", count); // 
        
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int arr[], int l, int r){
        
        if (l < r) {
        	//increment global counter
        	count++;

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
    // ============================================================
    // KEVIN (Quicksort Implementation)
    // ============================================================
    
    /**
     * Sorts the specified array into ascending order using the Quicksort algorithm.
     * *Adapted from "Introduction to Algorithms" and standard
     * implementations found on GeeksForGeeks.
     * URL: https://www.geeksforgeeks.org/quick-sort/
     * * Time Complexity: O(N log N) average, O(N^2) worst case.
     * Space Complexity: O(log N) for recursion stack.
     * * @param arr The array of integers to be sorted.
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        count = 0; // Reset Counter
        appendReport(arr); // Write array data to file -Spencer
        quickSortRecursive(arr, 0, arr.length - 1);
        appendReport("Quick Sort", count); // Write Sort data to file -Spencer
    }

    /**
     * Recursive helper method for Quicksort.
     * * @param arr  The array to sort
     * @param low  Starting index
     * @param high Ending index
     */
    private static void quickSortRecursive(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSortRecursive(arr, low, pi - 1);
            quickSortRecursive(arr, pi + 1, high);
        }
    }

    /**
     * Takes the last element as the pivot, places the pivot element at its
     * correct position in sorted array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot.
     * * @param arr  The array
     * @param low  The lower index
     * @param high The upper index (pivot)
     * @return The partition index
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            
            // Increment global comparison counter
            count++; 
            
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // ============================================================
    // KEVIN (Shaker Sort Implementation)
    // ============================================================

    /**
     * Sorts the specified array using the Shaker Sort algorithm
     * * SOURCE: Adapted from standard algorithms (Rosetta Code / Wikipedia).
     * URL: https://en.wikipedia.org/wiki/Cocktail_shaker_sort
     * * Time Complexity: O(N) best case, O(N^2) average/worst case.
     * Space Complexity: O(1).
     * * @param arr The array of integers to be sorted.
     */
    public static void shakerSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        count = 0; // Reset Counter
        appendReport(arr); // Write array data to file -Spencer
        
        boolean swapped = true;
        int start = 0;
        int end = arr.length;

        while (swapped) {
            swapped = false;

            // forward pass: bubble sort from left to right
            for (int i = start; i < end - 1; ++i) {
                
                // Increment global comparison counter
                count++;
                
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            // if no elements were swapped, then the array is sorted
            if (!swapped) {
                break;
            }

            // otherwise, reset the swapped flag so that it can be used in the next stage
            swapped = false;

            // move the end point back by one, because the item at the end is in its rightful spot
            end = end - 1;

            // backward pass: bubble sort from right to left
            for (int i = end - 1; i >= start; i--) {
                
                // Increment global comparison counter
                count++;
                
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            // increase the starting point, because the last stage would have moved the next
            // smallest number to its rightful spot.
            start = start + 1;
        }
        appendReport("Shaker Sort", count); // Write Sort data to file -Spencer
    }
}
  


