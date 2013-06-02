/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linearstructures;

/**
 *
 * @author cmc133
 */
public interface StackInterface {
    // this interface provides STACK (LIFO) access to the underlying data structure
    // Two operations exist on STACK: Push(info) and info <-- Pop()
    // The ADT definitions are:
    /**
     * PUSH(info): info becomes the top of the STACK the last item inserted
     * info <-- POP(): if the stack is empty nothing is returned
     *                 if the stack is not empty the first item in the list is returned and removed from the stack
     * 
     */
    
    void stackPush(String inInfo);
    String stackPop();
}
