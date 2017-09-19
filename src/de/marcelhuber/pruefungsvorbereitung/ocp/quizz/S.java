package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

/**
 *
 * @author Marcel Huber; 19.09.2017
 */
public class S {

    static class A implements AutoCloseable {

        @Override
        public void close() throws Exception {
            throw new Exception("catch ");
        }
    }

    private static void method() throws Exception {
        try (A a = new A()) {
            throw new Exception("try ");
//        }
        } finally {
            throw new Exception("finally ");
        }
    }

    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSuppressed()[0]);
        }
    }
}
