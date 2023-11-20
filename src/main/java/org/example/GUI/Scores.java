package org.example.GUI;

import org.example.service.Result;
import org.example.service.TotalResult;

import javax.swing.*;
import java.util.List;

public class Scores extends JFrame {
    private JPanel resultsPanel;
    private JTable resultsTable;
    private JLabel resultsLabel;
    private JLabel scoreLabel;
    private JLabel notServedLabel;

    private List<Result> resultsList;
    private TotalResult result;
    private MatchTable matchTableModel;

    public Scores(TotalResult result, List<Result> resultsList){
        this.result = result;
        this.resultsList = resultsList;

        this.setTitle("Results");                            // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // exit out off application
        this.setResizable(false);                                      // preventing frame from being resized
        this.setSize(600, 500);                            // setting size
        this.setVisible(true);                                         // making frame visible

        this.add(resultsPanel);
        setUpTable();
        setUpLabels();
    }

    private void setUpLabels(){
        scoreLabel.setText(String.format("Total score: " + Math.round(result.getResult()*100)/100.0));
        notServedLabel.setText(String.format("Unserved people: " + result.getNotServed()));
    }

    private void setUpTable(){
        matchTableModel = new MatchTable(resultsList);
        resultsTable.setModel(matchTableModel);
        resultsTable.setAutoCreateRowSorter(false);
    }
}
