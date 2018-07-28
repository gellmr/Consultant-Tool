/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ConsultantDateInput.java
 * 
 * Purpose:    A DateInput which is associated with a particular Consultant.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 *    
 *      When you create an instance of ConsultantDateInput, you pass some
 * 
 *      listeners to its constructor, which are fired by the various inputs.
 * 
 *         - DAY_OF_MONTH input uses a JTextField and fires a MyDocumentListener.
 * 
 *         - MONTH        input uses a JComboBox  and fires an ActionListener.
 * 
 *         - YEAR         input uses a JTextField and fires a MyDocumentListener.
 * 
 *      After creating this object, you can call setMyConsultant(c) to set the
 * 
 *      consultant for all the listeners you have just specified.
 * 
 * 
 * 
 *      Expected Output:
 *      
 *      In your event handler code for the MyDocumentListeners and ActionListener above,
 * 
 *      you can call getMyConsultant() to gain access to the consultant object,
 * 
 *      and perform some work on it.
 */


package consultanttool3;

import java.util.GregorianCalendar;


public class ConsultantDateInput extends DateInput
{
    
    

    /**
     * Project to be manipulated by the handler of this input.
     */
    private Consultant m_myConsultant;
    
    
    
    /**
     * Event Listeners associated with this input.
     */
    private ConsultantDocumentListener m_dayOfMonthListener;
        
    private ConsultantActionListener m_monthListener;
        
    private ConsultantDocumentListener m_yearListener;
    
    
    
    
    /**
     * Default Constructor.
     */
    public ConsultantDateInput()
    {
        super();
    }
    
    
    
    
    
    /**
     * Constructor with arguments.
     * 
     * @param calendar GregorianCalendar with the desired  DAY_OF_MONTH / MONTH / YEAR  values.
     * 
     * @param dayOfMonthListener  ConsultantDocumentListener, to be called when the DAY_OF_MONTH input is fired.
     * 
     * @param monthListener       ConsultantActionListener,          to be called when the MONTH input is fired.
     * 
     * @param yearListener        ConsultantDocumentListener, to be called when the YEAR input is fired.
     */
    public ConsultantDateInput(
            
        GregorianCalendar calendar,

        ConsultantDocumentListener dayOfMonthListener,

        ConsultantActionListener monthListener,

        ConsultantDocumentListener yearListener
    )
    {
        super(calendar, dayOfMonthListener, monthListener, yearListener);
        
        m_dayOfMonthListener = dayOfMonthListener;
        
        m_monthListener = monthListener;
        
        m_yearListener = yearListener;
    }
    
    
    
    
    
    
    
    /**
     * Mutator method. Set the Consultant that is linked to this GUI input.
     * 
     * @param c Consultant object to manipulate.
     */
    public void setMyConsultant(Consultant c)
    {
        m_myConsultant = c;
        
        m_dayOfMonthListener.setConsultant(m_myConsultant);
        
        m_monthListener.setMyConsultant(m_myConsultant);
        
        m_yearListener.setConsultant(m_myConsultant);
    }
    
    
    
    
    
    /**
     * Accessor method. Get the Consultant that is linked to this GUI input.
     * 
     * @return Consultant object, to manipulate.
     */
    public Consultant getMyConsultant()
    {
        return m_myConsultant;
    }
}
