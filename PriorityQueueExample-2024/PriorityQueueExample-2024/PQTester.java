
/**
 * 
 */

/**
 * @author delgadomatac
 *
 */
import java.util.PriorityQueue;
public class PQTester {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        PriorityQueue <Integer> pq = new PriorityQueue<Integer> ();
        pq.add(new Integer(13));
        pq.add(new Integer(7) );
        pq.add(new Integer(11));
        pq.add(new Integer(3));
        pq.add(new Integer(5));
        pq.add(new Integer(17));
        pq.add(new Integer(2));            

        while (!pq.isEmpty()) {
            System.out.println (pq.poll());                 
        }
        
 
    }
}
