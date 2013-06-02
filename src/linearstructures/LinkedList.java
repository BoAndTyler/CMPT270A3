/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linearstructures;

/**
 *
 * @author cmc133
 */
public class LinkedList implements StackInterface, queueInterface {
  // this class implements the standard abstract data type linked list as an object
    String info;
    LinkedList nextList;
   protected boolean amEmpty;
    
    // interface methods here
    // QUEUE interface
    public void queueJoin(String inInfo) {
      // Join(info): info becomes the end of the QUEUE the last item inserted
        this.insertInfo(inInfo);
    }
    public String queueLeave() {
     // info <-- Leave(): if the queue is empty nothing is returned
     //                 if the queue is not empty the last item in the list is returned and removed from the queue
        if (this.isEmpty()) { return null;}
        // if last item in list return and remove else leave from rest of queue
        String tempString;
        if (this.nextList.isEmpty()) {
            tempString = this.info;
            this.deleteInfo(tempString);
        }  else {
            // get from later in list
            tempString = this.nextList.queueLeave();
        }
        return tempString;
    }
    
    //STACK interface
    public void stackPush(String inInfo) {
    // PUSH(info): info becomes the top of the STACK the last item inserted
    // we can simply enter it into list since list places item at beginning (top of stack)
        this.insertInfo(inInfo);
}
    public String stackPop() {
    // info <-- POP(): if the stack is empty nothing is returned
    //                 if the stack is not empty the first item in the list is returned and removed from the stack    
        if (this.isEmpty()) { return null; }
        String tempInfo = this.info; // first item in list
        this.deleteInfo(tempInfo);   // remove from list
        return(tempInfo);
    }
    // end of interface methods
    
    public LinkedList() {
        info = "";
        nextList = null;
        amEmpty = true;
    }
    public boolean isEmpty() {
        return (amEmpty);
    }
    public void insertInfo(String inInfo) {
        if (this.amEmpty) {
            LinkedList tempLList = new LinkedList();
            // insert info here and add a new empty at end
            info = inInfo;
            nextList = tempLList;
            amEmpty = false;
        }
        else {
            
            this.nextList.insertInfo(this.info);
            this.info = inInfo;
            
        }
    }
    public void deleteInfo(String outInfo) {
        if (this.amEmpty)
            return;
  
        // check if this is the info to delete
        if (this.info.compareTo(outInfo) != 0) {
//                System.out.println("Didn't match so looking further down list");
                this.nextList.deleteInfo(outInfo);
                return;
        } 
        // found it so delete it
        if (this.nextList.isEmpty()) {
                this.nextList = null;
                this.info = "";
                amEmpty = true;
//                System.out.println("Deleting from last element");
        }
        else {
                this.info = this.nextList.info; // copy next info to current
                this.nextList.deleteInfo(this.info);
//                System.out.println("Shifted info forward and deleting down rest of list");
            }
        }
    public String traverseList() {
        // add current content to list returned by the rest of the list
        if (this.isEmpty())
            return "";
        if (this.nextList.isEmpty())
            return this.info;
        return this.info+", "+this.nextList.traverseList();
    }
}
