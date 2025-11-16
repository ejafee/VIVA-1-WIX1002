import java.util.Scanner;

    public static void main(String[] args) {
        // --- 1. GET USER INPUT ---
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a single word (no space!): ");
        String word = scanner.nextLine();

        System.out.print("Please enter the gem length (k): ");
        int k = scanner.nextInt();
        scanner.close();

        // --- 2. SETUP ---
        String lowerWord = word.toLowerCase();
        int wordLength = lowerWord.length();

        // error handling if gem length more than the length of the word itself
        if (k > wordLength) {
            System.out.println("Error: Gem length (k) cannot be longer than the word.");
            return;
        }

        // --- 3. INITIALIZE "CHAMPION" VARIABLES ---

        // Get the very first gem (e.g., "sat")
        String firstGem = lowerWord.substring(0, k);

        // Set all our champions to this first gem
        String firstWhisper = firstGem; // Smallest
        String coreValue = firstGem;    // Largest
        String lastEcho = firstGem;     // Heaviest

        // We need to calculate the score for the first gem ("sat")
        int maxScore = 0;
        for (int j = 0; j < firstGem.length(); j++) {
            maxScore = maxScore + firstGem.charAt(j);
        }

        // --- 4. THE MAIN LOOP ---
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

        // --- 5. PRINT THE FINAL WINNERS ---
        System.out.println("--- The 3 Winners ---");
        System.out.println(firstWhisper + " is the First Whisper");
        System.out.println(lastEcho + " is the Last Echo");
        System.out.println(coreValue + " is the Core Value");
    }
}
