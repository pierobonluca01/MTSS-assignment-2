////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.GiftException;
import it.unipd.mtss.model.Order;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class GiftImpl implements Gift {
    List<Order> orders;
    Random random;

    public GiftImpl(List<Order> orders) {
        if(orders == null) throw new IllegalArgumentException("La lista di ordini risulta null.");
        if(orders.isEmpty()) throw new IllegalArgumentException("La lista di ordini risulta vuota.");
        if(orders.contains(null)) throw new IllegalArgumentException("La lista contiene un ordine null.");

        this.orders = orders;
    }


    public long[] giftedUsersId() throws GiftException {
        orders.removeIf(o -> o.getTime().isBefore(LocalTime.of(18, 00)) || o.getTime().isAfter(LocalTime.of(19, 00)));
        orders.removeIf(o -> o.getUser().getAge() > 17);

        long[] users = new long[10];
        random = new Random(100);

        if (orders.size() < 10) throw new GiftException("Gli ordini non sono sufficienti per poterne regalare 10.");

        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(orders.size());
            users[i] = orders.get(n).getUser().getId();
            System.out.print(" " + users[i]);
            orders.remove(n);
        }

        return users;
    }
}

