/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ConsultantTool3.java
 * 
 * Purpose:    Entry point to the application.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 * 
 *      None required.
 *      
 * 
 *      Expected Output:
 * 
 *      Calls the unit testing module.
 * 
 *      Starts the application.
 */

package consultanttool3;


public class ConsultantTool3
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        UnitTesting.runUnitTests();
     
        boolean startWithTestData = true; // true - model starts with some objects in it.
        
        Application application = new Application(startWithTestData);
    }
    
}
