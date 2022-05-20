////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.ProductType;
import it.unipd.mtss.model.User;

import java.util.List;

public class BillImpl implements Bill {

    public double getOrderPrice(List<EItem> itemsOrdered, User user) throws BillException {
        if(itemsOrdered == null) throw new BillException("La lista di elementi risulta null.");
        if(itemsOrdered.contains(null)) throw new BillException("La lista contiene un elemento null.");
        if(itemsOrdered.isEmpty()) throw new BillException("La lista di elementi e' vuota.");
        if(user == null) throw new BillException("L'utente risulta null.");

        double total = 0;

        for(EItem item : itemsOrdered) {
            //[1]
            total += item.getPrice();
        }

        return total;
    }
}
