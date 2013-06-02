/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linearstructures;

/**
 *
 * @author cmc133
 */
public class OrdDllist extends LinkedList {
    OrdDllist prevDlist;
    OrdDllist nextDlist;
    
    public OrdDllist() {
        super();
        prevDlist = null;
        nextDlist = null;
    }
    public OrdDllist OrdDlistDelete(String outInfo) {
        // delete outInfo from the list if it exists
        // base case 1 - list is empty nothing to delete
        if (this.isEmpty()) return (this);
        
        if (this.info.compareTo(outInfo) == 0) {
            // base case 2 - I am it and have one empty list
            if (this.prevDlist.isEmpty()) {
                System.out.println("I am it and have left empty list");
                // get rid of prev
                this.info = "";
                this.prevDlist.nextDlist = null; // break its ref to me
                this.prevDlist = null; // break my ref to it
                this.amEmpty = true;
                return (this.nextDlist);
            }
            if (this.nextDlist.isEmpty()) {
                System.out.println("I am it and have right empty list");
                // get rid of next
                this.info = "";
                this.nextDlist.prevDlist = null; // break its ref to me
                this.nextDlist = null; // break my ref to it
                this.amEmpty = true;
                return (this);
            }
            // get rid of me in middle of list
            System.out.println("I am it and am in the middle");
            this.prevDlist.nextDlist = this.nextDlist;
            this.nextDlist.prevDlist = this.prevDlist;
            // return the reference to left
            OrdDllist returnList = this.prevDlist;
            this.prevDlist = null;
            this.nextDlist = null;
            return (returnList); 
        }
        // must be somewhere later in list if it exists
        this.nextDlist.OrdDlistDelete(outInfo);
        return (this);
    }
    public String traverseList() {
        // add current content to list returned by the rest of the list
        if (this.isEmpty())
            return "";
        if (this.nextDlist.isEmpty())
            return this.info;
        return this.info+", "+this.nextDlist.traverseList();
    }
    public OrdDllist OrdDlistInsert(String inInfo) {
        if (this.isEmpty()) {
            info = inInfo;
            // am I at right end?
            if (nextDlist == null) {
                // right end empty insert
                nextDlist = new OrdDllist();
                nextDlist.prevDlist = this;    
            }
            // am I at left end?
            if (prevDlist == null) {
                // right end empty insert
                prevDlist = new OrdDllist();
                prevDlist.nextDlist = this;    
            }
            amEmpty = false;
            return (this);
        }
        // insert to left?
        if (this.info.compareTo(inInfo) > 0) {
            return (this.prevDlist.OrdDlistInsert(inInfo));
        }
        
        // insert between us? Next list can not be empty...
        if (!(this.nextDlist.isEmpty())) {
          if (this.nextDlist.info.compareTo(inInfo) > 0) {
            // insert between
            OrdDllist tempDlist = new OrdDllist();
            tempDlist.OrdDlistInsert(inInfo);
            tempDlist.prevDlist = this;
            tempDlist.nextDlist = this.nextDlist;
            this.nextDlist.prevDlist = tempDlist;
            this.nextDlist = tempDlist;
            return (this); 
           }
        }
        // later in list
        this.nextDlist.OrdDlistInsert(inInfo);
        return(this);
                
    }
}