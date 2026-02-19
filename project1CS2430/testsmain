package project1CS2430;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Integration test for Main.java.
 * * Verifies that the driver:
 * 1. Runs without crashing.
 * 2. Generates the required output file.
 * 3. Formats the data correctly (checking for "Using: [SortName]").
 * * Reference: File I/O testing patterns adapted from Baeldung.
 * Ref: https://www.baeldung.com/java-testing-file-io
 * * @author Project 1 Team
 */
public class MainTest {

    public static void main(String[] args) {
        System.out.println("Starting Main Integration Test...\n");

        Path reportPath = Paths.get("project_1_data.txt");
        
        // 1. PRE-CHECK: Clean up old file
        try {
            Files.deleteIfExists(reportPath);
            System.out.println("Cleaned up old 'project_1_data.txt' for fresh test.");
        } catch (IOException e) {
            System.err.println("Warning: Could not delete old file.");
        }

        // 2. EXECUTE: Run Main
        System.out.println("Calling Main.main()... (This may take a moment for n=8)");
        long startTime = System.currentTimeMillis();
        
        // Note: This requires ArrayGenerator to be present in the package
        try {
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
            System.out.println("PASS: Report file created.");
            
            // 4. CHECK CONTENTS
            try {
                List<String> lines = Files.readAllLines(reportPath);
                boolean hasQuick = false;
                boolean hasShaker = false;
                
                for (String line : lines) {
                    if (line.contains("Using: Quick Sort")) hasQuick = true;
                    if (line.contains("Using: Shaker Sort")) hasShaker = true;
                }
                
                if (hasQuick) System.out.println("PASS: Output contains Quick Sort data.");
                else System.err.println("FAIL: Quick Sort data missing from file.");

                if (hasShaker) System.out.println("PASS: Output contains Shaker Sort data.");
                else System.err.println("FAIL: Shaker Sort data missing from file.");
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("FAIL: Report file not created or empty.");
        }
    }
}
