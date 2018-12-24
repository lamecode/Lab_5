/*У заданому рядку символів вилучити слова, що мають парні порядкові номери.
Качан, ІП-81*/

import java.util.Scanner;

public class Lab_9 {
    public static void main(String[] args) {
        System.out.println("Введіть слова:");
        Scanner Lab_9 = new Scanner(System.in);
        String text = Lab_9.nextLine();
        InputandChecking(text);
        DeletingWords(text);
    }
    private static void InputandChecking(String text) {
        if (text.length() != 0) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    System.out.print("");
                }
            }
        }
    }
    private static void DeletingWords(String text){
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if ((i + 1) % 2 != 0)
                System.out.println(words[i]);
        }
    }

}
