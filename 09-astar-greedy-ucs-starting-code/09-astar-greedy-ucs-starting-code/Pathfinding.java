import java.util.*;
/**
 * write a description of class Pathfinding here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pathfinding
{
    // map (PF) goes here
    private int start;
    
    public void mcNodes(){
        PFNode w401 = new PFNode("w401");
        PFNode w402 = new PFNode("w402");
        PFNode w403 = new PFNode("w403");
        PFNode w404 = new PFNode("w404");
        PFNode w405 = new PFNode("w405");
        PFNode w406 = new PFNode("w406");
        PFNode w407 = new PFNode("w407");
        PFNode w408 = new PFNode("w408");
        PFNode w409 = new PFNode("w409");
        PFNode w410 = new PFNode("w410");
        PFNode w411 = new PFNode("w411");
        PFNode w412 = new PFNode("w412");
        PFNode w413 = new PFNode("w413");
        PFNode w414 = new PFNode("w414");
        PFNode w415 = new PFNode("w415");
        PFNode w417 = new PFNode("w417");
        PFNode w418 = new PFNode("w418");
        PFNode w419 = new PFNode("w419");
        PFNode w420 = new PFNode("w420");
        
        w401.addLink(w402,180+436);
        w402.addLink(w415,382+548);
        w403.addLink(w415, 405+810);
        w404.addLink(w415, 465+680);
        w405.addLink(w415, 430+60+1250);
        w406.addLink(w415, 480+1250);
        w407.addLink(w415, 190+1250);
        w408.addLink(w415, 480+123);
        w409.addLink(w415, 480+1240);
        w410.addLink(w415, 283+1240);
        w411.addLink(w415, 230+260+310+123+1240);
        w412.addLink(w415, 310+123+1240);
        w413.addLink(w415, 330+760);
        w414.addLink(w415, 380+630);
        w417.addLink(w415, 770+170+960);
        w418.addLink(w415, 810);
        w419.addLink(w415, 210+370+810);
        w420.addLink(w420, 1090);        
    }
    
    // handle your input here ?
    
    public void getInput(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Type a room number 1 - 20 excluding 15.");
        start = kb.nextInt();
    }
    
    // if main is short most of the entry point for your algorithms 
    // should go here
    
    
    // SLD table
    
    // (static) methods for:
    //  UCS
    //  Greedy
    //  A*
    
}
