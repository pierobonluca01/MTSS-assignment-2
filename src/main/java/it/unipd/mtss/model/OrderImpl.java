////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import it.unipd.mtss.business.Bill;
import it.unipd.mtss.business.BillImpl;
import it.unipd.mtss.business.exception.BillException;

import java.time.LocalTime;
import java.util.List;

public class OrderImpl implements Order {
    List<EItem> items;
    User user;
    LocalTime time;

    public OrderImpl(List<EItem> items, User user, LocalTime time) {
        if(items == null || items.contains(null)) throw new IllegalArgumentException("La lista di elementi risulta null o contiene un elemento null.");
        if(items.isEmpty()) throw new IllegalArgumentException("La lista di elementi e' vuota.");
        if(user == null) throw new IllegalArgumentException("L'utente risulta null.");
        if(time == null) throw new IllegalArgumentException("Il tempo dell'ordine inserito risulta null.");

        this.items = items;
        this.user = user;
        this.time = time;
    }
}
