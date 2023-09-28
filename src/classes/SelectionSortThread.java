package classes;

import java.util.Arrays;

public class SelectionSortThread extends Thread {
    int[] array;

    public SelectionSortThread(int[] array, String threadName){
        this.array = array;
        Thread thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Start -> " + Thread.currentThread().getName());
        System.out.println("Array for selection sort" + Arrays.toString(this.array));
        selectionSort(this.array);
        System.out.println("Array sorted by selection sort" + Arrays.toString(this.array));
        System.out.println("End -> " + Thread.currentThread().getName());
    }

    public void selectionSort(int[] array){
        for (int left = 0; left < array.length; left++) {
            int minIndex = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            ArrayService.swap(array, left, minIndex);
        }
    }
}