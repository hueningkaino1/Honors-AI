import java.util.*;

/**
 * Write a description of class PFNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PFNode
{
    // data  (String)
    // ArrayList of Adjecencies
    //toString
    // Constructor(s)
    // other methods.
    private String data;
    public List<Adjacency> links;
    public int totalD;
    
    public PFNode(String dat)
    {
        data = dat;  
        links =  new ArrayList<>();
        totalD = 0;
    }
    
    public void addLink(PFNode node, int cost){
        links.add(new Adjacency(0, this));
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
    
    public int setTotal(Adjacency previousTot){
        totalD = dist + previousTot.totalD;
        return totalD;
    }
    
    public String getData(){
        return data;
    }
    
}
