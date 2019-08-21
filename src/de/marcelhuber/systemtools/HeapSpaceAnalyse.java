package de.marcelhuber.systemtools;

/**
 *
 * @author Huber, Marcel
 * @date 21.08.2019
 */
public class HeapSpaceAnalyse {

    public static void main(String[] args) {
        System.out.println("MaxMemory [MB]   :" + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("TotalMemory [MB] :" + Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println("FreeMemory [MB]  :" + Runtime.getRuntime().freeMemory() / 1024 / 1024);
    }
}
