/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  Consultant.java
 * 
 * Purpose:   (Part of the data model) Represents a Consultant.
 * 
 * 
 * Cardinality:  A Consultant is responsible for zero or many Projects.
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class Consultant extends Employee
{
    
    
    /**
     * Enum, stores the valid types of consultant.
     */
    public enum ConsultantType
    {
        FULL_TIME_CONSULTANT,
        
        PART_TIME_CONSULTANT,
        
        VANILLA;
    }
    
    
    
    
    
    /**
     * Tells what kind of consultant we are. To be overriden by subclasses.
     */
    public ConsultantType getMyType()
    {
        return ConsultantType.VANILLA;
    }
    
    
    
    
    /**
     * Stores the Projects this Consultant is responsible for.
     */
    protected LinkedList<Project> m_projects;
    
    
    
    
    
    
    /**
     * Initialize the list of projects belonging to this Consultant.
     */
    private void initList()
    {
        m_projects = new LinkedList<Project>();
    }
    
    
    
    
    
    /**
     * Equality comparison method.
     * 
     * Invokes Employee.equals(Employee) method in superclass.
     * 
     * @param consultant Consultant object to compare against.
     * 
     * @return true if the objects are considered equal.
     */
    public boolean equals(Consultant consultant)
    {
        return super.equals(consultant);
    }
    
    
    
    
    
    /**
     * Default Constructor.
     */
    public Consultant()
    {
        super(); // Initialise Employee class.
        
        initList();
    }
    
    
    
    
    
    /**
     * Constructor with arguments.
     * 
     * @param name    String value  - the name    of this Consultant.
     * 
     * @param address Address value - the address of this Consultant.
     * 
     * @param gender  String value  - the gender  of this Consultant.
     * 
     * @param pic  Picture object   - the portrait of this Consultant.
     */
    public Consultant(String name, Address address, GenderType gender, Picture pic)
    {
        super(name, address, gender, pic); // Employee
        
        initList();
    }
    
    
    
    
    
    
    /**
     * Copy Constructor.
     * 
     * @param otherConsultant Consultant object to construct with.
     */
    public Consultant(Consultant otherConsultant)
    {
        super( otherConsultant ); // Employee copy constructor.
        
        //initList();
        
        m_projects = new LinkedList<Project>(otherConsultant.m_projects); // copy projects
    }
    
    
    
    
    
    
    /**
     * Add a project to this Consultant's list of projects.
     * 
     * @param p - Project object to add.
     */
    private void addProject(Project p)
    {
        m_projects.add(p);
    }
    
    
    
    
    /**
     * Remove a project from this Consultant's list of projects.
     * 
     * @param p - Project object to remove.
     */
    private void removeProject(Project p)
    {
        m_projects.remove(p);
    }
    
    
    
    
    
    /**
     * Get a list of all Project IDs.
     * 
     * @return ArrayList <Integer>
     */
    public ArrayList <Integer> getProjectIDList()
    {
        ArrayList <Integer> outArray = new ArrayList <Integer>();
        
        ListIterator < Project > iterator = m_projects.listIterator();
        
        while ( iterator.hasNext() )
        {
            Project project = iterator.next();
            
            outArray.add(project.getProjectID());
        }
        
        return outArray;
    }
    
    
    
    
    
    
    
//    /**
//     * Retrieve a Project, given its ID.
//     * 
//     * @param searchId  int - the ID of the Project to find.
//     * 
//     * @return Project object, or null if not found.
//     */
//    public Project getProjectById(int searchId)
//    {
//        ListIterator < Project > iterator = m_projects.listIterator();
//        
//        while ( iterator.hasNext() )
//        {
//            Project project = iterator.next();
//            
//            if (project.getProjectID() == searchId)
//            {
//                return project;
//            }
//        }
//        
//        return null; // Not found.
//    }
    
    
    
    
    

    
    
    
    
    
    
  
    /**
     * Returns an ArrayList<String> containing the short names of the projects that are
     * 
     * associated with this consultant.
     * 
     * If this consultant does not belong to a project, the list is empty.
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getProjectNames()
    {
        ArrayList<String> projectNames = new ArrayList<String>();
        
        ListIterator < Project > iterator = m_projects.listIterator();
        
        while ( iterator.hasNext() )
        {
            Project project = iterator.next();
            
            String projName = project.getProjectShortName();
            
            projectNames.add(projName);
        }
        return projectNames;
    }
    
    
    
    
    
    
    
    /**
     * Returns true if this consultant has a reference to the given project.
     * 
     * @param p Project to check against.
     * 
     * @return boolean
     * 
     * @throws ControlException if Project parameter is null.
     */
    public boolean hasProject(Project p) throws ControlException
    {
        if (p == null)
        {
            throw new ControlException("hasProject()  ...project is null.    this: " + this.getName());
        }
        if (m_projects.contains(p))
        {
            return true;
        }
        return false;
    }
    
    
    
    
    
    /**
     * Remove a project from this Consultant's responsibility.
     * 
     * @param project  - Project object to remove.
     * 
     * @throws ControlException if the project is not registered to this consultant.
     */
    public void deregisterProject(Project project) throws ControlException
    {
        
        // If the ID does not match my ID, throw an exception.
        
        if (
            project.getConsultant() != null &&
            
            project.getConsultant().getId() != this.getId()
        )
        {
            throw new ControlException("Project " + project.getProjectShortName() + " is not registered to me: " + this.getName());
        }
        
        // The ID matches my ID.
        
        // Project is in fact registered to this consultant.

        removeProject(project);
    }
    
    
    
    
    
    /**
     * Add a project to this Consultant's responsibility.
     * 
     * If project is already under this consultant's responsibility, does nothing.
     * 
     * @param project - Project object to remove.
     * 
     * @throws ControlException if the project is already registered to this consultant, or is registered to someone else.
     */
    public void registerProject(Project project) throws ControlException
    {
        if (m_projects.contains(project))
        {
            throw new ControlException("Project " + project.getProjectShortName() + " already registered to this consultant " + this.getName());
        }
        
        if (
            project.getConsultant() != null &&
            
            project.getConsultant().getId() != this.getId()
        )
        {
            throw new ControlException("Project " + project.getProjectShortName() + " already registered to another consultant : " + project.getConsultant().getName());
        }
        
        addProject(project);
    }
    
    
    
        
//    /**
//     * Override toString method.
//     * 
//     * @return String value - the name of the Consultant.
//     */
//    @Override
//    public String toString()
//    {
//        return getName();
//    }
  
    
    
    
    
    
    
    
    
    /**
     * Override method - toString
     * 
     * @return String representation of this object.
     */
    @Override
    public String toString()
    {
        String outStr = String.format("Consultant----------%n%s", super.toString());
        
        ListIterator<Project> iterator = m_projects.listIterator();
        
        while(iterator.hasNext())
        {
            Project p = iterator.next();
            
            outStr = String.format("%s               (has Project) %s%n", outStr, p.getProjectShortName());
        }
        return outStr;
    }
    
    
}
