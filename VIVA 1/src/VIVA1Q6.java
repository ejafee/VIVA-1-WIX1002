import java.util.Scanner;

public class StutterDecompressor {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // INPUT: Read number of test cases
        int T = input.nextInt();
        input.nextLine(); // Consume the newline character after the integer
        
        // Process each log string
        for (int i = 0; i < T; i++) {
            String compressed = input.nextLine();
            
            // Call function to decompress the log
            String result = decompressLog(compressed);
            
            // OUTPUT: Print the result
            System.out.println(result);
        }
        
        input.close();
    }
    
    /**
     * Function to decompress a log string using Stutter Compression
     * 
     * Rules:
     * 1. Lowercase letters (a-z): append to decompressed string
     * 2. Digits (2-9): repeat the previous character (digit-1) additional times
     * 
     * Invalid conditions:
     * - Rule A: First character is a digit
     * - Rule B: A digit is preceded by another digit
     * - Rule C: Log contains '0' or '1'
     * 
     * @param compressed The compressed log string
     * @return Length of decompressed string if valid, or "Invalid Log" if invalid
     */
    public static String decompressLog(String compressed) {
        
        // Check if string is empty (edge case)
        if (compressed.length() == 0) {
            return "Invalid Log";
        }
        
        // ================================================
        // STEP 1: CHECK RULE A
        // The first character cannot be a digit
        // ================================================
        char firstChar = compressed.charAt(0);
        
        // Check if first character is a digit (0-9)
        if (firstChar >= '0' && firstChar <= '9') {
            return "Invalid Log";
        }
        
        // ================================================
        // STEP 2: CHECK RULE C
        // The log cannot contain '0' or '1'
        // ================================================
        for (int i = 0; i < compressed.length(); i++) {
            char c = compressed.charAt(i);
            
            // If we find '0' or '1', the log is invalid
            if (c == '0' || c == '1') {
                return "Invalid Log";
            }
        }
        
        // ================================================
        // STEP 3: PROCESS DECOMPRESSION
        // Go through each character and decompress
        // ================================================
        String decompressed = ""; // This will store the decompressed result
        
        for (int i = 0; i < compressed.length(); i++) {
            char currentChar = compressed.charAt(i);
            
            // -----------------------------------------
            // Case 1: Character is a lowercase letter
            // -----------------------------------------
            if (currentChar >= 'a' && currentChar <= 'z') {
                // Simply append the letter to the result
                decompressed = decompressed + currentChar;
            }
            
            // -----------------------------------------
            // Case 2: Character is a digit (2-9)
            // -----------------------------------------
            else if (currentChar >= '2' && currentChar <= '9') {
                
                // CHECK RULE B: Previous character cannot be a digit
                if (i > 0) {
                    char prevChar = compressed.charAt(i - 1);
                    
                    // If previous character is also a digit, it's invalid
                    if (prevChar >= '0' && prevChar <= '9') {
                        return "Invalid Log";
                    }
                    
                    // Convert character digit to integer
                    // Example: '4' - '0' = 4, '7' - '0' = 7
                    int digit = currentChar - '0';
                    
                    // Repeat the previous character (digit - 1) additional times
                    // For example: if digit is 4, repeat 3 more times
                    for (int j = 0; j < digit - 1; j++) {
                        decompressed = decompressed + prevChar;
                    }
                } else {
                    // This case shouldn't happen because of Rule A
                    // But included for safety
                    return "Invalid Log";
                }
            }
            
            // -----------------------------------------
            // Case 3: Invalid character
            // -----------------------------------------
            else {
                // Character is not a lowercase letter or valid digit
                return "Invalid Log";
            }
        }
        
        // ================================================
        // STEP 4: RETURN THE LENGTH
        // Calculate and return the length as a string
        // ================================================
        int length = decompressed.length();
        
        // Convert integer to string and return
        return String.valueOf(length);
    }
}
