import java.util.Scanner;

public class VIVA1Q2 {
    public static void main(String[] args) {
        // Displaying the input's format to the user
        System.out.println("=============Format of Input==============");
        System.out.println("Number of queries is a single digit (1-200)");
        System.out.println("Lucky number is single digit (0-9)");
        System.out.println("==========================================");

        // Taking queries input to determine the number of digits and array size
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the number of queries (1-200): ");
        
        int queries = -1; //declare it to -1 because the number of queries must be at least 1 so -1 would be invalid
        boolean validInput = false;
        
        while (!validInput) {
            try {
                queries = input.nextInt();
                if (queries < 1 || queries > 200) {
                    System.out.println("Please enter a single digit between 1 and 200.");
                    System.out.print("Enter the number of queries (1-200): ");
                } else {
                    validInput = true;
                }
            } catch (java.util.InputMismatchException e) {
                input.next(); // Clear the invalid input
                System.out.println("Please enter a valid integer for the number of queries.");
                System.out.print("Enter the number of queries (1-200): ");
            }
        }
        String[] results = new String[queries]; //

        // Initialize loop to process each query
        for (int i = 0; i < queries; i++) {

            // Taking digits and lucky number input
            System.out.print("Enter the digits: ");
            String number = input.next();
            System.out.print("Enter the lucky number: ");
            int luckyDigit= input.nextInt();

            if (luckyDigit < 0 || luckyDigit > 9) {
                System.out.println("Please enter a single digit between 0 and 9 for the lucky number.");
                i--; // Decrement i to repeat this iteration
                continue;
            }

            String luckyDigitString = Integer.toString(luckyDigit);

            if (luckyDigitString.length() != 1) {
                System.out.println("Please enter a single digit between 0 and 9 for the lucky number.");
                i--; // Decrement i to repeat this iteration
                continue;
            }
           
            // Initializing variables to count occurrences
            int luckyCount = 0;
            int evenCount = 0;
            int oddCount = 0;   
            int zeroCount = 0;

            // Looping through each digit in the number string 12345 5
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
                    oddCount++ ;
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