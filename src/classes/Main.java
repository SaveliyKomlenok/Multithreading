package classes;

import factories.ArrayFactory;

public class Main {
    public static void main(String[] args) {
        ArrayFactory arrayFactory = new ArrayFactory();
        try {
            new BubbleSortThread(arrayFactory.createArray(10), "Thread1:(Bubble sort)").join();
            new SelectionSortThread(arrayFactory.createArray(10), "Thread2:(Selection sort)").join();
            new InsertionSortThread(arrayFactory.createArray(10), "Thread3:(Insertion sort)").join();
            new ShuttleSortThread(arrayFactory.createArray(10), "Thread4:(Shuttle sort)").join();
            new ShellSortThread(arrayFactory.createArray(10), "Thread5:(Shell sort)").join();
            new CountingSortThread(arrayFactory.createArray(10), "Thread6:(Counting sort)").join();
            new QuickSortThread(arrayFactory.createArray(10), "Thread7:(Quick sort)").join();
        } catch (InterruptedException exception){
            System.out.println("Error: " + exception.getMessage());
        }
    }
}