////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import it.unipd.mtss.business.exception.BillException;

import java.time.LocalTime;
import java.util.List;

public interface Order {
    double getPrice() throws BillException;
    List<EItem> getItems();
    void setItems(List<EItem> items);
    User getUser();
    void setUser(User user);
    LocalTime getTime();
    void setTime(LocalTime time);
}
