/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  DateInput.java
 * 
 * Purpose:    A JPanel with three input components (DAY_OF_MONTH, MONTH, YEAR) to manipulate a Date value.
 * 
 *             This class also provides some static methods for working with GregorianCalendar objects.
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
 * 
 *      Expected Output:
 * 
 *      EventListeners are fired as the user interacts with the components.
 */


package consultanttool3;


import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.*;


public class DateInput extends JPanel
{
    
    /**
     * String array, the months of the year.
     */
    String[] months = new String[]
    {
        "January", "February", "March",    "April",    "May",      "June",
        
        "July",    "August",   "September", "October", "November", "December"
    };

    
    
    /**
     * Text input fields for DAY_OF_MONTH, MONTH, YEAR
     */
    private JTextField m_text_DD = new JTextField("");          // DAY_OF_MONTH
    
    private JComboBox m_combox_MM = new JComboBox(months);      // MONTH
    
    private JTextField m_text_YYYY = new JTextField("");        // YEAR
    
    
    
    /**
    * Width and height of the text input fields.
    */
    private int m_textFieldWidth = 40;
    
    private int m_comboBoxWidth = 90;
        
    private int m_textFieldHeight = 30;
    
    
    
    
    /**
     * Default Constructor
     */
    public DateInput()
    {
        super();
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        
        m_text_DD.setMinimumSize(  new Dimension(m_textFieldWidth, m_textFieldHeight));
        
        m_text_DD.setMaximumSize(  new Dimension(m_textFieldWidth, m_textFieldHeight));
        
        m_text_DD.setPreferredSize(new Dimension(m_textFieldWidth, m_textFieldHeight));
        
        
        m_combox_MM.setMinimumSize(  new Dimension(m_comboBoxWidth, m_textFieldHeight));
        
        m_combox_MM.setMaximumSize(  new Dimension(m_comboBoxWidth, m_textFieldHeight));
        
        m_combox_MM.setPreferredSize(new Dimension(m_comboBoxWidth, m_textFieldHeight));
        
        
        m_text_YYYY.setMinimumSize(  new Dimension(m_textFieldWidth, m_textFieldHeight));
        
        m_text_YYYY.setMaximumSize(  new Dimension(m_textFieldWidth, m_textFieldHeight));
        
        m_text_YYYY.setPreferredSize(new Dimension(m_textFieldWidth, m_textFieldHeight));
        
        
        add(new JLabel("Day:"));
        
        add(Box.createHorizontalStrut(8));
        
        add(m_text_DD);
        
        add(Box.createHorizontalStrut(29));
        
        
        add(new JLabel("Month:"));
        
        add(Box.createHorizontalStrut(8));
        
        add(m_combox_MM);
        
        add(Box.createHorizontalStrut(29));
        
        
        add(new JLabel("Year:"));
        
        add(Box.createHorizontalStrut(8));
        
        add(m_text_YYYY);
    }
    
    
    
    
    /**
     * Private constructor. Sets the listeners for the text input fields.
     * 
     * @param dayOfMonthListener MyDocumentListener Listener that responds to updates of the DAY_OF_MONTH input field.
     * 
     * @param monthListener      ActionListener     Listener that responds to updates of the MONTH input field.
     * 
     * @param yearListener       MyDocumentListener Listener that responds to updates of the YEAR input field.
     */
    private DateInput(
            
        MyDocumentListener dayOfMonthListener,

        ActionListener monthListener,

        MyDocumentListener yearListener
    )
    {
        this();
        
        try
        {
            m_text_DD.getDocument().addDocumentListener(dayOfMonthListener);
        }
        catch(NullPointerException ex)
        {
            // m_text_DD will have no listener.
        }
        
        try
        {
            m_combox_MM.addActionListener(monthListener);
        }
        catch(NullPointerException ex)
        {
            // m_text_MM will have no listener.
        }
        
        try
        {
            m_text_YYYY.getDocument().addDocumentListener(yearListener);
        }
        catch(NullPointerException ex)
        {
            // m_text_YYYY will have no listener.
        }
    }
    
    
    
    
    /**
     * Constructor with calendar argument
     * 
     * @param calendar GregorianCalendar with the desired  DAY_OF_MONTH / MONTH / YEAR  values.
     * 
     * @param dayOfMonthListener  MyDocumentListener that responds to updates of the DAY_OF_MONTH input field.
     * 
     * @param monthListener       ActionListener     that responds to updates of the MONTH input field.
     * 
     * @param yearListener        MyDocumentListener that responds to updates of the YEAR input field.
     */
    public DateInput(
            
        GregorianCalendar calendar,

        MyDocumentListener dayOfMonthListener,

        ActionListener monthListener,

        MyDocumentListener yearListener
    )
    {
        this(dayOfMonthListener, monthListener, yearListener);
        
        try
        {
            m_text_DD.setText(Integer.toString(calendar.get(GregorianCalendar.DAY_OF_MONTH)));

            m_combox_MM.setSelectedIndex(calendar.get(GregorianCalendar.MONTH));

            m_text_YYYY.setText(Integer.toString(calendar.get(GregorianCalendar.YEAR)));
        }
        catch(NullPointerException ex)
        {
            m_text_DD.setText("");

            m_combox_MM.setSelectedIndex(0);
            
            m_text_YYYY.setText("");
        }
        
    }




    
    
    /**
     * Given two GregorianCalendar objects, compare them for equality, insofar
     * 
     * as we care about accuracy for this program (matching day, month, year).
     * 
     * If both are null, they are considered equal.
     * 
     * @param cal1 GregorianCalendar object.
     * 
     * @param cal2 GregorianCalendar object.
     * 
     * @return boolean true if they are considered equal.
     */
    public static boolean compareDates(GregorianCalendar cal1, GregorianCalendar cal2)
    {
        if (cal1 == null && cal2 == null)
        {
            return true;
        }
        
        if (
            cal1.get(GregorianCalendar.DAY_OF_MONTH) == cal2.get(GregorianCalendar.DAY_OF_MONTH) &&

            cal1.get(GregorianCalendar.MONTH)        == cal2.get(GregorianCalendar.MONTH) &&

            cal1.get(GregorianCalendar.YEAR)         == cal2.get(GregorianCalendar.YEAR)
        )
        {
            return true;
        }
        
        return false;
    }
    
    
    
    
    
    
    /**
     * Public static convenience method.  Sets the day of month for a GregorianCalendar object.
     * 
     * @param cal GregorianCalendar object to set.
     * 
     * @param dayOfMonth int value, the new DAY_OF_MONTH value.
     */
    public static void setDayOfMonth(GregorianCalendar cal, int dayOfMonth)
    {
        cal.set(

            cal.get(GregorianCalendar.YEAR),          // YEAR

            cal.get(GregorianCalendar.MONTH),         // MONTH

            dayOfMonth,                               // DAY_OF_MONTH

            0, 0, 0
        );
    }
    
    
    /**
     * Public static convenience method.  Sets the day of month for a GregorianCalendar object.
     * 
     * @param cal GregorianCalendar object to set.
     * 
     * @param dayOfMonth String value, the new DAY_OF_MONTH value.
     */
    public static void setDayOfMonth(GregorianCalendar cal, String dayOfMonth)
    {
        try
        {
            DateInput.setDayOfMonth(cal, Integer.parseInt(dayOfMonth));
        }
        catch(java.lang.NumberFormatException ex)
        {
            DateInput.setDayOfMonth(cal, 0); // set to zero.
        }
    }
    
    
    
    
    
    
    /**
     * Public static convenience method.  Sets the month for a GregorianCalendar object.
     * 
     * @param cal GregorianCalendar object to set.
     * 
     * @param month int value, the new MONTH value.
     */
    public static void setMonth(GregorianCalendar cal, int month)
    {
        cal.set(

            cal.get(GregorianCalendar.YEAR),          // YEAR

            month,                                    // MONTH

            cal.get(GregorianCalendar.DAY_OF_MONTH),  // DAY_OF_MONTH

            0, 0, 0
        );
    }
    
    
    /**
     * Public static convenience method.  Sets the month for a GregorianCalendar object.
     * 
     * @param cal GregorianCalendar object to set.
     * 
     * @param month String value, the new MONTH value.
     */
    public static void setMonth(GregorianCalendar cal, String month)
    {
        try
        {
            DateInput.setMonth(cal, Integer.parseInt(month));
        }
        catch(java.lang.NumberFormatException ex)
        {
            DateInput.setMonth(cal, 0); // set to zero.
        }
    }
    
    
    
    
    
    
    
    
    /**
     * Public static convenience method.  Sets the year for a GregorianCalendar object.
     * 
     * @param cal GregorianCalendar object to set.
     * 
     * @param year int value, the new YEAR value.
     */
    public static void setYear(GregorianCalendar cal, int year)
    {
        cal.set(

            year,                                     // YEAR

            cal.get(GregorianCalendar.MONTH),         // MONTH

            cal.get(GregorianCalendar.DAY_OF_MONTH),  // DAY_OF_MONTH

            0, 0, 0
        );
    }
    
    
    /**
     * Public static convenience method.  Sets the year for a GregorianCalendar object.
     * 
     * @param cal GregorianCalendar object to set.
     * 
     * @param year String value, the new YEAR value.
     */
    public static void setYear(GregorianCalendar cal, String year)
    {
        try
        {
            DateInput.setYear(cal, Integer.parseInt(year));
        }
        catch(java.lang.NumberFormatException ex)
        {
            DateInput.setYear(cal, 0); // set to zero.
        }
    }
    
    
    
    
    
    /**
     * Convert int value 0-11 into a string describing the month.
     * 
     * @param month int value (0 ... 11)
     * 
     * @return String value   ("January" ... "December")
     */
    private static String getAsMonth(int month)
    {
        switch(month)
        {
            case 0:
                return "January";
                
            case 1:
                return "February";
                
            case 2:
                return "March";
                
            case 3:
                return "April";
                
            case 4:
                return "May";
                
            case 5:
                return "June";
                
            case 6:
                return "July";
                
            case 7:
                return "August";
                
            case 8:
                return "September";
                
            case 9:
                return "October";
                
            case 10:
                return "November";
                
            case 11:
                return "December";
                
        }
        return "";
    }
    
    
    
    
    
    /**
     * Given a GregorianCalendar object, return the date as a string.
     * 
     * @param cal GregorianCalendar object.
     * 
     * @return String of the following format:  "Day: 11  November  Year: 2011"
     */
    public static String getDateAsString(GregorianCalendar cal)
    {
        if (cal == null)
        {
            return null;
        }
        
        String out = String.format(

            "Day: %d   Month: %s   Year: %d",

            cal.get(GregorianCalendar.DAY_OF_MONTH),

            getAsMonth( cal.get(GregorianCalendar.MONTH) ),

            cal.get(GregorianCalendar.YEAR)
        );

        return out;
    }
}
