
/**
 * Write a description of class ThermostatAgent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Agent
{
    // code your agent.
    // instance variables
    private static Agent m_instance;
    private int [][] grid;
    private int [][] maze;
    private boolean isWall;
    private int direction;
    private int right;
    private int [] loc;
    private int x;
    private int y;
    private int [] gold;
    private int gx;
    private int gy;
    private boolean atGoal;
    
    private int right1;
    private int [] loc1;
    private int x1;
    private int y1;
    private int [] gold1;
    private int gx1;
    private int gy1;
    private boolean atGoal1;
    
    // constructor
    private Agent(){
        maze = new int [][] {{1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1}};
                    
                    
        //(14*16)
        grid = new int [][] { 
                    {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                    {1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                    {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1}};
         
        isWall = false;
        x = 8;
        y = 15;
        loc = new int [] {x,y};
        //1 - grid right, 2 - grid up, 3 - grid left, 4 grid down
        right = 3;
        gx = 0;
        gy = 8;
        gold = new int[] {gx, gy};
        atGoal = false;
        
        x1 = 28;
        y1= 31;
        loc1 = new int [] {x,y};
        right1 = 2;
        gx1 = 0;
        gy1 = 8;
        gold1 = new int[] {gx1, gy1};
        atGoal1 = false;
        
    }
    
    public static Agent getInstance(){
        if(m_instance==null){
            m_instance = new Agent();
        }
        
        return m_instance;
    }
    
    //getter and setter methods
    public int [][] getGrid(){
        return grid;
    }
    
    public int [][] getMaze(){
        return maze;
    }
    
    public void setLoc(int a, int b){
        loc[0] = a;
        loc[1] = b;
    }
    
    public int locX(){
        return loc[0];
    }
    
    public int locY(){
        return loc[1];
    }
    
    public int locX1(){
        return loc1[0];
    }
    
    public int locY1(){
        return loc1[1];
    }
    
    public void setG(int a, int b){
        gold[0] = a;
        gold[1] = b;
    }
    
    public int goldX(){
        return gold[0];
    }
    
    public int goldY(){
        return gold[1];
    }
    
    public int goldX1(){
        return gold1[0];
    }
    
    public int goldY1(){
        return gold1[1];
    }
    
    public boolean getGoal(){
        return atGoal;
    }
    
    // add sense decide act methods
    //sense senses whether or not there is a wall on the right side of the object and to change directions
    public void sense() {
        int x = loc[1];
        int y = loc[0];
    
        // 1 - grid right, 2 - grid up, 3 - grid left, 4 - grid down
        if (right == 1) {
            // Check if x+1 is within bounds
            if (x + 1 < grid.length && grid[x + 1][y] == 0) {
                right = 4;
            }
            // Check if x+1 and y+1 are within bounds for further checks
            else if (x + 1 < grid.length && y + 1 < grid[0].length && grid[x + 1][y] == 1 && grid[x][y + 1] == 1) {
                right = 2;
            }
            else if (y + 1 < grid[0].length && grid[x][y + 1] == 0) {
                right = 1;
            }
        }
        else if (right == 2) {
            // Check if y+1 is within bounds
            if (y + 1 < grid[0].length && grid[x][y + 1] == 0) {
                right = 1;
            }
            // Check if x-1 and y+1 are within bounds
            else if (y + 1 < grid[0].length && x - 1 >= 0 && grid[x][y + 1] == 1 && grid[x - 1][y] == 1) {
                right = 3;
            }
            else if (x - 1 >= 0 && grid[x - 1][y] == 0) {
                right = 2;
            }
        }
        else if (right == 3) {
            // Check if x-1 is within bounds
            if (x - 1 >= 0 && grid[x - 1][y] == 0) {
                right = 2;
            }
            // Check if x-1 and y-1 are within bounds
            else if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y] == 1 && grid[x][y - 1] == 1) {
                right = 4;
            }
            else if (y - 1 >= 0 && grid[x][y - 1] == 0) {
                right = 3;
            }
        }
        else if (right == 4) {
            // Check if y-1 is within bounds
            if (y - 1 >= 0 && grid[x][y - 1] == 0) {
                right = 3;
            }
            // Check if x+1 and y-1 are within bounds
            else if (y - 1 >= 0 && x + 1 < grid.length && grid[x][y - 1] == 1 && grid[x + 1][y] == 1) {
                right = 1;
            }
            else if (x + 1 < grid.length && grid[x + 1][y] == 0) {
                right = 4;
            }
        }
    }
    
    public void sense1() {
        int x = loc[1];
        int y = loc[0];
    
        // 1 - grid right, 2 - grid up, 3 - grid left, 4 - grid down
        if (right1 == 1) {
            // Check if x+1 is within bounds
            if (x + 1 < maze.length && maze[x + 1][y] == 0) {
                right1 = 4;
            }
            // Check if x+1 and y+1 are within bounds for further checks
            else if (x + 1 < maze.length && y + 1 < maze[0].length && maze[x + 1][y] == 1 && maze[x][y + 1] == 1) {
                right1 = 2;
            }
            else if (y + 1 < maze[0].length && maze[x][y + 1] == 0) {
                right1 = 1;
            }
        }
        else if (right1 == 2) {
            // Check if y+1 is within bounds
            if (y + 1 < maze[0].length && maze[x][y + 1] == 0) {
                right1 = 1;
            }
            // Check if x-1 and y+1 are within bounds
            else if (y + 1 < maze[0].length && x - 1 >= 0 && maze[x][y + 1] == 1 && maze[x - 1][y] == 1) {
                right1 = 3;
            }
            else if (x - 1 >= 0 && maze[x - 1][y] == 0) {
                right1 = 2;
            }
        }
        else if (right1 == 3) {
            // Check if x-1 is within bounds
            if (x - 1 >= 0 && maze[x - 1][y] == 0) {
                right1 = 2;
            }
            // Check if x-1 and y-1 are within bounds
            else if (x - 1 >= 0 && y - 1 >= 0 && maze[x - 1][y] == 1 && maze[x][y - 1] == 1) {
                right1 = 4;
            }
            else if (y - 1 >= 0 && maze[x][y - 1] == 0) {
                right1 = 3;
            }
        }
        else if (right1 == 4) {
            // Check if y-1 is within bounds
            if (y - 1 >= 0 && maze[x][y - 1] == 0) {
                right1 = 3;
            }
            // Check if x+1 and y-1 are within bounds
            else if (y - 1 >= 0 && x + 1 < maze.length && maze[x][y - 1] == 1 && maze[x + 1][y] == 1) {
                right1 = 1;
            }
            else if (x + 1 < maze.length && maze[x + 1][y] == 0) {
                right1 = 4;
            }
        }
    }
    
    //decides if touches treasure
    public boolean decide(){
        if (loc[1]==gold[0] && loc[0]==gold[1]){
            atGoal = true;
        }
        else{
            atGoal = false;
        }
        return atGoal;
    }
    
    public boolean decide1(){
        if (loc1[1]==gold1[0] && loc1[0]==gold1[1]){
            atGoal1 = true;
        }
        else{
            atGoal1 = false;
        }
        return atGoal1;
    }
    
    //checks direction and move the object forward based on direction
    public void act(){
        //1 - grid right, 2 - grid up, 3 - grid left, 4 grid down
        if (right == 1){
            //if (grid[loc[0]][loc[1]+1]==0){
                loc[0] = loc [0]+1;
            //}
        }
        else if (right == 2){
            //if (grid[loc[0]-1][loc[1]]==0){
                loc[1] = loc [1]-1;
            //}
        }
        else if (right == 3){
            //if (grid[loc[0]][loc[1]-1]==0){
                loc[0] = loc [0]-1;
            //}
        }
        else if (right == 4){
            //if (grid[loc[0]+1][loc[1]]==0){
                loc[1] = loc [1]+1;
            //}
        }
    }
    
    public void act1(){
        //1 - grid right, 2 - grid up, 3 - grid left, 4 grid down
        if (right1 == 1){
            //if (grid[loc[0]][loc[1]+1]==0){
                loc1[0] = loc1 [0]+1;
            //}
        }
        else if (right1 == 2){
            //if (grid[loc[0]-1][loc[1]]==0){
                loc1[1] = loc1 [1]-1;
            //}
        }
        else if (right1 == 3){
            //if (grid[loc[0]][loc[1]-1]==0){
                loc1[0] = loc1 [0]-1;
            //}
        }
        else if (right1 == 4){
            //if (grid[loc[0]+1][loc[1]]==0){
                loc1[1] = loc1 [1]+1;
            //}
        }
    }

    
}
