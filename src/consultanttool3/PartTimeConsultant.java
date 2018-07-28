/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  PartTimeConsultant.java
 * 
 * Purpose:   (Part of the data model) Represents a Consultant who works part time,
 * 
 *             has an hourly rate, and has a maximum allowed number of working hours per week.
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

import java.util.LinkedList;


public class PartTimeConsultant extends Consultant
{
    
    /**
     * Hourly rate in dollars, that this employee is paid.
     */
    private int m_hourlyRate;
    
    
    /**
     * Maximum number of hours per week, this employee may work.
     */
    private int m_maxHours;
    
    
    
    
    /**
     * Default hourly rate in dollars.
     */
    private final static int m_defaultHourlyRate = 60; // dollars an hour.
    
    
    
    /**
     * Default maximum number of hours per week this employee may work.
     */
    private final static int m_defaultMaxHours = 20; // hours per week.
    
    
    
    
    /**
     * Allows a client class to know what the default hourly rate should be.
     * 
     * @return int value, the default hourly rate.
     */
    public static int getDefaultHourlyRate()
    {
        return m_defaultHourlyRate;
    }
    
    
    
    /**
     * Allows a client class to know what the default maximum number of hours should be.
     * 
     * @return int value, the default maximum number of hours.
     */
    public static int getDefaultMaxHours()
    {
        return m_defaultMaxHours;
    }
    
    
    /**
     * Tells what kind of consultant we are.
     */
    @Override
    public ConsultantType getMyType()
    {
        return ConsultantType.PART_TIME_CONSULTANT;
    }
    
    
    
    
    /**
     * Default Constructor
     */
    public PartTimeConsultant()
    {
        super();
        
        setHourlyRate(m_defaultHourlyRate);
        
        setMaxHours(m_defaultMaxHours);
    }
    
    
    
    
    /**
     * Constructor with arguments.
     * 
     * @param name String value, the name of the consultant.
     * 
     * @param address Address object, the address of the consultant.
     * 
     * @param gender Employee.GenderType enumeration value, the gender of the consultant.
     * 
     * @param pic Picture object, a picture of the consultant.
     * 
     * @param hourlyRate int value - Hourly rate in dollars, that this employee is paid.
     * 
     * @param maxHours int value - Maximum number of hours per week, this employee may work. 
     */
    public PartTimeConsultant(String name, Address address, Employee.GenderType gender, Picture pic, int hourlyRate, int maxHours)
    {
        super(name, address, gender, pic);
        
        setHourlyRate(hourlyRate);
        
        setMaxHours(maxHours);
    }
    
    
    
    
    
    /**
     * Constructor with vanilla Consultant Argument.
     * 
     * @param otherConsultant a vanilla Consultant object, to construct with.
     */
    public PartTimeConsultant(Consultant otherConsultant)
    {
        super(
            otherConsultant
        );
        
        setHourlyRate(m_defaultHourlyRate);
        
        setMaxHours(m_defaultMaxHours);
        
        m_projects = new LinkedList<Project>(otherConsultant.m_projects); // copy projects
    }
    
    
    
    
    
    /**
     * Copy Constructor.
     * 
     * @param partTimeConsultant PartTimeConsultant object to construct with.
     */
    public PartTimeConsultant(PartTimeConsultant otherConsultant)
    {
        this(
            otherConsultant.getName(),
            
            otherConsultant.getAddress(),
            
            otherConsultant.getGender(),
            
            otherConsultant.getPicture(),
            
            otherConsultant.getHourlyRate(),
            
            otherConsultant.getMaxHours()
        );
        
        m_projects = new LinkedList<Project>(otherConsultant.m_projects); // copy projects
    }
    
    
    
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param rate - int value, the hourly rate in dollars that this employee is paid.
     */
    public final void setHourlyRate(int rate)
    {
        m_hourlyRate = rate;
    }
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param max - int value, the maximum number of hours per week that this employee may work.
     */
    public final void setMaxHours(int max)
    {
        m_maxHours = max;
    }
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return int value, the hourly rate in dollars that this employee is paid.
     */
    public final int getHourlyRate()
    {
        return m_hourlyRate;
    }
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return int value, the maximum number of hours per week that this employee may work.
     */
    public final int getMaxHours()
    {
        return m_maxHours;
    }
    
    
    
}
