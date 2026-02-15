package project1CS2430;

public class Sorter {

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
    /*****************************************
     * Merge Sort
     *****************************************/
 // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }


   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

}
