
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
    
    // constructor
    private Agent(){
        grid = new int [][] { {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},           
                    {1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1},  
                    {1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1}, 
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},  
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}}; 
        isWall = false;
        x = 14;
        y = 4;
        loc = new int [] {x, y};
        //1 - grid right, 2 - grid up, 3 - grid left, 4 grid down
        right = 2;
        gx = 3;
        gy = 0;
        gold = new int[] {gx, gy};
        atGoal = false;
        
        
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
    
    public void setG(int a, int b){
        gold[0] = a;
        gold[1] = b;
    }
    
    public int goldX(){
        return loc[0];
    }
    
    public int goldY(){
        return loc[1];
    }
    
    public boolean getGoal(){
        return atGoal;
    }
    
    // add sense decide act methods
    //sense senses whether or not there is a wall on the right side of the object and to change directions
    public void sense(){
        //1 - grid right, 2 - grid up, 3 - grid left, 4 grid down
        if (right == 1){
            //checks right
            if(grid[loc[0]+1][loc[1]] == 0){
                right = 4;
            }
            //checks front
            else if(grid[loc[0]+1][loc[1]] == 1 && grid[loc[0]][loc[1]+1] == 1){
                right = 2;
            }
        }
        else if (right == 2){
            if (grid[loc[0]][loc[1]+1] == 0){
                right = 1;
            }
            else if (grid[loc[0]][loc[1]+1] == 1 && grid[loc[0]-1][loc[1]] == 1){
                right = 3; 
            }
        }
        else if (right == 3){
            if (grid[loc[0]-1][loc[1]] == 0){
                right = 2;
            }
            else if (grid[loc[0]-1][loc[1]] == 1 && grid[loc[0]][loc[1]-1] == 1 ){
                right = 4;
            }
        }
        else if (right == 4){
            if (grid[loc[0]][loc[1]-1] == 0){
                right = 3;
            }
            else if (grid[loc[0]][loc[1]-1] == 1 && grid[loc[0]+1][loc[1]] == 1){
                right = 1;
            }
        }
        
    }
    
    //decides if touches treasure
    public boolean decide(){
        if (loc[0]==gold[0] && loc[1]==gold[1]){
            atGoal = true;
        }
        else{
            atGoal = false;
        }
        return atGoal;
    }
    
    //checks direction and move the object forward based on direction
    public void act(){
        //1 - grid right, 2 - grid up, 3 - grid left, 4 grid down
        if (right == 1){
            if (grid[loc[0]][loc[1]+1]!=1){
                loc[1] = loc [1]+1;
            }
        }
        else if (right == 2){
            if (grid[loc[0]-1][loc[1]]!=1){
                loc[0] = loc [0]-1;
            }
        }
        else if (right == 3){
            if (grid[loc[0]][loc[1]-1]!=1){
                loc[1] = loc [1]-1;
            }
        }
        else if (right == 2){
            if (grid[loc[0]+1][loc[1]]!=1){
                loc[0] = loc [0]+1;
            }
        }
    }

    
}
