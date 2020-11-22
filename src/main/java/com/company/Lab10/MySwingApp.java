package com.company.Lab10;

import javax.swing.*;
import java.awt.*;

public class MySwingApp extends JFrame {
    private int clickCount = 0;
    public MySwingApp(){
        setTitle("My swing app!!!");
        setSize(350, 350);

        JLabel label = new JLabel("Enter First operand");
        JLabel label1 = new JLabel("Enter Second operand");
        JLabel label2 = new JLabel("Result");
        JTextField firstoperandfield = new JTextField();
        JTextField secondoperandfield = new JTextField();
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiplacation = new JButton("*");
        JButton division = new JButton("/");

        label.setHorizontalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);


        plus.addActionListener(action -> {
            try {
                int operand = Integer.parseInt(firstoperandfield.getText());
                int rez = operand + Integer.parseInt(secondoperandfield.getText());
                label2.setText(rez + "");
            } catch (Exception ex) {
                label2.setText("error");
            }
        });

        minus.addActionListener(action -> {
            try {
                int operand = Integer.parseInt(firstoperandfield.getText());
                int rez = operand - Integer.parseInt(secondoperandfield.getText());
                label2.setText(rez + "");
            } catch (Exception ex) {
                label2.setText(ex.getMessage());
            }
        });

        division.addActionListener(action -> {
            try {
                double operand = Double.parseDouble(firstoperandfield.getText());
                double rez = operand / Double.parseDouble(secondoperandfield.getText());
                label2.setText(rez + "");
            } catch (Exception ex) {
                label2.setText(ex.getMessage());
            }
        });

        multiplacation.addActionListener(action -> {
            try {
                double operand = Double.parseDouble(firstoperandfield.getText());
                double rez = operand * Double.parseDouble(secondoperandfield.getText());
                label2.setText(rez + "");
            } catch (Exception ex) {
                label2.setText(ex.getMessage());
            }
        });

        JPanel panel = new JPanel();
        JPanel secondPanel = new JPanel();

        secondPanel.add(plus);
        secondPanel.add(minus);
        secondPanel.add(division);
        secondPanel.add(multiplacation);

        panel.setLayout(new GridLayout(6, 1));
        panel.add(label);
        panel.add(firstoperandfield);


        panel.add(label1);
        panel.add(secondoperandfield);
        panel.add(label2);
        panel.add(secondPanel);
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
