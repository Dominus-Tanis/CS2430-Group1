package project1CS2430;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// REMOVED: import com.sun.tools.javac.Main; (This was the error)

public class MainTest {

    public static void main(String[] args) {
        System.out.println("Starting Main Integration Test...\n");
        
        Path reportPath = Paths.get("project_1_data.txt");
        
        try {
            Files.deleteIfExists(reportPath);
            System.out.println("Cleaned up old 'project_1_data.txt'.");
        } catch (IOException e) { System.err.println("Warning: Could not delete old file."); }

        System.out.println("Calling Main.main()... (This may take a moment for n=8)");
        
        try {
            Main.main(new String[]{}); // Calls YOUR Main class
        } catch (Exception e) {
            System.err.println("CRITICAL FAIL: Main.main() crashed.");
            e.printStackTrace();
            return;
        }
        
        File reportFile = reportPath.toFile();
        if (reportFile.exists() && reportFile.length() > 0) {
            System.out.println("PASS: Report file created.");
        } else {
            System.err.println("FAIL: Report file not created or empty.");
        }
    }
}