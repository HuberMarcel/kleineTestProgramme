package de.marcelhuber.mathematischeHilfsprogramme;

/**
 *
 * @author viona25
 */
public class hilfsmethoden {

    public static void main(String[] args) {
        System.out.println(checkIs2erPotenz(3));
        System.out.println(checkIs2erPotenz(8));
        System.out.println(checkIs2erPotenz(9));
    }
    
    static private boolean check2erPotenz;
    
    static public boolean getResultCheckIs2erPotenz(long z){
//        System.out.println("(hilfsmethoden) checkIs2erPotenz: "+checkIs2erPotenz(z));
        return checkIs2erPotenz(z);
    }

    static private boolean checkIs2erPotenz(long z) {
        if (z <= 0) {
            check2erPotenz = false;
        } else {
            while (z % 2 == 0) {
                z /= 2;
            }
        }
        if (z == 1) {
            check2erPotenz = true;
        }  else{
            check2erPotenz = false;
        }
        return check2erPotenz;
    }
}
