package arrayOperations;

import operations.Operations;

import java.util.Scanner;

public class ArrayOperations implements Operations {
    private int[] myArray;
    private int arrayLength;
    private boolean arrayCreated;
    private int memoryAllocated;
    private Scanner scanner;

    public ArrayOperations() {
        myArray = null;
        arrayLength = 0;
        arrayCreated = false;
        memoryAllocated = 0;
        scanner = new Scanner(System.in);
    }

    @Override
    public int display() {
        return 0;
    }

    @Override
    public int search() {
        return 0;
    }

    @Override
    public int insert() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }
}
