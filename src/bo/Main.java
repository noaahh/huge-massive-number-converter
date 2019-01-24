package bo;

import java.awt.EventQueue;

import ui.ConverterInterface;

public class Main {

    public static void main(String[] args) {
    	EventQueue.invokeLater(() -> { new ConverterInterface().setVisible(true); });
    }
}
