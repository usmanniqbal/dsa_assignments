/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        int[] array = { 8, 4, 13, 11, 10, 5, 9, 6, 8 };

        System.out.println("Original Array");
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " - " + array[i]);
        }
        quickSort(array, 0, array.length - 1);

        System.out.println("Quick Sorted Array");
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " - " + array[i]);
        }

        int[] array2 = { 8, 4, 13, 11, 10, 5, 9, 6, 8 };

        mergeSort(array2, 0, array2.length - 1);
        System.out.println("Merge Sorted Array");
        for (int i = 0; i < array2.length; i++) {
            System.out.println(i + " - " + array2[i]);
        }
    }

    private static void quickSort(int[] array, int startIndex, int endIndex) {
        int end = endIndex;
        int pivotIndex = startIndex;
        int pivot = array[pivotIndex];
        while (endIndex >= startIndex) {
            if (pivot >= array[startIndex]) {
                startIndex++;
            } else if (array[endIndex] > pivot) {
                endIndex--;
            } else if (array[startIndex] > array[endIndex]) {
                int temp = array[endIndex];
                array[endIndex] = array[startIndex];
                array[startIndex] = temp;
            }
        }

        array[pivotIndex] = array[endIndex];
        array[endIndex] = pivot;

        if (endIndex > pivotIndex) {
            quickSort(array, 0, endIndex - 1);
        }
        if (end > startIndex) {
            quickSort(array, startIndex, end);
        }
    }

    private static void mergeSort(int[] array, int startIndex, int endIndex) {
        if (endIndex > startIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            mergeSort(array, startIndex, midIndex);
            mergeSort(array, midIndex + 1, endIndex);
            merge(array, startIndex, midIndex, endIndex);
        }
    }

    private static void merge(int[] array, int startIndex, int midIndex, int endIndex) {
        int leftIndex = midIndex - startIndex + 1;
        int rightIndex = endIndex - midIndex;

        int leftArray[] = new int[leftIndex];
        int rightArray[] = new int[rightIndex];

        for (int i = 0; i < leftIndex; i++) {
            leftArray[i] = array[startIndex + i];
        }
        for (int i = 0; i < rightIndex; i++) {
            rightArray[i] = array[midIndex + 1 + i];
        }

        int i = 0; 
        int j = 0;

        int k = startIndex;
        while (i < leftIndex && j < rightIndex) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftIndex) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightIndex) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}