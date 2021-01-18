package dreamhack;

public class revbasic07 {
    public static void main(String[] args) {
        int a[] = {0x52, 0xdf, 0xb3, 0x60, 0xf1, 0x8b, 0x1c, 0xb5, 0x57, 0xd1, 0x9f, 0x38, 0x4b, 0x29, 0xd9, 0x26, 0x7f, 0xc9, 0xa3, 0xe9, 0x53, 0x18, 0x4f, 0xb8, 0x6a, 0xcb, 0x87, 0x58, 0x5b, 0x39};

        int bVar1;

        for (int i = 0; i < a.length; i++) {
            bVar1 = i & 7;
            a[i] = a[i] ^ i;


            char[] arr = bytesToBinaryString((byte) a[i]).toCharArray();

            for (int j = 0; j < bVar1; j++) {
                char s = arr[arr.length - 1];
                for (int k = arr.length - 1; k > 0; k--) {
                    arr[k] = arr[k - 1];
                    if(k == 1) {
                        arr[0] = s;
                    }
                }
            }
            int[] ary = new int[8];
            for (int j = 0; j < arr.length; j++) {
                ary[j] = Integer.parseInt(String.valueOf(arr[j]));
            }
            int D = 0;
            for (int j = 1; j < 8; j++) {
                D += ary[j] * Math.pow(2, (7 - j));
            }
            System.out.print((char)D);

        }
    }

    static String bytesToBinaryString(Byte b) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            builder.append(((0x80 >>> i) & b) == 0 ? '0' : '1');
        }
        return builder.toString();
    }
}
