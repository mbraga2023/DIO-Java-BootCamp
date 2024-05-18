import java.util.Scanner;

public class HalfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for the pyramid: ");
        int rows = scanner.nextInt();

        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            // Print hash symbols
            for (int k = 1; k <= i; k++) {
                System.out.print("#");
            }

            System.out.println(); // Move to the next line
        }
        scanner.close();
    }
}
