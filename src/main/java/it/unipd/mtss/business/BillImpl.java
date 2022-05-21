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

        //[6]
        if(itemsOrdered.size() > 30) throw new BillException("Sono stati inseriti più di 30 elementi.");

        double total = 0;
        int processorsCount = 0;
        int mousesCount = 0;
        int keyboardsCount = 0;
        double lessExpensiveProcessor = Double.MAX_VALUE;
        double lessExpensiveMouse = Double.MAX_VALUE;
        double lessExpensiveKeyboard = Double.MAX_VALUE;

        for(EItem item : itemsOrdered) {
            //[1]
            total += item.getPrice();

            //[2]
            if(item.getItemType() == ProductType.Processor) {
                processorsCount++;
                if(item.getPrice() < lessExpensiveProcessor) {
                    lessExpensiveProcessor = item.getPrice();
                }
            }
            //[3][4]
            if(item.getItemType() == ProductType.Mouse) {
                mousesCount++;
                if(item.getPrice() < lessExpensiveMouse) {
                    lessExpensiveMouse = item.getPrice();
                }
            }
            //[4]
            if(item.getItemType() == ProductType.Keyboard) {
                keyboardsCount++;
                if(item.getPrice() < lessExpensiveKeyboard) {
                    lessExpensiveKeyboard = item.getPrice();
                }
            }
        }

        //[2]
        if(processorsCount > 5) {
            total = total-(lessExpensiveProcessor/2);
        }

        //[3]
        if(mousesCount > 10) {
            total = total - lessExpensiveMouse;
            lessExpensiveMouse = 0;
        }

        //[4]
        if(mousesCount == keyboardsCount && mousesCount > 0) {
            total = total - Math.min(lessExpensiveMouse, lessExpensiveKeyboard);
        }

        //[5]
        if(total > 1000) {
            total = total * 0.9;
        }

        return total;
    }
}
