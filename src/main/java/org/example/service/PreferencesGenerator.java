package org.example.service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class PreferencesGenerator{
    private String name = "preferences.txt";
    private int number_of_people;
    private PrintWriter inputFile;
    private Random rand;
    private String [] group = {"C", "J", "A"};
    private String [] typeSkis = {"gigant", "allmountain", "carving", "slalom", "race"};

    public PreferencesGenerator(){
        this(0);
    }

    public PreferencesGenerator(int number_of_people){
        this.number_of_people = number_of_people;
    }

    /*public PreferencesGenerator(String name, int number_of_people){
        this.name = name;
        this.number_of_people = number_of_people;
    }*/

    public void makingFile() {
        try {
            this.inputFile = new PrintWriter(this.name);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void generator(){
        makingFile();
        this.rand = new Random();
        int skisNum;

        inputFile.println("id,group,skis");
        for(int i=1; i <= this.number_of_people; i++){
            inputFile.print(i + ",");                                                                                   // id
            inputFile.print(group[rand.nextInt(3)] + ",");                                                       // group

            skisNum = rand.nextInt(2)+1;
            while (skisNum != 0){
                inputFile.print(typeSkis[rand.nextInt(5)] + ":");                                                 // type of skis
                inputFile.print((rand.nextInt(12)+24)*5);                                                         // lenght of skis
                skisNum--;
                if (skisNum == 1)
                    inputFile.print(";");
            }
            inputFile.print("\n");
        }
        inputFile.close();
    }

    public void checkTXT(){
        if(!this.name.contains(".txt"))
            System.out.println(name);
            this.name = this.name + ".txt";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        checkTXT();
    }

    public int getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(int number_of_people) {
        this.number_of_people = number_of_people;
    }
}
