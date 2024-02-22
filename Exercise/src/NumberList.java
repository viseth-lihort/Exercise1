import java.util.Scanner;

public class NumberList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbers = new int[1];
        int index = 0;


        while (true) {
            Integer userInput = getIntegerInput(scanner);

            if (userInput == -1) {
                break;
            }

            if (userInput != null) {
                if (index == numbers.length) {
                    numbers = resizeArray(numbers);
                }

                numbers[index] = userInput;
                index++;
            }
        }

        displayEnteredNumbers(numbers, index);

        scanner.close();

    }
    private static Integer getIntegerInput(Scanner scanner) {
        System.out.print("Number (enter -1 to stop): ");

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.next();
            System.out.println("Invalid input. Please enter a valid number or -1 to stop.");
            return null;
        }
    }

    private static int[] resizeArray(int[] oldArray) {
        int newSize = oldArray.length * 2;
        int[] newArray = new int[newSize];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        return newArray;
    }

    private static void displayEnteredNumbers(int[] numbers, int size) {
        System.out.println("\nEntered numbers:");

        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

}