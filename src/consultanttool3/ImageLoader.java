/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  ImageLoader.java
 * 
 * Purpose:    Contains a static method to help load image files.
 * 
 *             The following tutorial helped me:
 * 
 *             http://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
 * 
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 * 
 *      The url of an existing image.
 * 
 * 
 *      Expected Output:
 * 
 *      Loads and returns an ImageIcon.
 * 
 *      If a problem occurs, returns null.
 */


package consultanttool3;

import java.awt.Image;
import javax.swing.ImageIcon;



public class ImageLoader
{
    
    /**
     * Given the url of an existing image, loads and returns an ImageIcon
     * 
     * @param urlPath java.net.URL
     * 
     * @return ImageIcon or null if not able to load image.
     */
    public static ImageIcon getImageIcon(String absPath)
    {
        if (absPath != null)
        {
            // System.out.println("Loading image: " + absPath);
            
            ImageIcon icon = new ImageIcon(absPath);
            
            // If the image dimensions exceed the allowed maximum, perform smooth scale.
            
            if (
                icon.getIconHeight() > Application.getMaxImageSpan()
            )
            {
                Image image = icon.getImage().getScaledInstance(
                        
                    -1, // auto-calculate the correct width to maintain aspect of the original
                    
                    Application.getMaxImageSpan(),
                    
                    Image.SCALE_SMOOTH
                );
                
                icon.setImage(image);
            }
               
            if (
                icon.getIconWidth() > Application.getMaxImageSpan()
            )
            {
                Image image = icon.getImage().getScaledInstance(
                        
                    Application.getMaxImageSpan(),
                    
                    -1, // auto-calculate the correct height to maintain aspect of the original
                    
                    Image.SCALE_SMOOTH
                );
                
                icon.setImage(image);
            }
            
            return icon;
        }
        else
        {
            System.err.println("Couldn't find file: " + absPath);
            
            return null;
        }
    }
}
