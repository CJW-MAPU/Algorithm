package study;

public class CountingSort {
    public static void main(String[] args) {
        int[] array = { 7, 2, 3, 5, 7, 1, 4, 6, 7, 5, 0, 1 };
        int[] counting = new int[8];
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            counting[temp]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        for (int i = array.length - 1; i >= 0 ; i--) {
            result[--counting[array[i]]] = array[i];
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
