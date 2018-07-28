/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  RemoveProjectButton.java
 * 
 * Purpose:    A button that appears in the Details Panel of the currently selected Consultant.
 * 
 *             This button is associated with a Project, which will be unlinked from the Consultant
 * 
 *             if the button is clicked.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 * 
 *      Invoke setRemovableProject() and setConsultantToRemoveFrom(), passing the required objects.
 * 
 * 
 *      Expected Output:
 *      
 *      Invoke getProject() and getConsultant(), to gain access to the objects.
 */


package consultanttool3;

import javax.swing.JButton;


public class RemoveProjectButton extends JButton
{
    
    /**
     * Reference to the project that will be removed.
     */
    private Project m_project;
    
    
    /**
     * Reference to the consultant that is assigned to the project.
     */
    private Consultant m_consultant;
    
    
    
    
    /**
     * Default constructor.
     * 
     * Creates a JButton
     */
    public RemoveProjectButton()
    {
        super();
    }
    
    
    
    
    /**
     * Constructor with argument.
     * 
     * @param label String value - creates a button with text.
     */
    public RemoveProjectButton(String label)
    {
        super(label);
    }
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return Project object - the one we want to deregister from the consultant.
     * 
     * @throws ControlException if project is null.
     */
    public final Project getProject() throws ControlException
    {
        if (m_project == null)
        {
            throw new ControlException("RemoveProjectButton.getProject()    Error - project is null.");
        }
        return m_project;
    }
    
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return Consultant object - the one we want to deregister the project from.
     * 
     * @throws ControlException if Consultant is null.
     */
    public final Consultant getConsultant() throws ControlException
    {
        if (m_consultant == null)
        {
            throw new ControlException("RemoveProjectButton.getConsultant()    Error - consultant is null.");
        }
        return m_consultant;
    }
    
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param c Consultant object. The one we want to deregister the project from.
     * 
     * @throws ControlException if Consultant is null.
     */
    public final void setConsultantToRemoveFrom(Consultant c) throws ControlException
    {
        if (c == null)
        {
            throw new ControlException("RemoveProjectButton.setConsultantToRemoveFrom(Consultant)    Error - consultant is null.");
        }
        m_consultant = c;
    }
    
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param p Project object. The one we want to deregister from the Consultant when we click the button.
     * 
     * @throws ControlException if Project is null.
     */
    public final void setRemovableProject(Project p) throws ControlException
    {
        if (p == null)
        {
            throw new ControlException("RemoveProjectButton.setRemovableProject(Project)    Error - project is null.");
        }
        m_project = p;
    }
}

