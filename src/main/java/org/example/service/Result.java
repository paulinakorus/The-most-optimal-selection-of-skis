package org.example.service;

import org.example.model.PersonKind;
import org.example.model.Ski;

public class Result {
    private int id;
    private PersonKind kind;
    private Ski ski;
    private double score;
    public Result(){
        this(0, null, null, 0.0);
    }
    public Result(int id, PersonKind kind, Ski ski, double score){
        this.id = id;
        this.kind = kind;
        this.ski = ski;
        this.score = score;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setKind(PersonKind kind) {
        this.kind = kind;
    }

    public void setSki(Ski ski) {
        this.ski = ski;
    }

    public int getId() {
        return id;
    }

    public PersonKind getKind() {
        return kind;
    }

    public Ski getSki() {
        return ski;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
