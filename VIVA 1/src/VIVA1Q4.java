import java.util.Scanner;

public class VIVA1Q4 {
    public static void main(String[] args) {
        // user input
        Scanner scanner = new Scanner(System.in);

        // declare variables *outside* the loop
        String word;
        int k;
        int wordLength;

        // inf loop for user input (handles error too)
        // the way it works it's like a "security check". if the input is accepted,
        while (true) {

            System.out.print("Enter a single word (no space!): ");
            word = scanner.nextLine();

            System.out.print("Enter the gem length (k): ");
            k = scanner.nextInt();

            //this code in the next line is to remove the "leftover" enter, common bug in java.
            scanner.nextLine();

            // get the length amount
            wordLength = word.length();

            // checking if the input is acceptable
            if (k > 0 && k <= wordLength) {
                break;

            } else {
                // if error the loop repeats
                System.out.println("\nError: Gem length (k) must be positive,and less than/equal to the word's length.");
                System.out.println("Please try again.\n");
            }
        }

        scanner.close();
        // ignoring uppercase (converts to lowercase)
        String lowerWord = word.toLowerCase();

        // setting up variables for the "gem finder"

        // get the very first gem (e.g., "sat")
        String firstGem = lowerWord.substring(0, k);

        // Set all our champions to this first gem
        String firstWhisper = firstGem;
        String coreValue = firstGem;
        String lastEcho = firstGem;

        // We need to calculate the score for the first gem ("sat")
        int maxScore = 0;
        for (int j = 0; j < firstGem.length(); j++) {
            maxScore = maxScore + firstGem.charAt(j);
        }

        // THE MAIN LOOP
        // This loop slides the "window" from the second gem onwards
        for (int i = 1; i <= wordLength - k; i++) {

            // Get the gem we are currently checking (e.g., "ata", "tay"...)
            String currentGem = lowerWord.substring(i, i + k);

            // --- Comparison 1: "First Whisper" (Smallest) ---
            if (currentGem.compareTo(firstWhisper) < 0) {
                firstWhisper = currentGem;
            }

            // --- Comparison 2: "Core Value" (Largest) ---
            if (currentGem.compareTo(coreValue) > 0) {
                coreValue = currentGem;
            }

            // --- Comparison 3: "Last Echo" (Heaviest) ---

            // This is the new part. We calculate the score right here.
            int currentScore = 0; // Reset score to 0 for each new gem

            // This is the NESTED LOOP. It loops through the letters
            // of *only* the currentGem (e.g., "a", "t", "a")
            for (int j = 0; j < currentGem.length(); j++) {
                currentScore = currentScore + currentGem.charAt(j);
            }

            // Now we compare the score we just found
            if (currentScore > maxScore) {
                maxScore = currentScore; // New high score
                lastEcho = currentGem;   // New heaviest gem
            }
        }

        // final output
        System.out.println("--- The 3 Winners ---");
        System.out.println(firstWhisper + " is the First Whisper");
        System.out.println(lastEcho + " is the Last Echo");
        System.out.println(coreValue + " is the Core Value");
    }
}