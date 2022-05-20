////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.time.LocalDate;
import java.time.Period;

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

    public long getId() {
        return id;
    }
    public void setId(long id) throws IllegalArgumentException {
        if(id <= 0) throw new IllegalArgumentException("ID inserito non valido.");
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) throws IllegalArgumentException {
        if(name == null) throw new IllegalArgumentException("Nome dell'utente risulta null.");
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) throws IllegalArgumentException {
        if(surname == null) throw new IllegalArgumentException("Cognome dell'utente risulta null.");
        this.surname = surname;
    }
    public LocalDate getBirth() {
        return birth;
    }
    public void setBirth(LocalDate birth) throws IllegalArgumentException {
        if(birth == null) throw new IllegalArgumentException("Data di nascita dell'utente risulta null.");
        if(!birth.isBefore(LocalDate.now())) throw new IllegalArgumentException("Data di nascita dell'utente inserita non valida.");
        this.birth = birth;
    }
    public int getAge() {
        return Period.between(birth, LocalDate.now()).getYears();
    }
}