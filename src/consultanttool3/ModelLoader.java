/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ModelLoader.java
 * 
 * Purpose:    Saves and loads the data model, to and from hard disk.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 * 
 *      When saving, this class attempts to write a serializable Model object to hard disk.
 * 
 *      When loading, this class attempts to read a serialized object from hard disk.
 * 
 *      This class needs to know what parent JFrame is using it, so it can display
 * 
 *      message dialogs or error messages, as required.
 * 
 * 
 * 
 *      Expected Output:
 * 
 *      If the model is successfully saved, a serialized object is written to hard disk.
 * 
 *      If the model is successfully loaded, a Model object is returned.
 * 
 *      If the model fails to load, a ControlException may be thrown to the outside method.
 */


package consultanttool3;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class ModelLoader
{
    
    /**
     * Default Constructor
     */
    public ModelLoader()
    {
        
    }
    
    
    /**
     * Loads the model from a sequential binary file.
     */
    public static Model loadModel(JFrame jFrame) throws ControlException
    {
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int result = fileChooser.showOpenDialog(jFrame);
        
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File file;
            
            file = fileChooser.getSelectedFile();
            
            if (file == null || file.getName().equals(""))
            {
                JOptionPane.showMessageDialog(jFrame, "Invalid Name", "Invalid Name", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try
                {
                    if (file.exists())
                    {
                        System.err.printf("Selected file: %s%n", file.getName());
                        
                        System.err.printf("Opening file...%n");
                        
                        ObjectInputStream inStrm = new ObjectInputStream(new FileInputStream(file.getName()));
                    
                        System.err.printf("Reading file...%n");
                        
                        Model model = (Model)(inStrm.readObject());

                        if (inStrm != null)
                        {
                            System.err.printf("Closing file...%n");

                            inStrm.close();

                            System.err.println("Success closing " + file.getName());
                            
                            return model;
                        }
                    }
                }
                catch (ClassNotFoundException ex)
                {
                    System.err.println("Error reading from file - ClassNotFoundException");
                }
                catch (IOException ex)
                {
                    System.err.println("Error opening file");
                    
                    throw new ControlException("Error opening file");
                }
            }
        }
        else if (result == JFileChooser.CANCEL_OPTION)
        {
            throw new ControlException("Cancelled");
        }
        else if (result == JFileChooser.ERROR_OPTION)
        {
            throw new ControlException("An error occurred.");
        }
        return null;
    }
    
    
    
    
    
    /**
     * Saves the model to a sequential binary file.
     */
    public static void saveModel(JFrame jFrame, Model model)
    {
        // Create new data file.
        
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int result = fileChooser.showSaveDialog(jFrame);
        
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File file;
            
            file = fileChooser.getSelectedFile();
            
            if (file == null || file.getName().equals(""))
            {
                JOptionPane.showMessageDialog(jFrame, "Invalid Name", "Invalid Name", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try
                {
                    if (!file.exists())
                    {
                        System.err.printf("Creating new file: %s%n", file.getName());
                        
                        file.createNewFile();
                        
                        System.err.println("Created " + file.getName());
                    }
                    else
                    {
                        System.err.printf("Selected file to overwrite: %s%n", file.getName());
                        
                        System.err.printf("Overwrite? Show showConfirmDialog%n");
                        
                        int confirm = JOptionPane.showConfirmDialog(jFrame, "Overwrite existing file?", "Overwrite existing file?", JOptionPane.YES_NO_OPTION);
                        
                        if (confirm == JOptionPane.NO_OPTION)
                        {
                            System.err.println("Aborted by user.");
                            
                            return;
                        }
                        System.err.println("Confirm Overwrite.");
                    }
                    
                    System.err.println("Writing to file...");
                    
                    ObjectOutputStream outStrm = new ObjectOutputStream(new FileOutputStream(file.getName()));
                    
                    outStrm.writeObject(model);
                    
                    if (outStrm != null)
                    {
                        System.err.printf("Closing file...%n");
                        
                        outStrm.close();
                        
                        System.err.println("Success closing " + file.getName());
                    }
                }
                catch (IOException ex)
                {
                    System.err.println("Error opening file");
                }
            }
        }
    }
}
