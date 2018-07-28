/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ProjectDocumentListener.java
 * 
 * Purpose:    Abstract class.
 * 
 *             Handles updates to text-based input fields (JTextArea or JTextField)
 * 
 *             for a Project who's details are shown in the DetailsPanel.
 * 
 *             The following tutorial provides more information about using DocumentListener:
 * 
 *             http://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 * 
 *      Provide an implementation of ProjectDocumentListener, which has a method body for
 * 
 *      protected void manipulate(String docText)
 * 
 *      Create a JTextArea or JTextField and attach the ProjectDocumentListener to it.
 * 
 *      When the user types text into the JTextArea or JTextField, events are generated
 * 
 *      while the user is typing. These update events are forwarded to manipulate() by MyDocumentListener.
 * 
 *      In the method body of manipulate(), you can call getMyProject() to gain access to the
 * 
 *      Project object, and perform work on it.
 *      
 * 
 *      Expected Output:
 *      
 *      Calling getMyProject() returns the Project object.
 */

package consultanttool3;

public abstract class ProjectDocumentListener extends MyDocumentListener
{

    /**
     * Store the project who's data will be manipulated by this handler.
     * 
     * Subclasses will be able to carry out their manipulations on this object.
     */
    private Project m_myProject;

    
    
    
    /**
     * Default Constructor
     */
    public ProjectDocumentListener()
    {
        super();
    }
    
    
    
    
    /**
     * Constructor with Project Argument.
     * 
     * @param p Project object to be manipulated.
     */
    public ProjectDocumentListener(Project p)
    {
        super();
        
        setMyProject(p);
    }
    
    
    


    
    /**
     * Mutator method. Set the Project who's data is to be manipulated by this handler.
     * 
     * @param p Project object from the model.
     */
    public final void setMyProject(Project p)
    {
        m_myProject = p;
    }

    
    
    /**
     * Accessor method - provides subclasses with the Project object that is to be manipulated.
     * 
     * @return Project object.
     */
    protected final Project getMyProject()
    {
        return m_myProject;
    }
}
