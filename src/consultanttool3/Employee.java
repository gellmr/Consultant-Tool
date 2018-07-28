/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  Employee.java
 * 
 * Purpose:   (Part of the data model) Represents an Employee.
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


public class Employee implements Serializable
{
    
    
    /**
     * Enum, tells the possible gender options for an employee.
     */
    public enum GenderType
    {
        FEMALE,
        
        MALE,
        
        OTHER;
    }
    
    
    
    
    /**
     * Static counter.
     * 
     * Used to generate unique ID values for instances of this Class.
     */
    private static int nextId;
    
    
    
    
    
    /**
     * Private method to generate the next unique Employee ID.
     * 
     * @return int value
     */
    private int getNextId()
    {
        return ++nextId;
    }
    
    
    //////////////////////////////////////////////////////////////////////
    
    
    
    
    
    
    /**
     * Unique ID - int value.
     */
    private int m_employeeID;
    
    
    /**
     * Name of the employee.
     */
    private String m_name;
    
    
    /**
     * Address of the employee.
     */
    private Address m_address;
    
    
    /**
     * Gender of the employee.
     */
    private GenderType m_gender;
    
    
    /**
     * Picture for this employee. If constructed with no arguments, the picture has no image.
     */
    private Picture m_picture = new Picture();
    
    
    
    
    //////////////////////////////////////////////////////////////////////
    
    
    
    
    /**
     * equality comparison method.
     * 
     * @param obj Employee object.
     * 
     * @return true if the objects are considered equal.
     */
    public boolean equals(Employee obj)
    {
        if (
            obj.getId() == this.getId()
                
            &&
                
            obj.getName().equals(this.getName())
                
            &&
                
            obj.getAddress() == this.getAddress()
                
            &&
                
            obj.getGender().equals(this.getGender())
        )
        {
            return true;
        }
        return false;
    }
    
    
    
    
    
    /**
     * Default Constructor.
     */
    public Employee()
    {
        m_employeeID = getNextId();
        
        m_name = "no name";
        
        m_address = new Address();
        
        m_gender = GenderType.FEMALE;
        
        setPicture(null);
    }
    
    
    
    
    
    
    
    
    /**
     * Constructor with arguments.
     * 
     * @param name String - the name of the employee.
     * 
     * @param address Address - the address of the employee.
     * 
     * @param gender String - the gender of the employee.
     * 
     * @param picture Picture - the picture of this employee. May be null.
     */
    public Employee(String name, Address address, GenderType gender, Picture picture)
    {
        this();
        
        setName(name);
        
        setAddress(address);
        
        setGender(gender);
        
        setPicture(picture);
    }
    

    
    
    
    
    
    /**
     * Copy Constructor.
     * 
     * @param employee Employee - object to construct with.
     * 
     */
    public Employee(Employee employee)
    {
        this();
        
        setName(employee.getName());
        
        setAddress(employee.getAddress());
        
        setGender(employee.getGender());
        
        setPicture(employee.getPicture());
        
        setId(employee.getId()); // copy the id.
    }

    
    
    
    
    //////////////////////////////////////////////////////////////////////
    
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return int value - the unique ID of this employee.
     */
    public final int getId()
    {
        return m_employeeID;
    }
    
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return String value - the name of the employee
     */
    public final String getName()
    {
        return m_name;
    }
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return Address value - the address of this employee.
     */
    public final Address getAddress()
    {
        return m_address;
    }
    
    
    
    /**
     * Accessor method.
     * 
     * @return String value - represents the gender of this employee.
     */
    public final GenderType getGender()
    {
        return m_gender;
    }
    
    
    
    
    /**
     * Accessor method.
     * 
     * Get the portrait of this employee.
     * 
     * @return Picture object. If it was constructed with no arguments, the Picture object has no image.
     */
    public final Picture getPicture()
    {
        return m_picture;
    }
    
    
    //////////////////////////////////////////////////////////////////////
    
    
    
    
    /**
     * Called Internally.
     * 
     * Set the unique ID of this employee.
     * 
     * @param id - int value
     */
    private void setId(int id)
    {
        m_employeeID = id;
    }
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param name - String value, the name of this employee.
     */
    public final void setName(String name)
    {
        m_name = name;
    }
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param address - Address value, the address of this employee.
     */
    public final void setAddress(Address address)
    {
        m_address = address;
    }
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param gender - String value, the gender of this employee.
     */
    public final void setGender(GenderType gender)
    {
        m_gender = gender;
    }
    
    
    
    
    
    /**
     * Mutator method.
     * 
     * If null is passed to this method, the Employee will have a picture with no image.
     * 
     * @param picture - Picture, the portrait of this employee.
     */
    public final void setPicture(Picture p)
    {
        if (p != null)
        {
            m_picture = p;
        }
        else
        {
            m_picture = new Picture(); // Picture with no image.
        }
    }
    
    
    
    
    
    /**
     * Override method - toString
     * 
     * @return String representation of this object.
     */
    @Override
    public String toString()
    {
        String picFile = "(picture has no filename)";
        
        String picDate = "(picture has no date-taken)";
        
        Picture pic = getPicture();
        
        if (pic != null)
        {
            picFile = pic.getFileName();
            
            picDate = pic.getDateTakenStr();
        }
        
        return String.format(
                
              "      Employee Name: %s%n"
                
            + "            Address: %s%n" // too many newline characters here ?
                
            + "        Employee ID: %d%n"
                
            + "             Gender: %s%n"
                
            + "   Picture Filename: %s%n"
                
            + "  Picture DateTaken: %s%n",
            
            getName(),
            
            getAddress(),
            
            getId(),
            
            getGender(),
            
            picFile,
            
            picDate
        );
    }
}
