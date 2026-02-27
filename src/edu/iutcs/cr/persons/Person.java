package edu.iutcs.cr.persons;

import java.io.Serializable;
import java.util.Objects;
import edu.iutcs.cr.controller.ConsoleHelper;

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
        this.name = ConsoleHelper.readMandatoryLine("name");
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = ConsoleHelper.readMandatoryLine("id");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = ConsoleHelper.readMandatoryLine("email");
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
