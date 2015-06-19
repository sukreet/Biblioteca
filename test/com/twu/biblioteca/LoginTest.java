package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class LoginTest {

    private ArrayList<User> userList = new ArrayList<>();

    @Before
    public void setup() {
        userList.add(new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false));
        userList.add(new User("Name", "000-0000", "930127876", "as1@gmail.com", "password", true));
    }

    @Test
    public void shouldReturnNullWhenInvalidCredentialsIsPassed() {
        Login login = new Login(userList);

        User authorisedUser = login.authoriseUser("121-2222", "pas");

        assertNull(authorisedUser);
    }

    @Test
    public void shouldReturnCorrectUserWhenValidCredentialsIsPassed() {
        Login login = new Login(userList);

        User authorisedUser = login.authoriseUser("111-1111", "password");
        User expectedUser = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        assertThat(authorisedUser, is(expectedUser));
    }
}
