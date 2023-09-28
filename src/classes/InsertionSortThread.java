package classes;

import java.util.Arrays;

public class InsertionSortThread extends Thread{
    int[] array;
    public InsertionSortThread (int[] array, String threadName){
        this.array = array;
        Thread thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Start -> " + Thread.currentThread().getName());
        System.out.println("Array for insertion sort" + Arrays.toString(this.array));
        insertionSort(this.array);
        System.out.println("Array sorted by insertion sort" + Arrays.toString(this.array));
        System.out.println("End -> " + Thread.currentThread().getName());
    }

    public void insertionSort(int[] array){
        for (int left = 0; left < array.length; left++) {
            int number = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (number < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = number;
        }
    }
}