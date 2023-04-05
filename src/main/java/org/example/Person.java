package org.example;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected String city;
    protected int age = -1;

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setAddress(String city) {
        this.city = city;
    }


    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }


    public String toString() {
        if (hasAge() && hasAddress()) {

            return "Person{ " + surname + " " + name + " " + age + " " + city + "}";
        }
        if (!hasAge() && hasAddress()) {
            return "Person{ " + surname + " " + name + " " + city + "}";
        }
        if (hasAge() && !hasAddress()) {
            return "Person{ " + surname + " " + name + " " + age + "}";
        } else {
            return "Person{ " + surname + " " + name + "}";
        }
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public boolean hasAge() {
        if (age != -1) {
            return true;
        }
        return false;
    }

    public boolean hasAddress() {
        if (city != null) {
            return true;
        }
        return false;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(getSurname())

                .setAddress(getCity())
                .setName(name);
    }
}

