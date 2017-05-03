package de.marcelhuber.pruefungsvorbereitung.oca.selftestseite075;

/**
 *
 * @author Marcel Huber
 */
public class Electronic implements Device {

    @Override
    public void doIt() {
    }
}

abstract class Phone1 extends Electronic {
}

abstract class Phone2 extends Electronic {

    public void doIt(int x) {
    }
}

class Phone3 extends Electronic implements Device {

    public void doStuff() {
    }
}

interface Device {

    public void doIt();
}
