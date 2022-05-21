////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.*;
import org.junit.After;
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

    @Test(expected = BillException.class)
    public void testNullItems() throws BillException {
        System.out.println(" testNullItems");
        List<EItem> itemsNull = null;
        double price = bill.getOrderPrice(itemsNull, user);
    }

    @Test(expected = BillException.class)
    public void testNullItem() throws BillException {
        System.out.println(" testNullItem");
        items.add(null);
        double price = bill.getOrderPrice(items, user);
    }

    @Test(expected = BillException.class)
    public void testEmptyList() throws BillException {
        System.out.println(" testEmptyList");
        List<EItem> itemsNull = new ArrayList<>();
        double price = bill.getOrderPrice(itemsNull, user);
    }

    @Test(expected = BillException.class)
    public void testNullUser() throws BillException {
        System.out.println(" testNullUser");
        User userNull = null;
        items.add(new EItemImpl(ProductType.Mouse, "Logitech G502", 45.90));
        double price = bill.getOrderPrice(items, userNull);
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

    @Test//[2]
    public void testMore5Processors() throws BillException {
        System.out.println(" testMore5Processors");

        items.add(new EItemImpl(ProductType.Processor, "Intel i3", 99.90));
        items.add(new EItemImpl(ProductType.Processor, "Intel i5", 140.90));
        items.add(new EItemImpl(ProductType.Processor, "Intel i7", 170.90));
        items.add(new EItemImpl(ProductType.Processor, "AMD Ryzen 3", 190.90));
        items.add(new EItemImpl(ProductType.Processor, "AMD Ryzen 5", 130.90));
        items.add(new EItemImpl(ProductType.Processor, "AMD Ryzen 7", 160.90));

        assertEquals(844.45, bill.getOrderPrice(items, user), 1e-3);
    }

    @Test//[3]
    public void testGiftMouse() throws BillException {
        System.out.println(" testGiftMouse ");

        items.add(new EItemImpl(ProductType.Mouse, "Logitech G502", 45.90));
        items.add(new EItemImpl(ProductType.Mouse, "Tecknet PRO", 11.90));
        items.add(new EItemImpl(ProductType.Mouse, "Amazon Basics", 16.40));
        items.add(new EItemImpl(ProductType.Mouse, "Trust Voca", 30.50));
        items.add(new EItemImpl(ProductType.Mouse, "Logitech M220", 40.10));
        items.add(new EItemImpl(ProductType.Mouse, "Coolerplus FC112", 45.90));
        items.add(new EItemImpl(ProductType.Mouse, "HP - PC X500", 11.90));
        items.add(new EItemImpl(ProductType.Mouse, "Kensington Mouse", 16.40));
        items.add(new EItemImpl(ProductType.Mouse, "CHERRY MC 1000", 30.50));
        items.add(new EItemImpl(ProductType.Mouse, "Black Shark Mouse", 40.10));
        items.add(new EItemImpl(ProductType.Mouse, "HyperX Pulsefire", 8.10));

        assertEquals(289.60, bill.getOrderPrice(items, user), 1e-3);
    }

    @Test//[4]
    public void testGiftSameMouseKeyboard() throws BillException {
        System.out.println(" testGiftSameMouseKeyboard");

        items.add(new EItemImpl(ProductType.Mouse, "Logitech G502", 45.90));
        items.add(new EItemImpl(ProductType.Mouse, "Tecknet PRO", 11.90));
        items.add(new EItemImpl(ProductType.Mouse, "Amazon Basics", 16.40));
        items.add(new EItemImpl(ProductType.Keyboard, "Trust Keys", 24.50));
        items.add(new EItemImpl(ProductType.Keyboard, "Logitech MX Keys", 45.10));
        items.add(new EItemImpl(ProductType.Keyboard, "Microsoft Surface Pro Keyboard", 36.90));

        assertEquals(168.80, bill.getOrderPrice(items, user), 1e-3);
    }

    @Test//[5]
    public void testDiscount1000() throws BillException {
        System.out.println(" testDiscount1000");

        items.add(new EItemImpl(ProductType.Mouse, "Logitech G502", 45.90));
        items.add(new EItemImpl(ProductType.Mouse, "Tecknet PRO", 11.90));
        items.add(new EItemImpl(ProductType.Processor, "Intel i5", 140.90));
        items.add(new EItemImpl(ProductType.Motherboard, "ASUS X570", 830.90));
        items.add(new EItemImpl(ProductType.Keyboard, "Corsair K65", 60.90));

        assertEquals(981.45, bill.getOrderPrice(items, user), 1e-3);
    }

    @After
    public void end() {
        System.out.println("    FINE TEST");
    }

}