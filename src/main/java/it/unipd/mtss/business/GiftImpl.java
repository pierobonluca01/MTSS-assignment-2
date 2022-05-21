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
}

