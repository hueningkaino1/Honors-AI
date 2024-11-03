import java.util.List;
import java.util.ArrayList;
import java.util.*;

/**
 * Write a description of class GraphNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GraphNode
{
    public GraphNode left;
    public GraphNode right;
    public GraphNode up;
    public GraphNode down;
    private String data;
    List <GraphNode> links;
    private static Queue <GraphNode> queue;
    //public BTNode parent;

    /**
     * Constructor for objects of class BTNode
     */
    public GraphNode(String dat, GraphNode l, GraphNode r, GraphNode u, GraphNode d)
    {
        data = dat;
        left = l;
        right = r;
        up = u;
        down = d;
        
    }
    
    public GraphNode(GraphNode l, GraphNode r, GraphNode u, GraphNode d)
    {
        left = l;
        right = r;
        up = u;
        down = d; 
    }
    
    public GraphNode(String dat)
    {
        data = dat;  
        this.links =  new ArrayList<>();
    }

    
    public void setPos(GraphNode l, GraphNode r, GraphNode u, GraphNode d){
        left = l;
        right = r;
        up = u;
        down = d; 
    }
    
    public void addLink(GraphNode node){
        if (!this.links.contains(node)){
            this.links.add(node);
            node.links.add(this);
        }
    }
    
    public String getData(){
        return data;
    }
    
    
    
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder(data + "->");
        for(GraphNode link : links){
            result.append(link.data).append(", ");
        }
        
        if (result.length()>4){
            result.setLength(result.length()-2);
        }
        return result.toString();
    }
    public void printNode(){
        System.out.print(this.data+" connects to: ");
        for (GraphNode linkedNode: links) {
            System.out.print(linkedNode.data + " ");
        }
        System.out.println();
    }
   
    
}
