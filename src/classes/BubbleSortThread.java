package classes;

import interfaces.Swappable;

import java.util.Arrays;

public class BubbleSortThread extends Thread implements Swappable {
    int[] array;

    public BubbleSortThread(int[] array, String threadName){
        this.array = array;
        Thread thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Start -> " + Thread.currentThread().getName());
        System.out.println("Array for bubble sort: " + Arrays.toString(this.array));
        System.out.println("Array sorted by bubble sort: " + Arrays.toString(bubbleSort(this.array)));
        System.out.println("End -> " + Thread.currentThread().getName());
    }

    public int[] bubbleSort(int[] array){
        boolean needIteration = true;
        while (needIteration){
            needIteration = false;
            for (int i = 1; i < array.length; i++) {
                if(array[i] < array[i-1]){
                    swap(array, i, i - 1);
                    needIteration = true;
                }
            }
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