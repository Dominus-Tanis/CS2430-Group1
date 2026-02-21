package project1CS2430;

import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

/**
 * Unit tests for Sorter.java.
 * Verifies that the sorting algorithms correctly sort arrays and track comparisons.
 */
public class SorterTest {

	public static void main(String[] args) {
	    System.out.println("Starting Sorter Tests...");
	    
	    // 1. SETUP
	    Sorter.dataFile = Paths.get("test_report.txt");
	    Sorter.newReport(); // ADD THIS LINE: Creates the file and adds headers
	    
	    System.out.println("(Output redirected to test_report.txt for duration of tests)\n");
	    // ... rest of your tests

        // TEST: Quick Sort
        System.out.println("--- Testing Quick Sort (Kevin) ---");
        try {
            int[] input = { 50, 23, 9, 18, 61, 32 };
            int[] expected = { 9, 18, 23, 32, 50, 61 };
            Sorter.quickSort(input);
            assertArrayEquals("Quick Sort Basic", expected, input);
        } catch (Exception e) { e.printStackTrace(); }

        // TEST: Shaker Sort
        System.out.println("\n--- Testing Shaker Sort (Kevin) ---");
        try {
            int[] input = { 5, 1, 4, 2, 8, 0, 2 };
            int[] expected = { 0, 1, 2, 2, 4, 5, 8 };
            Sorter.shakerSort(input);
            assertArrayEquals("Shaker Sort Mixed", expected, input);
        } catch (Exception e) { e.printStackTrace(); }

        // TEST: Merge Sort (Andrew) - Fixed to use the 1-arg wrapper
        System.out.println("\n--- Testing Merge Sort (Andrew) ---");
        try {
            int[] input = { 12, 7, 14, 9, 10, 11 };
            int[] expected = { 7, 9, 10, 11, 12, 14 };
            Sorter.mergeSort(input); 
            assertArrayEquals("Merge Sort logic", expected, input);
        } catch (Exception e) { System.err.println("FAIL: Merge Sort Exception: " + e.getMessage()); }
        
        // TEST: Heap Sort (Mike) - Fixed to use the 1-arg wrapper
        System.out.println("\n--- Testing Heap Sort (Mike) ---");
        try {
            int[] input = { 3, 9, 2, 1, 4, 5 };
            int[] expected = { 1, 2, 3, 4, 5, 9 };
            Sorter.heapSort(input);
            assertArrayEquals("Heap Sort logic", expected, input);
        } catch (Exception e) { System.err.println("FAIL: Heap Sort Exception: " + e.getMessage()); }

        // CLEANUP
        try { Files.deleteIfExists(Paths.get("test_report.txt")); } catch (IOException e) { }
        System.out.println("\nTests Finished.");
    }

    private static void assertArrayEquals(String testName, int[] expected, int[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println("PASS: " + testName);
        } else {
            System.err.println("FAIL: " + testName + "\nExpected: " + Arrays.toString(expected) + "\nActual:   " + Arrays.toString(actual));
        }
    }
}

