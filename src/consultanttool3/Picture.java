/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  Picture.java
 * 
 * Purpose:   (Part of the data model) A Picture of an employee.
 * 
 *             Stores a filename (String) and the date taken (GregorianCalendar).
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 *    
 *      Clients of this class can use the Mutator methods provided.
 * 
 * 
 *      Expected Output:
 *      
 *      Clients of this class can use the Accessor methods provided.
 *      
 *      When printing the contents of the data model to console, see the
 * 
 *      toString() method.
 */


package consultanttool3;

import java.io.Serializable;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;



public class Picture implements Serializable
{
    
    
    /**
     * Filename of the image. May be null.
     */
    private String m_absFilePath;
    
    
    
    /**
     * The date this picture was taken.
     * 
     * Contains (YEAR, MONTH, DAY_OF_MONTH)
     */
    private GregorianCalendar m_dateTaken;
    
    
    
    
    /**
     * The image loaded from hard disk.
     */
    private ImageIcon m_imageIcon;
    
    
    
    
    
    /**
     * Default Constructor.
     * 
     * Initializes the filename to null, indicating there is no picture.
     * 
     * Initializes the date taken to today's date. Uses GregorianCalendar.
     */
    public Picture()
    {
        m_absFilePath = null; // no picture.
        
        
        // Initialise the picture with today's date.
        
        GregorianCalendar todayCalendar = (GregorianCalendar)GregorianCalendar.getInstance(); // Current time, default time zone, default locale.
        
        setDateTaken(todayCalendar);
    }
    
    
    
    
    
    
    
    /**
     * Constructor with arguments.
     * 
     * @param absFilePath String - Filename of the image. May be null.
     * 
     * @param dateTaken GregorianCalendar object - The date this picture was taken.
     */
    public Picture(String absFilePath, GregorianCalendar dateTaken)
    {
        this();
        
        setFileName(absFilePath);
        
        setDateTaken(dateTaken);
    }
    
    
    
    
    
    
    
    /**
     * Copy Constructor.
     * 
     * @param otherPicture Picture to copy construct with.
     */
    public Picture(Picture otherPicture)
    {
        this(otherPicture.getFileName(), otherPicture.getDateTaken());
    }
    
    
    
    
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return String value - the filename of the picture. May be null. Will not be an empty string.
     */
    public final String getFileName()
    {
        return m_absFilePath;
    }
    
    
    
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return GregorianCalendar object, containing (YEAR, MONTH, DAY_OF_MONTH). Tells the date this picture was taken.
     */
    public final GregorianCalendar getDateTaken()
    {
        return m_dateTaken;
    }
    
    
    
    
    
    
    /**
     * Convenience method.
     * 
     * @return String value - the date this picture was taken, or the string "null"
     */
    public String getDateTakenStr()
    {
        if (m_dateTaken == null)
        {
            return "null";
        }
        else
        {
            return String.format("Year: %s Month: %s DayOfMonth: %s",

                m_dateTaken.get(GregorianCalendar.YEAR),
               
                m_dateTaken.get(GregorianCalendar.MONTH),

                m_dateTaken.get(GregorianCalendar.DAY_OF_MONTH)
            );
        }
    }
    
    
    
    
    
    /**
     * Mutator method.
     * 
     * Set the filename of this picture.
     * 
     * @param absFilePath String - file path of the picture. May be null. If length == 0 then it is saved as null.
     */
    public final void setFileName(String absFilePath)
    {
        if (absFilePath != null && absFilePath.length() == 0)
        {
            m_absFilePath = null; // no picture.
            
            return;
        }
        
        m_absFilePath = absFilePath;
        
        m_imageIcon = ImageLoader.getImageIcon(m_absFilePath);
        
    }
    
    
    
    
    
    /**
     * Get the ImageIcon so we can display it.
     * 
     * @return ImageIcon (may be null)
     */
    public ImageIcon getImageIcon()
    {
        return m_imageIcon;
    }
    
    
    
    
    
    
    /**
     * Set the date the picture was taken.
     * 
     * @param calendar GregorianCalendar object, containing (YEAR, MONTH, DAY_OF_MONTH)
     * 
     * @throws ArrayIndexOutOfBoundsException if the given values are not legal (correct) calendar values.
     */
    public final void setDateTaken(GregorianCalendar calendar) throws ArrayIndexOutOfBoundsException
    {
        if (calendar == null)
        {
            m_dateTaken = null;
            
            return;
        }
        
        m_dateTaken = new GregorianCalendar();
        
        m_dateTaken.setLenient(true); // Use forgiving Calendar, which adjusts bad input for us.
        
        m_dateTaken.set(GregorianCalendar.YEAR, calendar.get(GregorianCalendar.YEAR));
        
        m_dateTaken.set(GregorianCalendar.MONTH, calendar.get(GregorianCalendar.MONTH));
        
        m_dateTaken.set(GregorianCalendar.DAY_OF_MONTH, calendar.get(GregorianCalendar.DAY_OF_MONTH));
        
    }
}
