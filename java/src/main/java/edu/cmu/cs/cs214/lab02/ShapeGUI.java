package edu.cmu.cs.cs214.lab02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import edu.cmu.cs.cs214.lab02.shapes.Circle;
import edu.cmu.cs.cs214.lab02.shapes.Rectangle;
import edu.cmu.cs.cs214.lab02.shapes.Shape;
import edu.cmu.cs.cs214.lab02.shapes.Square;

/**
 * The class provides a graphical user interface for selecting,
 * drawing, and computing the area of different shapes (Rectangle, Circle, or Square).
 * The class displays controls for user input, a drawing panel for rendering the shape,
 * and a label that shows the computed area.
 */
public class ShapeGUI extends JFrame {
    private ShapePanel drawingPanel;
    private JLabel areaLabel;
    private JComboBox<String> shapeSelector;
    private JTextField param1Field, param2Field;
    private JPanel inputPanel;

    /**
     * Constructs a new {@code ShapeGUI} instance and initializes the GUI components.
     */
    public ShapeGUI() {
        initializeGUI();
    }

    /**
     * Initializes the GUI by setting up the main window, control panel,
     * drawing panel, and event listeners.
     */
    private void initializeGUI() {
        setTitle("Shape Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(400, 400));

        // Setup control panel with shape selection and input fields
        JPanel controlPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        shapeSelector = new JComboBox<>(new String[]{"Rectangle", "Circle", "Square"});
        shapeSelector.addActionListener(this::shapeSelected);

        param1Field = new JTextField();
        param2Field = new JTextField();
        inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        updateInputFields("Rectangle"); // Default selection

        JButton drawButton = new JButton("Draw");
        drawButton.addActionListener(this::drawShape);

        controlPanel.add(new JLabel("Select Shape:"));
        controlPanel.add(shapeSelector);
        controlPanel.add(inputPanel);
        controlPanel.add(drawButton);

        // Setup drawing panel
        drawingPanel = new ShapePanel();
        drawingPanel.setPreferredSize(new Dimension(300, 300));
        areaLabel = new JLabel("Area: ", SwingConstants.CENTER);

        add(controlPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        add(areaLabel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Handles the action event when a new shape is selected from the combo box.
     *
     * @param e the action event triggered by the shape selection
     */
    private void shapeSelected(ActionEvent e) {
        updateInputFields((String) shapeSelector.getSelectedItem());
        revalidate();
        repaint();
    }

    /**
     * Updates the input fields based on the selected shape.
     * Rectangle: displays fields for Height and Width
     * Circle: displays a field for Radius
     * Square: displays a field for Side Length
     *
     * @param shape the selected shape type as a string
     */
    private void updateInputFields(String shape) {
        inputPanel.removeAll();
        switch (shape) {
            case "Rectangle" -> {
                inputPanel.add(new JLabel("Height:"));
                inputPanel.add(param1Field);
                inputPanel.add(new JLabel("Width:"));
                inputPanel.add(param2Field);
            }
            case "Circle" -> {
                inputPanel.add(new JLabel("Radius:"));
                inputPanel.add(param1Field);
                param2Field.setText("");
            }
            case "Square" -> {
                inputPanel.add(new JLabel("Side Length:"));
                inputPanel.add(param1Field);
                param2Field.setText("");
            }
        }
        inputPanel.revalidate();
        inputPanel.repaint();
    }

    /**
     * Handles the action event when the "Draw" button is clicked.
     * It creates the appropriate shape based on user input and updates the display.
     *
     * @param e the action event triggered by clicking the draw button
     */
    private void drawShape(ActionEvent e) {
        try {
            String shapeType = (String) shapeSelector.getSelectedItem();
            Shape shape = createShape(shapeType);
            updateDisplay(shape);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter numbers.");
        }
    }

    /**
     * Creates a shape object based on the selected shape type and user input parameters.
     *
     * @param shapeType the type of shape to create ("Rectangle", "Circle", or "Square")
     * @return the created {@code Shape} object
     * @throws NumberFormatException if the input values cannot be parsed as numbers
     */
    private Shape createShape(String shapeType) {
        double param1 = Double.parseDouble(param1Field.getText());
        double param2 = param2Field.getText().isEmpty() ? 0 : Double.parseDouble(param2Field.getText());
        return switch (shapeType) {
            case "Rectangle" -> new Rectangle(param1, param2);
            case "Circle" -> new Circle(param1);
            case "Square" -> new Square(param1);
            default -> throw new IllegalArgumentException("Unknown shape");
        };
    }

    /**
     * Updates the drawing panel and the area label with the newly created shape.
     *
     * @param shape the {@code Shape} object to display
     */
    private void updateDisplay(Shape shape) {
        drawingPanel.setShape(shape);
        areaLabel.setText(String.format("Area: %.2f", shape.getArea()));
        drawingPanel.repaint();
    }

    /**
     * A custom {@code JPanel} extension that holds and renders a {@code Shape} object.
     */
    static class ShapePanel extends JPanel {
        private Shape shape;

        /**
         * Sets the shape to be drawn on the panel.
         *
         * @param shape the {@code Shape} object to be rendered
         */
        public void setShape(Shape shape) {
            this.shape = shape;
        }

        /**
         * Paints the current shape on the panel by delegating to the shape's own
         * {@code draw} method.
         *
         * @param g the {@code Graphics} object used for painting
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (shape != null) {
                g.setColor(Color.BLUE);
                shape.draw(g, getWidth(), getHeight());
            }
        }
    }

    /**
     * The main entry point of the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShapeGUI().setVisible(true));
    }
}
