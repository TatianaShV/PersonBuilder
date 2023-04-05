package org.example;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected String city;
    protected int age = -1;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Некорректный возраст");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        Person person;
        if (name == null) {
            throw new IllegalStateException("Не хватает обязательных полей");
        }
        if (surname == null) {
            throw new IllegalStateException("Не хватает обязательных полей");
        }
        if (age > -1) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        if (city != null) {
            person.setAddress(city);
        }
        return person;
    }


}
