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
        if(itemType == null) throw new IllegalArgumentException("Il tipo di prodotto risulta null.");
        if(name == null) throw new IllegalArgumentException("Il nome del prodotto risulta null.");
        if(price <= 0) throw new IllegalArgumentException("Il prezzo inserito è nullo o negativo.");
        this.itemType = itemType;
        this.name = name;
        this.price = price;
    }
    public ProductType getItemType() {
        return itemType;
    }
    public void setItemType(ProductType itemType) throws IllegalArgumentException {
        if(itemType == null) throw new IllegalArgumentException("Il tipo di prodotto risulta null.");
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if(name == null) throw new IllegalArgumentException("Il nome del prodotto risulta null.");
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) throws IllegalArgumentException {
        if(price <= 0) throw new IllegalArgumentException("Il prezzo inserito è nullo o negativo.");
        this.price = price;
    }
}
