
/**
 * Write a description of class Team here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Team implements Comparable
{
   private String name;
   private int leagues;
    
   public Team (String n, int l) {
       name = n;
       leagues =l;
       
   }
   
   public int compareTo (Object o) {
       Team other = (Team)o;
       return leagues - other.leagues;
   }
    
   public String toString () {
       return name + " " + leagues;
   }
}
