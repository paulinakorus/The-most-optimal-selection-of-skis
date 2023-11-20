package org.example.GUI;

import org.example.service.Repository;
import org.example.service.Result;
import org.example.service.TotalResult;
import org.example.generating.GenerateMatches;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

public class InsertName extends JFrame{
    private JPanel insertNames;
    private JLabel insertLabel;
    private JTextField prefField;
    private JTextField equipField;
    private JButton insertButton;
    private JLabel prefFile;
    private JLabel equipFile;
    private JSlider accyrencySlider;
    private JLabel accurencyLabel;
    private Repository repository;
    private int iterations;

    public InsertName(Repository repository){
        this.repository = repository;

        this.setTitle("Optimization task");                            // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // exit out off application
        this.setResizable(false);                                      // preventing frame from being resized
        this.setSize(600, 500);                            // setting size
        this.setVisible(true);                                         // making frame visible

        this.add(insertNames);
        setUpButton();
    }
    private void setUpButton(){
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==insertButton){
                    try {
                        repository.prefReader(prefField.getText());
                        repository.eqiupReader(equipField.getText());
                        System.out.println("Files have been read");

                        iterations = accyrencySlider.getValue();
                        System.out.println("Number of iterations has been taken");

                        GenerateMatches matches = new GenerateMatches(repository, iterations);
                        matches.generating();
                        System.out.println("Generating answers");

                        List<Result> resultsList = matches.getBestList();
                        TotalResult result = matches.getBestResult();
                        System.out.println("Getting results");

                        Scores resultFrame = new Scores(result, resultsList);
                        System.out.println("Creating results frame");
                    } catch (FileNotFoundException ex) {
                        Error error = new Error(repository);
                    }
                }
            }
        });
    }
}
