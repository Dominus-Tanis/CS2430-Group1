package project1CS2430;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorter {
	/**
	 * Stores Data
	 */
	public static List<SortReportData> reports = new ArrayList<>();
	/*
	 * Stores the number of comparisons from a sort 
	 */
	public static int count = 0;
	/**
	 * Stores the file name for the data report file
	 */
	public static Path dataFile = Paths.get("project_1_data.txt");
	
	//======================================
	// Report Writing (Spencer)
	// =====================================
	
	/**
	 * Deletes the old file and creates a new report with the header.
	 * This prevents errors and ensures the file is ready for appending.
	 * @author SpencerJPeck
	 */
	public static void newReport() {
		//try {
			reports.clear();
			//Files.deleteIfExists(dataFile);
			//List<String> lines = Arrays.asList("Array,Method,Comparisons");
			//Files.write(dataFile, lines, StandardCharsets.UTF_8);
		//} catch (IOException e) {
			//e.printStackTrace();
		//}
	}

	/**
	 * Using the stored file path, this method appends the given int array to the stored file.
	 * * @param arrayData The array you wish to append to the report file.
	 * @author SpencerJPeck
	 */
	private static void appendReport(int[] arrayData) {
		try {
			StringBuilder sb = new StringBuilder(); 
			sb.append("["); 
			for (int i = 0; i < arrayData.length; i++) { 
				sb.append(arrayData[i]);
				if (i < arrayData.length - 1) sb.append("-");
			}
			sb.append("],");

			// Added StandardOpenOption.CREATE to prevent NoSuchFileException
			Files.write(dataFile, sb.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Using the stored file path, this method appends the given string to be labeled as a sort method
	 * and the number of counts the sort took to the stored file.
	 * * @param sortMethod Name of the sort algorithm
	 * @param count Total comparison count
	 * @author SpencerJPeck
	 */
	private static void appendReport(String sortMethod, long count) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(sortMethod + "," + count+ "\n");
            
            // Added StandardOpenOption.CREATE to prevent NoSuchFileException
			Files.write(dataFile, sb.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    // ============================================================
    // Mike (Heapsort Implementation)
    // ============================================================
    
    static void heapSort(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        count++; // INCREMENT: Data comparison count
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        count++; // INCREMENT: Data comparison count
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        count++; // INCREMENT: Data comparison count
        if (largest != i) {
        	int temp = arr[i];
        	arr[i] = arr[largest];
            arr[largest] = temp;
            heapSort(arr, n, largest);
        }
    }
    
    public static int[] heapSort(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        
        count = 0;           // Reset Counter
        //appendReport(arr);   // Write starting array
        int[] tempArry = Arrays.copyOf(arr, arr.length);
        
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
        	heapSort(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSort(arr, i, 0);
        }
        
        //appendReport("Heap Sort", count); // Final report
        reports.add(new SortReportData("HeapSort", tempArry, count));
        return arr; 
    }

    // ============================================================
    // Andrew (Mergesort Implementation) - Fixed Entry Point
    // ============================================================
    /**
     * Entry point for Mergesort. Handles initial reporting and counter reset.
     * @author Andrew Clark (logic), Kevin Ajongbah (wrapper)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        
        count = 0;           // Reset Counter ONCE at the start
        //appendReport(arr);   // Write array data to file ONCE
        int[] tempArry = Arrays.copyOf(arr, arr.length);
        
        
        // Call Andrew's original recursive method
        mergeSortRecursive(arr, 0, arr.length - 1);
        
        //appendReport("Merge Sort", count); // Final report ONCE
        reports.add(new SortReportData("MergeSort", tempArry, count));
    }

    // Andrew's original function that sorts arr[l..r]
    private static void mergeSortRecursive(int arr[], int l, int r){
        if (l < r) {
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSortRecursive(arr, l, m);
            mergeSortRecursive(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Andrew's original merging logic
    private static void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            count++; // INCREMENT: Data comparison count
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

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    // ============================================================
    // KEVIN (Quicksort Implementation)
    // ============================================================
    
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        count = 0; 
        int[] tempArry = Arrays.copyOf(arr, arr.length);
        //appendReport(arr); 
        quickSortRecursive(arr, 0, arr.length - 1);
        //appendReport("Quick Sort", count); 
        reports.add(new SortReportData("QuickSort", tempArry, count));
    }

    private static void quickSortRecursive(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortRecursive(arr, low, pi - 1);
            quickSortRecursive(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            count++; 
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // ============================================================
    // KEVIN (Shaker Sort Implementation)
    // ============================================================

    public static void shakerSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        count = 0; 
        int[] tempArry = Arrays.copyOf(arr, arr.length);
        //appendReport(arr); 
        
        boolean swapped = true;
        int start = 0;
        int end = arr.length;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                count++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;

            swapped = false;
            end = end - 1;

            for (int i = end - 1; i >= start; i--) {
                count++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
        //appendReport("Shaker Sort", count); 
        reports.add(new SortReportData("ShakerSort", tempArry, count));
    }
}
  



