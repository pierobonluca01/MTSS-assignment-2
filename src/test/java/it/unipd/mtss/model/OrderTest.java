////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrderTest {
    Order order;
    User user;
    EItem item;
    List<EItem> items;

    @Before
    public void init() {
        user = new UserImpl(1, "Luca", "Pierobon", LocalDate.of(2001, 11, 23));
        item = new EItemImpl(ProductType.Mouse, "Mouse", 13.50);
        items = new ArrayList<EItem>();
        items.add(item);
        order = new OrderImpl(items, user, LocalTime.of(18, 30));
        System.out.print("\nINIZIO TEST");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrderNullItems() {
        System.out.println(" testOrderNullItems");

        Order orderNull = new OrderImpl(null, user, LocalTime.of(18, 30));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrderEmptyList() {
        System.out.println(" testOrderEmptyList");

        List<EItem> itemsNull = new ArrayList<EItem>();
        Order orderNull = new OrderImpl(itemsNull, user, LocalTime.of(18, 30));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrderNullUser() {
        System.out.println(" testOrderNullUser");

        Order orderNull = new OrderImpl(items, null, LocalTime.of(18, 30));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrderNullTime() {
        System.out.println(" testOrderNullTime");

        Order orderNull = new OrderImpl(items, user, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrderSetNullItems() {
        System.out.println(" testOrderSetNullItems");

        order.setItems(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrderSetEmptyList() {
        System.out.println(" testOrderSetEmptyList");

        List<EItem> itemsNull = new ArrayList<EItem>();
        order.setItems(itemsNull);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrderSetNullUser() {
        System.out.println(" testOrderSetNullUser");

        order.setUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrderSetNullTime() {
        System.out.println(" testOrderSetNullTime");

        order.setTime(null);
    }

    @Test
    public void testOrderGetPrice() {
        System.out.println(" testOrderGetPrice");

        try {
            assertEquals(13.50, order.getPrice(), 1e-3);
        } catch (BillException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testOrderItemsSetGet() {
        System.out.println(" testOrderItemsSetGet");

        order.setItems(items);
        assertEquals(items, order.getItems());
    }

    @Test
    public void testOrderUserSetGet() {
        System.out.println(" testOrderUserSetGet");

        order.setUser(user);
        assertEquals(user, order.getUser());
    }

    @Test
    public void testOrderTimeSetGet() {
        System.out.println(" testOrderTimeSetGet");

        order.setTime(LocalTime.of(18, 30));
        assertEquals(LocalTime.of(18, 30), order.getTime());
    }

    @After
    public void end() {
        System.out.println("    FINE TEST");
    }

}