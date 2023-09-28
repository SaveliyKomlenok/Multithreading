package classes;

import java.util.Arrays;

public class QuickSortThread extends Thread {
    int[] array;
    public QuickSortThread (int[] array, String threadName){
        this.array = array;
        Thread thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Start -> " + Thread.currentThread().getName());
        System.out.println("Array for quick sort" + Arrays.toString(this.array));
        quickSort(this.array, 0, array.length - 1);
        System.out.println("Array sorted by quick sort" + Arrays.toString(this.array));
        System.out.println("End -> " + Thread.currentThread().getName());
    }

    public void quickSort(int[] array, int left, int right){
        int leftMarker = left;
        int rightMarker = right;
        int pivot = array[(leftMarker + rightMarker) / 2];
        do {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }

            while (array[rightMarker] > pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    ArrayService.swap(array, leftMarker, rightMarker);
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < right) {
            quickSort(array, leftMarker, right);
        }
        if (left < rightMarker) {
            quickSort(array, left, rightMarker);
        }
    }
}