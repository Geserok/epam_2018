package com.kav.epam.homework2;


import java.io.IOException;
import java.util.Scanner;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Введите номер интересующей буквы в строке: ");
        Scanner in = new Scanner(System.in);
        int numberOfLetter = in.nextInt();
        String word = "Harry Potter";
        String sentence = "Moscow is the capital of Russia";
        System.out.println("Используемое слово: " + word);
        System.out.println("Используемое предложение: " + sentence);
        TaskString taskString = new TaskString();
        System.out.println("Третий символ: " + taskString.getThirdLetter(word));
        System.out.println("Последний символ: " + taskString.getLastLetter(word));
        System.out.println("Выбраный символ: " + taskString.getLetterByNumber(word, numberOfLetter));
        System.out.println("Число одинаковых соседних букв в предложении: " + taskString.getCountOfNearSameLatter(sentence));
        System.out.println("Слово с поменяными местами 2 и 5 буквами: " + taskString.getReverseLetterString(word));
        System.out.println("Предложение задом наперед: " + taskString.reverseString(sentence));

    }
}

