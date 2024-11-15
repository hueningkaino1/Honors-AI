import java.util.*;

/**
 * Write a description of class Adjacency here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Adjacency implements Comparable <Adjacency>
{
    private int dist;
    private PFNode cont;
    private int [][] adlink;
    //Node connection to other node
    // cost (distance ---real distance)
    public Adjacency(int distance, PFNode node)
    {
        dist = distance;
        cont = node;
    }

    public int getDist(){
        return dist;
    }
    
    public PFNode connectedNode(){
        return cont;
    }
    
    
    @Override
    public int compareTo(Adjacency a){
        if (this.getDist()>a.getDist()){
            return 1;
        }
        else if (this.getDist()<a.getDist()){
            return -1;
        }
        else {
            return 0;
        }
    }
    /*
        public void adddis(int cos, int a, int b){
        adlink[a][b] = cos;
        }
        
    */
    
    
}
