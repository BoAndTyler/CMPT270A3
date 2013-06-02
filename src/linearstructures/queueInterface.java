/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linearstructures;

/**
 *
 * @author cmc133
 */
public interface queueInterface {
 // this interface provides QUEUE (FIFO) access to the underlying data structure
    // Two operations exist on QUEUE: Join(info) and info <-- Leave()
    // The ADT definitions are:
    /**
     * Join(info): info becomes the end of the QUEUE the last item inserted
     * info <-- Leave(): if the queue is empty nothing is returned
     *                 if the queue is not empty the last item in the list is returned and removed from the queue
     * 
     */   
    
    void queueJoin(String inInfo);
    String queueLeave();
}
