package study;

public class CollectionSort {
    public static void main(String[] args) {
        int[] array = { 5, 3, 2, 7, 1, 0, 4, 8, 9, 6 };

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
