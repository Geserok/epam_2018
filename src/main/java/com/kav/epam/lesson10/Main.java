package com.kav.epam.lesson10;

/**
 * Main
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Main {
    public static void main(String[] args) {
        Barsik barsik = new Barsik("Barsik", "Male", "isDead", (byte) 8);

        CatUtil.getCatTalk(barsik);
    }

}
