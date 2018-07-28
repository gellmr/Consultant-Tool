/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ConsultantComboBox.java
 * 
 * Purpose:    This class allows you to create a JComboBox that is related to a specific Consultant.
 * 
 *             In your ActionListener, you can invoke event.getSource().getMyConsultant() to gain access
 * 
 *             to the consultant object, then perform some work on it.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 *    
 *      Set the consultant when the JComboBox is created.
 * 
 * 
 *      Expected Output:
 *      
 *      In your implementation of actionPerformed(), invoke event.getSource().getMyConsultant()
 * 
 *      to gain access to the consultant object.
 */


package consultanttool3;

import javax.swing.JComboBox;



public class ConsultantComboBox extends JComboBox
{
    
    
    
    /**
     * The consultant object associated with this combo box.
     */
    private Consultant m_myConsultant;
    
    
    
    
    
    /**
     * Default Constructor.
     */
    public ConsultantComboBox()
    {
        super();
    }
    
    
    
    
    
    /**
     * Constructor with argument.
     * 
     * @param array Object[]
     */
    public ConsultantComboBox(Object[] array)
    {
        super(array);
    }
    
    
    
    
    /**
     * Mutator method. Set the consultant object associated with this combo box.
     * 
     * @param c Consultant object.
     */
    public final void setMyConsultant(Consultant c)
    {
        m_myConsultant = c;
    }
    
    
    
    
    /**
     * Accessor method. Get the consultant object associated with this combo box.
     * 
     * @return Consultant object.
     */
    public final Consultant getMyConsultant()
    {
        return m_myConsultant;
    }
}
