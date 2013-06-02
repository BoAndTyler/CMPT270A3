
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linearstructures;

/**
 *
 * @author cmc133
 */
public class LINEARsTRUCTURES {

    /**
     * @param args the command line arguments
     */
    LinkedList myLlist = new LinkedList();
    OrdDllist myOrdDllist = new OrdDllist();
    
    public static void main(String[] args) {
        // TODO code application logic here
     LINEARsTRUCTURES lstructuresApp = new LINEARsTRUCTURES();
     
     
     // implement testing and driving code here
     try {
     // ***** Testing code for Llist, Stack and queue
         // make sure list is empty
     if (!(lstructuresApp.myLlist.isEmpty())) {
         throw new Exception("Llist reports not empty when it really is empty");
     }
     // insert something and test that it is there
     lstructuresApp.myLlist.insertInfo("Hello");
     if (lstructuresApp.myLlist.isEmpty()) {
         throw new Exception("Llist reports empty when it really is not empty");
     }
     String traversedListString = lstructuresApp.myLlist.traverseList();
     if (traversedListString.compareTo("Hello") != 0) 
         throw new Exception("Did not return correct content list!");
     lstructuresApp.myLlist.insertInfo("World");
     traversedListString = lstructuresApp.myLlist.traverseList();
     if (traversedListString.compareTo("World, Hello") != 0) 
         throw new Exception("Did not return correct content list with two elements!");
     lstructuresApp.myLlist.deleteInfo("Hello");
     traversedListString = lstructuresApp.myLlist.traverseList();
     if (traversedListString.compareTo("World") != 0) 
         throw new Exception("Did not return correct content list with one element after delete! "+traversedListString);
     
     // now test stack implementation
     lstructuresApp.myLlist = new LinkedList();
     StackInterface aStack = lstructuresApp.myLlist;
     
     aStack.stackPush("First in");
     
     aStack.stackPush("Second in");
     
     String stackTop = aStack.stackPop();
     if (stackTop.compareTo("Second in") != 0) 
         throw new Exception("Did not return correct top of stack! "+stackTop);
     stackTop = aStack.stackPop();
     if (stackTop.compareTo("First in") != 0) 
         throw new Exception("Did not return correct top of stack! "+stackTop);
     
     // now test queue implementation
     lstructuresApp.myLlist = new LinkedList();
     queueInterface aQueue = lstructuresApp.myLlist;
     aQueue.queueJoin("First in");
     aQueue.queueJoin("Second in");
     aQueue.queueJoin("Third in");
     
     String queueFront = aQueue.queueLeave();
     if (queueFront.compareTo("First in") != 0) 
         throw new Exception("Did not return correct front of queue! "+queueFront);
     queueFront = aQueue.queueLeave();
     if (queueFront.compareTo("Second in") != 0) 
         throw new Exception("Did not return correct front of queue! "+queueFront);
     queueFront = aQueue.queueLeave();
     if (queueFront.compareTo("Third in") != 0) 
         throw new Exception("Did not return correct front of queue! "+queueFront);
     
     
     // ***** Testing code for OrdDllist    
     // make sure list is empty
         System.out.println("Testing for empty list when empty.");
     if (!(lstructuresApp.myOrdDllist.isEmpty())) {
         throw new Exception("OrdDllist reports not empty when it really is empty");
     }
     // insert something and test that it is there
     System.out.println("Testing for non-empty list when non-empty.");
     lstructuresApp.myOrdDllist.OrdDlistInsert("Hello");
     if (lstructuresApp.myOrdDllist.isEmpty()) {
         throw new Exception("Llist reports empty when it really is not empty");
     }
     traversedListString = lstructuresApp.myOrdDllist.traverseList();
     System.out.println("Testing for corect traversal of single item list.");
     if (traversedListString.compareTo("Hello") != 0) 
         throw new Exception("Did not return correct content list!");
     System.out.println("Testing for correct traversal of two element list with second element inserted after first one.");
     lstructuresApp.myOrdDllist = lstructuresApp.myOrdDllist.OrdDlistInsert("World");
     traversedListString = lstructuresApp.myOrdDllist.traverseList();
     if (traversedListString.compareTo("Hello, World") != 0) 
         throw new Exception("Did not return correct content list with two elements! Returned: "+traversedListString);
     // insert third element before first one
     System.out.println("Testing for correct traversal of three element list with third element inserted before first one.");
     lstructuresApp.myOrdDllist = lstructuresApp.myOrdDllist.OrdDlistInsert("About");
     traversedListString = lstructuresApp.myOrdDllist.traverseList();
     if (traversedListString.compareTo("About, Hello, World") != 0) 
         throw new Exception("Did not return correct content list with three elements! Returned: "+traversedListString);
     
     // now test an insert in the middle
     System.out.println("Testing for correct traversal of three element list with fourth element inserted between first and second one.");
     lstructuresApp.myOrdDllist = lstructuresApp.myOrdDllist.OrdDlistInsert("Bragging");
     traversedListString = lstructuresApp.myOrdDllist.traverseList();
     if (traversedListString.compareTo("About, Bragging, Hello, World") != 0) 
         throw new Exception("Did not return correct content list with four elements! Returned: "+traversedListString);
     
     // now create a long list then try deleting from various positions
     lstructuresApp.myOrdDllist = new OrdDllist();
     lstructuresApp.myOrdDllist.OrdDlistInsert("A");
     lstructuresApp.myOrdDllist.OrdDlistInsert("B");
     lstructuresApp.myOrdDllist.OrdDlistInsert("C");
     // test 1 delete front value
     System.out.println("List before delete at front: "+lstructuresApp.myOrdDllist.traverseList());
     lstructuresApp.myOrdDllist = lstructuresApp.myOrdDllist.OrdDlistDelete("A");
     traversedListString = lstructuresApp.myOrdDllist.traverseList();
     if (traversedListString.compareTo("B, C") != 0) 
         throw new Exception("Did not delete properly, list is: ["+traversedListString+"]");
     
     // test 2 delete end value
     lstructuresApp.myOrdDllist = new OrdDllist();
     lstructuresApp.myOrdDllist.OrdDlistInsert("A");
     lstructuresApp.myOrdDllist.OrdDlistInsert("B");
     lstructuresApp.myOrdDllist.OrdDlistInsert("C");
     System.out.println("List before delete at end: "+lstructuresApp.myOrdDllist.traverseList());
     lstructuresApp.myOrdDllist = lstructuresApp.myOrdDllist.OrdDlistDelete("C");
     traversedListString = lstructuresApp.myOrdDllist.traverseList();
     if (traversedListString.compareTo("A, B") != 0) 
         throw new Exception("Did not delete properly, list is: ["+traversedListString+"]");
     
     // test 3 delete in middle
     lstructuresApp.myOrdDllist = new OrdDllist();
     lstructuresApp.myOrdDllist.OrdDlistInsert("A");
     lstructuresApp.myOrdDllist.OrdDlistInsert("B");
     lstructuresApp.myOrdDllist.OrdDlistInsert("C");
     System.out.println("List before delete at end: "+lstructuresApp.myOrdDllist.traverseList());
     lstructuresApp.myOrdDllist = lstructuresApp.myOrdDllist.OrdDlistDelete("B");
     traversedListString = lstructuresApp.myOrdDllist.traverseList();
     if (traversedListString.compareTo("A, C") != 0) 
         throw new Exception("Did not delete properly, list is: ["+traversedListString+"]");
     } // end of try block
     catch (Exception e) {
         System.out.println(e.getMessage());
     }
     
     // done app tests
     System.out.println("Tests complete!");
     }
    }