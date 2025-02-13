
package edu.cmu.cs.cs214.lab02.shapes;
import java.awt.Graphics;

public final class Rectangle implements Shape {
    /** The height of the rectangle. */
    private final double height;

    /** The width of the rectangle. */
    private final double width;

    /**
     * Constructs a rectangle with the specified height and width.
     *
     * @param rectHeight the height of the rectangle
     * @param rectWidth the width of the rectangle
     */
    public Rectangle(final double rectHeight, final double rectWidth) {
        this.height = rectHeight;
        this.width = rectWidth;
    }

    /**
     * Calculates and returns the area of the rectangle.
     *
     * @return the area of the rectangle as a double
     */
    @Override
    public double getArea() {
        return height * width;
    }

    /**
     * Getters for GUI.
     *
     * @return the height of the rectangle as a double.
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return the width of the rectangle as a double.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Draws the rectangle on the panel.
     *
     * @param g the Graphics object used for drawing
     * @param panelWidth the width of the panel
     * @param panelHeight the height of the panel
     */
    @Override
    public void draw(Graphics g, int panelWidth, int panelHeight) {
        int shapeWidth = (int) (width * 20);
        int shapeHeight = (int) (height * 20);
        int x = (panelWidth - shapeWidth) / 2;
        int y = (panelHeight - shapeHeight) / 2;
        g.drawRect(x, y, shapeWidth, shapeHeight);
    }
}
