import java.util.Scanner;

public class Reversal {

    int count = 0;

    // Count reverse pairs and merge two sorted subarrays
    void merge(int arr[], int l, int m, int r) {
        // Count reverse pairs
        int j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && (long) arr[i] > 2L * arr[j]) {
                j++;
            }
            count += j - (m + 1);
        }

        // Merge step
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int i = 0; i < n2; ++i)
            R[i] = arr[m + 1 + i];

        int i = 0, k = l;
        j = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void printArray(int arr[]) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scn.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        Reversal ob = new Reversal();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: ");
        printArray(arr);

        System.out.println("Number of reverse pairs: " + ob.count);
    }
}
