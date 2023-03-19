package geoTreeResearch;

import geoTreeResearch.Interface.Printable;

import java.util.ArrayList;
import java.util.List;

public class Family implements Printable {

    private Person person;
    private List<Person> family;

    public Family(Person person) {
        this.person = person;
        this.family = new ArrayList<>();
    }

    public Person getPerson() {
        return person;
    }

    public List<Person> getFamily() {
        return family;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setFamily(List<Person> family) {
        this.family = family;
    }

    public void addToFamily(Person person) {
        if (!person.equals(this.person) && person != null) {
            this.family.add(person);
        } else {
            System.out.printf("%s не может быть добавлен в семью человека %s.", person.getName(), this.person.getName());
        }
    }

    @Override
    public void print() {
        for (Person pr : this.family) {
            pr.print();
        }
    }
}

