import java.util.Scanner;

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
    private static Scanner kb;
    public static void main (String[] args){
        BTNode APUSH = new BTNode ("Period 1? 1491 - 1607", new BTNode("Spanish Armada 1588?",null, null), new BTNode ("Pilgrims/Mayflower 1620?", null, null));
        kb = new Scanner(System.in);
        
        
        
        
        
    }
    
    public static void thing(BTNode node){
        if (node!=null){
            System.out.println(node.getData());
            String answer = kb.nextLine();
            if (answer.equals("y")){
                preorder(node.left);
            }
            else if (answer.equals("n")){
                preorder(node.right);
            }
            else{
                System.out.println("y or n");
            }
        }
        
        System.out.println("What makes it different from ");
        
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
