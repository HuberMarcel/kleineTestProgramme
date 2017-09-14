package de.marcelhuber.pruefungsvorbereitung.ocp;

/**
 *
 * @author Marcel Huber; 14.09.2017
 */
public class ExceptionsDemoKompliziert {

    static class ThrowCatch implements AutoCloseable {

        @Override
        public void close() throws Exception {
            throw new Exception("catch");
        }

    }

    public static void method() throws Exception {
        try (ThrowCatch throwCatch = new ThrowCatch()) {
            throw new Exception("try");
        } catch(Exception e) {       
            System.out.println(e.getMessage());
            System.out.println(e.getSuppressed()[0]);
        }
        finally {
            throw new Exception("finally");
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
