package org.example.model;

public class Person {
    private int id;
    private PersonKind kind;

    public Person(int id, PersonKind kind) {
        this.id = id;
        this.kind = kind;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonKind getKind() {
        return kind;
    }

    public void setKind(PersonKind kind) {
        this.kind = kind;
    }
}
