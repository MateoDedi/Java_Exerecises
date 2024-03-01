package Getting_Unique_values;

import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

    public class CovidTradeEffects {
        // Define the main method
        public static void main(String[] args) {
            try {
                // Read the CSV file into a list of string arrays
                List<String[]> rows = readCsv("effects-of-covid-19-on-trade.csv");
                // For each column in the CSV file
                for (int i = 0; i < rows.get(0).length; i++) {
                    // Get the unique values in the column
                    Set<String> uniqueValues = getUniqueValues(rows, i);
                    // Print the unique values
                    System.out.println("Unique values for column " + (i + 1) + ": " + uniqueValues);
                }
            } catch (IOException e) {
                // Print an error message if there was a problem reading the CSV file
                System.out.println("Error reading CSV file: " + e.getMessage());
            }
        }

        // Define a method to read a CSV file into a list of string arrays
        private static List<String[]> readCsv(String filePath) throws IOException {
            // Create a BufferedReader to read the file
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
                // Return a list of string arrays, where each array represents a row in the CSV file
                return reader.lines()
                        .skip(1)  // Skip the header row
                        .map(line -> line.split(","))  // Split each line into an array of strings
                        .collect(Collectors.toList());  // Collect the arrays into a list
            }
        }

        // Define a method to get the unique values in a specific column
        private static Set<String> getUniqueValues(List<String[]> rows, int columnIndex) {
            // Return a set of unique values in the specified column
            return rows.stream()
                    .map(row -> row[columnIndex])  // Map each row to the value at the specified column index
                    .collect(Collectors.toSet());  // Collect the values into a set to remove duplicates
        }
    }