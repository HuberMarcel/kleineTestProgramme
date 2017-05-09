// dieses Interface soll nur anzeigen, wie man mehrere Interfaces erweitern kann
// bei KLASSEN geht das nicht
package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel
 */
//abstract public class IMehrfacherweiterndesInterface extends DarthVader, DarthVadersSonLuke {
public interface IMehrfacherweiterndesInterface extends IBeispielInterfaceDefault, IBeispielInterfacePublic {
  static final public int ICH_BIN_DIE_KONSTANTE_NULL = 0;    // automatisch final static und public
  int ICH_BIN_DIE_KONSTANTE_EINS = 1;                        // analog zu oben 
}
