import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.Font;
import java.awt.Container;

/**
 * Write a description of class grid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class grid
{
    // instance variables - replace the example below with your own
    /*private static final int [][] map = {
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
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}}; */
    private static int[] start = new int [] {1, 1};
    private static int[] goal = new int [] {12, 15};
    
    private static int count;
    private static int size;
    private static int [][] cells;
    private static boolean starter;
    private static int [][] placer ;
    private static int click_count = 0;
    private static int SIZE = 30;
            
    public grid()
    {
        count = 0;
        size = 0;
        cells = new int[30][30];
        starter = true;
        placer = new int [30][30];
    }
    
    
    public static int [][] getMap(){
        return cells;
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
    
    
    public static void drawGrid(int sizes){
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i< size; i++){
            for (int j = 0; j<size;j++){
                StdDraw.square(i+0.5, j+0.5, 0.5);
                cells [i][j] = 0;
                count++;
            }
        }
        StdDraw.setPenColor(StdDraw.BLUE);
        cells[start[0]][start[1]] = 0;
        StdDraw.filledSquare(start[0]+0.5, start[1]+0.5, 0.5);
        StdDraw.setPenColor(StdDraw.PINK);
        cells[goal[0]][goal[1]] = 0;
        StdDraw.filledSquare(goal[0]+0.5, goal[1]+0.5, 0.5);
    }
    
    
    public static void fill(){
        try{
            TimeUnit.MILLISECONDS.sleep(100);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
        for (int i = 0; i< size; i++){
            for (int j = 0; j<size;j++){
                if(placer[i][j]==1){
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(i+0.5,j+0.5,0.5);
                }else{
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(i+0.5,j+0.5,0.5);
                }
            }
        }
        drawGrid(size);
        StdDraw.show();
    }
    
    
    public static void getCount(){
        System.out.println(count);
    }
    
    public static boolean inter(){
        double x = 0;
        int a = 0;
        double y = 0;
        int b = 0;
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledRectangle(1.5,-1.5,2,1);
        //**StdDraw.setPenColor(StdDraw.PINK);
        //**StdDraw.filledRectangle(6.5,-1.5,2,1);
        Font font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.WHITE);
        //**change text
        StdDraw.text(1.5, -1.75, "Path");
        //**StdDraw.text(6.5, -1.75, "Pause");
        StdDraw.show();
        if (StdDraw.isMousePressed()){
            x = StdDraw.mouseX();
            y = StdDraw.mouseY();
            a = (int)x;
            b = (int)y;
            if(!(a<0)&&!(b<0)&&!(a>=size)&&!(b>=size)){
                if (placer[a][b]==0){
                placer[a][b]=1;
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(a+0.5,b+0.5,0.5);
                try{
                    TimeUnit.MILLISECONDS.sleep(150);
                }
                catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                
                }else if (placer[a][b]==1){
                    placer[a][b]=0;
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(a+0.5,b+0.5,0.5);
                    try{
                        TimeUnit.MILLISECONDS.sleep(150);
                    }
                    catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
            else{
                if (StdDraw.mouseX()>0 && StdDraw.mouseX()<4 && StdDraw.mouseY()>-2 && StdDraw.mouseY()<0){
                    StdDraw.setMouseIsPressed(false);
                    saveCells();
                    Pathfinding pf = new Pathfinding();
                    pf.start();
                    //**add draw path
                    drawPath(pf);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void saveCells(){
        for (int i = 0; i<SIZE; i++){
            for (int j = 0; j<SIZE; j++){
                cells[i][j] = placer [i][j];
            }
        }
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledSquare(start[0]+0.5, start[1]+0.5, 0.5);
        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.filledSquare(goal[0]+0.5, goal[1]+0.5, 0.5);
    }
    
    
    public static void start() {
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize();
        StdDraw.setXscale(-2.5,31.5);
        StdDraw.setYscale(-2.5,31.5);
        StdDraw.setPenRadius(0.010);
        StdDraw.setPenColor(StdDraw.BLACK);
        size = 30;
        drawGrid(size);
        StdDraw.show();
        while (true){
            if (inter()==true){
                break;
            }
        }
    }
    //**add draw path
    public static void drawPath(Pathfinding pf){
        List<PFNode> path = pf.getPath();
        
        try{
            for (PFNode p:path){
                StdDraw.setPenColor(StdDraw.GRAY);
                StdDraw.filledSquare(p.getRow()+0.5,p.getCol()+0.5,0.5);
                TimeUnit.MILLISECONDS.sleep(100);
                StdDraw.show();
            }        
            
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledSquare(start[0]+0.5, start[1]+0.5, 0.5);
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.filledSquare(goal[0]+0.5, goal[1]+0.5, 0.5);
            StdDraw.show();
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }


    public static void main(String[] args){
        grid gd = new grid();
        gd.start();
    }
    
}
