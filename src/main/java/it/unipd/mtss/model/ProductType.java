////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public enum ProductType {
    Processor("Processore"),
    Motherboard("Scheda Madre"),
    Keyboard("Tastiera"),
    Mouse("Mouse");
    private final String textValue;
    ProductType(final String textValue) {
        this.textValue = textValue;
    }
    @Override
    public String toString() {
        return textValue;
    }
}