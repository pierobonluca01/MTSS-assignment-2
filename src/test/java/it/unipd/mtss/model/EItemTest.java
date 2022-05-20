////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EItemTest {

    EItem item;

    @Before
    public void init() {
        System.out.print("\nINIZIO TEST");

        item = new EItemImpl(ProductType.Mouse, "Product", 14.50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullItemType() {
        System.out.println(" testNullItemType");

        EItem itemNull = new EItemImpl(null, "Product", 14.50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
        System.out.println(" testNullName");

        EItem itemNull = new EItemImpl(ProductType.Mouse, null, 14.50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrice() {
        System.out.println(" testNegativePrice");

        EItem itemNull = new EItemImpl(ProductType.Mouse, "Product", -14.50);
    }

}