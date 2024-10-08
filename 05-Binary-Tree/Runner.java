
/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner
{
    // instance variables - replace the example below with your own
    //Preorder - Parent, Left, Right
    //Inorder - Left, Parent, Right
    //Postorder - Left, Right, Parent
    public static void main (String[] args){
        BTNode head = new BTNode ("A", new BTNode("B",new BTNode("D", null, null), new BTNode ("E", null, null)), new BTNode ("C",new BTNode("F", null, null), new BTNode("G", null, null)));
        
        System.out.print(head.getData());
        
        
        
        
    }
    
    public void Preorder(){
        
    }
}
