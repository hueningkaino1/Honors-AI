
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
        
        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);
        
        
        
    }
    
    public static void preorder(BTNode node){
        if (node!=null){
            System.out.print(node.getData());
            preorder(node.left);
            preorder(node.right);
        }
    }
    
    public static void inorder(BTNode node){
        if (node!=null){
            inorder(node.left);
            System.out.print(node.getData());
            inorder(node.right);
        }
    }
    
    public static void postorder(BTNode node){
        if (node!=null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.getData());
        }
    }
}
