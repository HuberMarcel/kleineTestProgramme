// Buch Seite 719 ff., 722 ff.
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter13;

/**
 *
 * @author Marcel Huber; letzte Änderung: 12.08.2017
 */
public class ThreadsWithNames {
    public static void main(String[] args) {
        ThreadsWithNames dummyObject = new ThreadsWithNames();
        dummyObject.go01();
    }
    
    private void go01() {
        MyRunnableTester myRunnable = new MyRunnableTester();
        Thread[] threads = new Thread[3];
        threads[0] = new Thread(myRunnable,"Pascal");
        threads[1] = new Thread(myRunnable,"Marcel");
        threads[2] = new Thread(myRunnable,"Sascha");
        for (Thread thread : threads) {
            thread.start();
        }
    }   
}

class MyRunnableTester implements Runnable{
    
    @Override
    public void run() {
        for (int k = 0; k < 1_000; k++) {
            System.out.println(Thread.currentThread().getName()+": "
                    + "Wert von k: "+k);
        }
    }
}
