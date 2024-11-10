import java.io.Serializable;
/**
 * Write a description of class BTNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BTNode implements Serializable
{
    //Preorder - Parent, Left, Right
    //Inorder - Left, Parent, Right
    //Postorder - Left, Right, Parent
    public BTNode left;
    public BTNode right;
    private String data;
    //public BTNode parent;

    /**
     * Constructor for objects of class BTNode
     */
    public BTNode(String dat, BTNode l, BTNode r)
    {
        data = dat;
        left = l;
        right = r;
        
    }
    
    public BTNode(String dat)
    {
        data = dat;
        left = null;
        right = null;
        //parent = null;
        
    }
   
    
    public String getData(){
        return data;
    }
        
}
