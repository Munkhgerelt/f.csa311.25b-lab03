package edu.cmu.cs.cs214.lab02;

import javax.swing.SwingUtilities;

/** The Main class serves as the entry point for the application. */
final class Main {
    /**
     * Private constructor to prevent instantiation.
     *
     * @throws UnsupportedOperationException if instantiated.
     */
    private Main() {
        throw new UnsupportedOperationException("Utility class");
    }

    /** The main method initializes the GUI. */
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new ShapeGUI().setVisible(true));
    }
}
