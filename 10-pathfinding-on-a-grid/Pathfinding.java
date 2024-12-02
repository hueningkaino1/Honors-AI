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
    // map (PF) goes here
    //private static PFNode starter;
    //private static PFNode goal;
    public static PFNode [] nodes;
    public static ArrayList<PFNode> visited = new ArrayList<PFNode>();
    //public static PriorityQueue <PFNode> queue = new PriorityQueue<PFNode>(Comparator.comparingInt(PFNode::getTotal));
    private static int sum;
    public static PFNode [][] grids;
    public static int [][] maps;
    private static PFNode starter;
    private static PFNode goal;
    
    public static void start(){
        setGrid();
        getInput();
    }
    
    public static void setGrid(){
        int maps[][] = grid.getMap();
        int ro = 0;
        for (int row []: maps){
            for (int col: row){
                if(col == 1){
                    grids[ro][col] = new PFNode(calculateMD(ro, col), true);
                }
                else if(col == 0){
                    grids[ro][col] = new PFNode(calculateMD(ro, col), false);
                }
            }
            ro++;
        }
        starter = grids[grid.getSR()][grid.getSC()];
        goal = grids[grid.getGR()][grid.getGC()];
    }
    
    public static int calculateMD(int s, int t){
        int x;
        int y;
        x = grid.getGR() - s;
        y = grid.getGC() - t;
        return (x+y)*10;
    } 
    
    public static int calculateCost(){
        
    }
    
    public void sense(){
        
    }
    
    // handle your input here ?    
    public static void getInput(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Type a room number 01 - 20 excluding 16.");
        String start = "w4" + kb.nextLine();
        for(PFNode n: nodes){
            if(n.getData().equals(start)){
                starter = n;
            }
        }
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
                if (){
                   //PFNode.setVisited(true);
                   neighbors.add(PFNode);
                }
            }
        }
    }
    // if main is short most of the entry point for your algorithms 
    // should go here

    
    private static void reconstructPath(PFNode node){
        List<PFNode> path = new ArrayList<>();
        List<PFNode> visit = new ArrayList<>();
        /*for (PFNode at = node; at != null; at = at.getPrev()){
            path.add(at);
        }*/
        PFNode at = node;
        while(at!=null){
            if(!visit.contains(at)){
                path.add(at);
                visit.add(at);
            }
            at = at.getPrev();
            //System.out.println(at.getData());
        }
        
        Collections.reverse(path);
        System.out.print("Path: ");
        for (PFNode p : path){
            System.out.print(p.getData() + " ");
        }
        System.out.println();
    }
    
    public static PFNode UCS (PFNode node){
        PriorityQueue <PFNode> queue = new PriorityQueue<PFNode>(Comparator.comparingInt(PFNode::getTotal));
        PFNode s;
        if (node!=null){
            s = node;
            queue.add(s);
            while(!queue.isEmpty()){
                
                System.out.print("Queue:");
                for (PFNode q: queue){
                    System.out.print(q.getData() + " ");
                }
                System.out.println();
                
                s = queue.poll();
                visited.add(s);
                
                if (s.getData().equals("w405")){
                    reconstructPath(s);
                    System.out.println("Total Distance:" + s.getTotal());
                    
                    
                    
                    System.out.print("Visited:");
                    for (PFNode q: visited){
                        System.out.print(q.getData() + " ");
                    }
                    System.out.println();
                    visited.clear();

                    
                    return s;
                }
                else{
                    for(Adjacency child : s.links){
                        int newTotal = s.getTotal()+child.getDist();
                        PFNode childNode = child.Node();
                        if (!visited.contains(child.Node())||newTotal<childNode.getTotal()){
                            child.Node().setTotal(newTotal);
                            child.Node().setPrev(s);
                            queue.add(childNode);
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public static PFNode greedy(PFNode node){
        PriorityQueue <PFNode> queue = new PriorityQueue<PFNode>();
        PFNode s;
        if(node!=null){
            s = node;
            queue.add(s);
            while(!queue.isEmpty()){
                
                System.out.print("Queue:");
                for (PFNode q: queue){
                    System.out.print(q.getData() + " ");
                }
                System.out.println();
                
                s = queue.remove();
                visited.add(s);
                if(s.getData().equals("w405")){
                    
                    reconstructPath(s);
                    System.out.println("Total Distance:" + s.getTotal());
                    
                    System.out.print("Visited:");
                    for (PFNode q: visited){
                        System.out.print(q.getData() + " ");
                    }
                    System.out.println();
                    visited.clear();
                    
                    return s;
                }
                else{
                    for(Adjacency child : s.links){
                        if(!visited.contains(child.Node())){
                            child.Node().setPrev(s);
                            child.Node().setTotal(child.getDist()+child.Node().getMD());
                            /*if (child.Node().getData().equals("w402")||child.Node().getData().equals("w415")){
                                System.out.println("setPrev");
                                System.out.println(s.getData());
                                System.out.println(child.Node().getData());
                            }
                            System.out.print("Visited:");
                            for (PFNode q: visited){
                                System.out.print(q.getData() + " "+ q + " ");
                            }
                            System.out.println();*/
                            
                            queue.add(child.Node());
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public static PFNode AS(PFNode node){
        PriorityQueue <PFNode> queue = new PriorityQueue<PFNode>(Comparator.comparingInt(PFNode::getTotal));
        PFNode s;
        if(node!=null){
            s = node;
            queue.add(s);
            while(!queue.isEmpty()){
                
                System.out.print("Queue:");
                for (PFNode q: queue){
                    System.out.print(q.getData() + " ");
                }
                System.out.println();
                
                s = queue.remove();
                visited.add(s);
                if(s.getData().equals("w405")){
                    reconstructPath(s);
                    System.out.println("Total Distance:" + s.getTotal());
                    
                    
                    System.out.print("Visited:");
                    for (PFNode q: visited){
                        System.out.print(q.getData() + " ");
                    }
                    System.out.println();
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
                }
            }
        }
        return null;
    }
    
}
