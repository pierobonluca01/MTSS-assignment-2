////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

import java.util.List;

public interface Bill {
    double getOrderPrice(List<EItem> itemsOrdered, User user) throws BillException;
}
