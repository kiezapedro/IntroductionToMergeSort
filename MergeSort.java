import java.util.Scanner;

public class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l...n]
    // Second subaray is arr[n+1...r]
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy remaining elemenets of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    // Main function that sorts arr[l...r] using merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // A utility function to print the array of size n
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        // Create a scanner to read input from the user
        Scanner scn = new Scanner(System.in);

        // Prompt the user to input the number of elements
        System.out.print("Enter the number of elements in the array: ");
        int n = scn.nextInt();

        // Create an array of size n
        int[] arr = new int[n];

        // Prompt the user to input the elements of the array
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt(); // Read each element
        }
        // Create an instance of MergeSort
        MergeSort ob = new MergeSort();

        // Call the sort method to sort the array
        ob.sort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println("Sorted array: ");
        printArray(arr);
    }

}