////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public interface EItem {
    ProductType getItemType();
    void setItemType(ProductType itemType) throws IllegalArgumentException;
    String getName();
    void setName(String name) throws IllegalArgumentException;
    double getPrice();
    void setPrice(double price) throws IllegalArgumentException;
}
