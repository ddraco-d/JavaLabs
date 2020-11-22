package com.company.Lab10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MySwingApp app = new MySwingApp();
            app.setVisible(true);
        });
    }
}
