////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.time.LocalDate;

public class UserImpl implements User {
    private long id;
    private String name;
    private String surname;
    private LocalDate birth;

    public UserImpl(long id, String name, String surname, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }
}