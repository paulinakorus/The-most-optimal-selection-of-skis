package org.example.service;

import org.example.model.Ski;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EquipmentGenerator {
    private String name = "wykaz.txt";
    private int numTypes;
    private PrintWriter inputFile;
    private Random rand;
    private String [] typeSkis = {"gigant", "allmountain", "carving", "slalom", "race"};
    private List<Ski> listSkis = new ArrayList<>();

    public EquipmentGenerator(){
        this(0);
    }

    public EquipmentGenerator(int numTypes){
        this.name = name;
        this.numTypes = numTypes;
    }
    /*public EquipmentGenerator(String name, int numTypes){
        this.name = name;
        this.numTypes = numTypes;
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
        Ski ski;
        int quantity = 0;

        inputFile.println("quantity,ski");
        while (numTypes!=0){
            ski = new Ski((rand.nextInt(12)+24)*5, typeSkis[rand.nextInt(5)]);
            for (Ski skis:listSkis) {
                if(skis.getLenght()!=ski.getLenght() && skis.getType()!=ski.getType()){
                    miniGenerator(ski, quantity);
                    break;
                }
            }
            if(listSkis.isEmpty()){
                miniGenerator(ski, quantity);
            }
        }
        inputFile.close();
    }

    private void miniGenerator(Ski ski, int quantity){
        this.listSkis.add(ski);

        quantity = rand.nextInt(5)+1;
        inputFile.print(quantity + "," + ski.getType() + ":" + ski.getLenght() + "\n");
        numTypes--;
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

    public int getNumTypes() {
        return numTypes;
    }

    public void setNumTypes(int numTypes) {
        this.numTypes = numTypes;
    }
}
