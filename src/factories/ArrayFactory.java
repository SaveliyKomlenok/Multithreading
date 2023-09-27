package factories;

import java.util.concurrent.ThreadLocalRandom;

public class ArrayFactory {
    public int[] createArray(int size){
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1,100);
        }
        return array;
    }
}