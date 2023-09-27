package classes;

import interfaces.Swappable;

import java.util.Arrays;

public class ShellSortThread extends Thread implements Swappable {
    int[] array;
    public ShellSortThread (int[] array, String threadName){
        this.array = array;
        Thread thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Start -> " + Thread.currentThread().getName());
        System.out.println("Array for shell sort" + Arrays.toString(this.array));
        System.out.println("Array sorted by shell sort" + Arrays.toString(shellSort(this.array)));
        System.out.println("End -> " + Thread.currentThread().getName());
    }

    public int[] shellSort(int[] array){
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int right = 0; right < array.length; right++) {
                for (int i = right - gap; i >= 0; i -= gap) {
                    if (array[i] > array[i + gap]) {
                        swap(array, i, i + gap);
                    }
                }
            }
            gap = gap / 2;
        }
        return array;
    }
    @Override
    public void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}