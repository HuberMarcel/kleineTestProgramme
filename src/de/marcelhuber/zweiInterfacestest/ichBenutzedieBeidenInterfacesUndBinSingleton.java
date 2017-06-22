package de.marcelhuber.zweiInterfacestest;

public class ichBenutzedieBeidenInterfacesUndBinSingleton implements Interface1, Interface2 {

    static private boolean returnTheSingleObjectIfExistent;

    static private boolean itExistsOneInstance;
    static private byte counter;
    static private ichBenutzedieBeidenInterfacesUndBinSingleton dasEinzigeObjekt;
    private String name;

    public static boolean isItExistsOneInstance() {
        return itExistsOneInstance;
    }

    public static void setItExistsOneInstance(boolean itExistsOneInstance) {
        ichBenutzedieBeidenInterfacesUndBinSingleton.itExistsOneInstance
                = itExistsOneInstance;
    }

    {
        itExistsOneInstance = true;
        name = "Objekt der Klasse ichBenutzedieBeidenInterfaces Nr.: "
                + ++counter;
    }

    private ichBenutzedieBeidenInterfacesUndBinSingleton() {
    }

    @Override
    public void ichBinDa() {
        System.out.println("Hahaha");
    }

    private static void ichBenutzeIchBinDa() {
        new ichBenutzedieBeidenInterfacesUndBinSingleton().ichBinDa();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public static boolean isReturnTheSingleObjectIfExistent() {
        return returnTheSingleObjectIfExistent;
    }

    public static void setReturnTheSingleObjectIfExistent(boolean returnTheSingleObjectIfExistent) {
        ichBenutzedieBeidenInterfacesUndBinSingleton.returnTheSingleObjectIfExistent = returnTheSingleObjectIfExistent;
    }

    static public ichBenutzedieBeidenInterfacesUndBinSingleton getInstance() {
        if (!itExistsOneInstance) {
            dasEinzigeObjekt = new ichBenutzedieBeidenInterfacesUndBinSingleton();
            return dasEinzigeObjekt;
        }
        if (!returnTheSingleObjectIfExistent) {
            return null;
        }
        return dasEinzigeObjekt;
    }

}
