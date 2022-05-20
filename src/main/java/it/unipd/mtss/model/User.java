////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.time.LocalDate;

public interface User {
    long getId();
    void setId(long id);
    String getName();
    void setName(String name);
    String getSurname();
    void setSurname(String surname);
    LocalDate getBirth();
    void setBirth(LocalDate birth);
    int getAge();
}


