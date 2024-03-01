package Measurements_trans_calculation;

import java.util.Scanner; // Import the Scanner class, which is used to get user input.


// Define a class called SurfaceCalculator.
public class SurfaceCalculator {
    // Define the main method, which is the entry point for the program.
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user.
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the length measurement.
        System.out.println("Enter length measurement:");
        // Read the length measurement from the user.
        String lengthInput = scanner.nextLine();

        // Prompt the user to enter the width measurement.
        System.out.println("Enter width measurement:");
        // Read the width measurement from the user.
        String widthInput = scanner.nextLine();

        // Try to parse the measurements and calculate the surface area.
        try {
            // Parse the length measurement.
            double length = parseMeasurement(lengthInput);
            // Parse the width measurement.
            double width = parseMeasurement(widthInput);

            // Calculate the surface area.
            double surfaceArea = length * width;
            // Print the surface area.
            System.out.printf("The surface area is %.2f square meters.\n", surfaceArea);
        } catch (IllegalArgumentException e) {
            // If an IllegalArgumentException is thrown, print the error message.
            System.out.println(e.getMessage());
        }
    }

    // Define a method that parses a measurement string and returns the measurement in meters.
    private static double parseMeasurement(String measurement) {
        // Remove leading and trailing whitespace from the measurement string.
        measurement = measurement.trim();

        // Get the MeasurementUnit for the unit of measurement in the string.
        MeasurementUnit unit = MeasurementUnit.getUnit(measurement);

        // If no MeasurementUnit was found, throw an IllegalArgumentException.
        if (unit == null) {
            throw new IllegalArgumentException("Invalid unit of measurement.");
        }

        double value;
        try {
            // Try to parse the numeric part of the measurement string.
            value = Double.parseDouble(measurement.substring(0, measurement.length() - unit.getUnit().length()));
        } catch (NumberFormatException e) {
            // If the numeric part of the measurement string is not a valid number, throw an IllegalArgumentException.
            throw new IllegalArgumentException("Invalid numeric value.");
        }

        // Convert the value to meters and return it.
        return unit.convertToMeters(value);
    }
}