package lecture2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class add_2022572022 {
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        array = new int[N];

        IntStream.range(0, N).forEach(i -> array[i] = i + 1);

        System.out.println(Arrays.toString(array));
        int left = 0;
        int right = array.length - 1;
        int result = divideSum(left, right);

        System.out.println(result);
    }

    public static int divideSum(int left, int right) {
        if (left == right) {
            return array[left];
        }

        int mid = (left + right) / 2;
        int leftSum = divideSum(left, mid);
        int rightSum = divideSum(mid + 1, right);

        return leftSum + rightSum;
    }
}
