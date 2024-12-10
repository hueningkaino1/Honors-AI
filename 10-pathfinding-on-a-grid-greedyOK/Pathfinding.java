import java.util.*;
import java.util.ArrayList;

/**
 * write a description of class Pathfinding here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pathfinding
{
    //How to make it realize user interaction is a wall
    // how to let each node take in its indiviual cost
    //make sure the regular cost addition for ucs is right
    //animation of adding the nodes to visited
    //last animation of finding the path
    
    // map (PF) goes here
    //private static PFNode starter;
    //private static PFNode goal;
    public static PFNode [] nodes;
    public static ArrayList<PFNode> visited = new ArrayList<PFNode>();
    //**change to global var
    private static List<PFNode> path = new ArrayList<>();
    //public static PriorityQueue <PFNode> queue = new PriorityQueue<PFNode>(Comparator.comparingInt(PFNode::getTotal));
    private static int sum;
    public static PFNode [][] grids;
    private static int [][] maps;
    private static PFNode starter;
    private static PFNode goal;
    private static int SIZE = 30;
    
    public static void start(){
        grids = new PFNode [SIZE][SIZE];
        setGrid();
        //** open the input function
        getInput();
    }
    
    //**return path
    public static List<PFNode> getPath(){
        return path;
    }
    
    public static void setGrid(){
        maps = grid.getMap();
        for (int i = 0; i<SIZE; i++){
            for (int j = 0; j<SIZE; j++){
                System.out.print(maps[i][j]);
            }
            System.out.println();
        }
        int ro = 0;
        for (int row []: maps){
            int co = 0;
            for (int val: row){
                if(val == 1){
                    grids[ro][co] = new PFNode(calculateMD(ro, co), true, ro, co);
                }
                else if(val == 0){
                    grids[ro][co] = new PFNode(calculateMD(ro, co), false, ro, co);
                }
                co++;
            }
            ro++;
        }
        starter = grids[grid.getSR()][grid.getSC()];
        System.out.println(starter);
        goal = grids[grid.getGR()][grid.getGC()];
    }
    
    public static int calculateMD(int s, int t){
        int x;
        int y;
        x = Math.abs(grid.getGR() - s);
        y = Math.abs(grid.getGC() - t);
        return (x+y)*10;
    } 
    
    public static int calculateCost(PFNode currentNode){
        for (int i = -1; i<2; i++){
            for (int j = -1; j<2; j++){
                if(currentNode.getRow()+i >= 0 && currentNode.getRow()+i < SIZE && currentNode.getCol()+j >= 0 && currentNode.getCol()+j < SIZE){
                    if(maps[currentNode.getRow()+i][currentNode.getCol()+j]==0){
                        if ((i == 1 ||i == -1)&&j==0){
                            return 10;
                        }
                        else if((j==1||j==-1)&&i==0){
                            return 10;
                        }
                        else{
                            return 14;
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    
    //handle your input here ?    
    public static void getInput(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Which search method? 0 - UCS, 1-Greedy, 2-A*");
        int method = kb.nextInt();
        chooseMethod(method);
    }
    
    public static void chooseMethod(int met){
        if (met<=2){
            if (met == 0){
            if(UCS(starter)==null){
                System.out.println("The path is blocked.");
            }
            else{
                System.out.println("The path is found.");
            }
            }
            else if (met==1){
                if(greedy(starter)==null){
                    System.out.println("The path is blocked.");
                }
                else{
                    System.out.println("The path is found.");
                }
            }
            else if (met ==2){
                if(AS(starter)==null){
                    System.out.println("The path is blocked.");
                }
                else{
                    System.out.println("The path is found.");
                }
            }
        }
    }
    
    public static ArrayList<PFNode> getNeighbors(PFNode currentNode){
        ArrayList <PFNode> neighbors = new ArrayList<>();
        for (int i = -1; i<2; i++){
            for (int j = -1; j<2; j++){
                if (currentNode.getRow()+i >= 0 && currentNode.getRow()+i<SIZE && currentNode.getCol()+j >= 0 && currentNode.getCol()+j < SIZE){
                    if (!neighbors.contains(grids[currentNode.getRow()+i][currentNode.getCol()+j])){
                       //PFNode.setVisited(true);
                       neighbors.add(grids[currentNode.getRow()+i][currentNode.getCol()+j]);
                    }
                }
            }
        }
        return neighbors;
    }
    // if main is short most of the entry point for your algorithms 
    // should go here

    //**change return type
    private static void reconstructPath(PFNode node){
        int [][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
        PriorityQueue <PFNode> adj = new PriorityQueue<PFNode>(Comparator.comparingInt(PFNode::getTotal).reversed());
        
        PFNode maxNei;
        PFNode curNode = node;
        path.add(node);
        while(curNode != starter){
            //PFNode v = visited.remove(visited.size()-1);
            for(int [] direct : direction){
                int newX = curNode.getRow() + direct[0];
                int newY = curNode.getCol() + direct[1];
                
                if (newX >= 0 && newX < SIZE && newY >=0 && newY < SIZE && maps[newX][newY] == 0 && visited.contains(grids[newX][newY]) && !path.contains(grids[newX][newY])){
                    adj.add(grids[newX][newY]);                    
                }
            }
            maxNei = adj.poll();
            visited.remove(maxNei);
            curNode = maxNei;
            //**System.out.println(maxNei.getMD());
            
            path.add(maxNei);
            adj.clear();
        }
        
        
        Collections.reverse(path);
        System.out.print("Path: ");
        for (PFNode p : path){
            System.out.print( p.getMD() + " ");
        }
        System.out.println();       
    }
    
    public static PFNode UCS (PFNode node){
        PriorityQueue <PFNode> queue = new PriorityQueue<PFNode>(Comparator.comparingInt(PFNode::getTotal));
        PFNode s;
        if (node!=null){
            s = node;
            queue.add(s);
            s.setTotal(0);
            while(!queue.isEmpty()){
                
                System.out.print("Queue:");
                for (PFNode q: queue){
                    //**change to get total
                    System.out.print(q.getTotal() + " ");
                }
                System.out.println();
                
                s = queue.poll();
                visited.add(s);
                
                if (s.getMD()==0){
                    
                    System.out.println("Total Distance:" + s.getTotal());
                    
                    
                    
                    System.out.print("Visited:");
                    for (PFNode q: visited){
                        System.out.print(q.getTotal() + " ");
                        //+ " "+ q.getRow() + " " + q.getCol() + " " 
                    }
                    System.out.println();
                    reconstructPath(s);
                    visited.clear();

                    
                    return s;
                }
                else{
                    ArrayList <PFNode> neighbors = getNeighbors(s);
                    for(PFNode neigh : neighbors){
                        if(!visited.contains(neigh)){
                            //neigh.setPrev(s);
                            if (neigh.getCost()==-1){
                                neigh.setCost(calculateCost(s));
                                neigh.setTotal(neigh.getCost()+s.getTotal());
                                queue.add(neigh);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public static PFNode greedy(PFNode node){
        PriorityQueue <PFNode> queue = new PriorityQueue<PFNode>(Comparator.comparingInt(PFNode::getTotal));
        PFNode s;
        if(node!=null){
            s = node;
            queue.add(s);
            s.setTotal(s.getMD());
            while(!queue.isEmpty()){
                
                System.out.print("Queue:");
                for (PFNode q: queue){
                    System.out.print(q.getMD() + " ");
                }
                System.out.println();
                
                s = queue.remove();
                visited.add(s);
                if(s.getMD()==0){                   
                    
                    
                    System.out.print("Visited:");
                    //**
                    for (PFNode q: visited){
                        System.out.print(q.getMD() + " "+ q.getRow() + " " + q.getCol() + " " );
                    }
                    System.out.println();
                    reconstructPath(s);
                    visited.clear();
                    
                    return s;
                }
                else{
                    ArrayList <PFNode> neighbors = getNeighbors(s);
                    for(PFNode neigh : neighbors){
                        //**getWall
                        if(!visited.contains(neigh) && !neigh.getWall()){
                            //neigh.setPrev(s);
                            neigh.setTotal(neigh.getMD());
                            queue.add(neigh);
                        }
                    }
                }
            }
        }
        return null;
    }
    
    //calculate which way to go based on adding the cost to move from one node to another and 
    //the manhattan cost of the new node to the goal
    public static PFNode AS(PFNode node){
        PriorityQueue <PFNode> queue = new PriorityQueue<PFNode>(Comparator.comparingInt(PFNode::getTotal));
        PFNode s;
        if(node!=null){
            s = node;
            queue.add(s);
            while(!queue.isEmpty()){
                
                System.out.print("Queue:");
                for (PFNode q: queue){
                    //**change to get total
                    System.out.print(q.getTotal() + " ");
                }
                System.out.println();
                
                s = queue.remove();
                visited.add(s);
                if(s.getMD()==0){
                    
                    System.out.println("Total Distance:" + s.getTotal());
                    
                    
                    System.out.print("Visited:");
                    for (PFNode q: visited){
                        //System.out.print(q.getData() + " ");
                    }
                    System.out.println();
                    reconstructPath(s);
                    visited.clear();

                    return s;
                }else{
                    for(Adjacency child : s.links){
                        if(!visited.contains(child.Node())){
                            child.Node().setPrev(s);
                            child.Node().setTotal(child.getDist()+child.Node().getMD());
                            queue.add(child.Node());
                        }
                    }
                    ArrayList <PFNode> neighbors = getNeighbors(s);
                    for(PFNode neigh : neighbors){
                        if(!visited.contains(neigh)){
                            //neigh.setPrev(s);
                            neigh.setTotal(neigh.getMD()+neigh.getCost());
                            queue.add(neigh);
                        }
                    }
                }
            }
        }
        return null;
    }
    
}
