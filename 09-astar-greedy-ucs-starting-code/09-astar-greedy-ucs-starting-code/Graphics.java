import java.awt.Font;
import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * Write a description of class Graphics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Graphics
{
    // instance variables - replace the example below with your own
    private static Map <String, int[]> coordinates;
    
    /**
     * Constructor for objects of class Graphics
     */
    public Graphics()
    {
        start();
    }
    
    public static void start(){
        StdDraw.setCanvasSize();
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        image();
        drawTree();
        initPoints();
    }

    public static void image(){
        StdDraw.picture(50, 50, "images/fplanr.jpeg");
    }
    
    public static void drawTree(){
        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.point(50, 55);
        StdDraw.point(30, 22);
        StdDraw.point(65, 39);
        StdDraw.point(82, 37);
        StdDraw.point(75, 22);
        StdDraw.point(22, 39);
        StdDraw.point(8, 45);
        StdDraw.point(18, 47);
        StdDraw.point(22, 58);
        StdDraw.point(20, 73);
        StdDraw.point(47, 73);
        StdDraw.point(62, 73);
        StdDraw.point(77, 73);
        StdDraw.point(85, 76);
        StdDraw.point(88, 71);
        StdDraw.point(83, 71);
        StdDraw.point(88, 63);
        StdDraw.point(88, 54);
        StdDraw.point(82, 54);
    }
    
    
    public static void initPoints(){
        coordinates = new HashMap <>();
        coordinates.put("w415", new int[]{50, 55});
        coordinates.put("w420", new int[]{30, 22});
        coordinates.put("w404", new int[]{65, 39});
        coordinates.put("w405", new int[]{82, 37});
        coordinates.put("w417", new int[]{75, 22});
        coordinates.put("w403", new int[]{22, 39});
        coordinates.put("w419", new int[]{8, 45});
        coordinates.put("w418", new int[]{18, 47});
        coordinates.put("w402", new int[]{22, 58});
        coordinates.put("w401", new int[]{20, 73});
        coordinates.put("w414", new int[]{47, 73});
        coordinates.put("w413", new int[]{62, 73});
        coordinates.put("w412", new int[]{77, 73});
        coordinates.put("w411", new int[]{85, 76});
        coordinates.put("w409", new int[]{88, 71});
        coordinates.put("w410", new int[]{83, 71});
        coordinates.put("w408", new int[]{88, 63});
        coordinates.put("w406", new int[]{88, 54});
        coordinates.put("w407", new int[]{82, 54});
    }
    
    public static void drawLine(PFNode pathHead, PFNode pathEnd){
        StdDraw.setPenRadius(0.005);
        int[] pointHead = coordinates.get(pathHead.getData());
        int[] pointEnd = coordinates.get(pathEnd.getData());
        StdDraw.setPenRadius(0.005);
        StdDraw.line(pointHead[0], pointHead[1], pointEnd[0], pointEnd[1]);
        try{
            TimeUnit.MILLISECONDS.sleep(180);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
