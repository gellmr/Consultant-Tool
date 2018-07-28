/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ControlException.java
 * 
 * Purpose:    Not really an exception, I am just taking advantage of the way
 * 
 *             an exception can act like an immediate return statement.
 * 
 *             Sometimes its easier to deliberately throw an exception than to
 *
 *             write logic for a return statement.
 * 
 *             I have used this as a "general purpose" exception class,
 * 
 *             which is probably not the best thing, because in retrospect it has
 * 
 *             muddied my code. I should have created more specific exception types
 * 
 *             or used existing types, rather than blur the purpose of this class.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 * 
 *      Optionally add a message. Behaves like any plain Exception, but we have
 * 
 *      our own type so we don't mess up the hierarchy of catch statements.
 *      
 * 
 *      Expected Output:
 * 
 *      I was using this class to help me ignore events that I didn't want to respond to,
 * 
 *      which were being generated from clicking on items in a JList.
 * 
 *      The "getIsUnfinishedSelection()" method was used to help me tell whether the exception
 * 
 *      was from such an occurrence. I didn't want to print stack traces when that happened.
 */


package consultanttool3;


public class ControlException extends Exception
{
    
    
    
    /**
     * Indicates whether this exception was thrown because the user has not
     * 
     * finished making a selection in a JList, and we want to exit the event handler
     * 
     * rather than respond to the event. True if this is the case.
     */
    private boolean m_isUnfinishedSelection = false;
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param b boolean value - True if this exception was thrown because the user has not
     * 
     * finished making a selection in a JList, and we want to exit the event handler
     * 
     * rather than respond to the event.
     */
    public void setIsUnfinishedSelection(boolean b)
    {
        m_isUnfinishedSelection = b;
    }
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return boolean value - True if this exception was thrown because the user has not
     * 
     * finished making a selection in a JList, and we want to exit the event handler
     * 
     * rather than respond to the event.
     */
    public boolean getIsUnfinishedSelection()
    {
        return m_isUnfinishedSelection;
    }
    
    
    
    
    /**
     * Default Constructor.
     */
    public ControlException()
    {
        super();
    }
    
    
    
    
    /**
     * Constructor with argument.
     * 
     * @param s String value, a message describing the exception that has occurred.
     */
    public ControlException(String s)
    {
        super(s);
    }
}
