package programmers;

import java.util.Arrays;

public class NumberGame {
    public static void main(String[] args) {
        int[] A = {
                5, 1, 3, 7
//                2, 2, 2, 2
        };
        int[] B = {
                2, 2, 6, 8
//                1, 1, 1, 1
        };

        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int count = 0;

        for (int i = A.length -1, j = B.length - 1; i >= 0 ; i--) {
            if (A[i] < B[j]) {
                count++;
                j--;
            }
        }

        return count;
    }
}
