package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.GiftException;
import it.unipd.mtss.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class GiftTest {
    List<Order> orders;

    @Before
    public void init() {
        orders = new ArrayList<Order>();
        System.out.print("\nINIZIO TEST");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullListGift() {
        System.out.println(" testNullListGift");

        List<Order> nullOrders = null;
        GiftImpl giftedOrders = new GiftImpl(nullOrders);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyListGift() {
        System.out.println(" testEmptyListGift");

        GiftImpl giftedOrders = new GiftImpl(orders);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullOrderGift() {
        System.out.println(" testEmptyListGift");

        orders.add(null);
        GiftImpl giftedOrders = new GiftImpl(orders);
    }

    @Test(expected = GiftException.class)
    public void testNotEnoughGift() throws GiftException {
        System.out.println(" testNotEnoughGift");

        UserImpl user = new UserImpl(1, "Name","Surname", LocalDate.of(2011, 11, 23));
        List<EItem> items = new ArrayList<>();
        EItemImpl item = new EItemImpl(ProductType.Mouse, "Mouse", 13.46);
        items.add(item);
        OrderImpl order = new OrderImpl(items, user, LocalTime.of(18, 30));
        orders.add(order);

        GiftImpl giftedOrders = new GiftImpl(orders);
        long[] giftedOrdersId = giftedOrders.giftedUsersId();
    }

    @Test
    public void testNotEqualsGift() throws GiftException {
        System.out.println(" testNotEqualsGift");

        for(int i=1; i<=20; i++) {
            String name = "Persona "+i;
            UserImpl user = new UserImpl(i, name,"Surname", LocalDate.of(2011, 11, 23));
            List<EItem> items = new ArrayList<>();
            EItemImpl item = new EItemImpl(ProductType.Mouse, "Mouse", i);
            items.add(item);
            OrderImpl order = new OrderImpl(items, user, LocalTime.of(18, 30));
            orders.add(order);
        }

        GiftImpl giftedOrders = new GiftImpl(orders);
        long[] giftedOrdersId = giftedOrders.giftedUsersId();
        boolean equals = orders.stream().distinct().count()<=1;

        assertFalse(equals);

    }

    @Test(expected = GiftException.class)
    public void testOutOfTimeRange() throws GiftException {
        System.out.println(" testOutOfTimeRange");

        for(int i=1; i<=9; i++) {
            String name = "Persona "+i;
            UserImpl user = new UserImpl(i, name,"Surname", LocalDate.of(2011, 11, 23));
            List<EItem> items = new ArrayList<>();
            EItemImpl item = new EItemImpl(ProductType.Mouse, "Mouse", i);
            items.add(item);
            OrderImpl order = new OrderImpl(items, user, LocalTime.of(18, 30));
            orders.add(order);
        }
        String name = "Persona "+10;
        UserImpl user = new UserImpl(10, name,"Surname", LocalDate.of(2011, 11, 23));
        List<EItem> items = new ArrayList<>();
        EItemImpl item = new EItemImpl(ProductType.Mouse, "Mouse", 10);
        items.add(item);
        OrderImpl order = new OrderImpl(items, user, LocalTime.of(17, 30));
        orders.add(order);

        GiftImpl giftedOrders = new GiftImpl(orders);
        long[] giftedOrdersId = giftedOrders.giftedUsersId();
    }

    @Test(expected = GiftException.class)
    public void testUnderage() throws GiftException {
        System.out.println(" testUnderage");

        for(int i=1; i<=9; i++) {
            String name = "Persona "+i;
            User user = new UserImpl(i, name,"Surname", LocalDate.of(2011, 11, 23));
            List<EItem> items = new ArrayList<>();
            EItem item = new EItemImpl(ProductType.Mouse, "Mouse", i);
            items.add(item);
            Order order = new OrderImpl(items, user, LocalTime.of(18, 30));
            orders.add(order);
        }
        String name = "Persona "+10;
        User user = new UserImpl(10, name,"Surname", LocalDate.of(2001, 11, 23));
        List<EItem> items = new ArrayList<>();
        EItemImpl item = new EItemImpl(ProductType.Mouse, "Mouse", 10);
        items.add(item);
        OrderImpl order = new OrderImpl(items, user, LocalTime.of(18, 30));
        orders.add(order);

        Gift giftedOrders = new GiftImpl(orders);
        long[] giftedOrdersId = giftedOrders.giftedUsersId();
    }

    @Test
    public void testRandomSeed() throws GiftException {
        System.out.println(" testRandomSeed");

        for(int i=1; i<=20; i++) {
            String name = "Persona "+i;
            UserImpl user = new UserImpl(i, name,"Surname", LocalDate.of(2011, 11, 23));
            List<EItem> items = new ArrayList<>();
            EItemImpl item = new EItemImpl(ProductType.Mouse, "Mouse", i);
            items.add(item);
            OrderImpl order = new OrderImpl(items, user, LocalTime.of(18, 30));
            orders.add(order);
        }

        List<Order> orders_copy = new ArrayList<>(orders);
        GiftImpl giftedOrders = new GiftImpl(orders);
        long[] giftedOrdersId = giftedOrders.giftedUsersId();

        Random random = new Random(100);
        long[] expected = new long[10];

        System.out.println();
        for(int i=0; i<10; i++) {
            int n = random.nextInt(orders_copy.size());
            expected[i] = orders_copy.get(n).getUser().getId();
            System.out.print(" "+expected[i]);
            orders_copy.remove(n);
        }
        System.out.println();

        assertArrayEquals(expected, giftedOrdersId);

    }

    @After
    public void end() {
        System.out.println("    FINE TEST");
    }
}