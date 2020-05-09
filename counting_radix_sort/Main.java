
public class Main {
    public static void main(String[] args) {
        int[] countSortArray = countingSort(new int[] { 10, 3, 6, 2, 1, 7, 3, 2 }, null, null, null);

        System.out.println("Counting sort values");
        for (int i = 0; i < countSortArray.length; i++) {
            System.out.println(countSortArray[i]);
        }

        int[] radixSortArray = radixSort(new int[] { 10, 25, 2, 300, 855, 8, 89 });

        System.out.println("Radix sort values");
        for (int i = 0; i < radixSortArray.length; i++) {
            System.out.println(radixSortArray[i]);
        }
    }

    private static int[] countingSort(int[] array, Integer count, Integer maxValue, Integer position) {
        count = count == null ? array.length : count;

        if (maxValue == null) {
            maxValue = 0;
            // Find maximum value in given array
            for (int i = 0; i < array.length; i++) {
                if (maxValue < array[i]) {
                    maxValue = array[i];
                }
            }
        }

        // Declare an array with the size of max value iterated in last loop + 1
        int[] countingArray = new int[maxValue + 1];

        // Put no of occurrences in to of each element in array to countingArray
        for (int i = 0; i < array.length; i++) {
            int arrayValue = array[i];
            if (position != null) {
                arrayValue /= position;
                arrayValue %= 10;
            }

            countingArray[arrayValue]++;
        }

        // Calculate cumulative sum.
        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i] + countingArray[i - 1];
        }

        int[] result = new int[count];
        // Prepare result
        for (int i = array.length - 1; i >= 0; i--) {
            int arrayValue = array[i];
            if (position != null) {
                arrayValue /= position;
                arrayValue %= 10;
            }
            result[--countingArray[arrayValue]] = array[i];
        }

        return result;
    }

    private static int[] radixSort(int[] array) {
        int count = array.length;
        int maxValue = 0;

        // Find maximum value in given array
        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }


        int[] result = array;
        for (int p = 1; maxValue / p > 0; p *= 10) {
            result = countingSort(result, count, 9, p);
        }
        return result;
    }
}
