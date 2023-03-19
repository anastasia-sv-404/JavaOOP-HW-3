package geoTreeResearch;

import geoTreeResearch.Interface.Printable;

import java.util.Objects;
import java.util.Random;


public class Person implements Printable{
    private String name;
    private int age;

    enum Gender {
        man, woman
    }

    private Gender gender;

    /**
     * Общий конструктор для класса.
     *
     * @param name   - имя
     * @param gender - пол
     * @param age    - возраст
     */
    public Person(String name, Gender gender, int age) {
        Random random = new Random();
        this.name = name;
        this.gender = gender;
        if (age < 0 || age > 123) {
            this.age = random.nextInt(1, 123);
        } else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person: " +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", gender = " + gender;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return person.name.equals(this.name) && person.age == this.age
                && person.gender.equals(this.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
