package com.kav.epam.homework6;

import java.util.ArrayList;
import java.util.List;

/**
 * Create and control threads of Atm
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class AtmService {

    /**
     * Start the Atm service
     *
     * @param quantityOfAtm
     * @param quantityOfThreads
     */
    public void start(int quantityOfAtm, int quantityOfThreads) {
        if (quantityOfAtm < 0 || quantityOfThreads < 0) {
            throw new IllegalArgumentException(
                    "Wrong! quantityOfAtm and quantityOfThreads must be greater than 0");
        }
        List<Thread> listAtm = new ArrayList<>();
        for (int i = 0; i < quantityOfAtm; i++) {
            listAtm.add(new Thread(new Atm(i, quantityOfThreads)));
        }
        listAtm.forEach(Thread::start);
    }

    public static void main(String[] args) {
        AtmService atmService = new AtmService();
        atmService.start(10, 3);
    }
}
