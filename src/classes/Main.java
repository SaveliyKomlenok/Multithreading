package classes;

import factories.ArrayFactory;

public class Main {
    public static void main(String[] args) {
        ArrayFactory arrayFactory = new ArrayFactory();
        BubbleSortThread bubbleSortThread = new BubbleSortThread(arrayFactory.createArray(10), "Thread1:(Bubble sort)");
        SelectionSortThread selectionSortThread = new SelectionSortThread(arrayFactory.createArray(10), "Thread2:(Selection sort)");
        InsertionSortThread insertionSortThread = new InsertionSortThread(arrayFactory.createArray(10), "Thread3:(Insertion sort)");

        try {
            bubbleSortThread.join();
            selectionSortThread.join();
            insertionSortThread.join();
        } catch (InterruptedException exception){
            System.out.println("Error: " + exception.getMessage());
        }
    }
}