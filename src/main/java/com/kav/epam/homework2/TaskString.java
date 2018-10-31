package com.kav.epam.homework2;


import java.io.IOException;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class TaskString {

    /**
     * returned the char which number is selected from word
     *
     * @param word
     * @param numberOfLetter
     * @throws IllegalArgumentException
     * if the {@param word} length less then {@param numberOfLetter} or {@param numberOfLetter} less then 0
     * @return
     */
    char getLetterByNumber(String word, int numberOfLetter) throws IOException {
        if (numberOfLetter <= 0 && word.length() < --numberOfLetter) {
            throw new IllegalArgumentException("Incorrect input argument");
        }
        return word.toCharArray()[--numberOfLetter];
    }

    /**
     * * returned the 3rd char from selected word
     *
     * @param word must be greater then 3 symbols
     * @throws IllegalArgumentException
     * If the {@param word} shorter then 3 symbols
     * @return
     */
    char getThirdLetter(String word) throws IOException {
        if (word.length() <= 3) {
            throw new IllegalArgumentException("Incorrect input argument");
        }
        return word.toCharArray()[2];
    }

    /**
     * return selected string with reversed 2 and 5 char
     *
     * @param word must be longer then 5 symbols.
     * @throws IllegalArgumentException
     * If the {@param word} shorter then 5 symbols
     * @return
     */
    String getReverseLetterString(String word) throws IOException {
        if (word.length() <= 5) {
            throw new IllegalArgumentException("Incorrect input argument");
        }
        char[] charsOfLetter = word.toCharArray();
        char firstLetter = charsOfLetter[1];
        charsOfLetter[1] = charsOfLetter[4];
        charsOfLetter[4] = firstLetter;
        return new String(charsOfLetter);
    }

    /**
     * return th last char from selected string
     *
     * @param word
     * @return
     */
    char getLastLetter(String word) {
        int length = word.toCharArray().length;
        return word.toCharArray()[--length];
    }

    /**
     * return the count of same letters which were nearly standing
     *
     * @param sentence
     * @return
     */
    int getCountOfNearSameLatter(String sentence) {
        int countOfSameNearLetters = 0;
        int countOfLettersTemp = 0;
        char[] chars = sentence.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            char first = chars[i];
            char second = chars[i + 1];
            if (checkTheSame(first, second)) {
                countOfLettersTemp += 1;
            } else if (countOfLettersTemp > 0) {
                countOfSameNearLetters += ++countOfLettersTemp;
                countOfLettersTemp = 0;
            }
        }
        if (countOfLettersTemp > 0) {
            countOfSameNearLetters += ++countOfLettersTemp;
        }
        return countOfSameNearLetters;
    }

    /**
     * return true if 1st and 2nd char in word are the same
     *
     * @param first
     * @param second
     * @return
     */
    private static boolean checkTheSame(char first, char second) {
        return first == second;
    }

    /**
     * return sentence with reverse words
     *
     * @param sentence
     * @return
     */
    String reverseString(String sentence) {
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : split) {
            sb.append(new StringBuilder().append(word).reverse());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
