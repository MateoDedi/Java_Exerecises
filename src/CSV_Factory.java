import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class CSV_Factory {
    private static final String[] FIRST_NAMES = {
            "James", "John", "Robert", "Michael", "William",
            "David", "Richard", "Joseph", "Thomas", "Charles",
            "Christopher", "Daniel", "Matthew", "Anthony", "Donald",
            "Mark", "Paul", "Steven", "Andrew", "Kenneth",
            "Joshua", "George", "Kevin", "Brian", "Edward",
            "Ronald", "Timothy", "Jason", "Jeffrey", "Ryan"};
    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Williams", "Brown", "Jones",
            "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson",
            "Thomas", "Taylor", "Moore", "Jackson", "Martin",
            "Lee", "Perez", "Thompson", "White", "Harris",
            "Sanchez", "Clark", "Ramirez", "Lewis", "Robinson",
            "Walker", "Young", "Allen", "King", "Wright",
            "Scott", "Torres", "Nguyen", "Hill", "Flores"};
    private static final String[] REASONS = {"Appointment", "Visit"};
    private static final String[] DEPARTMENTS = {"Cardiology", "Radiology", "Pediatrics", "Geriatrics", "Pulmonology"};
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("output.csv")) {
            writer.append("First Name,Last Name,Reason,Department,Date of Visit\n");
            for (int i = 0; i < 100; i++) {
                String firstName = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
                String lastName = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
                String reason = REASONS[RANDOM.nextInt(REASONS.length)];
                String department = reason.equals("Appointment") ? DEPARTMENTS[RANDOM.nextInt(DEPARTMENTS.length)] : "";
                LocalDate dateOfVisit = LocalDate.of(LocalDate.now().getYear(), RANDOM.nextInt(12) + 1, RANDOM.nextInt(28) + 1);
                writer.append(String.format("%s,%s,%s,%s,%s\n", firstName, lastName, reason, department, dateOfVisit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
