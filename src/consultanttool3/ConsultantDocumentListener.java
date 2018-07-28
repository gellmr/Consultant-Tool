/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ConsultantDocumentListener.java
 * 
 * Purpose:    Abstract class.
 * 
 *             Handles updates to text-based input fields (JTextArea or JTextField)
 * 
 *             for a Consultant who's details are shown in the DetailsPanel.
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
 *      Provide an implementation of ConsultantDocumentListener, which has a method body for
 * 
 *      protected void manipulate(String docText)
 * 
 *      Create a JTextArea or JTextField and attach the ConsultantDocumentListener to it.
 * 
 *      When the user types text into the JTextArea or JTextField, events are generated
 * 
 *      while the user is typing. These update events are forwarded to manipulate() by MyDocumentListener.
 * 
 *      In the method body of manipulate(), you can call getMyConsultant() to gain access to the
 * 
 *      consultant object, and perform work on it.
 *      
 * 
 *      Expected Output:
 *      
 *      Calling getMyConsultant() returns the consultant object.
 */

package consultanttool3;

public abstract class ConsultantDocumentListener extends MyDocumentListener
{


    /**
     * Store the consultant who's data will be manipulated by this handler.
     * 
     * Subclasses will be able to carry out their manipulations on this object.
     */
    private Consultant m_myConsultant;


    
    
    /**
     * Mutator method. Set the Consultant who's data is to be manipulated by this handler.
     * 
     * @param c Consultant object from the model.
     */
    public final void setConsultant(Consultant c)
    {
        m_myConsultant = c;
    }

    
    
    /**
     * Accessor method - provides subclasses with the Consultant object that is to be manipulated.
     * 
     * @return Consultant object.
     */
    protected final Consultant getMyConsultant()
    {
        return m_myConsultant;
    }
}
