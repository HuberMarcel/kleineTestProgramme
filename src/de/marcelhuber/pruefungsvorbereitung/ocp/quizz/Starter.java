package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber; 19.09.2017
 */
public class Starter implements Runnable {

    void go(long id) {
        System.out.print(id + " ");
    }

    public static void main(String[] args) {
        for (int x = 0; x < 5; x++) {
            System.out.println("x + 1 = " + (x + 1));
            System.out.print(Thread.currentThread().getId() + " ");
            switch (x + 1) {
                case 1:
                    new Starter().run();
                    System.out.println("");
                    Marker.marker('_');
                    break;
                case 2:
//                new Starter().start();
                    System.out.println("");
                    Marker.marker('_');
                    break;
                case 3:
                    Thread t;
                    t = new Thread(new Starter());
                    System.out.println("");
                    Marker.marker('_');
                    break;
                case 4:
                    t = new Thread(new Starter());
                    t.run();
                    System.out.println("");
                    Marker.marker('_');
                    break;
                case 5:
                    t = new Thread(new Starter());
                    t.start();
                     {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                    }
                    System.out.println("");
                    Marker.marker('_');
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    @Override
    public void run() {
        go(Thread.currentThread().getId());
    }
}
