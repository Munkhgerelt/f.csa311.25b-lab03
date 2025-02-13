package edu.cmu.cs.cs214.lab02.shapes;
import java.awt.Graphics;

public class Circle implements Shape {
    /** The radius of the circle. */
    private final double radius;

    /**
     * Constructs a circle with the specified radius.
     *
     * @param circleRadius the radius of the circle
     */
    public Circle(final double circleRadius) {
        this.radius = circleRadius;
    }

    /**
     * Calculates and returns the area of the circle.
     *
     * @return the area of the circle as a double
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Getters for GUI.
     *
     * @return the radius of the circle as a double.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Draws the circle on the panel.
     *
     * @param g the Graphics object used for drawing
     * @param panelWidth the width of the panel
     * @param panelHeight the height of the panel
     */
    @Override
    public void draw(Graphics g, int panelWidth, int panelHeight) {
        int radiusPixels = (int) (radius * 20);
        int diameter = radiusPixels * 2;
        int x = (panelWidth - diameter) / 2;
        int y = (panelHeight - diameter) / 2;
        g.drawOval(x, y, diameter, diameter);
    }
}
