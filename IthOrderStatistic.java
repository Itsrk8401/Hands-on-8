public class IthOrderStatistic {
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private static int quickselect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pivotIndex = partition(arr, low, high);

            if (pivotIndex == k) {
                return arr[pivotIndex];
            } else if (pivotIndex < k) {
                return quickselect(arr, pivotIndex + 1, high, k);
            } else {
                return quickselect(arr, low, pivotIndex - 1, k);
            }
        }

        return -1; // Out of bounds or error
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int n = arr.length;
        int k = 3; // ith order statistic

        int result = quickselect(arr, 0, n - 1, k - 1);

        if (result != -1) {
            System.out.println("The " + k + "th order statistic is: " + result);
        } else {
            System.out.println("Invalid index or array size.");
        }
    }
}

Output : 

The 3th order statistic is: 5

