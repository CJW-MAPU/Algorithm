package study;

public class MinimumCostGraph {
    public static void main(String[] args) {
        int[] C = { 4, 2, 10, 7, 12, 15, 18, 20, 9, 13, 1 };            /* Height */
        int[] CYCLE = { 0, 0, 0, 0, 0, 1, 0 };                          /* 6번째 사이클 발생 */

        int N = 7;                                                      /* Node */
        int E = 11;                                                     /* Edge */

        for (int i = 0; i < C.length; i++) {
            System.out.format("%4d", C[i]);
        }

        for (int i = 0; i < E - 1; i++) {                               /* Selection Sort */
            for (int j = i + 1; j < E; j++) {
                if (C[i] > C[j]) {
                    int temp = C[i];
                    C[i] = C[j];
                    C[j] = temp;
                }
            }
        }

        System.out.println();
        for (int i = 0; i < C.length; i++) {
            System.out.format("%4d", C[i]);
        }

        int count = 1;
        int K = 0;
        int T = 0;

        while (count < N) {
            if (CYCLE[K] == 0) {
                T += C[K];
                count++;
            }
            K++;
        }
        System.out.println();
        System.out.println(T);
    }
}
