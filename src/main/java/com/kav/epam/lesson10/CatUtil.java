package com.kav.epam.lesson10;

/**
 * CatUtil
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class CatUtil {

    /**
     * Method print call {@talkToSpirits} 6 times
     *
     * @param barsik
     */
    static void getCatTalk(Barsik barsik) {
        System.out.println(barsik.talkToSpirits());
        System.out.println(barsik.talkToSpirits());
        System.out.println(barsik.talkToSpirits());
        System.out.println(barsik.talkToSpirits());
        System.out.println(barsik.talkToSpirits());
        System.out.println(barsik.talkToSpirits());
    }
}