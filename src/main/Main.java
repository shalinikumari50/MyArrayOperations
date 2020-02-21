package main;

import arrayOperations.ArrayOperations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayOperations arrayOperations = new ArrayOperations();
        arrayOperations.printMenu();
        int choice = -1;
        do {
            System.out.println("Enter choice : ");
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input");
                continue;
            }
            switch (choice) {
                case 0:
                    break;
                case 1:
                    try {
                        arrayOperations.createArray();
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid input");
                    } catch (NegativeArraySizeException nae) {
                        System.out.println("Array size can not be negative");
                    }
                    break;
                case 2:
                    arrayOperations.display();
                    break;
                case 3:
                    try {
                        arrayOperations.insert();
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid input");
                    }
                    break;
                case 4:
                    try {
                        arrayOperations.delete();
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid input");
                    }
                    break;
                case 5:
                    try {
                        arrayOperations.deleteIndex();
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid input");
                    }
                    break;
                case 6:
                    try {
                        arrayOperations.search();
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid input");
                    }
                    break;
                case 7:
                    arrayOperations.sortArrayInAscendingOrder();
                    break;
                case 8:
                    arrayOperations.printMenu();

                    break;
                default:
                    System.out.println("Please enter valid choice");


            }


        } while (choice != 0);
    }
}
