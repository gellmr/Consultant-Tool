/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ProjectActionListener.java
 * 
 * Purpose:    An (abstract) ActionListener that is associated with a project.
 * 
 *             This class is abstract so you need to create a subclass and implement
 * 
 *             the actionPerformed() method. When this method is called, you should
 * 
 *             invoke getMyProject() to gain access to the project object,
 * 
 *             then perform some work on it.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 *    
 *      Set the project when the listener is created.
 * 
 *      It will be available to the ActionListener object when the event is fired.
 * 
 * 
 *      Expected Output:
 *      
 *      In your implementation of actionPerformed(), invoke getMyProject()
 * 
 *      to gain access to the project object.
 */


package consultanttool3;

import java.awt.event.ActionListener;


public abstract class ProjectActionListener implements ActionListener
{

    
    /**
     * The Project object associated with this listener.
     */
    private Project m_myProject;
    
    
    
    
    
    /**
     * Default Constructor.
     */
    public ProjectActionListener()
    {
        super();
    }
    
    
    
    
    
    /**
     * Constructor with argument.
     * 
     * @param p Project object object associated with this listener.
     */
    public ProjectActionListener(Project p)
    {
        super();
        
        setMyProject(p);
    }
    
    
    
    
    
    /**
     * Mutator method. Set the Project object associated with this listener.
     * 
     * @param p Project object.
     */
    public final void setMyProject(Project p)
    {
        m_myProject = p;
    }
    
    
    
    
    /**
     * Accessor method. Get the Project object associated with this listener.
     * 
     * @return Project object.
     */
    public final Project getMyProject()
    {
        return m_myProject;
    }

}
