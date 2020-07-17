package codeup;

import java.util.Scanner;

public class Problem_1014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char x, y;
        x = scanner.next().charAt(0);
        y = scanner.next().charAt(0);

        System.out.println(y + " " + x);

        scanner.close();
    }
}
