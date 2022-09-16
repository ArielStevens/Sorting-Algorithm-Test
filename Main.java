import java.util.Random;

public class Main {
    public static void main(String[] args) {
        long startTime;
        long endTime;
        float duration;

        //creating six arrays to hold the different amounts of numbers to be tested
        int[] list1 = new int[10000];
        int[] list2 = new int[50000];
        int[] list3 = new int[100000];
        int[] list4 = new int[500000];
        int[] list5 = new int[1000000];
        int[] list6 = new int[5000000];

        //call method to populate arrays with random numbers
        populateArray(list1, list1.length);
        populateArray(list2, list2.length);
        populateArray(list3, list3.length);
        populateArray(list4, list4.length);
        populateArray(list5, list5.length);
        populateArray(list6, list6.length);

        //TODO - get the execution time in seconds (logarithmic base 10)
        //execution times for bubble sort
        startTime = System.nanoTime();
        SortingAlgo.insertionSort(list1);
        endTime = System.nanoTime();

        duration = ((endTime - startTime) / 1000000000F);  //divide by 1000000000 to get seconds.
        System.out.printf("The time in seconds (logarithmic base 10) for bubble sort with data set size 10000 is: %.9f", duration);
        System.out.println();


        /*execution times for insertion sort

        startTime = System.nanoTime();
        SortingAlgo.insertionSort(list1);
        endTime = System.nanoTime();

        duration = ((endTime - startTime) / 1000000000F);  //divide by 1000000000 to get seconds.
        System.out.printf("The time in seconds (logarithmic base 10) for insertion sort with data set size 10000 is: %.9f", duration);
        System.out.println();
        */
    }

    public static int[] populateArray(int[] array, int num){
        Random rand = new Random();
        int number = num;
        int[] populatedArray = array;
        for (int i = 0; i < number; i++){
            populatedArray[i] = rand.nextInt(5000);;
        }
        return populatedArray;

    }
}
