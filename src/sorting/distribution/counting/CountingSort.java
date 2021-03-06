package sorting.distribution.counting;



public class CountingSort {

    /**
     * Stable
     * runtime: O(n)
     */
    public static void countingSort(int[] arr, int maxVal) {

        // array to count
        int[] countOccur = new int[maxVal+ 1];

        // array to store sorted values
        int[] sortedArr = new int[arr.length];

        // count occurrence
        for (int i = 0; i < arr.length; i++) {
            countOccur[arr[i]]++;
        }

        // add counted occurrence
        for (int i = 1; i < countOccur.length; i++) {
            countOccur[i] += countOccur[i - 1];
        }

        // create a sorted array
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[--countOccur[arr[i]]] = arr[i];
        }

        System.arraycopy(sortedArr, 0, arr, 0, arr.length);
    }



    public static int[] countingSortWithValues(int[] keys, String[] values, int k) {

        int[] count = new int[k]; // count occurrence
        int[] sortedKeys = new int[keys.length]; // keys
        int[] valueIndex = new int[keys.length]; // value's index (optional)
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < keys.length; i++) {
            count[keys[i]]++;
        }

        for (int i = 1; i < k; i++) {
            count[i] += count[i - 1];
        }

        // to keep the order n-1, n-2, n-3 ... 1, 0
        for (int i = keys.length - 1; i >= 0; i--) {
            sortedKeys[--count[keys[i]]] = keys[i];
            valueIndex[count[keys[i]]] = i;
        }

        for (int i = 0; i < keys.length; i++) {
            if (valueIndex[i] < keys.length / 2)
                builder.append("- ");
            else
                builder.append(values[valueIndex[i]]).append(" ");
        }

        return sortedKeys;
    }


}
