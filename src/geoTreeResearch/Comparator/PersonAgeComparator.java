package geoTreeResearch.Comparator;

import geoTreeResearch.Person;
import humanAndPet.Pet;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}
