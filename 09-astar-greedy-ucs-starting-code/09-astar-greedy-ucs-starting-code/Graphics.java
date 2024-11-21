import java.awt.Font;

/**
 * Write a description of class Graphics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Graphics
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Graphics
     */
    public Graphics()
    {
        start();
    }
    
    public void start(){
        StdDraw.setCanvasSize();
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        image();
        drawTree();
    }

    public void image(){
        StdDraw.picture(50, 50, "images/fplanr.jpeg");
    }
    
    public void drawTree(){
        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.point(50, 55);
        StdDraw.point(30, 22);
        StdDraw.point(65, 39);
        
    }
}
