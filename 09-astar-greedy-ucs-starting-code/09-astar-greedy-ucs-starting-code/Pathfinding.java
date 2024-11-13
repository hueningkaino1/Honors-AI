import java.util.*;
/**
 * Write a description of class Pathfinding here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pathfinding
{
    // map (PF) goes here
    
    public void makeNodes(){
        PFNode 4W01 = new PFNode("4W01");
        PFNode 4W02 = new PFNode("4W02");
        PFNode 4W03 = new PFNode("4W03");
        PFNode 4W04 = new PFNode("4W04");
        PFNode 4W05 = new PFNode("4W05");
        PFNode 4W06 = new PFNode("4W06");
        PFNode 4W07 = new PFNode("4W07");
        PFNode 4W08 = new PFNode("4W08");
        PFNode 4W09 = new PFNode("4W09");
        PFNode 4W10 = new PFNode("4W10");
        PFNode 4W11 = new PFNode("4W11");
        PFNode 4W12 = new PFNode("4W12");
        PFNode 4W13 = new PFNode("4W13");
        PFNode 4W14 = new PFNode("4W14");
        PFNode 4W15 = new PFNode("4W15");
        PFNode 4W17 = new PFNode("4W17");
        PFNode 4W18 = new PFNode("4W18");
        PFNode 4W19 = new PFNode("4W19");
        PFNode 4W20 = new PFNode("4W20");
        
    }
    
    public void createLinks(){
        4W01.addLink(4W02,180+436);
        4W02.addLink(4W15,382+548);
        4W03.addLink(4W15, 405+810);
        4W04.addLink(4W15, 465+680);
    }
    
    
    // handle your input here ?
    
    // if main is short most of the entry point for your algorithms 
    // should go here
    
    
    // SLD table
    
    // (static) methods for:
    //  UCS
    //  Greedy
    //  A*
    
}
