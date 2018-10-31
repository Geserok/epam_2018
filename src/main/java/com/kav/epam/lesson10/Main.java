package com.kav.epam.lesson10;

/**
 * Created by zstudent on 08/10/2018.
 */
public class Main {
    public static void main(String[] args) {
        Barsik barsik = new Barsik("Barsik","Male", "isDead", (byte) 8);

        CatUtil.getCatTalk(barsik);
    }

}
