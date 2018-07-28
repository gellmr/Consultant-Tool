/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  FullTimeConsultant.java
 * 
 * Purpose:   (Part of the data model) Represents a Consultant who works full time and has an annual salary.
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


public class FullTimeConsultant extends Consultant
{
    
    
    
    /**
     * Annual Salary in Dollars
     */
    private int m_annualSalary;
    
    
    
    
    /**
     * Default annual salary.
     */
    protected static final int defaultAnnualSalary = 80000; // 80 K
    
    
    
    
    /**
     * Allows a client class to know what the default annual salary should be.
     * 
     * @return int value.
     */
    public static int getDefaultAnnualSalary()
    {
        return defaultAnnualSalary;
    }
    
    
    
    
    /**
     * Tells what kind of consultant we are.
     */
    @Override
    public ConsultantType getMyType()
    {
        return ConsultantType.FULL_TIME_CONSULTANT;
    }
    
    
    
    
    
    
    
    /**
     * Default Constructor
     */
    public FullTimeConsultant()
    {
        super();
        
        setAnnualSalary(defaultAnnualSalary);
    }
    
    
    
    
    /**
     * Constructor with arguments.
     * 
     * @param name         String
     * 
     * @param address      Address
     * 
     * @param gender       String
     * 
     * @param pic          Picture
     * 
     * @param annualSalary int
     */
    public FullTimeConsultant(String name, Address address, GenderType gender, Picture pic, int annualSalary)
    {
        super(name, address, gender, pic);
        
        setAnnualSalary(annualSalary);
    }
    
    
    
    
    
    
    /**
     * Constructor with vanilla Consultant Argument.
     * 
     * @param otherConsultant a vanilla Consultant object, to construct with.
     */
    public FullTimeConsultant(Consultant otherConsultant)
    {
        super( otherConsultant ); // Consultant copy constructor.
        
        setAnnualSalary(defaultAnnualSalary);
        
        m_projects = new LinkedList<Project>(otherConsultant.m_projects); // copy projects
    }
    
    
    
    
    
    
    /**
     * Copy Constructor.
     * 
     * @param otherConsultant FullTimeConsultant object to construct with.
     */
    public FullTimeConsultant(FullTimeConsultant otherConsultant)
    {
        this(
            otherConsultant.getName(),
            
            otherConsultant.getAddress(),
            
            otherConsultant.getGender(),
            
            otherConsultant.getPicture(),
            
            otherConsultant.getAnnualSalary()
        );
        
        m_projects = new LinkedList<Project>(otherConsultant.m_projects); // copy projects
    }
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return int value - the annual salary (in dollars) of this Employee.
     */
    public final int getAnnualSalary()
    {
        return m_annualSalary;
    }
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param salary - int value, the annual salary (in dollars) of this Employee.
     */
    public final void setAnnualSalary(int salary)
    {
        m_annualSalary = salary;
    }
    
}
