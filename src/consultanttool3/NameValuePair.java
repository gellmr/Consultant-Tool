/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  NameValuePair.java
 * 
 * Purpose:    Stores two JComponents:
 * 
 *              - name JComponent (usually a JLabel)
 * 
 *              - value JComponent (usually a JLabel, JTextField, JTextArea, or JComboBox)
 * 
 *             These components are to be displayed in the Details Panel.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 * 
 *      The Application class sets the m_nameComponent and m_valueComponent
 * 
 *      members of this class, as well as configuring their min/max/preferred
 * 
 *      dimensions, and whether fixed sizing should be used.
 * 
 *      The TabWithGroupLayout class needs to know whether it should use fixed
 * 
 *      or flexible sizing when it adds the components to its layout.
 * 
 * 
 * 
 *      Expected Output:
 * 
 *      The TabWithGroupLayout class receives a list of NameValuePair objects
 * 
 *      from the Application class, and iterates through them, adding each
 * 
 *      component to the GroupLayout of the Details Panel. For example:
 * 
 * 
 * 
 *              DETAILS PANEL:
 * 
 *              Name Component      Value Component
 * 
 *              Name Component      Value Component
 * 
 *              Name Component      Value Component
 */


package consultanttool3;

import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JTextField;


public class NameValuePair
{
    
    
    /**
     * By default, fixed dimensions are used.
     * 
     * This works well when we know all the components are going to be of a predictable size, eg JLabel.
     * 
     * For unpredictable components (Like JTextArea), we can switch variables off,
     * 
     * For example, so that the height is not fixed.
     * 
     * This is useful for JTextArea components that may need to hold a paragraph of text.
     */
    private boolean m_NAME_Height_isFixed  = true;
    
    private boolean m_NAME_Width_isFixed   = true;
    
    private boolean m_VALUE_Height_isFixed = true;
    
    private boolean m_VALUE_Width_isFixed  = true;
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
    /**
     * Dimensions to specify the maximum, minimum and preferred size of (name) component.
     */
    private Dimension m_nameDimensionMax;
    
    private Dimension m_nameDimensionPref;
    
    private Dimension m_nameDimensionMin;
    
    
    
    
    /**
     * Dimensions to specify the maximum, minimum and preferred size of (value) component.
     */
    private Dimension m_valueDimensionMax;
    
    private Dimension m_valueDimensionPref;
    
    private Dimension m_valueDimensionMin;
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * Name Component
     */
    private JComponent m_nameComponent;

    
    
    /**
     * Value Component
     */
    private JComponent m_valueComponent;
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * Default Constructor
     */
    public NameValuePair()
    {
        
        m_nameComponent = new JTextField("Name: (none)");

        m_valueComponent = new JTextField("Value: (none)");
        
        
        
        // Some hastily prepared dimensions...
        
        
        // Name JComponent
        
        m_nameDimensionMax = new Dimension(  200,  40);
        
        m_nameDimensionPref = new Dimension( 175,  20);
        
        m_nameDimensionMin = new Dimension(  150,  20);
        
        
        
        // Value JComponent
        
        m_valueDimensionMax = new Dimension(  600,  100 );
        
        m_valueDimensionPref = new Dimension( 500,  20  );
        
        m_valueDimensionMin = new Dimension(  200,  20  );
        
        
        
        
        // Set the components.
        
        setName(m_nameComponent);
        
        setValue(m_valueComponent);
    }
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    /**
     * Constructor with arguments.
     * 
     * @param nameComponent  - JComponent
     * 
     * @param valueComponent - JComponent 
     */
    public NameValuePair(JComponent n, JComponent v)
    {
        this();
        
        setName(n);
        
        setValue(v);
    }
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    /**
    * Set the min, max, preferred size constraints of the given component to
    * 
    * the same values as used with this name value pair.
    * 
    * Used to ensure that a subcomponent conforms to the constraints of its parent.
    * 
    * @param j JComponent
    */
    public final void applySizeConstrait(JComponent j)
    {
        j.setMinimumSize(m_nameDimensionMin);
        
        j.setMaximumSize(m_nameDimensionMax);
        
        j.setPreferredSize(m_nameDimensionPref);
    }
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
    /**
     * Set the minimum, maximum and preferred size constraints for the value component.
     * 
     * Affects the display of the component within the Details Panel.
     * 
     * @param min   Dimension to constrain the minimum size of the component
     * 
     * @param max   Dimension to constrain the maximum size of the component
     * 
     * @param pref  Dimension to constrain the preferred size of the component
     */
    public void setValueDimensions(
            
        Dimension min,
        
        Dimension max,
        
        Dimension pref
    )
    {
        m_valueDimensionMin = min;
        
        m_valueDimensionMax = max;
        
        m_valueDimensionPref = pref;
        
        m_valueComponent.setMinimumSize(   m_valueDimensionMin  );
        
        m_valueComponent.setMaximumSize(   m_valueDimensionMax  );
            
        m_valueComponent.setPreferredSize( m_valueDimensionPref );

    }
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    /**
     * Set the name component.
     * 
     * @param name - JComponent.
     */
    private void setName(JComponent name)
    {
        if (m_nameComponent != null)
        {
            m_nameComponent = null;
        }
        
        if (name != null)
        {
            name.setMaximumSize(   m_nameDimensionMax  );
            
            name.setPreferredSize( m_nameDimensionPref );
            
            name.setMinimumSize(   m_nameDimensionMin  );
            
            m_nameComponent = name;
        }
    }
    
    
    
    
    
    /**
     * Set the value component.
     * 
     * @param value - JComponent.
     */
    public final void setValue(JComponent value)
    {
        if (m_valueComponent != null)
        {
            m_valueComponent = null;
        }
        
        if (value != null)
        {
            value.setMaximumSize(   m_valueDimensionMax  );
            
            value.setPreferredSize( m_valueDimensionPref );
            
            value.setMinimumSize(   m_valueDimensionMin  );
            
            m_valueComponent = value;
        }
    }
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Accessor method.
     * 
     * @return JComponent object - (name JComponent)
     */
    public final JComponent getNameComponent()
    {
        return m_nameComponent;
    }
    
    
    
    /**
     * Accessor method.
     * 
     * @return JComponent object - (value JComponent)
     */
    public final JComponent getValueComponent()
    {
        return m_valueComponent;
    }
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * Mutator method.
     * 
     * @param fixed - boolean value.  True if you want to make the name height fixed.
     */
    public void set_NameHeight_IsFixed(boolean fixed)
    {
        m_NAME_Height_isFixed = fixed;
    }
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param fixed - boolean value.  True if you want to make the name width fixed.
     */
    public void set_NameWidth_IsFixed(boolean fixed)
    {
        m_NAME_Width_isFixed = fixed;
    }
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param fixed - boolean value.  True if you want to make the value height fixed.
     */
    public void set_ValueHeight_IsFixed(boolean fixed)
    {
        m_VALUE_Height_isFixed = fixed;
    }
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param fixed - boolean value.  True if you want to make the value width fixed.
     */
    public void set_ValueWidth_IsFixed(boolean fixed)
    {
        m_VALUE_Width_isFixed = fixed;
    }
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return boolean value. True if the name height is fixed.
     */
    public boolean get_NameHeight_IsFixed()
    {
        return m_NAME_Height_isFixed;
    }
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return boolean value. True if the name width is fixed.
     */
    public boolean get_NameWidth_IsFixed()
    {
        return m_NAME_Width_isFixed;
    }
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return boolean value. True if the value height is fixed.
     */
    public boolean get_ValueHeight_IsFixed()
    {
        return m_VALUE_Height_isFixed;
    }
    
    
    
    
    /**
     * Accessor method.
     * 
     * @return boolean value. True if the value width is fixed.
     */
    public boolean get_ValueWidth_IsFixed()
    {
        return m_VALUE_Width_isFixed;
    }
}
