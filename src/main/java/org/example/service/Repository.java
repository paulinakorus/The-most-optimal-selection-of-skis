package org.example.service;

import org.example.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Repository {
    private final List<Preference> lPrefe = new ArrayList<>();
    private final List<Equipment> lEquip = new ArrayList<>();
    private PreferencesGenerator preferenceFile;
    private EquipmentGenerator listFile;
    private String firstLine;
    private String line;
    private String prefTab[];
    private String equipTab[];
    private String skiTab[];
    private String ski[];
    private Preference pref;
    private Repository repository;

    public Repository(){
        this(null, null);
    }
    public Repository(PreferencesGenerator preferenceFile, EquipmentGenerator listFile){
        this.preferenceFile = preferenceFile;
        this.listFile = listFile;
    }

    public Repository(Repository repository, List<Preference> lPrefe, List<Equipment> lEquip){
        this(repository.getPreferenceFile(), repository.getListFile());

        for (Preference preference : lPrefe) {
            Person preferencePerson = preference.getP();
            this.lPrefe.add(new Preference(preference.getLskis(), new Person(preferencePerson.getId(), preferencePerson.getKind())));
        }
        for (Equipment equipment : lEquip) {
            Ski equipmentSki = equipment.getSki();
            this.lEquip.add(new Equipment(equipment.getQuantity(), new Ski(equipmentSki.getLenght(), equipmentSki.getType())));
        }
    }

    public List<Preference> prefReader(String name) throws FileNotFoundException {
        final Scanner prefReader = new Scanner(new File(checkTXT(name)));
        firstLine = prefReader.nextLine();

        while(prefReader.hasNextLine()) {
            line = prefReader.nextLine();
            prefTab = line.split(",");
            skiTab = prefTab[2].split(";");

            pref = new Preference(new Person(parseInt(prefTab[0]), PersonKind.readPersonKind(prefTab[1])));
            for (String splitted : skiTab) {
                ski = splitted.split(":");
                pref.addSki(new Ski(parseInt(ski[1]), ski[0]));
            }
            lPrefe.add(pref);
        }
        return lPrefe;
    }

    public List<Equipment> eqiupReader(String name) throws FileNotFoundException {
        final Scanner equipReader = new Scanner(new File(checkTXT(name)));
        firstLine = equipReader.nextLine();

        while (equipReader.hasNextLine()){
            line = equipReader.nextLine();
            equipTab = line.split(",");
            skiTab = equipTab[1].split(":");

            lEquip.add(new Equipment(parseInt(equipTab[0]), new Ski(parseInt(skiTab[1]), skiTab[0])));
        }
        return lEquip;
    }

    public String checkTXT(String name){
        if(!name.contains(".txt"))
            return name = name + ".txt";
        return name;
    }
    public void mixLPrefe(){
        Collections.shuffle(this.lPrefe);
    }

    public void mixLEquip(){
        Collections.shuffle(this.lEquip);
    }

    public PreferencesGenerator getPreferenceFile() {
        return preferenceFile;
    }

    public EquipmentGenerator getListFile() {
        return listFile;
    }

    public List<Preference> getlPrefe() {
        return lPrefe;
    }

    public List<Equipment> getlEquip() {
        return lEquip;
    }


}
