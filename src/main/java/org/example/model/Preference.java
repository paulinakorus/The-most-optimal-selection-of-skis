package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// import w C wstawia w danym momencie miejscu.
// import w Javie importuje klasy
public class Preference {

    public List<Ski> lskis = new ArrayList<>();                                // w ArrayList nie trzeba pisać typu w <>, bo Java się domyśla
    public Person p;
    
    public Preference(Person p) {                                               // lista została stworzona wiec nie trzeba
        this.p = p;
    }

    public Preference(List<Ski> lskis, Person p){
        for (Ski ski:lskis) {
            this.lskis.add(new Ski(ski.getLenght(), ski.getType()));
        }
        this.p = p;
    }

    public void mixSkis(){
        Collections.shuffle(this.lskis);
        //return this.lskis.get(0);
    }

    public void addSki(Ski ski){
        lskis.add(ski);
    }

    public List<Ski> getLskis() {
        return lskis;
    }

    public Ski getSki(){
        return lskis.get(0);
    }

    public Person getP() {
        return p;
    }
}


    // ArrayList - bezpośrednie przejście do elementu
    // LinkedList - przechodzi przez całą listę, aby uzyskać co chcemy

    /*
    var l = new ArrayList<Ski>();
     */