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

    public int inputInteger() throws NumberFormatException {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public int inputLength() throws NumberFormatException, NegativeArraySizeException {
        int length = Integer.parseInt(scanner.nextLine().trim());
        if (length < 0) {
            throw new NegativeArraySizeException();
        }
        return length;
    }

    public boolean createArray() {
        System.out.println("Enter length of array");
        arrayLength = inputLength();
        myArray = new int[arrayLength];
        memoryAllocated = arrayLength;
        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            try {
                myArray[i] = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException nfe) {
                while (true) {
                    System.out.println("Invalid input. Enter again or press 'q' to return home");
                    String inputByUser = scanner.nextLine().trim();
                    if (inputByUser.equals("q")) {
                        System.out.println("Array created");
                        arrayCreated = true;
                        return true;

                    } else {
                        try {
                            myArray[i] = Integer.parseInt(inputByUser);
                        } catch (NumberFormatException nfe2) {
                            continue;
                        }
                        break;
                    }

                }
            }
        }
        System.out.println("Array created");
        arrayCreated = true;
        return true;
    }

    public int checkLength() {
        if (arrayLength == 0) {
            System.out.println("No elements in array!");
            return 0;
        }
        return arrayLength;
    }


    @Override
    public int display() {
        if (checkLength() == 0) {
            return -1;
        }
        System.out.print("Elements in array are : ");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(myArray[i] + " ");

        }
        System.out.println();
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
