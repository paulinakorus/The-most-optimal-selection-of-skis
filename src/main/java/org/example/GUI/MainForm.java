package org.example.GUI;

import org.example.service.EquipmentGenerator;
import org.example.service.PreferencesGenerator;
import org.example.service.Repository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class MainForm extends JFrame{
    private JPanel GeneretingFiles;
    private JButton preferencesButton;
    private JButton equipmentButton;
    private JLabel prefText;
    private JTextField preferencesTextField;
    private JTextField equipmentTextField;
    private JButton endButton;

    private PreferencesGenerator preferenceFile;
    private EquipmentGenerator listFile;
    public MainForm (PreferencesGenerator preferenceFile, EquipmentGenerator listFile){
        this.preferenceFile = preferenceFile;
        this.listFile = listFile;
        this.setTitle("Optimization task");                            // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // exit out off application
        this.setResizable(false);                                      // preventing frame from being resized
        this.setSize(600, 500);                            // setting size
        this.setVisible(true);                                         // making frame visible
        //this.getContentPane().setBackground(new Color(224,255,255));

        this.add(GeneretingFiles);
        setUpButtons();

    }

    private void setUpButtons(){
        preferencesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==preferencesButton){
                    MainForm.this.preferenceFile = new PreferencesGenerator();
                    MainForm.this.preferenceFile.setNumber_of_people(parseInt(preferencesTextField.getText()));
                    MainForm.this.preferenceFile.generator();
                    System.out.println("Preference file generated");
                }
            }
        });

        equipmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==equipmentButton){
                    MainForm.this.listFile = new EquipmentGenerator();
                    MainForm.this.listFile.setNumTypes(parseInt(equipmentTextField.getText()));
                    MainForm.this.listFile.generator();
                    System.out.println("Equipment file generated");
                }
            }
        });

        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==endButton){
                    Repository repository = new Repository(preferenceFile, MainForm.this.listFile);
                    InsertName insertName = new InsertName(repository);
                }
            }
        });
    }
    public PreferencesGenerator getPreferenceFile() {
        return preferenceFile;
    }

    public void setPreferenceFile(PreferencesGenerator preferenceFile) {
        this.preferenceFile = preferenceFile;
    }

    public EquipmentGenerator getListFile() {
        return listFile;
    }

    public void setListFile(EquipmentGenerator listFile) {
        this.listFile = listFile;
    }
}







// https://www.youtube.com/watch?v=Kmgo00avvEw

/*
        JLabel generating = new JLabel();
        generating.setText("Generating files");
        generating.setHorizontalTextPosition(JLabel.CENTER);            // setting label on the middle
        generating.setVerticalTextPosition(JLabel.TOP);                 // setting label on the top
        generating.setForeground(new Color(0,0,0));

 */