package classes;

import interfaces.Swappable;
import java.util.Arrays;

public class ShuttleSortThread extends Thread implements Swappable {
    int[] array;
    public ShuttleSortThread (int[] array, String threadName){
        this.array = array;
        Thread thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Start -> " + Thread.currentThread().getName());
        System.out.println("Array for shuttle sort" + Arrays.toString(this.array));
        System.out.println("Array sorted by shuttle sort" + Arrays.toString(shuttleSort(this.array)));
        System.out.println("End -> " + Thread.currentThread().getName());
    }

    public int[] shuttleSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
                for (int j = i - 1; (j - 1) >= 0; j--) {
                    if (array[j] < array[j - 1]) {
                        swap(array, j, j - 1);
                    } else {
                        break;
                    }
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