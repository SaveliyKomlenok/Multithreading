package classes;

import java.util.Arrays;

public class ShellSortThread extends Thread{
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
        shellSort(this.array);
        System.out.println("Array sorted by shell sort" + Arrays.toString(this.array));
        System.out.println("End -> " + Thread.currentThread().getName());
    }

    public void shellSort(int[] array){
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int right = 0; right < array.length; right++) {
                for (int i = right - gap; i >= 0; i -= gap) {
                    if (array[i] > array[i + gap]) ArrayService.swap(array, i, i + gap);
                }
            }
            gap = gap / 2;
        }
    }
}