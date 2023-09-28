package classes;

import java.util.Arrays;

public class ShuttleSortThread extends Thread{
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
        shuttleSort(this.array);
        System.out.println("Array sorted by shuttle sort" + Arrays.toString(this.array));
        System.out.println("End -> " + Thread.currentThread().getName());
    }

    public void shuttleSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                ArrayService.swap(array, i, i - 1);
                for (int j = i - 1; (j - 1) >= 0; j--) {
                    if (array[j] < array[j - 1]) {
                        ArrayService.swap(array, j, j - 1);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}