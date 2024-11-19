import java.util.*;

/**
 * Write a description of class PFNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PFNode implements Comparable <PFNode>
{
    // data  (String)
    // ArrayList of Adjecencies
    //toString
    // Constructor(s)
    // other methods.
    private String data;
    public List<Adjacency> links;
    private int totalD;
    private int SLD;
    
    public PFNode(String dat,int straight)
    {
        data = dat;  
        links =  new ArrayList<>();
        totalD = 0;
        SLD = straight;
    }
    
    public void addLink(PFNode node, int cost){
        System.out.println(this.getData() +" " +cost);
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
    
    public int getSLD(){
        return SLD;
    }
    
    @Override
    public int compareTo(PFNode a){
        if (this.totalD>a.totalD){
            return 1;
        }
        else if (this.totalD<a.totalD){
            return -1;
        }
        else {
            return 0;
        }
    }
    
    @Override
    public int compareTo(PFNode a){
        if (this.getSLD()>a.getSLD()){
            return 1;
        }
        else if (this.getSLD()<a.getSLD()){
            return -1;
        }
        else {
            return 0;
        }
    }
    
}
