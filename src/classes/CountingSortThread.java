package classes;

import java.util.Arrays;

public class CountingSortThread extends Thread{
    int[] array;
    public CountingSortThread (int[] array, String threadName){
        this.array = array;
        Thread thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Start -> " + Thread.currentThread().getName());
        System.out.println("Array for counting sort" + Arrays.toString(this.array));
        System.out.println("Array sorted by counting sort" + Arrays.toString(countingSort(this.array, maxNumberOfArray(this.array))));
        System.out.println("End -> " + Thread.currentThread().getName());
    }

    public int maxNumberOfArray(int[] array){
        int maxValue = Integer.MIN_VALUE;
        for (int number: array) {
            if(number > maxValue){
                maxValue = number;
            }
        }
        return maxValue;
    }

    public int[] countingSort(int[] array, int maxValue){
        int[] numberCounts = new int[maxValue + 1];
        for (int num : array) {
            numberCounts[num]++;
        }

        int[] sortedArray = new int[array.length];
        int currentSortedIndex = 0;

        for (int n = 0; n < numberCounts.length; n++) {
            int count = numberCounts[n];
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }
}