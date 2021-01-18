package study;

public class DecToHex {
    public static void main(String[] args) {
        char[] H = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'F' };
        char[] T = new char[20];

        int D = 20;
        int A, B;
        int i = 0;

        do {
            A = D / 16;
            B = D % 16;
            T[i] = H[B];
            i++;
            D = A;
        } while(A >= 16);
        T[i] = H[A];
        int K = i;

        do {
            System.out.print(T[K]);
            K--;
        } while(K >= 0);
    }
}
