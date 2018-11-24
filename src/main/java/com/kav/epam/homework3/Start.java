package com.kav.epam.homework3;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Start {

    /**
     * Method which initialise solving of tasks 1-5
     */
    public void init(){
        char[][] a = new char[5][5];
        a[0] = new char[]{'A', 'B', 'C', 'D', 'E'};
        a[1] = new char[]{'F', 'G', 'H', 'I', 'J'};
        a[2] = new char[]{'K', 'L', 'M', 'N', 'O'};
        a[3] = new char[]{'P', 'Q', 'R', 'S', 'T'};
        a[4] = new char[]{'U', 'V', 'W', 'X', 'Y'};

        FirstTaskArray firstTaskArrays = new FirstTaskArray();
        System.out.println(firstTaskArrays.getStringFromCornersChars(a));

        SecondTaskArray secondTaskArray = new SecondTaskArray();
        int[] intArr = new int[]{1, 2};
        System.out.println(secondTaskArray.getWordFromArray(1, intArr, a));

        ThirdTaskArray thirdTaskArray = new ThirdTaskArray();
        System.out.println(thirdTaskArray.getWordFromArrayInRows(a));
        System.out.println(thirdTaskArray.getWordFromArrayInColumns(a));

        FourthTaskArray fourthTaskArray = new FourthTaskArray();
        System.out.println(fourthTaskArray.getWordFromEvenElementsRows(a));

        FifthTaskArray fifthTaskArray = new FifthTaskArray();
        System.out.println(fifthTaskArray.getWordFromUnevenElementsColumn(a));
    }
}
