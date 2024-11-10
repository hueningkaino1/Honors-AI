import java.util.Scanner;
import java.io.*;

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
    private static BTNode child;
    private static boolean play;
    private static BTNode tree;
    private static boolean real = false;
    
    public static void main (String[] args){
        tree = new BTNode("Korean");
        tree.left = new BTNode("IU");
        tree.right = new BTNode("Zendaya");
        kb = new Scanner(System.in);
        File f = new File("game_state.ser");
        if (!f.exists()){
            saveTree("game_state.ser");
        }
        play = true;
        while (play){
            loadTree("game_state.ser");
            thing(tree);
            if (!real){
                System.out.println("Tell me what you were thinking about?");
                String think = kb.nextLine();
                System.out.println("What makes it different from " + child.getData() + "?");
                String category = kb.nextLine();
                changeNode(category, think);
            }
            System.out.println("Play again?");
            String yn = kb.nextLine().toLowerCase();
            if (yn.equals("y")){
                play = true;
            }
            else {
                play = false;
            }
            saveTree("game_state.ser");
        }        
    }
    
    public static void thing(BTNode node){
        if (node!=null){
            System.out.println(node.getData() + "?");
            String answer = kb.nextLine();
            child = node;
            if (answer.equals("y")){
                real = true;
                thing(node.left);
            }
            else{
                real = false; 
                thing(node.right);                               
            }
        }
    }
    // true = right, false = left
    public static void changeNode(String cat, String an){
        BTNode cat1 = new BTNode(cat);
        cat1.right = child;
        cat1.left = new BTNode(an);
        BTNode parent = findParent(tree, child);
        if (parent.left==child){
            parent.left=cat1;
        }
        else{
            parent.right=cat1;
        }
    }
    
    public static BTNode findParent(BTNode parent, BTNode child){
        if (parent == null){
            return null;
        }
        if (parent.left == child || parent.right == child){
            return parent;
        }
        BTNode found = findParent(parent.left, child);
        if(found == null){
            found = findParent(parent.right, child);
        }
        return found;
    }
    
    public static void saveTree(String filename){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
            out.writeObject(tree);
        }catch(IOException e){
            System.out.println("Error saving the tree" + e.getMessage());
        }
    }
    
    public static void loadTree(String filename){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            try
            {
                tree = (BTNode) in.readObject();
            }
            catch (ClassNotFoundException cnfe)
            {
                cnfe.printStackTrace();
            }
        }catch(IOException e){
            System.out.println("Error loading the tree" + e.getMessage());
        }
    }
    
}
