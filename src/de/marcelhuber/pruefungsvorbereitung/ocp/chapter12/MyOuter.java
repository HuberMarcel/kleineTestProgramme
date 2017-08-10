// Ähnlich zu Seite 689
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter12;

/**
 *
 * @author Marcel Huber; letzte Änderung: 10.8.2017
 */
public class MyOuter {

    private int x = 3;

    public class MyInner {

        private int x = 2;
        private int y = MyOuter.this.x * MyOuter.this.x;

        public void showXandYFromMyInner() {
            System.out.println("x aus MyInner hat den Wert: " + x);
            System.out.println("x aus MyOuter hat den Wert: " + MyOuter.this.x);
            System.out.println("y aus MyInner hat den Wert: " + y);
            System.out.println("(Hinweis: y = x * x mit x aus MyOuter!)");
        }
    }

//    private 
    class ASecondInnerClass extends MyInner {
    }
}

class UseMyOuter {

    public static void main(String[] args) {
        UseMyOuter dummyObject = new UseMyOuter();
        dummyObject.go01();
        dummyObject.go02();
    }

    private void go01() {
        MyOuter.MyInner testObject = new MyOuter().new MyInner();
        testObject.showXandYFromMyInner();
    }

    private void go02() {
        MyOuter.ASecondInnerClass testObject02 
                = new MyOuter().new ASecondInnerClass();
        System.out.println(testObject02);
    }
}
