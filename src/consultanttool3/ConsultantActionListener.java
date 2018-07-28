/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ConsultantActionListener.java
 * 
 * Purpose:    An (abstract) ActionListener that is associated with a consultant.
 * 
 *             This class is abstract so you need to create a subclass and implement
 * 
 *             the actionPerformed() method. When this method is called, you should
 * 
 *             invoke getMyConsultant() to gain access to the consultant object,
 * 
 *             then perform some work on it.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 *    
 *      Set the consultant when the listener is created.
 * 
 *      It will be available to the ActionListener object when the event is fired.
 * 
 * 
 *      Expected Output:
 *      
 *      In your implementation of actionPerformed(), invoke getMyConsultant()
 * 
 *      to gain access to the consultant object.
 */


package consultanttool3;

import java.awt.event.ActionListener;


public abstract class ConsultantActionListener implements ActionListener
{

    
    /**
     * The consultant object associated with this listener.
     */
    private Consultant m_myConsultant;
    
    
    
    
    
    /**
     * Default Constructor.
     */
    public ConsultantActionListener()
    {
        super();
    }
    
    
    
    
    /**
     * Constructor with argument.
     * 
     * @param c Consultant object to be manipulated by this listener.
     */
    public ConsultantActionListener(Consultant c)
    {
        super();
        
        setMyConsultant(c);
    }
    
    
    
    
    /**
     * Mutator method. Set the consultant object associated with this listener.
     * 
     * @param c Consultant object.
     */
    public final void setMyConsultant(Consultant c)
    {
        m_myConsultant = c;
    }
    
    
    
    
    /**
     * Accessor method. Get the consultant object associated with this listener.
     * 
     * @return Consultant object.
     */
    public final Consultant getMyConsultant()
    {
        return m_myConsultant;
    }

}
