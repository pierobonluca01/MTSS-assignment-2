////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public class EItemImpl implements EItem {
    private ProductType itemType;
    private String name;
    private double price;

    public EItemImpl(ProductType itemType, String name, double price) {
        this.itemType = itemType;
        this.name = name;
        this.price = price;
    }

}
