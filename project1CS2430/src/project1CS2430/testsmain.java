package project1CS2430;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Integration test for Main.java.
 * * Verifies that the driver:
 * 1. Runs without crashing.
 * 2. Generates the required output file safely (even for large n=8 datasets).
 * 3. Formats the data correctly (checking for "Using: [SortName]").
 * * Reference: File I/O testing patterns adapted from Baeldung.
 * Ref: https://www.baeldung.com/java-testing-file-io
 * * @author Project 1 Team
 */
public class MainTest {

    public static void main(String[] args) {
        System.out.println("Starting Main Integration Test...\n");
        
        // Warning to the user since Main.java has dataLength = 8
        System.out.println(">>> IMPORTANT: dataLength is currently set to 8 in Main.java! <<<");
        System.out.println(">>> This will generate ~40,000 permutations and take a while to finish. <<<");
        System.out.println(">>> Consider temporarily changing dataLength to 4 in Main.java for faster testing. <<<\n");

        Path reportPath = Paths.get("project_1_data.txt");
        
        // 1. PRE-CHECK: Clean up old file
        try {
            Files.deleteIfExists(reportPath);
            System.out.println("Cleaned up old 'project_1_data.txt' for fresh test.");
        } catch (IOException e) {
            System.err.println("Warning: Could not delete old file.");
        }

        // 2. EXECUTE: Run Main
        System.out.println("Calling Main.main()... (Please wait)");
        long startTime = System.currentTimeMillis();
        
        try {
            // This runs the exact logic inside your Main.java file
            Main.main(new String[]{}); 
        } catch (Exception e) {
            System.err.println("CRITICAL FAIL: Main.main() crashed.");
            e.printStackTrace();
            return;
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Main finished in " + (endTime - startTime) + "ms.");

        // 3. VERIFY: Check file creation
        File reportFile = reportPath.toFile();
        if (reportFile.exists() && reportFile.length() > 0) {
            System.out.println("PASS: Report file created. Size: " + (reportFile.length() / 1024) + " KB");
            
            // 4. CHECK CONTENTS
            // We use BufferedReader here because n=8 generates a massive file.
            // Using Files.readAllLines() would cause a memory crash.
            boolean hasQuick = false;
            boolean hasShaker = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(reportFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("Using: Quick Sort")) hasQuick = true;
                    if (line.contains("Using: Shaker Sort")) hasShaker = true;
                    
                    // Optimization: Stop reading early if we found both!
                    if (hasQuick && hasShaker) {
                        break; 
                    }
                }
                
                if (hasQuick) System.out.println("PASS: Output contains Quick Sort data.");
                else System.err.println("FAIL: Quick Sort data missing from file.");

                if (hasShaker) System.out.println("PASS: Output contains Shaker Sort data.");
                else System.err.println("FAIL: Shaker Sort data missing from file.");
                
            } catch (IOException e) {
                System.err.println("FAIL: Could not read report file: " + e.getMessage());
            }

        } else {
            System.err.println("FAIL: Report file not created or empty.");
        }
        
        System.out.println("\nMain Integration Test Complete.");
    }
}
