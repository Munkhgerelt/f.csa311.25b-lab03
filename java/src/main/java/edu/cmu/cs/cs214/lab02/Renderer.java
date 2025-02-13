package edu.cmu.cs.cs214.lab02;
import edu.cmu.cs.cs214.lab02.shapes.Shape;

public final class Renderer {
    /** The shape of the renderer. */
    private final Shape shape;

    /**
     * Constructs the shape to be rendered.
     *
     * @param rendererShape the shape to be rendered
     */
    public Renderer(final Shape rendererShape) {
        this.shape = rendererShape;
    }
    /**
    * Draws the shape by printing its area to the console.
    */
    void draw() {
        double area = shape.getArea();
        System.out.println(String.format("""
                           Shape printed
                           Its area is %s""", area));
    }
}
