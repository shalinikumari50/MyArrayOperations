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

    public int search(int element) {

        for (int i = 0; i < arrayLength; i++) {
            if (myArray[i] == element) {
                System.out.println("Element found at index " + i);
                return i;
            }

        }
        System.out.println("Element not found");
        return -1;

    }

    @Override
    public int search() {
        if (checkLength() == 0) {
            return -1;
        }
        System.out.println("Enter element to be searched");
        int element = inputInteger();
        return search(element);
    }

    public int validIndex(int index) throws NumberFormatException {
        while (true) {
            if (index < 0 || index >= arrayLength) {
                System.out.println("Invalid position. Enter again or press 'q' to return home");
                String inputByUser = scanner.nextLine().trim();
                if (inputByUser.equals("q")) {
                    return -1;

                } else {

                    index = Integer.parseInt(inputByUser);

                }
            } else {
                break;
            }
        }
        return index;
    }

    public void growSizeOfArray(int arrayLength) {
        int[] temp;
        if (arrayLength == 0) {
            temp = new int[1];

        } else {
            temp = new int[arrayLength + (arrayLength / 2)];
        }
        memoryAllocated = temp.length;
        for (int i = 0; i < arrayLength; i++) {
            temp[i] = myArray[i];
        }
        myArray = temp;
    }

    public boolean isArrayCreated() {
        return arrayCreated;
    }


    @Override
    public int insert() {
        if (!isArrayCreated()) {
            System.out.println("Create an array first!");
            return -1;
        }

        System.out.println("Enter index at which the element needs to be inserted");
        int index = inputInteger();
        while (true) {
            if (index >= 0 && index <= arrayLength) {
                System.out.println("Enter element to be inserted");
                int element = inputInteger();
                if (memoryAllocated == arrayLength) {
                    growSizeOfArray(arrayLength);
                }
                for (int i = arrayLength; i > index; i--) {
                    myArray[i] = myArray[i - 1];
                }
                myArray[index] = element;
                arrayLength += 1;
                System.out.println("Element inserted");
                return index;
            } else {
                System.out.println("Invalid position. Enter again or press 'q' to return home");
                String inputByUser = scanner.nextLine().trim();
                if (inputByUser.equals("q")) {
                    break;
                } else {
                    try {
                        index = Integer.parseInt(inputByUser);
                    } catch (NumberFormatException nn) {
                        System.out.println("Invalid input");
                        break;
                    }
                }

            }
        }
        return -1;
    }

    public int deleteIndex(int index) {
        for (int i = index; i < (arrayLength - 1); i++) {
            myArray[i] = myArray[i + 1];
        }
        arrayLength -= 1;
        System.out.println("Element deleted");
        return index;
    }

    public int deleteIndex() {
        if (checkLength() == 0) {
            return -1;
        }
        System.out.println("Enter index which is to be deleted");
        int index = validIndex(inputInteger());
        if (index > 0) {
            return deleteIndex(index);
        }
        return -1;
    }

    @Override
    public int delete() {
        return 0;
    }
}
