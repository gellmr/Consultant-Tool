/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  PartTimeConsultantDocumentListener.java
 * 
 * Purpose:    Abstract class.
 * 
 *             Handles updates to text-based input fields (JTextArea or JTextField)
 * 
 *             for a PartTimeConsultant who's details are shown in the DetailsPanel.
 * 
 *             The following tutorial provides more information about using DocumentListener:
 * 
 *             http://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 * 
 *      Provide a concrete implementation of PartTimeConsultantDocumentListener, which
 * 
 *      has a method body for "protected void manipulate(String docText)"
 * 
 *      Create a JTextArea or JTextField and attach the listener to it.
 * 
 *      When the user types text into the JTextArea or JTextField, events are generated
 * 
 *      while the user is typing. These update events are forwarded to manipulate() by MyDocumentListener.
 * 
 *      In the method body of manipulate(), you can call getMyConsultant() to gain access to the
 * 
 *      PartTimeConsultant object, and perform work on it.
 *      
 * 
 *      Expected Output:
 *      
 *      Calling getMyConsultant() returns the PartTimeConsultant object.
 */

package consultanttool3;


public abstract class PartTimeConsultantDocumentListener extends MyDocumentListener
{


    /**
     * Store the PartTimeConsultant who's data will be manipulated by this handler.
     * 
     * Subclasses will be able to carry out their manipulations on this object.
     */
    private PartTimeConsultant m_myConsultant;


    
    
    /**
     * Mutator method. Set the PartTimeConsultant who's data is to be manipulated by this handler.
     * 
     * @param c PartTimeConsultant object from the model.
     */
    public final void setConsultant(PartTimeConsultant c)
    {
        m_myConsultant = c;
    }

    
    
    /**
     * Accessor method - provides subclasses with the PartTimeConsultant object that is to be manipulated.
     * 
     * @return PartTimeConsultant object.
     */
    protected final PartTimeConsultant getMyConsultant()
    {
        return m_myConsultant;
    }
}
