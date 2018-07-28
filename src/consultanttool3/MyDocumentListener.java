/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  MyDocumentListener.java
 * 
 * Purpose:    Abstract class.
 * 
 *             This class is intended to be subclassed by ConsultantDocumentListener
 * 
 *             and ProjectDocumentListener, which both provide implementations of the
 * 
 *             manipulate() method.
 * 
 *             When the user types text into a JTextArea or JTextField, events are generated
 * 
 *             while the user is typing.
 * 
 *             This class forwards such events to the abstract manipulate() method.
 * 
 *             Concrete subclasses should override the manipulate() method,
 * 
 *             which receives the text value that has just been updated. This value
 * 
 *             can then be used to perform some meaningful work, like updating
 * 
 *             a consultant or project.
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
 *      Attaching a concrete subclass of this listener to a text input component
 * 
 *      will allow the concrete subclass to receive text data from the component
 * 
 *      while the user is still typing.
 *      
 * 
 *      Expected Output:
 *      
 *      Concrete implementations of the manipulate() method will receive the value
 * 
 *      of the updated text, as it is being typed.
 */

package consultanttool3;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;



public abstract class MyDocumentListener implements DocumentListener
{
    
    
    
    /**
     * Subclasses should override this method and carry out their desired actions.
     */
    protected abstract void manipulate(String docText);


    
    
    /**
     * Receive the document update event, get some text from it and call manipulate.
     * 
     * @param event DocumentEvent
     */
    private void textUpdate(DocumentEvent event)
    {
        Document document = event.getDocument();
        
        try
        {
            String docText = document.getText(0, document.getLength());

            manipulate(docText); // Client code does some useful work here.
            
            System.err.println(docText); // Show the text update as user is typing.
        }
        catch(BadLocationException exception)
        {
            System.err.println(exception.getMessage());
        }
    }
    
    
    
    

    /**
     * Called whenever the user inserts text in the (JTextArea or JTextField).
     * 
     * @param e - DocumentEvent that occurred when the user changed the (JTextArea or JTextField).
     */
    @Override
    public void insertUpdate(DocumentEvent e)
    {
        // Inserted some text.
        
        textUpdate(e);
    }


    
    
    
    

    /**
     * Called whenever the user removes text from the (JTextArea or JTextField).
     * 
     * @param e - DocumentEvent that occurred when the user changed the (JTextArea or JTextField).
     */
    @Override
    public void removeUpdate(DocumentEvent e)
    {
        // Removed some text.
        
        textUpdate(e);
    }


    
    

    
    

    /**
     * Called when a "style-change" happens to some text in the document.
     * 
     * Only applies to StyledDocument.
     * 
     * We are using a PlainDocument.
     * 
     * Interface requires this method to be implemented.
     */
    @Override
    public void changedUpdate(DocumentEvent e)
    { 
        // Plain text does not fire these events.
        
        throw new UnsupportedOperationException("changedUpdate() Only applies to StyledDocument.");
    }
}
