package org.example;

import org.example.GUI.MainForm;
import org.example.service.EquipmentGenerator;
import org.example.service.PreferencesGenerator;

import java.io.FileNotFoundException;
import java.util.Scanner;

// wskazywać tylko klasy, które potrzebujemy

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        final PreferencesGenerator preferenceFile = new PreferencesGenerator();
        final EquipmentGenerator listFile = new EquipmentGenerator();
        MainForm mainForm = new MainForm(preferenceFile, listFile);

        /*System.out.println("Zadanie optymalizacyjne");

        System.out.println("\nGenerowanie plików");
        System.out.print("   Preferences\n\tname of file: ");                               // creating file of preferences

        final PreferencesGenerator preferenceFile = new PreferencesGenerator();
        //preferenceFile.setName(input.nextLine());

        System.out.print("\tnumber: ");                                 // taking away everything what left after nextInt(), changing position of cursor
        preferenceFile.setNumber_of_people(input.nextInt());
        preferenceFile.generator();

        input.nextLine();

        System.out.print("\n   List of the equipment\n\tname of file: ");                   // creating file of the available equipment
        final EquipmentGenerator listFile = new EquipmentGenerator();
        //listFile.setName(input.nextLine());

        System.out.print("\tnumber: ");
        listFile.setNumTypes(input.nextInt());
        listFile.generator();
        input.close();

        Repository repository = new Repository(preferenceFile, listFile);
        //
        GenerateMatches matches = new GenerateMatches(repository);
        matches.generating();
        List<Result> resultsList = matches.getBestList();
        TotalResult result = matches.getBestResult();
        */
    }
}








/*      Ski s = new Ski(10, "carving");
        // rekord dostarcza funckje lenght, type
        Object o;
        /
            List <Pozycja> l = new ArrayList<Pozycja>();
        /
        Preference p = new Preference(new Person(1, PersonKind.A));
        //p.lskis.add(new Ski(140, "caving"));
        p.addSki(new Ski(140, "caving"));
        String line = "1,J,slalom:140;gigant:150";
        String[] tabs = line.split(",");
        String[] tabs2 = tabs[2].split(";");
        String[] tabs3;
        for (String cos : tabs2) {                      // foreach jest bardziej wydajny od for w przypadku LinkedList
            tabs3 = cos.split(":");
        }

        List<Preference> lp = new ArrayList<>();
*/