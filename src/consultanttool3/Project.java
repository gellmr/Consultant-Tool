/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  Project.java
 * 
 * Purpose:   (Part of the data model) Represent a Project.
 * 
 * 
 * Cardinality:  A Project has (zero or one) Consultants.  (0..1)
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


public class Project implements Serializable
{
    
    /**
     * Boolean value, tells if the project is finished or not. True if finished.
     */
    private boolean m_finished = false;
    
    
    /**
     * A short descriptive name for this project.
     */
    private String m_projectShortName;
    
    
    
    /**
     * The unique ID for this project.
     */
    private int m_projectId = 0;
    
    
    
    /**
     * The cost in dollars per hour that is charged for this project.
     */
    private int m_costCharged;
    
    
    
    
    /**
     * The name of the client for this project.
     */
    private String m_clientName;
    
    
    
    
    /**
     * The consultant for this project. May be null.
     */
    private Consultant m_consultant;
    
    
    
    
    /**
     * The starting date for this project.
     */
    private GregorianCalendar m_startingDate;
    
    
    
    /**
     * The proposed finishing date for this project.
     */
    private GregorianCalendar m_proposedFinishingDate;
    
    
    
    /**
     * The actual finishing date for this project (may be null)
     */
    private GregorianCalendar m_actualFinishingDate;
    
    
    
    /**
     * A longer description of this project (paragraph)
     */
    private String m_description;
    
    
    
    
    
    
    
    
    /**
     * Default Constructor.
     */
    public Project()
    {
        m_consultant = null; // This project has no consultant.
        
        m_projectId = ProjectID.getNextId();
        
        m_projectShortName = "Project_" + m_projectId;
        
        m_clientName = "no name";
        
        m_costCharged = 100;
        
        m_startingDate = (GregorianCalendar)GregorianCalendar.getInstance(); // Today, now.
        
        m_proposedFinishingDate = (GregorianCalendar)GregorianCalendar.getInstance(); // Today, now.
        
        m_actualFinishingDate = null;
        
        m_description = "no description";
    }
    
    
    
    
    
    /**
     * Constructor with arguments.
     * 
     * @param shortName            String value - single phrase description of this project.
     * 
     * @param clientName           String value - the client for this Project.
     * 
     * @param costPerHour          int value (dollars)
     * 
     * @param startDate            GregorianCalendar object
     * 
     * @param proposedFinishDate   GregorianCalendar object
     * 
     * @param actualFinishDate     GregorianCalendar object (may be null)
     * 
     * @param description          String value - paragraph description of this project.
     * 
     * @param consultant           InspectableConsultant object assigned to this project.
     */
    public Project(
            
        String shortName,
            
        String clientName,
        
        int costPerHour,
        
        GregorianCalendar startDate,
        
        GregorianCalendar proposedFinishDate,
        
        GregorianCalendar actualFinishDate,
        
        String description,
        
        Consultant consultant)
    {
        this();
        
        setConsultant(consultant); // Set the consultant for this project.
        
        setProjectShortName(shortName);
        
        setClientName(clientName);
        
        setCostCharged(costPerHour);
        
        setStartingDate(startDate);
        
        setProposedFinishingDate(proposedFinishDate);
        
        setActualFinishingDate(actualFinishDate);
        
        setDescription(description);
    }
    
    
    
    
    
    
    
    
    
    /**
     * Copy Constructor.
     * 
     * @param otherProject Project object to construct with.
     */
    public Project(Project otherProject)
    {
        this(
            otherProject.getProjectShortName(),

            otherProject.getClientName(),

            otherProject.getCostCharged(),

            otherProject.getStartingDate(),

            otherProject.getProposedFinishingDate(),

            otherProject.getActualFinishingDate(),

            otherProject.getDescription(),

            otherProject.getConsultant()
        );
    }
    
    
    
    
    
    
    /**
     * Mutator method - sets whether this project is finished or not.
     * 
     * @param finished boolean value.
     */
    public final void setFinished(boolean finished)
    {
        m_finished = finished;
    }
    
    
    
    /**
     * Accessor method - tells if this project is finished or not.
     * 
     * @return boolean value. True if the project is finished.
     */
    public final boolean isFinished()
    {
        return m_finished;
    }
    
    
    
    /**
     * Mutator method - sets the name of the project.
     * 
     * @param name - String value. Single phrase description of this project.
     */
    public final void setProjectShortName(String name)
    {
        m_projectShortName = name;
    }
    
    
    
    
    
    /**
     * Private method.
     * 
     * Mutator method - sets the id of this project.
     * 
     * @param id - int value. Must be unique.
     */
    private void setProjectID(int id)
    {
        m_projectId = id;
    }
    
    
    
    
    
    /**
     * Mutator method - sets the name of the client for this project.
     * 
     * @param name - String value.
     */
    public final void setClientName(String name)
    {
        m_clientName = name;
    }
    
    
    
    
    /**
     * Mutator method - sets the cost in dollars per hour, for this project.
     * 
     * @param cost - int value. Dollars per hour.
     */
    public final void setCostCharged(int cost)
    {
        m_costCharged = cost;
    }
    
    
    
    
    
    /**
     * Mutator method - sets the starting Date of this project.
     * 
     * @param d - Date object.
     */
    public final void setStartingDate(GregorianCalendar d)
    {
        m_startingDate.set(GregorianCalendar.DAY_OF_MONTH, d.get(GregorianCalendar.DAY_OF_MONTH));
        
        m_startingDate.set(GregorianCalendar.MONTH, d.get(GregorianCalendar.MONTH));
        
        m_startingDate.set(GregorianCalendar.YEAR, d.get(GregorianCalendar.YEAR));
    }
    
    
    
    /**
     * Mutator method - sets the proposed finishing Date of this project.
     * 
     * @param d - Date object.
     */
    public final void setProposedFinishingDate(GregorianCalendar d)
    {
        m_proposedFinishingDate.set(GregorianCalendar.DAY_OF_MONTH, d.get(GregorianCalendar.DAY_OF_MONTH));
        
        m_proposedFinishingDate.set(GregorianCalendar.MONTH, d.get(GregorianCalendar.MONTH));
        
        m_proposedFinishingDate.set(GregorianCalendar.YEAR, d.get(GregorianCalendar.YEAR));
    }
    
    
    
    
    /**
     * Mutator method - sets the actual finishing Date of this project.
     * 
     * @param d - Date object. May be null.
     */
    public final void setActualFinishingDate(GregorianCalendar d)
    {
        if (d == null)
        {
            m_actualFinishingDate = null;
        }
        else
        {
            if (m_actualFinishingDate == null)
            {
                m_actualFinishingDate = (GregorianCalendar)GregorianCalendar.getInstance();
            }
            m_actualFinishingDate.set(GregorianCalendar.DAY_OF_MONTH, d.get(GregorianCalendar.DAY_OF_MONTH));
        
            m_actualFinishingDate.set(GregorianCalendar.MONTH, d.get(GregorianCalendar.MONTH));

            m_actualFinishingDate.set(GregorianCalendar.YEAR, d.get(GregorianCalendar.YEAR));
        }
    }
    
    
    
    
    
    /**
     * Mutator method - sets the consultant for this project.
     * 
     * @param consultant - Consultant object. You can pass null.
     */
    public final void setConsultant(Consultant consultant)
    {
        m_consultant = consultant;
    }
    
    
    
    
    
    
    /**
     * Mutator method - sets the description string of this project.
     * 
     * @param description - String value. (Paragraph)
     */
    public final void setDescription(String description)
    {
        m_description = description;
    }
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return - String value (single phrase) description of the project.
     */
    public final String getProjectShortName()
    {
        return m_projectShortName;
    }
    
    
    
    /**
     * Accessor method.
     * 
     * @return - int value representing the project ID.
     */
    public final int getProjectID()
    {
        return m_projectId;
    }
    
    
    /**
     * Accessor method.
     * 
     * @return - String value representing the name of the client for this project.
     */
    public final String getClientName()
    {
        return m_clientName;
    }
    
    
    /**
     * Accessor method.
     * 
     * @return - int value representing the cost of this project charged per hour.
     */
    public final int getCostCharged()
    {
        return m_costCharged;
    }
    
    
    /**
     * Accessor method.
     * 
     * @return Date object - the starting date of this project.
     */
    public final GregorianCalendar getStartingDate()
    {
        return m_startingDate;
    }
    
    
    /**
     * Accessor method.
     * 
     * @return Date object - the proposed finishing date of this project.
     */
    public final GregorianCalendar getProposedFinishingDate()
    {
        return m_proposedFinishingDate;
    }
    
    
    /**
     * Accessor method.
     * 
     * @return Date object - the actual finishing date of this project.
     */
    public final GregorianCalendar getActualFinishingDate()
    {
        return m_actualFinishingDate;
    }
    
    
    /**
     * Accessor method.
     * 
     * @return String value - a (paragraph) description of this project.
     */
    public final String getDescription()
    {
        return m_description;
    }
    
    
    /**
     * Accessor method.
     * 
     * @return InspectableConsultant object - the consultant for this project. May be null.
     */
    public final Consultant getConsultant()
    {
        return m_consultant;
    }
    
    
    
//    /**
//     * Override toString method.
//     * 
//     * @return String value - the shortname for this Project.
//     */
//    @Override
//    public String toString()
//    {
//        return m_projectShortName;
//    }
  
    
    
    
    
    
    /**
     * Convenience method.
     * 
     * @return String value - the start date, or the string "null"
     */
    public String getStartDateStr()
    {
        if (m_startingDate == null)
        {
            return "null";
        }
        else
        {
            return String.format("Year: %s Month: %s DayOfMonth: %s",

                m_startingDate.get(GregorianCalendar.YEAR),
               
                m_startingDate.get(GregorianCalendar.MONTH),

                m_startingDate.get(GregorianCalendar.DAY_OF_MONTH)
            );
        }
    }
    
    
    
    
    
    
    
    
    /**
     * Convenience method.
     * 
     * @return String value - the proposed finishing date, or the string "null"
     */
    public String getProposedFinDateStr()
    {
        if (m_proposedFinishingDate == null)
        {
            return "null";
        }
        else
        {
            return String.format("Year: %s Month: %s DayOfMonth: %s",

                m_proposedFinishingDate.get(GregorianCalendar.YEAR),
               
                m_proposedFinishingDate.get(GregorianCalendar.MONTH),

                m_proposedFinishingDate.get(GregorianCalendar.DAY_OF_MONTH)
            );
        }
    }
    
    
    
    
    
    
    /**
     * Convenience method.
     * 
     * @return String value - the actual finishing date, or the string "null"
     */
    public String getActualFinDateStr()
    {
        if (m_actualFinishingDate == null)
        {
            return "null";
        }
        else
        {
            return String.format("Year: %s Month: %s DayOfMonth: %s",

                m_actualFinishingDate.get(GregorianCalendar.YEAR),
               
                m_actualFinishingDate.get(GregorianCalendar.MONTH),

                m_actualFinishingDate.get(GregorianCalendar.DAY_OF_MONTH)
            );
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
        String consultantName = "(Consultant == null)";
        
        Consultant c = getConsultant();

        if (c != null)
        {
            consultantName = c.getName();
        }
        
        return String.format(
                  "Project-------------%n"
                + "   ProjectShortName: %s%n"
                + "          ProjectID: %d%n"
                + "       Cost Charged: %d%n"
                + "        Client Name: %s%n"
                + "    Consultant Name: %s%n"
                + "         Start Date: %s%n"
                + "  Proposed Fin Date: %s%n"
                + "    Actual Fin Date: %s%n"
                + "        Description: %s%n"
                + "%n",
                getProjectShortName(),
                getProjectID(),
                getCostCharged(),
                getClientName(),
                consultantName,
                getStartDateStr(),
                getProposedFinDateStr(),
                getActualFinDateStr(),
                getDescription()
        );
    }
}

