package unternehmensstruktur.model;

/**
 * Beschreibt den UI-Feldtyp fuer die generische SimpleSingleView.
 * Wird in fieldTypes-Map verwendet, um zu steuern welches Vaadin-Widget
 * fuer ein Feld gerendert wird.
 */
public enum FieldType {
    STRING,
    INTEGER,
    DATE,
    TIME,
    BOOLEAN,
    BIG_DECIMAL,
    ICTO_NUMBER
}
