package codeup;

import java.util.Scanner;

public class Problem_1055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a == 0 && b == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

        sc.close();
    }
}
