package study;

public class HexToDec {
    public static void main(String[] args) {
        char[] H = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'F' };
        char[] T = { '1', 'A' };
        int D = 0;

        for (int i = 0; i < T.length; i++) {
//            D += Integer.parseInt(T[i] + "") * (int)Math.pow(16, T.length - 1 - i);
            try {
                D += Integer.parseInt(T[i] + "") * (int)Math.pow(16, T.length - 1 - i);
            } catch(NumberFormatException e) {
                for (int j = 0; j < H.length; j++) {
                    if(T[i] == H[j]) {
                        D += j * (int)Math.pow(16, T.length - 1 - i);
                    }
                }
            }
        }
        System.out.println(D);
    }
}
