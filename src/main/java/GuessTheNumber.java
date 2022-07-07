import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Please, enter your name:");
        String name = scanner.next();
        System.out.print("Which game you want to play? \nType 1 for numbers game, type 2 for well-known event game:");
        int choice = scanner.nextInt();

        if (choice == 1) {
            int randomNumber = random.nextInt(1, 101);
            System.out.println("Let the game begin!\nThe number is between 0 and 100.");
            int counter = 0;
            int[] numbers = new int[1];

            while (true) {
                System.out.print("Guess the number:");
                try {
                    counter++;
                    int temp;
                    int number = scanner.nextInt();
                    if (counter == 1) numbers[0] = number;
                    else {
                        int[] tempArray = numbers;
                        numbers=new int[tempArray.length+1];
                        System.arraycopy(tempArray, 0, numbers, 0, tempArray.length);
                        numbers[tempArray.length]=number;}

                    if (number > randomNumber) {
                        System.out.println("Your number is too big. Please, try again.");
                    } else if (number < randomNumber) {
                        System.out.println("Your number is too small. Please, try again.");
                    } else {
                        for (int i = 0; i < numbers.length; i++) {
                            for (int k = i + 1; k < numbers.length; k++) {
                                if (numbers[i] < numbers[k]) {
                                    temp = numbers[i];
                                    numbers[i] = numbers[k];
                                    numbers[k] = temp;
                                }
                            }
                        }
                        System.out.println("Your numbers:" + Arrays.toString(numbers));
                        break;
                    }

                } catch(InputMismatchException Exception){
                    System.out.println("Please, play write a number!");
                    scanner.nextLine();
                }
            }
            System.out.printf("Congratulations, %s!", name);
        }

        else if (choice ==2){
            System.out.println("Let the game begin!");
            String[][] matrix = { {"1914","1917","1939","1941","1945","1947","1949","1963","1989","2020"}
                    ,{"Start of World War I","Russian Revolution","Start of World War II","Pearl Harbour – and entry of the US into WWII"
                    ,"Atomic Bomb dropped on Hiroshima","Indian Independence","Establishment of Maoist China","The assassination of John F Kennedy",
                    "Fall of the Berlin Wall","Covid-19 Pandemic"}
            };

            int randomNumber2 = random.nextInt(1,11);
            System.out.println("When happened? " + matrix[1][randomNumber2]);
            while(true) {
                String answer = scanner.next();
                if (answer.equalsIgnoreCase(matrix[0][randomNumber2])) {
                    System.out.println("You won, " + name + "!");
                    break;
                }
                else System.out.println("Try again!");
            }
        }
        else
            System.out.println("Please enter 1 or 2!");
    }
}

