package de.marcelhuber.pruefungsvorbereitung.oca;
// diese Klasse dient eigentlich nur zur Demonstration, wie man die Methoden
// einer anderen Klasse, die nur default-Access hat, nach außen (anderes package) 
// tragen kann, sofern die Methoden der anderen Klasse mindestens Access-Level 
// default haben

/**
 *
 * @author Marcel Huber
 */
public class DarthVadersSonLuke extends DarthVader {

    @Override
    public void ichStelleMichVor() {
        super.ichStelleMichVor();
    }

    @Override
    DarthVadersSonLuke getDarthVader() {
        return this;
    }
}
