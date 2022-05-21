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

    public double getPrice() throws BillException {
        Bill bill = new BillImpl();
        return bill.getOrderPrice(items, user);
    }

    public List<EItem> getItems() {
        return items;
    }
    public void setItems(List<EItem> items) {
        if (items == null || items.contains(null)) throw new IllegalArgumentException("La lista risulta null o contiene un elemento null.");
        if (items.isEmpty()) throw new IllegalArgumentException("La lista di elementi e' vuota.");
        this.items = items;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        if(user == null) throw new IllegalArgumentException("L'utente risulta null.");
        this.user = user;
    }

    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        if(time == null) throw new IllegalArgumentException("Il tempo dell'ordine inserito risulta null.");
        this.time = time;
    }
}
