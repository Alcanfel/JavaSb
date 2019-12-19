package Task20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Scanner;

public class User {

    private String firstName;
    private String lastName;
    private Integer tabNumber;
    private Number session;

    public User(String firstName, String lastName, Integer tabNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tabNumber = tabNumber;
        this.session = generateNumber();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getTabNumber() {
        return tabNumber;
    }

    public Number getSession() {
        return session;
    }

    @Override
    public String toString() {
        return firstName + "." + lastName + "." + tabNumber + "." + session;
    }

    private Integer generateNumber() {
        return (int) (Math.random() * 100000);
    }
}
