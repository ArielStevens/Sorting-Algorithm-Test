public class SortingAlgo {
    public static void insertionSort(int[] list){
        for(int i = 1; i < list.length; i++){
            int current = list[i];
            int j;
            for(j = i-1; j >=0 && list[j]> current; j--){
                list[j+1] = list[j];
            }
            list[j+1] = current;
        }
    }
    public static void bubbleSort(int[] list){
        boolean nextpassflag = true;
        for(int j = 1; j< list.length && nextpassflag; j++){
            nextpassflag = false;
            for(int i = 0; i < list.length-j; i++){
                if(list[i] > list[i+1]){
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    nextpassflag = true;
                }
            }
        }
    }
    /** The method for sorting the numbers */
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);
            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }
    /** Merge two sorted lists */
    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }
        while (current1 < list1.length)
            temp[current3++] = list1[current1++];
        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }
    public static void main(String args[]){
        int[] list = {3,6,7,9,2,5,8};
        //insertionSort(list);
        //bubbleSort(list);
        mergeSort(list);
        for(int i = 0; i<list.length;i++){
            System.out.print(list[i] + " ");
        }
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }
    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    /** Partition the array list[first..last] */
    private static int partition(int[] list, int first, int last) {
        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search
        while (high > low) {
            // Search forward from left
            while (low <= high && list[low] <= pivot)
                low++;
            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;
            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while (high > first && list[high] >= pivot)
            high--;
        // Swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }
}
