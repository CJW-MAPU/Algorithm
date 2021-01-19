package study;

public class quickSort {
    public static void main(String[] args) {
    int[] A = { 26, 14, 100, 95, 22, 17, 48, 20, 50, 90 };

    for (int i = 0; i < A.length; i++) {
        System.out.print(A[i] + "\t");
    }
    quickSort(A, 0, 9);
    System.out.println();
    System.out.println("================================");
    for (int i = 0; i < A.length; i++) {
        System.out.print(A[i] + "\t");
    }
}

    private static void quickSort(int[] arr, int idxL, int idxR) {
        if (idxL >= idxR) {
            return;
        }

        int pivot = arr[idxL];
        int i = idxL + 1;
        int j = idxR;

        while(true) {
            while (pivot > arr[i] && i < idxR) i++;
            while (pivot < arr[j] && j > idxL) j--;

            if (i >= j) {
                break;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


        int temp = arr[j];
        arr[j] = arr[idxL];
        arr[idxL] = temp;

        quickSort(arr, idxL, j - 1);
        quickSort(arr, j + 1, idxR);
    }
}
