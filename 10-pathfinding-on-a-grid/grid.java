
/**
 * Write a description of class grid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class grid
{
    // instance variables - replace the example below with your own
     private static final int [][] map = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,1,1,1,1,1,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0},
            {0,0,0,0,1,1,0,0,0,0,0,1,1,1,1,0},
            {0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}}; 
    private static int[] start = new int [] {1, 1};
    private static int[] goal = new int [] {12, 15};
            
    public grid()
    {
      
    }
    
    
    public static int [][] getMap(){
        return map;
    }
    
    public static int getSR(){
        return start[0];
    }
    
    public static int getSC(){
        return start[1];
    }
    
    public static int getGR(){
        return goal[0];
    }
    
    public static int getGC(){
        return goal[1];
    }

}
