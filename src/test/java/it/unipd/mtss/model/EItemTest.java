////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import org.junit.After;
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

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullItemType() {
        System.out.println(" testSetNullItemType");

        item.setItemType(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullName() {
        System.out.println(" testSetNullName");

        item.setName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativePrice() {
        System.out.println(" testSetNegativePrice");

        item.setPrice(-14.50);
    }

    @Test
    public void testItemTypeSetGet() {
        System.out.println(" testItemTypeGetter");

        item.setItemType(ProductType.Keyboard);
        assertEquals(ProductType.Keyboard, item.getItemType());
    }

    @Test
    public void testNameSetGet() {
        System.out.println(" testNameGetter");

        item.setName("NewProduct");
        assertEquals("NewProduct", item.getName());
    }

    @Test
    public void testPriceSetGet() {
        System.out.println(" testPriceGetter");

        item.setPrice(17.90);
        assertEquals(17.90, item.getPrice(), 1e-3);
    }

    @After
    public void end() {
        System.out.println("    FINE TEST");
    }

}