package geoTreeResearch;

import geoTreeResearch.Comparator.PersonAgeComparator;
import geoTreeResearch.Comparator.PersonNameComparator;
import geoTreeResearch.Interface.Printable;

import java.util.ArrayList;

enum SortType {
    name,
    age
}

public class Result implements Printable {

    private ArrayList<Person> result;

    public Result(GeoTree tree, Person p, Relationship re) {
        System.out.printf("%s - это %s для: \n", p.getName(), re);
        this.result = new Research(tree).spendRelationships(p, re);
    }

    public Result(GeoTree tree, Person.Gender gender) {
        System.out.printf("Выводим всех %s: \n", gender);
        this.result = new Research(tree).spendGender(gender);
    }

    public void sorting(SortType sortType) {
        if (sortType == SortType.name) this.result.sort(new PersonNameComparator());
        else if (sortType == SortType.age) this.result.sort(new PersonAgeComparator());
        }

    @Override
    public void print() {
        System.out.println(this.result);
    }

    public void printWithSorting(SortType sortType){
        sorting(sortType);
        print();
    }
}
