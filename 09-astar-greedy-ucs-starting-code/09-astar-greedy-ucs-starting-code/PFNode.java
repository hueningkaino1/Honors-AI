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
    
    public PFNode(String dat)
    {
        data = dat;  
        links =  new ArrayList<>();
    }
    
    public void addLink(PFNode node, int cost){
        if (!links.contains(new Adjacency(cost, node))){
            links.add(new Adjacency(cost, node));
            node.links.add(new Adjacency(cost, this));
        }
    }
    
    public String getData(){
        return data;
    }
    
}
