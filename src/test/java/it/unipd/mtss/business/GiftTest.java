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

    @Test
    public void testRandomSeed() throws GiftException {
        System.out.println(" testRandomSeed");

        for (int i = 1; i <= 20; i++) {
            String name = "Persona " + i;
            UserImpl user = new UserImpl(i, name, "Surname", LocalDate.of(2011, 11, 23));
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
        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(orders_copy.size());
            expected[i] = orders_copy.get(n).getUser().getId();
            System.out.print(" " + expected[i]);
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