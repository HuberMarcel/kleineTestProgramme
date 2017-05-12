package de.marcelhuber.systemtools;

/**
 *
 * @author Marcel Huber
 */
public class Pause {
    
    static public void breakInMillis(){
//        breakInMillis(0);
    }
    
    static public void breakInMillis(long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException ex) {
        }
    }
    
    static public void breakInSeconds(long timeOut) {
        breakInMillis(1000 * timeOut);
    }
    
    static public void breakInSeconds(){
//       breakInSeconds(0);
    }
}
