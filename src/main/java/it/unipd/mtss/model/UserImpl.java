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
        if(id <= 0) throw new IllegalArgumentException("ID inserito non valido.");
        if(name == null) throw new IllegalArgumentException("Nome dell'utente risulta null.");
        if(surname == null) throw new IllegalArgumentException("Cognome dell'utente risulta null.");
        if(birth == null) throw new IllegalArgumentException("Data di nascita dell'utente risulta null.");
        if(!birth.isBefore(LocalDate.now())) throw new IllegalArgumentException("Data di nascita dell'utente inserita non valida.");
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }
}