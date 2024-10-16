
/**
 * Write a description of class BTNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BTNode
{
    //Preorder - Parent, Left, Right
    //Inorder - Left, Parent, Right
    //Postorder - Left, Right, Parent
    public BTNode left;
    public BTNode right;
    private String data;

    /**
     * Constructor for objects of class BTNode
     */
    public BTNode(String dat, BTNode l, BTNode r)
    {
        data = dat;
        left = l;
        right = r;
        
    }
    
    public String getData(){
        return data;
    }
    
    /*public String left(){
        return left.getData();
    }
    
    public String right(){
        return right.getData();
    }*/


}
