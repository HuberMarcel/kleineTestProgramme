package de.marcelhuber.pruefungsvorbereitung.ocp.quizz;

/**
 *
 * @author Marcel Huber; 17.09.2017
 */
public class Foo {
//    protected short test(float[] yahoo) {
//        return 7;
//    }

    protected Number test(float[] yahoo) {
        return (Long) 7L;
    }
}

class FooChild extends Foo {
////    @Override
////    public short test(float[] yahooChild) {
////        return 49;
////    }
//    
//    @Override
//    public long test(float[] yahooChild) {
//        return 49;
//    }

    @Override
    protected Short test(float[] yahoo) {
        return 49;
    }
}
