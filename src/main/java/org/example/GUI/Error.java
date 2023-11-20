package org.example.GUI;

import org.example.service.Repository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Error extends JFrame{
    private JPanel errorPanel;
    private JButton errorButton;
    private JLabel errorLabel;
    private Repository repository;

    public Error(Repository repository){
        this.repository = repository;

        this.setTitle("Error");                                        // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // exit out off application
        this.setResizable(false);                                      // preventing frame from being resized
        this.setSize(600, 500);                            // setting size
        this.setVisible(true);

        this.add(errorPanel);
        setUpButton();
    }

    private void setUpButton(){
        errorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == errorButton) {
                    InsertName insertData = new InsertName(repository);
                }
            }
        });
    }
}
