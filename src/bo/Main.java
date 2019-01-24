package bo;

import ui.ConverterInterface;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ConverterInterface().setVisible(true);
        });
    }
}
