package edu.cmu.cs.cs214.lab02.shapes;
import java.awt.Graphics;

public class Square implements Shape {
    /** The side of the square. */
    private final double sideLength;

    /**
     * Constructs a square with the specified side length.
     *
     * @param squareSideLength the side length of the square.
     */
    public Square(final double squareSideLength) {
        this.sideLength = squareSideLength;
    }

    /**
     * Calculates and returns the area of the square.
     *
     * @return the area of the square as a double
     */
    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    /**
     * Getters for GUI.
     *
     * @return the side length of the square as a double.
     */
    public double getSideLen() {
        return sideLength;
    }

    /**
     * Draws the square on the panel.
     *
     * @param g the Graphics object used for drawing
     * @param panelWidth the width of the panel
     * @param panelHeight the height of the panel
     */
    @Override
    public void draw(Graphics g, int panelWidth, int panelHeight) {
        int sidePixels = (int) (sideLength * 20);
        int x = (panelWidth - sidePixels) / 2;
        int y = (panelHeight - sidePixels) / 2;
        g.drawRect(x, y, sidePixels, sidePixels);
    }
}