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
        //totalD = dist;
    }

    public int getDist(){
        return dist;
    }
    
    public String connectedNode(){
        return cont.getData();
    }
    
    public PFNode Node(){
        return cont;
    }
    
    
    
    
    @Override
    public int compareTo(PFNode a){
        if (cont.totalD>a.totalD){
            return 1;
        }
        else if (this.cont.totalD<a.cont.totalD){
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
