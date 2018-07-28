/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  Address.java
 * 
 * Purpose:   (Part of the data model) Represent the address of an employee. 
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


/**
 * Represents the address of an employee.
 */
public class Address implements Serializable
{
    
    /**
     * House number
     */
    private int m_streetNumber;
    
    
    /**
     * Street Name
     */
    private String m_streetName;
    
    
    /**
     * Suburb
     */
    private String m_suburb;
    
    
    /**
     * Post Code
     */
    private int m_postCode;
    
    
    
    
    /**
     * Default Constructor.
     */
    public Address()
    {
        m_streetNumber = -1;
        
        m_streetName = "no street name";
        
        m_suburb = "no suburb";
        
        m_postCode = -1;
    }
    
    
    
    /**
     * Constructor with Arguments.
     */
    public Address(int streetNumber, String streetName, String suburb, int postCode)
    {
        this();
        
        setStreetNumber(streetNumber);
        
        setStreetName(streetName);
        
        setSuburb(suburb);
        
        setPostCode(postCode);
    }
    
    
    /**
     * Copy Constructor.
     * 
     * @param a Address object to copy construct with.
     */
    public Address(Address a)
    {
        this();
        
        setStreetNumber(a.getStreetNumber());
        
        setStreetName(a.getStreetName());
        
        setSuburb(a.getSuburb());
        
        setPostCode(a.getPostCode());
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * Mutator method.
     * 
     * @param n int value, the number of the house. 
     */
    public final void setStreetNumber(int n)
    {
        m_streetNumber = n;
    }
    
    
    
    /**
     * Mutator method.
     * 
     * @param n String value, the name of the street.
     */
    public final void setStreetName(String n)
    {
        m_streetName = n;
    }
    
    
    
    /**
     * Mutator method.
     * 
     * @param s String value, the suburb. 
     */
    public final void setSuburb(String s)
    {
        m_suburb = s;
    }
    
    
    
    /**
     * Mutator method.
     * 
     * @param p int value, the post code.
     */
    public final void setPostCode(int p)
    {
        m_postCode = p;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    /**
     * Accessor Method.
     * 
     * @return int value, the number of the house.
     */
    public final int getStreetNumber()
    {
        return m_streetNumber;
    }
    
    
    
    /**
     * Accessor Method.
     * 
     * @return String value, the name of the street.
     */
    public final String getStreetName()
    {
        return m_streetName;
    }
    
    
    
    /**
     * Accessor Method.
     * 
     * @return String value, the suburb.
     */
    public final String getSuburb()
    {
        return m_suburb;
    }
    
    
    
    /**
     * Accessor Method.
     * 
     * @return int value, the post code.
     */
    public final int getPostCode()
    {
        return m_postCode;
    }
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Override method - toString
     * 
     * @return String representation of this object.
     */
    @Override
    public String toString()
    {
        return String.format(
                
              "      Street Name  : %s%n"
                
            + "      Street Number: %d%n"
                
            + "      Suburb       : %s%n"
                
            + "      Post Code    : %d%n",
            
            getStreetName(),
            
            getStreetNumber(),
            
            getSuburb(),
            
            getPostCode()
        );
    }
}
