/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ProjectDateInput.java
 * 
 * Purpose:    A DateInput which is associated with a particular Project.
 * 
 *             A DateInput is a JPanel with three input components:
 * 
 *            (DAY_OF_MONTH, MONTH, YEAR) for manipulating a Date value.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 *      
 *      Receives a GregorialCalendar object to use for setting the initial value of the components.
 * 
 *      Receives EventListener objects for attaching to each component.
 * 
 *      The client class can set which project object is associated with this DateInput by calling setMyProject()
 * 
 * 
 * 
 *      Expected Output:
 *      
 *      EventListeners are fired as the user interacts with the components.
 * 
 *       - DAY_OF_MONTH input uses a JTextField and fires a MyDocumentListener.
 * 
 *       - MONTH        input uses a JComboBox  and fires an ActionListener.
 * 
 *       - YEAR         input uses a JTextField and fires a MyDocumentListener.
 */


package consultanttool3;

import java.awt.event.ActionListener;
import java.util.GregorianCalendar;


public class ProjectDateInput extends DateInput
{
    
    

    /**
     * Project to be manipulated by the handler of this input.
     */
    private Project m_project;
    
    
    
    
    /**
     * Default Constructor.
     */
    public ProjectDateInput()
    {
        super();
    }
    
    
    
    
    
    /**
     * Constructor with arguments.
     * 
     * @param calendar GregorianCalendar with the desired  DAY_OF_MONTH / MONTH / YEAR  values.
     * 
     * @param dayOfMonthListener  ProjectDocumentListener, to be called when the DAY_OF_MONTH input is fired.
     * 
     * @param monthListener       ActionListener,          to be called when the MONTH input is fired.
     * 
     * @param yearListener        ProjectDocumentListener, to be called when the YEAR input is fired.
     */
    public ProjectDateInput(
            
        GregorianCalendar calendar,

        MyDocumentListener dayOfMonthListener,

        ActionListener monthListener,

        MyDocumentListener yearListener
    )
    {
        super(calendar, dayOfMonthListener, monthListener, yearListener);
    }
    
    
    
    
    
    
    
    /**
     * Mutator method. Set the project that is linked to this GUI input.
     * 
     * @param p Project object to manipulate
     */
    public void setMyProject(Project p)
    {
        m_project = p;
    }
    
    
    
    
    
    /**
     * Accessor method. Get the project that is linked to this GUI input.
     * 
     * @return Project object to manipulate
     */
    public Project getMyProject()
    {
        return m_project;
    }
}
