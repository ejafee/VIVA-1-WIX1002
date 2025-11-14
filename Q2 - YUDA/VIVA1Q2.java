import java.util.Scanner;

public class VIVA1Q2 {
    public static void main(String[] args) {
        // Displaying the input's format to the user
        System.out.println("=============Format of Input=============");
        System.out.println("Number of queries is a single digit (1-200)");
        System.out.println("Digits & lucky number (Digits \" \" Lucky number). \nLucky number is single digit (0-9) \nExample: 813278 7");
        System.out.println("Digits = 813278 \nLucky number = 7");
        System.out.println("=========================================");

        // Taking queries input to determine the number of digits and array size
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the number of queries (1-200): ");
        int queries = input.nextInt();
        String[] results = new String[queries];

        // Initialize loop to process each query
        for (int i = 0; i < queries; i++) {

            // Taking digits and lucky number input
            System.out.print("Enter the digits & lucky number to analyze: ");
            String number = input.next();
            int luckyDigit= input.nextInt();

            // Initializing variables to count occurrences
            int luckyCount = 0;
            int evenCount = 0;
            int oddCount = 0;   
            int zeroCount = 0;

            // Looping through each digit in the number string
            for (int j = 0; j < number.length() ; j++) {
                int digit = Character.getNumericValue(number.charAt(j));

                // Counting occurrences based on digit type
                if (digit == luckyDigit) {
                    luckyCount++;
                } else if (digit == 0) {
                    zeroCount++;
                } else if (digit % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }

            // Determining the result based on the counts of the occurrences and store it in results array
            if (luckyCount > zeroCount && luckyCount > evenCount && luckyCount > oddCount) {
                results[i] = "LUCKY";
            } else if (evenCount > luckyCount && evenCount > zeroCount && evenCount > oddCount) {
                results[i] = "BALANCED";
            } else if (oddCount > luckyCount && oddCount > zeroCount && oddCount > evenCount) {
                results[i] = "ENERGETIC";
            } else {
                results[i] = "NEUTRAL";
            }

        }
        // Display the results for all queries according to the list in the results array
        System.out.println("\n=========Results=========");
        for (int i = 0; i < queries; i++) {
            System.out.println(results[i]);
        }
        input.close();
    }
}