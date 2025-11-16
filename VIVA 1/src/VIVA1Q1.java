import java.util.Scanner;

public class VIVA1Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the number of queries (1-500): ");

        int queries = -1;
        boolean validInput = false;

        // Validasi jumlah queries
        while (!validInput) {
            try {
                queries = input.nextInt();
                if (queries < 1 || queries > 500) {
                    System.out.println("Please enter a number between 1 and 500.");
                    System.out.print("Enter the number of queries (1-500): ");
                } else {
                    validInput = true;
                }
            } catch (java.util.InputMismatchException e) {
                input.next(); // Clear the invalid input
                System.out.println("Please enter a valid integer for the number of queries.");
                System.out.print("Enter the number of queries (1-500): ");
            }
        }

        // Array untuk menyimpan input
        int[] initialValues = new int[queries];
        int[] multiplierSeeds = new int[queries];
        int[] charmLengths = new int[queries];

        // Proses SEMUA input terlebih dahulu
        for (int i = 0; i < queries; i++) {
            System.out.println("\n--- Query " + (i + 1) + " ---");
            
            // Input initial value dengan validasi
            boolean valid = false;
            while (!valid) {
                System.out.print("Enter the initial value (1-50): ");
                try {
                    initialValues[i] = input.nextInt();
                    if (initialValues[i] < 1 || initialValues[i] > 50) {
                        System.out.println("Please enter a number between 1 and 50.");
                    } else {
                        valid = true;
                    }
                } catch (java.util.InputMismatchException e) {
                    input.next();
                    System.out.println("Please enter a valid integer.");
                }
            }

            // Input multiplier seed dengan validasi
            valid = false;
            while (!valid) {
                System.out.print("Enter the multiplier seed (1-50): ");
                try {
                    multiplierSeeds[i] = input.nextInt();
                    if (multiplierSeeds[i] < 1 || multiplierSeeds[i] > 50) {
                        System.out.println("Please enter a number between 1 and 50.");
                    } else {
                        valid = true;
                    }
                } catch (java.util.InputMismatchException e) {
                    input.next();
                    System.out.println("Please enter a valid integer.");
                }
            }

            // Input charm length dengan validasi
            valid = false;
            while (!valid) {
                System.out.print("Enter the charm length (1-15): ");
                try {
                    charmLengths[i] = input.nextInt();
                    if (charmLengths[i] < 1 || charmLengths[i] > 15) {
                        System.out.println("Please enter a number between 1 and 15.");
                    } else {
                        valid = true;
                    }
                } catch (java.util.InputMismatchException e) {
                    input.next();
                    System.out.println("Please enter a valid integer.");
                }
            }
        }

        // Array 2D untuk menyimpan hasil setiap query
        int[][] results = new int[queries][];

        // Proses semua hasil setelah semua input dikumpulkan
        for (int i = 0; i < queries; i++) {
            results[i] = new int[charmLengths[i]];
            
            for (int j = 0; j < charmLengths[i]; j++) {
                // Formula: initialValue + (multiplierSeed * 2^j)
                int charmFormula = initialValues[i] + (multiplierSeeds[i] * (int)Math.pow(2, j));
                results[i][j] = charmFormula;
            }
        }

        input.close();

        // Tampilkan hasil
        System.out.println("\n========== Results ==========");
        for (int i = 0; i < queries; i++) {
            System.out.print("Query " + (i + 1) + ": ");
            for (int j = 0; j < results[i].length; j++) {
                System.out.print(results[i][j]);
                if (j < results[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

// Pertama kita bakal ngebuat loop formulanya mengulang sebanyak charmLength dan hasilnya akan di print dalam 1 baris
// Setiap 1 baris itu akan di simpan dalam array results[] yang nanti di print di luar loop utama setelah semua query selesai diproses
