/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ProjectID.java
 * 
 * Purpose:    Contains a static counter, used to generate unique ID values for Projects.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input: None.
 * 
 * 
 *      Expected Output:
 *      
 *      Invoke getNextId() to increment the counter and get its value.
 */

package consultanttool3;



public class ProjectID
{
    
    /**
     * Static counter.
     * 
     * Used to generate unique ID values for Projects.
     */
    private static int nextId;
    
    
    
    /**
     * Private method to generate the next unique Project ID.
     * 
     * @return int value
     */
    public static int getNextId()
    {
        return ++nextId;
    }
}
