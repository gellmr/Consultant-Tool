/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ProjectCheckBox.java
 * 
 * Purpose:    Allows a client class to create a JCheckBox which is associated with a particular project.
 * 
 *             Attach an ItemListener to this ProjectCheckBox, and invoke
 * 
 *           ((ProjectCheckBox)itemEvent.getItemSelectable()).getMyProject()
 * 
 *             to gain access to the project object. Then perform some work on it.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 *    
 *      Call setMyProject(p) when you create the ProjectCheckBox.
 * 
 * 
 *      Expected Output:
 *      
 *      Call getMyProject() to gain access to the project object.
 */

package consultanttool3;

import javax.swing.JCheckBox;


/**
 * Allows a client class to create a JCheckBox which is associated with a particular project.
 * 
 * When the event listeners of the JCheckBox are fired, we can get the Project object that is
 * 
 * to be manipulated, by calling getMyProject().
 */
public class ProjectCheckBox extends JCheckBox
{
    
    /**
     * The Project that is associated with this JCheckBox.
     */
    private Project m_myProject;
    
    
    
    
    /**
     * Default Constructor.
     */
    public ProjectCheckBox()
    {
        super();
    }
    
    
    
    /**
     * Constructor with string argument.
     * 
     * @param s String value, to set the label of this JCheckBox
     */
    public ProjectCheckBox(String s)
    {
        super(s);
    }
    
    
    
    
    
    /**
     * Mutator Method.
     * 
     * @param p Project object, to be associated with this JCheckBox
     */
    public final void setMyProject(Project p)
    {
        m_myProject = p;
    }
    
    
    
    
    
    /**
     * Accessor Method.
     * 
     * @return p Project object, that is associated with this JCheckBox
     */
    public final Project getMyProject()
    {
        return m_myProject;
    }
}
