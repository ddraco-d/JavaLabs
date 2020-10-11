package com.company.Lab10;

import javax.swing.*;
import java.awt.*;

public class MySwingApp extends JFrame {
    private int clickCount = 0;
    public MySwingApp(){
        setTitle("My swing app!!!");
        setSize(500, 500);

        JLabel label = new JLabel("Enter First operand");
        JLabel label1 = new JLabel("Enter Second operand");
        JLabel label2 = new JLabel("Result");
        JTextField firstoperandfield = new JTextField();
        JTextField secondoperandfield = new JTextField();
//        field.addCaretListener(action -> {
//            try {
//                int value = Integer.parseInt(field.getText());
//                label.setText("" + ++value);
//            } catch (Exception ex) {
//                label.setText(ex.getMessage());
//            }
//
//        });
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiplacation = new JButton("*");
        JButton division = new JButton("/");
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


        GridLayout layout = new GridLayout(3, 5);
        panel.add(label);
        panel.add(firstoperandfield);
        panel.setLayout(layout);


        JPanel secondPanel = new JPanel();
        secondPanel.add(label1);
        secondPanel.add(secondoperandfield);
        secondPanel.setLayout(layout);


        JPanel ThirdPanel = new JPanel();
        ThirdPanel.setLayout(layout);
        ThirdPanel.add(plus);
        ThirdPanel.add(minus);
        ThirdPanel.add(division);
        ThirdPanel.add(multiplacation);


        JPanel FourthPanel = new JPanel();
        FourthPanel.add(label2);
        FourthPanel.setLayout(layout);


        panel.add(secondPanel);
        panel.add(ThirdPanel);
        panel.add(FourthPanel);
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
