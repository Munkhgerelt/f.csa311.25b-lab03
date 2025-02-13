package edu.cmu.cs.cs214.lab02.shapes;
import java.awt.Graphics;

/**
 * An interface representing a geometric shape.
 */
public interface Shape {
    /**
     * Calculates and returns the area of ​​the shapes.
     *
     * @return the area of the shape as a double
     */
    double getArea();

    /**
     * Draws the shape using the provided Graphics object.
     *
     * @param g the Graphics object used for drawing
     * @param panelWidth the width of the panel
     * @param panelHeight the height of the panel
     */
    void draw(Graphics g, int panelWidth, int panelHeight);
}
