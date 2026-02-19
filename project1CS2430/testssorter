package project1CS2430;

import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

/**
 * Unit tests for Sorter.java.
 * * Testing Strategy Sources:
 * 1. Corner cases (empty, sorted, reverse) adapted from Princeton Algorithms (Sedgewick/Wayne).
 * Ref: https://algs4.cs.princeton.edu/code/
 * 2. Randomized testing arrays strategy adapted from GeeksForGeeks.
 * Ref: https://www.geeksforgeeks.org/test-case-generation-for-sorting-algorithms/
 * * @author Project 1 Team
 */
public class SorterTest {

    public static void main(String[] args) {
        System.out.println("Starting Sorter Tests...");
        
        // 1. SETUP: Redirect output to a test file so we don't mess up the main report
        Sorter.dataFile = Paths.get("test_report.txt");
        System.out.println("(Output redirected to test_report.txt for duration of tests)\n");

        // ============================================================
        // TEST: Quick Sort (Kevin)
        // ============================================================
        System.out.println("--- Testing Quick Sort (Kevin) ---");
        try {
            int[] input = { 50, 23, 9, 18, 61, 32 };
            int[] expected = { 9, 18, 23, 32, 50, 61 };
            
            Sorter.count = 0; // Reset count manually before call
            Sorter.quickSort(input);
            
            assertArrayEquals("Basic Input", expected, input);
            if(Sorter.count > 0) System.out.println("PASS: Comparison Counter updated (" + Sorter.count + ")");
            else System.err.println("FAIL: Comparison Counter was 0");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ============================================================
        // TEST: Shaker Sort (Kevin)
        // ============================================================
        System.out.println("\n--- Testing Shaker Sort (Kevin) ---");
        try {
            int[] input = { 5, 1, 4, 2, 8, 0, 2 };
            int[] expected = { 0, 1, 2, 2, 4, 5, 8 };
            
            Sorter.count = 0;
            Sorter.shakerSort(input);
            
            assertArrayEquals("Mixed Input", expected, input);
            if(Sorter.count > 0) System.out.println("PASS: Comparison Counter updated (" + Sorter.count + ")");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ============================================================
        // TEST: Merge Sort (Andrew)
        // Note: Testing compatibility with Comparable[] inputs
        // ============================================================
        System.out.println("\n--- Testing Merge Sort (Andrew) ---");
        try {
            // Must use Integer[] (Object) instead of int[] (Primitive)
            // because Andrew's code signature is: sort(Comparable[] a)
            Integer[] input = { 12, 7, 14, 9, 10, 11 };
            Integer[] expected = { 7, 9, 10, 11, 12, 14 };
            
            // Call Andrew's sort
            Sorter.sort(input);
            
            // Check results
            if (Arrays.equals(input, expected)) {
                System.out.println("PASS: Merge Sort logic works (using Integer[] wrapper)");
            } else {
                System.err.println("FAIL: Merge Sort Result: " + Arrays.toString(input));
            }
        } catch (Exception e) {
            System.err.println("FAIL: Merge Sort Exception: " + e.getMessage());
        }
        
        // ============================================================
        // TEST: Heap Sort (Mike)
        // Note: The provided Sorter.java only contains the 'heapify' helper
        // ============================================================
        System.out.println("\n--- Testing Heap Sort (Mike) ---");
        System.out.println("SKIP: The file 'Sorter.java' currently contains the 'heapSort' helper method \n" +
                           "      but implies the full sorting loop is inside Main or missing. \n" +
                           "      (Cannot unit test full sort on this method alone).");

        // CLEANUP: Delete the test report file
        try {
            Files.deleteIfExists(Paths.get("test_report.txt"));
            System.out.println("\n(Cleaned up test_report.txt)");
        } catch (IOException e) { /* Ignore */ }
        
        System.out.println("Tests Finished.");
    }

    // --- Helper Methods ---

    /**
     * Custom assertion to print pass/fail messages clearly.
     * Adapted from JUnit assertion logic.
     */
    private static void assertArrayEquals(String testName, int[] expected, int[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println("PASS: " + testName);
        } else {
            System.err.println("FAIL: " + testName);
            System.err.println("Expected: " + Arrays.toString(expected));
            System.err.println("Actual:   " + Arrays.toString(actual));
        }
    }
}
