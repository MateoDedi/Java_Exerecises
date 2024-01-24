import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class Counting_letters {

    public static void main(String[] args) {

        // Create a HashMap to store the word count
        HashMap<String, Integer> wordCount = new HashMap<>();
        // Create a HashMap to store the letter count
        HashMap<Character, Integer> letterCount = new HashMap<>();

        try {
            // Open the file
            File file = new File("C:\\Users\\mateo\\OneDrive\\Desktop\\mkn.txt");
            Scanner scanner = new Scanner(file);

            // Read the file word by word
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase(); // Read a word and convert it to lower case
                // If the word is already in the map, increment its count, otherwise add it to the map with a count of 1
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }

                // Increment the count of each letter in the word
                for (char letter : word.toCharArray()) {
                    letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Variables to keep track of the word with the highest count
        String mostUsedWord = "";
        int highestCount = 0;

        // Iterate over the word count map
        for (String word : wordCount.keySet()) {
            int count = wordCount.get(word);
            // If the current word's count is higher than the highest count, update the most used word and the highest count
            if (count > highestCount) {
                mostUsedWord = word;
                highestCount = count;
            }
        }

        // Variables to keep track of the letter with the highest count
        char mostUsedLetter = ' ';
        int highestLetterCount = 0;

        // Iterate over the letter count map
        for (char letter : letterCount.keySet()) {
            int count = letterCount.get(letter);
            // If the current letter's count is higher than the highest count, update the most used letter and the highest count
            if (count > highestLetterCount) {
                mostUsedLetter = letter;
                highestLetterCount = count;
            }
        }

        // Print the word count
        for (String word : wordCount.keySet()) {
            System.out.println("Word: " + word + ", Count: " + wordCount.get(word));
        }

        // Print the most used word and its count
        System.out.println("The most used word is '" + mostUsedWord + "' with a count of " + highestCount);

        // Print the most used letter and its count
        System.out.println("The most used letter is '" + mostUsedLetter + "' with a count of " + highestLetterCount);
    }
}