package study;

public class mergeSort {
    public static void main(String[] args) {
        int[] A = { 2, 5, 10, 17, 20 };
        int[] B = { 11, 9, 8, 7 };

        int M = A.length;
        int N = B.length;

        int[] C = new int[M + N];
        int iA = 0, iB = N - 1, iC = 0;
        int Done = 0;

        while(true) {
            if(A[iA] < B[iB]) {
                C[iC] = A[iA];
                iA++;
                iC++;
                if(iA > M - 1) {
                    if (Done == 0) {
                        A[M - 1] = 999999;
                        iA = M - 1;
                        Done = 1;
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                C[iC] = B[iB];
                iB--;
                iC++;
                if(iB < 0) {
                    if (Done == 0) {
                        B[0] = 999999;
                        iB = 0;
                        Done = 1;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < C.length; i++) {
            System.out.print(C[i] + "\t");
        }
    }
}
