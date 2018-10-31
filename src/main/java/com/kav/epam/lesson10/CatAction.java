package com.kav.epam.lesson10;

/**
 * Created by zstudent on 08/10/2018.
 */
public class CatAction {

    public String getCatActionBySituation(CatEnum action) {
        if (action == CatEnum.DEFECATION) {
            return "pffrffrpff";
        } else if (action == CatEnum.EAT) {
            return "I am eating";
        } else if (action == CatEnum.HUNT){
            return "I am hunting";
        } else if (action == CatEnum.MEOW){
            return "Meow - Meow";
        } else if (action == CatEnum.PLAY){
            return "I am playing";
        } else if (action == CatEnum.SLEEP){
            return "Zzz...";
        }
        throw new IllegalArgumentException("Wrong action " + action);
    }
}
