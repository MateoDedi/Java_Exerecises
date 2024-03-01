package Measurements_trans_calculation;

// Define an enumeration called MeasurementUnit
public enum MeasurementUnit {
    // Define three constants for the enumeration, each representing a unit of measurement.
    // Each constant is associated with a string (the unit of measurement) and a double (the conversion factor to meters).
    MILLIMETERS("mm", 0.001),
    CENTIMETERS("cm", 0.01),
    METERS("m", 1);

    // Declare fields for the unit of measurement and the conversion factor.
    private final String unit;
    private final double conversionFactor;

    // Constructor for the enumeration. This is called when any of the constants are created.
    MeasurementUnit(String unit, double conversionFactor) {
        this.unit = unit;
        this.conversionFactor = conversionFactor;
    }

    // Getter method for the unit field.
    public String getUnit() {
        return unit;
    }

    // Static method that takes a measurement string and returns the corresponding MeasurementUnit constant.
    // If the measurement string ends with the unit of a MeasurementUnit constant, that constant is returned.
    // If no match is found, null is returned.
    public static MeasurementUnit getUnit(String measurement) {
        for (MeasurementUnit unit : values()) {
            if (measurement.endsWith(unit.getUnit())) {
                return unit;
            }
        }
        return null;
    }

    // Method that converts a value to meters based on the conversion factor.
    public double convertToMeters(double value) {
        return value * conversionFactor;
    }
}