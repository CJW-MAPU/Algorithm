package study;

import java.util.Scanner;

public class binarySearch {
    public static void main(String[] args) {
        int[] A = { 14, 17, 20, 22, 26, 48, 50, 90, 95, 100 };

        Scanner scanner = new Scanner(System.in);

        int L = 0;
        int R = A.length;

        int S = scanner.nextInt();

        int Result = BS(A, S, L, R);

        System.out.println("결과 : " + Result + "번 인덱스");
    }

    private static int BS(int[] A, int S, int L, int R) {
        if (L > R) {
            return -99;
        }

        int M = (L + R) / 2;

        if (S >A[M]) {
            return BS(A, S, M + 1, R);
        }
        else if (S < A[M]) {
            return BS(A, S, L, M - 1);
        }
        else {
            return M;
        }
    }
}
