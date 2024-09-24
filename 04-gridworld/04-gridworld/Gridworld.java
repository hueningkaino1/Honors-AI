import java.util.concurrent.TimeUnit;

/**
 * Write a description of class Environment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gridworld
{
    private int x;
    private int y;
    
    public Gridworld(){
       x = Agent.getInstance().locX();
       y = Agent.getInstance().locY();
    }
    
    // your grid (2d array with your map) goes here.
    public void map(){
        int row =0;
        int col =0;
        int [][] grid = Agent.getInstance().getGrid(); 
        for (int number [] : grid) {
            for (int num: number){
                if (num == 1){
                    StdDraw.setPenRadius(0.0035);
                    StdDraw.filledSquare(row+2,col+4,0.5);
                }
                else if (num ==0){
                    StdDraw.setPenRadius(0.0005);
                    StdDraw.square(row+2,col+4,0.5);
                }
                row++;
            }
            row = 0;
            col++;
        }
        StdDraw.show();
    }
    
    public void objMov(){
        x = Agent.getInstance().locX();
        y = Agent.getInstance().locY();
        StdDraw.picture(x+2, y+4, "images/jakebgr.png");
        StdDraw.show();
        System.out.println(x +" "+ y);
    }
    

    // code for your Gridworld
    public void start(){
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize();
        StdDraw.setXscale(0,20);
        StdDraw.setYscale(0,20);
        while (true){
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch (InterruptedException ie){
                ie.printStackTrace();
            }
            map();
            objMov();
            Agent.getInstance().sense();
            Agent.getInstance().decide();
            Agent.getInstance().act();
        }
    }
        
    
    // Add methods that the agent will use.
    
    
    
}