package edu.iutcs.cr.persons;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;
import edu.iutcs.cr.menu.MenuHelper;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Person implements Serializable {

    private String name;
    private String id;
    private String email;

    public Person() {
        setName();
        setId();
        setEmail();
    }

    public Person(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        Scanner scanner = new Scanner(System.in);
        this.name = MenuHelper.readMandatoryLine(scanner, "name");
    }

    public String getId() {
        return id;
    }

    public void setId() {
        Scanner scanner = new Scanner(System.in);
        this.id = MenuHelper.readMandatoryLine(scanner, "id");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        Scanner scanner = new Scanner(System.in);
        this.email = MenuHelper.readMandatoryLine(scanner, "email");
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person person))
            return false;

        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
