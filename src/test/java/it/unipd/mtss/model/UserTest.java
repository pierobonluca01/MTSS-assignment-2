////////////////////////////////////////////////////////////////////
// LUCA PIEROBON 2008649
// ZACCARIA MARANGON 2009111
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class UserTest {
    User user;

    @Before
    public void init() {
        System.out.print("\nINIZIO TEST");
        user = new UserImpl(10, "Name", "Surname", LocalDate.of(2001, 11, 23));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullId() {
        System.out.println(" testNullId");
        User userNull = new UserImpl(-10, "Name", "Surname", LocalDate.of(2001, 11, 23));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
        System.out.println(" testNullName");
        User userNull = new UserImpl(10, null, "Surname", LocalDate.of(2001, 11, 23));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullSurname() {
        System.out.println(" testNullSurname");
        User userNull = new UserImpl(10, "Name", null, LocalDate.of(2001, 11, 23));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullBirth() {
        System.out.println(" testNullBirth");
        User userNull = new UserImpl(10, "Name", "Surname", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidBirth() {
        System.out.println(" testInvalidBirth");
        User userNull = new UserImpl(10, "Name", "Surname", LocalDate.of(3000, 11, 23));
    }
}