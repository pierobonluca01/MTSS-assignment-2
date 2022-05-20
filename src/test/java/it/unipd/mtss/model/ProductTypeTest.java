////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTypeTest {

    @Test
    public void testProductType() {
        assertEquals("Mouse", ProductType.Mouse.toString());
    }
}