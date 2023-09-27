package classes;

import interfaces.Swappable;
import java.util.Arrays;

public class SelectionSortThread extends Thread implements Swappable {
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
        System.out.println("Array sorted by selection sort" + Arrays.toString(selectionSort(this.array)));
        System.out.println("End -> " + Thread.currentThread().getName());
    }

    public int[] selectionSort(int[] array){
        for (int left = 0; left < array.length; left++) {
            int minIndex = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            swap(array, left, minIndex);
        }
        return array;
    }

    @Override
    public void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}