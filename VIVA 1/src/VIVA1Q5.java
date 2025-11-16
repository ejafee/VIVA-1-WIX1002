import java.util.Scanner;

public class VIVA1Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T;
        while (true) {
            System.out.println("Enter the number of words (1-100) : ");
            T = sc.nextInt();
            sc.nextLine();

            if (T >= 1 && T <= 100) {
                break;
            } else {
                System.out.println("Invalid number! Enter 1–100 only.");
            }
        }


        for (int i = 0; i < T; i++) {
            String word;
            while (true) {
                System.out.println("word " + (i + 1) + ":");
                word = sc.nextLine().toLowerCase();

                boolean valid = true;
                for (int k = 0; k < word.length(); k++) {
                    if (!Character.isLetter(word.charAt(k))) {
                        valid = false;
                        break;
                    }
                }

                if (valid) break;
                System.out.println("Please input words only!");
            }
            boolean isHarmony = true;

            // Rule 1: last letter cannot be a vowel
            char last = word.charAt(word.length()-1);
            if (last == 'a' || last == 'i' || last == 'u'|| last == 'e' || last == 'o') {
                isHarmony = false;
            }

            // Rule 2: No two vowels next to each other
            for (int j = 0; j < word.length() - 1; j++) {
                char c1 = word.charAt(j);
                char c2 = word.charAt(j + 1);

                boolean c1IsVowel = (c1 == 'a' || c1 == 'i' || c1 == 'u' || c1 == 'e' || c1 == 'o');
                boolean c2IsVowel = (c2 == 'a' || c2 == 'i' || c2 == 'u' || c2 == 'e' || c2 == 'o');

                if (c1IsVowel && c2IsVowel){
                    isHarmony = false;
                }
            }

            if (isHarmony) {
                System.out.println("Harmony");
            } else {
                System.out.println("Chaos");
            }
        }
    }
}