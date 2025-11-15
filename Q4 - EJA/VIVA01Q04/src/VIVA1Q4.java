import java.util.Scanner;

public class VIVA1Q4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt for and read the word
        System.out.print("Please enter a word: ");
        String word = scanner.nextLine();

        // Prompt for and read the number
        System.out.print("Please enter the gem length (k): ");
        int k = scanner.nextInt();

        scanner.close();

        String lowerWord = word.toLowerCase();
        int wordLength = lowerWord.length();

        // Check if k is valid (not longer than the word)
        if (k > wordLength) {
            System.out.println("Error: Gem length (k) cannot be longer than the word.");
            return; // Stop the program
        }

        String firstGem = lowerWord.substring(0, k);

        // "First Whisper" (Smallest)
        String firstWhisper = firstGem;

        // "Last Echo" (Heaviest / Highest ASCII)
        String lastEcho = firstGem;
        int maxScore = calculateScore(firstGem);

        // "Core Value" (Largest)
        String coreValue = firstGem;


        // main loop
        for (int i = 1; i <= wordLength - k; i++) {

            String currentGem = lowerWord.substring(i, i + k);

            // comparison

            // Check for "First Whisper" (smallest)
            if (currentGem.compareTo(firstWhisper) < 0) {
                firstWhisper = currentGem;
            }

            // Check for "Core Value" (largest)
            if (currentGem.compareTo(coreValue) > 0) {
                coreValue = currentGem;
            }

            // Check for "Last Echo" (heaviest)
            int currentScore = calculateScore(currentGem);
            if (currentScore > maxScore) {
                maxScore = currentScore;
                lastEcho = currentGem;
            }
        }

        //

        System.out.println("The gems are: ");

        System.out.println(firstWhisper);

        System.out.println(lastEcho);

        System.out.println(coreValue);
    }

    /**
     * A helper method to calculate the "Core Value" (ASCII sum) of a string.
     */
    public static int calculateScore(String s) {
        int totalScore = 0;
        for (int i = 0; i < s.length(); i++) {
            totalScore = totalScore + s.charAt(i);
        }
        return totalScore;
    }
}
