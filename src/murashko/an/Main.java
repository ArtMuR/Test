package murashko.an;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        System.out.print(Check(scan));


    }

    public static String Check(String s) {
        int bracketsLevel = 0;
        int bracketSymb = 0;
        int multiplication = 0;
        String outputStr = "";

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {

            if (!String.valueOf(array[i]).matches("[\\w]||[\\Q[]\\E]")) {
                System.out.println("Введён неккоректный символ");
                new Error();
                break;

            }

            if (Character.isLetter(array[i]) && bracketsLevel == 0) {
                outputStr += array[i];
            }

            if (Character.isDigit(array[i]) && bracketsLevel == 0) {
                int level = 0;
                level = Integer.parseInt(String.valueOf(array[i]));
                multiplication = multiplication * 10 + level;
            }

            if (array[i] == '[') {
                if (bracketsLevel == 0) bracketSymb = i;
                bracketsLevel++;

                if (!Character.isDigit(array[i - 1])) {

                    System.out.println("Некорректно введено число");
                    new ExceptionInInitializerError();
                    break;

                }

            } else if (array[i] == ']') {
                bracketsLevel--;
                if (bracketsLevel < 0) {
                    outputStr = "";
                    System.out.print("Некорректный ввод ");
                    new ExceptionInInitializerError();
                    break;
                }


                if (bracketsLevel == 0) {
                    outputStr += Check(String.valueOf(Arrays.copyOfRange(array, bracketSymb + 1, i))).repeat(multiplication);
                    multiplication = 0;
                }

            }

        }

        return outputStr;
    }


}


//                      3[xyz]y  2[3[xy]z]
