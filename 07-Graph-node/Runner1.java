
/**
 * Write a description of class Runner1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner1
{
    // instance variables - replace the example below with your own
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
        
        A.addLink(B);
        A.addLink(H);
        A.addLink(I);
        A.addLink(N);
        
        B.addLink(M);
        B.addLink(J);
        B.addLink(C);
        
        C.addLink(D);
        
        D.addLink(E);
        
        E.addLink(F);
        E.addLink(K);
        
        F.addLink(G);
        F.addLink(L);
        
        G.addLink(H);
        
        GraphNode[] nodes = {A, B, C, D, E, F, G, H, I, J, K, L, M, N};
        for (GraphNode node: nodes){
            System.out.println(node);
        }
    }
}
