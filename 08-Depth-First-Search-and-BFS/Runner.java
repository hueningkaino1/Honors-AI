import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

/**
 * Write a description of class Runner1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner
{
    // instance variables - replace the example below with your own
    private static String start;
    private static String goal;
    private static Queue <GraphNode> queue;
    private static ArrayList<GraphNode> stack = new ArrayList<GraphNode>();
    public static ArrayList<GraphNode> visited = new ArrayList<GraphNode>();
    public static GraphNode star;
    private static GraphNode[] nodes;
    private static int way;
    private static Scanner kb;

    public static void main (String[] args){
        GraphNode A = new GraphNode("A");
        GraphNode B = new GraphNode("B");
        GraphNode C = new GraphNode("C");
        GraphNode D = new GraphNode("D");
        GraphNode E = new GraphNode("E");
        GraphNode F = new GraphNode("F");
        GraphNode G = new GraphNode("G");
        GraphNode H = new GraphNode("H");
        GraphNode I = new GraphNode("I");
        GraphNode J = new GraphNode("J");
        GraphNode K = new GraphNode("K");
        GraphNode L = new GraphNode("L");
        GraphNode M = new GraphNode("M");
        GraphNode N = new GraphNode("N");
        GraphNode O = new GraphNode("O");
        GraphNode P = new GraphNode("P");
        nodes = new GraphNode []{A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P};
        queue = new LinkedList<>();
        
        A.addLink(B);
        A.addLink(C);
        A.addLink(D);
        A.addLink(E);
        A.addLink(F);       
        B.addLink(G);
        B.addLink(H);
        B.addLink(K);
        C.addLink(I);
        C.addLink(J);        
        E.addLink(L);
        F.addLink(M);
        F.addLink(N);
        N.addLink(O);
        O.addLink(P);
        
        kb = new Scanner(System.in);
        System.out.println("What is the starting Node?");
        start = kb.nextLine().toUpperCase();
        System.out.println("What is the goal Node?");
        goal = kb.nextLine().toUpperCase();
        System.out.println("Choose the search method 0-BFS, 1-DFS, 2-LDS, 3-IDS");
        way = kb.nextInt();
        intoNode(start);
        chooseSearch(way);
        
        
    }
    
    public static void chooseSearch(int a){
        //visited.clear();
        if (a<=3){
            if (a == 0){
            if(BFS(star)==null){
                System.out.println("We have not found the Node you are looking for.");
            }
            else{
                System.out.println("We have found the Node.");
            }
            }
            else if (a==1){
                if(DFS(star)==null){
                    System.out.println("We have not found the Node you are looking for.");
                }
                else{
                    System.out.println("We have found the Node.");
                }
            }
            else if (a ==2){
                System.out.println("What is the depth you want to reach?");
                int num = kb.nextInt();
                if(LDS(star,num)==null){
                    System.out.println("We have not found the Node you are looking for.");
                }
                else{
                    System.out.println("We have found the Node.");
                }
            }
            else if (a == 3){
                System.out.println("What is the depth you want to reach?");
                int numb = kb.nextInt();
                if(IDS(star, numb)==null){
                    System.out.println("We have not found the Node you are looking for.");
                }
                else{
                    System.out.println("We have found the Node.");
                }
            }
            System.out.print("Visited:");
            for (GraphNode q: visited){
                System.out.print(q.getData() + " ");
            }
            visited.clear();
            stack.clear();
            queue.clear();
        }else {
            System.out.println("Choose a valid Search Method.");
            int met = kb.nextInt();
            chooseSearch(met);
        }
    }
    
    public static void intoNode(String A){
        for (GraphNode node: nodes){
            if (node.getData().equals(A)){
                star = node;
            }
        }
    }
    
    public static void printLinks(){
        for (GraphNode node: nodes){
            System.out.println(node);
        }
    }
    
    public static String DFS(GraphNode node){
        GraphNode s;
        if (node!=null){
            stack.add(node);
            while(!stack.isEmpty()){
                System.out.print("Stack:");
                for (GraphNode q: stack){
                    System.out.print(q.getData() + " ");
                }
                System.out.println();
                
                s = stack.remove(stack.size()-1);
                visited.add(s);
                if(s.getData().equals(goal)){
                    return s.getData();
                }
                else{
                    for(GraphNode child: s.links){
                        if (!visited.contains(child)){
                            stack.add(child);
                        }
                    }
                }
            }
        }
        return null;
    }
    
    
    public static String BFS(GraphNode node){
        GraphNode s;
        if (node!=null){
            System.out.println(node.getData());
            queue.add(node);
            while(!queue.isEmpty()){
                System.out.print("Queue:");
                for (GraphNode q: queue){
                    System.out.print(q.getData() + " ");
                }
                System.out.println();
                
                s = queue.remove();
                visited.add(s);
                if(s.getData().equals(goal)){
                    return s.getData();
                }
                else{
                    for(GraphNode child: s.links){
                            if (!visited.contains(child)){
                                queue.add(child);
                            }
                    }
                }
            }
        }
        return null;
    }
    
    public static String LDS(GraphNode node, int a){
        int count = 0;
        GraphNode s;
        if (node!=null){
            stack.add(node);
            while(!stack.isEmpty()){
                System.out.print("Stack:");
                for (GraphNode q: stack){
                    System.out.print(q.getData() + " ");
                }
                System.out.println();
                
                s = stack.remove(stack.size()-1);
                visited.add(s);
                if(s.getData().equals(goal)){
                    return s.getData();
                }
                else{
                    if (count<a){
                        for(GraphNode child: s.links){
                            if (!visited.contains(child)){
                                stack.add(child);
                            }
                        }
                        count++;
                    }
                }
            }
        }
        return null;
    }
    
    public static String IDS(GraphNode node, int maxDepth){
        for (int i = 0; i<maxDepth; i++){
            visited.clear();
            if (LDS(node, i)!=null){
                return "yes";
            }
            System.out.print("Visited:");
            for (GraphNode q: visited){
                System.out.print(q.getData() + " ");
            }
            System.out.println();
            System.out.println("---------------------------");
        }
        return null;
    }
}
