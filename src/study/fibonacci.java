package study;

public class fibonacci {
    static int [] F = new int[1000];

    public static void main(String[] args) throws Exception {
        System.out.println(fibo(4));
    }

    public static int fibo(int n) {
        if(F[n] == 0) {
            if(n == 1 || n == 2) {
                F[n] = 1;
                return F[n];
            }
            else {
                F[n] = fibo(n - 1) + fibo(n - 2);
                return F[n];
            }
        }
        else {
            return F[n];
        }
    }
}
