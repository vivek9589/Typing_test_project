import java.util.Scanner;
import java.util.Random;

public class TypingSpeedTest {
    // Sample sentences
    private static final String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a popular programming language.",
            "Typing speed can be improved with practice.",
            "A journey of a thousand miles begins with a single step.",
            "Always write clean and readable code."
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Pick a random sentence
        String testSentence = sentences[random.nextInt(sentences.length)];
        System.out.println("\nType the following sentence as fast and accurately as you can:");
        System.out.println("---------------------------------------------------------------");
        System.out.println(testSentence);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Press Enter when you're ready to start...");
        scanner.nextLine();

        // Start timing
        long startTime = System.currentTimeMillis();

        // Take user input
        System.out.println("Start typing:");
        String userInput = scanner.nextLine();

        // Stop timing
        long endTime = System.currentTimeMillis();

        // Calculate time taken in seconds
        double timeTaken = (endTime - startTime) / 1000.0;

        // Calculate Words Per Minute (WPM)
        int wordCount = userInput.trim().split("\\s+").length;
        double wpm = (wordCount / timeTaken) * 60;

        // Calculate accuracy
        int correctChars = 0;
        int minLength = Math.min(testSentence.length(), userInput.length());
        for (int i = 0; i < minLength; i++) {
            if (testSentence.charAt(i) == userInput.charAt(i)) {
                correctChars++;
            }
        }
        double accuracy = ((double) correctChars / testSentence.length()) * 100;

        // Show results
        System.out.printf("\nTime Taken: %.2f seconds\n", timeTaken);
        System.out.printf("Typing Speed: %.2f WPM\n", wpm);
        System.out.printf("Accuracy: %.2f%%\n", accuracy);
    }
}
