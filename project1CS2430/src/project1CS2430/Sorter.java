package project1CS2430;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Sorter {
	/**
	 * Stores the file name for the data report file
	 * This is a path so could be rerouted to another folder but will normally create at the project's directory
	 */
	public static Path dataFile = Paths.get("project_1_data.txt");
	
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
	public static void appendReport(int[] arrayData) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("\nNow testing the following array:\n[ ");
			for (int i = 0; i < arrayData.length; i++) {
				sb.append(arrayData[i]);
				if (i < arrayData.length - 1) sb.append(", ");
			}
			sb.append(" ]");

			Files.write(dataFile, sb.toString().getBytes(), StandardOpenOption.APPEND);
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
	public static void appendReport(String sortMethod, int count) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("\nUsing: "+ sortMethod + ".\nComparisons: " + count+ ".");
			Files.write(dataFile, sb.toString().getBytes(), StandardOpenOption.APPEND);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static long count = 0;
    static void sortheap(int[] arr, int n, int i) {
//	    	System.out.println("printing heapsort..."); // p.c.
//	    	System.out.println("n="+n+", i="+i); // p.c.
	        // largest is set to i to setup the variable for comparisons later
//	    	System.out.println(i); // p.c.
	        int largest = i;

	        // left index = 2*i + 1
	        int left = 2 * i + 1;
//	        System.out.println(left); // p.c.

	        // right index = 2*i + 2
	        int right = 2 * i + 2;
//	        System.out.println(right); // p.c.
	        
	        // if left subtree is bigger than root
	        if (left < n && arr[left] > arr[largest]) {
	            largest = left;
//	            System.out.println("left child is larger: "+arr[largest]); // p.c.
	        }
	        // if right subtree is bigger than root
	        if (right < n && arr[right] > arr[largest]) {
	            largest = right;
//	            System.out.println("right child is larger: "+arr[largest]); // p.c.
	        }

	        //if the root got replaced by a child node, set new largest and run again
//	        System.out.println("largest is not root"); // p.c.
	        if (largest != i) {
//	        	System.out.println("largest does not equal i, "+arr[largest]+", "+arr[i]); // p.c.
	            
	        	int temp = arr[i];
//	            System.out.println("printing temp = arr[i]"+arr[i]); // p.c.
	            
	            arr[i] = arr[largest];
//	            System.out.println("printing arr[i] = arr[largest]"+arr[i]); // p.c.
	            
	            arr[largest] = temp;
//	            System.out.println("printing arr[largest] = temp"+arr[largest]); // p.c.

//	            System.out.println("heapsort recursing..."); // p.c.
//	            System.out.println("i = largest"); // p.c.
	          
	            sortheap(arr, n, largest);
//	            System.out.println(""); // p.c.
	        }
	        // printed for clarity
//	        else {
//	        	System.out.println("largest did equal i, "+arr[largest]+", "+arr[i]); // p.c.
//	       	System.out.println(""); // p.c.
//	        }
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
        quickSortRecursive(arr, 0, arr.length - 1);
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
    }

}
