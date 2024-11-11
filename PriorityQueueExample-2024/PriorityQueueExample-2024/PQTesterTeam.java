
/**
 * Write a description of class PQTesterTeam here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.PriorityQueue;

public class PQTesterTeam
{
    // TODO Auto-generated method stub
    public static void main (String []args) {

        PriorityQueue <Team> pq = new PriorityQueue<Team> ();
        pq.add(new Team ("Manchester United", 20));
        pq.add (new Team ("Sheffield Wednesday", 4));
        pq.add (new Team ("Sunderland", 6));
        pq.add (new Team ("Manchester City", 10));
        while (!pq.isEmpty()) {
            System.out.println (pq.poll());   
        }
    }
}
