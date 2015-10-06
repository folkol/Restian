package com.github.gherkin.api.data;

/**
 * Created by niyohn on 10/6/15.
 */
public class Person extends Data {

    private String name;

    public Person() {

    }

    public Person(Long id, String name) {

        this.id = id;
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
