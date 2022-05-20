////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BillTest {
    Bill bill;
    User user;
    List<EItem> items;

    @Before
    public void init() {
        bill = new BillImpl();
        user = new UserImpl(1, "Nome", "Cognome", LocalDate.of(2001, 11, 23));
        items = new ArrayList<EItem>();
        System.out.print("\nINIZIO TEST");
    }

    @Test//[1]
    public void testTotal() throws BillException {
        System.out.println(" testTotal");

        items.add(new EItemImpl(ProductType.Mouse, "Logitech G502", 45.90));
        items.add(new EItemImpl(ProductType.Mouse, "Tecknet PRO", 11.90));
        items.add(new EItemImpl(ProductType.Processor, "Intel i5", 140.90));
        items.add(new EItemImpl(ProductType.Motherboard, "ASUS X570", 230.90));
        items.add(new EItemImpl(ProductType.Keyboard, "Corsair K65", 60.90));

        assertEquals(490.50, bill.getOrderPrice(items, user), 1e-3);
    }

}