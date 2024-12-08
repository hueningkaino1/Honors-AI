import java.util.*;

/**
 * Write a description of class PFNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PFNode 
//implements Comparable <PFNode>
{
    // data  (String)
    // ArrayList of Adjecencies
    //toString
    // Constructor(s)
    // other methods.
    private String data;
    public List<Adjacency> links;
    private PFNode previous;
    private int totalD;
    private int MD;
    private boolean isWall;
    private int row;
    private int col;
    
    public PFNode(int md, boolean IW, int r, int c)
    { 
        links =  new ArrayList<>();
        totalD = md;
        MD = md;
        isWall = IW;
        row = r;
        col = c;
    }
    
    public void setPrev(PFNode node){
        previous = node;
    }
    
    public PFNode getPrev(){
        return previous;
    }
    
    public void addLink(PFNode node, int cost){
        //System.out.println(this.getData() +" " +cost);
        //links.add(new Adjacency(0, this));
        if (!links.contains(new Adjacency(cost, node))){
            links.add(new Adjacency(cost, node));
            node.links.add(new Adjacency(cost, this));
        }
    }
    
    public int getLength(PFNode node){
        int i = 0;
        for(int j = 0; j<links.size(); j++){
            if(links.get(j).connectedNode() == node.getData()){
                i = links.get(j).getDist();
            }
        }
        return i;
    }
    
    public Adjacency getAdj(PFNode node){
        Adjacency i=null;
        for(int j = 0; j<links.size(); j++){
            if(links.get(j).connectedNode() == node.getData()){
                i = links.get(j);
            }
        }
        return i;
    }
    
    public int setTotal(int dist){
        totalD = dist;
        return totalD;
    }
    
    public int getTotal(){
        return totalD;
    }
    
    public String getData(){
        return data;
    }
    
    public int getMD(){
        return MD;
    }
    
    public void setWall(boolean a){
        isWall = a;
    }
    
    public boolean getWall(){
        return isWall;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
    }
    
