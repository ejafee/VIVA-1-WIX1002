import java.util.Scanner;
public class VIVA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int height;
        int queries;
        char style;

        while (true) {
            System.out.print("How many queries?(1-50): ");
            queries = input.nextInt();
            // Set boundaries for the queries
            if (queries > 50 || queries < 1) {
                System.out.println("Please enter a number between 1 and 50.");
            } else  {
                break;
            }
        }

        // Loop for each queries
        for (int t = 1; t <= queries; t++) {
            System.out.print("Enter the height (1-9) and style (A/P): ");
            height = input.nextInt();
            style = input.next().charAt(0);
            if (style == 'A' || style == 'a') {
                for (int i = 1; i <= height; i++) {
                    // Making the staircase
                    for  (int j = 0; j < i ; j++) {
                        System.out.print(i);
                    }
                    System.out.println();
                }
            } else if (style == 'P' || style == 'p') {
                for (int i = 1; i <= height; i++) {
                    // Print the spaces
                    for (int s = 0; s < height-i; s++) {
                        System.out.print(" ");
                    }
                    // Printing ascending numbers
                    for (int j = 1; j <= i; j++) {
                        System.out.print(j);
                    }
                    // Print descending numbers
                    for (int j = i-1; j >= 1; j--) {
                        System.out.print(j);
                    }
                    System.out.println();
                }
                // If Inputted neither A nor P
            } else  {
                System.out.println("Please input either A or P");
            }
            if (height > 9 || height < 1) {
                System.out.println("Please enter a height between 1 and 9.");
            }
        }
    }
}
