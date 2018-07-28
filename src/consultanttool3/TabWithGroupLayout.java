/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  TabWithGroupLayout.java
 * 
 * Purpose:    This class contains the difficult logic for GroupLayout.
 * 
 *             I have used GroupLayout to get a really nice looking GUI.
 * 
 *             Here we control the sizing and arrangement of elements in the ListPanel and DetailsPanel.
 * 
 *             An instance of this class is created for the Projects Tab.
 * 
 *             An instance of this class is created for the Consultants Tab.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 * 
 *      This class receives a list of NameValuePair objects each time we want to
 * 
 *      regenerate the GUI. This is done almost every time the user interacts.
 * 
 *      (So... efficiency-wise, there is room for improvement.)
 * 
 *      The NameValuePair objects contain JComponents, which are added to the layout.
 * 
 * 
 *      Expected Output:
 * 
 *      When the user clicks on GUI components, (or otherwise interacts)
 * 
 *      events are generated - to be received by event handlers back in
 * 
 *      the Application class. The Application class attaches its own listeners
 * 
 *      to the GUI components while it is creating them.
 */

package consultanttool3;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;



public class TabWithGroupLayout extends JPanel
{
    
    
    
    /**
     * GroupLayout for this JPanel
     */
    private GroupLayout m_groupLayout;
    
    
    
    /**
     * The List Panel
     */
    private JPanel m_listPanel;
    
    /**
     * The List Panel has its own group layout.
     */
    private GroupLayout m_listGroupLayout;
    
    /**
     * Scroll Pane for the list panel
     */
    private JScrollPane m_listScroller;
    
    /**
     * Stores the contents of m_listScroller
     */
    private JList m_listPanelContents;
    
    /**
     * Add button for the list panel.
     */
    private JButton m_listAddButton;
    
    /**
     * Add button for the list panel.
     */
    private JButton m_listRemoveButton;
    
    /**
     * Event Handler assigned to the ListPanel
     */
    private ListSelectionListener m_ListPanelHandler;
    
    /**
     * Label for the list panel
     */
    private JLabel m_listTitle;
    
    /**
     * Used to identify the listPanel
     */
    private String m_listPanelIdentifierString = "listPanelJList";
    
    /**
     * Minimum size for the ListPanel
     */
    private Dimension m_listPanelElement_minSize;
    
    /**
     * Maximum size for the ListPanel
     */
    private Dimension m_listPanelElement_maxSize;
    
    /**
     * Preferred size for the ListPanel
     */
    private Dimension m_listPanelElement_preferredSize;
    
    
    
    /**
     * Details Panel
     */
    private JPanel m_detailsPanel;
    
    /**
     * Label for the Details panel
     */
    private JLabel m_detailsTitle;
    
    /**
     * Scroll Pane for the details panel
     */
    private JScrollPane m_detailScroller;
    
    
    
    
    
    
    
    /**
     * Called whenever data has changed and we want to try and force a repaint
     * 
     * for the entire tab and its contained elements.
     */
    public void forceRepaint()
    {
        this.setVisible(false);
        
        this.setVisible(true);
        
        m_listPanel.setVisible(false);
        
        m_listPanel.setVisible(true);
        
        m_detailsPanel.setVisible(false);
        
        m_detailsPanel.setVisible(true);
    }
    
    
    
    
    
    /**
     * Set whether or not the Add / Remove buttons work.
     * 
     * @param enable boolean true if the buttons should work.
     */
    public void addRemButtonsEnable(boolean enable)
    {
        m_listAddButton.setEnabled(enable);
        
        m_listRemoveButton.setEnabled(enable);
    }
    
    
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param title String value - the title for the List Panel.
     */
    public void setListPanelTitle(String title)
    {
        m_listTitle.setText(title);
    }
    
    
    
    
    /**
     * Set the string that uniquely identifies the ListPanel in the application.
     * 
     * @param idString String.
     */
    private void setListPanelIDString(String idString)
    {
        m_listPanelIdentifierString = idString;
    }
    
    
    
    
    /**
     * Mutator method.
     * 
     * @param title String value - the title for the Details Panel.
     */
    public void setDetailsPanelTitle(String title)
    {
        m_detailsTitle.setText(title);
    }
    
    
    
    
    
    
    
    /**
     * Get a new instance of the JList that we will use in the List Panel.
     * 
     * @return JList for display in the List Panel.
     */
    private JList makeJListForListPanel()
    {
        JList jList = new JList();
        
        jList.addListSelectionListener(m_ListPanelHandler); // ListSelectionListener
        
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // jList.setSelectedIndex(m_mostRecentListPanelSelectedIdx);
        
        Component comp = (Component)jList; // Upcast
        
        // comp.setName("listPanelJList");
        
        comp.setName(m_listPanelIdentifierString);  // Set name to help identify us in the superhandler.
        
        return (JList)comp; // Downcast.
    }
    
    
    
    
    
    /**
     * Overload.
     * 
     * Get a new instance of the JList that we will use in the List Panel.
     * 
     * @return JList for display in the List Panel, with String[] data.
     */
    private JList makeJListForListPanel(String[] array)
    {
        JList jList = makeJListForListPanel();
        
        // Using an obsolete collection.
        final java.util.Vector<String> stringArray = new java.util.Vector<String>();
        
        for(String s : array)
        {
            stringArray.add(s);
        }
        
        jList.setListData(stringArray); // can't believe it wouldn't compile this.
        
        return jList;
    }
    
    
    
    
    
    /**
     * Set the selected index of the List Panel JList
     * 
     * @param index int value.  -1 means nothing is selected.
     */
    public void setListPanelSelection(int index)
    {
        if (m_listPanelContents != null)
        {
            if(index >= -1)
            {
                m_listPanelContents.setSelectedIndex(index);
            }
        }
    }
    
    
    
    
    /**
     * Sets the contents of the ListPanel, given a list of String values.
     * 
     * First removes all contents of the ListPanel.
     * 
     * If we receive an empty list, we still need to make a list panel.
     * 
     * @param items ArrayList<String> the new contents of the List Panel.
     */
    public void setListNames(ArrayList<String> items) throws ControlException
    {
        if (items == null)
        {
            throw new ControlException("ControlException: setListPanelContents(null) cannot be processed. Command ignored.");
        }
        
        // Copy strings into an array

        String[] array = new String[items.size()];
        
        array = items.toArray(array);
        
        m_listPanelContents = makeJListForListPanel(array);

        JScrollPane newScroller = new JScrollPane(

            m_listPanelContents,

            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,

            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        
        m_listGroupLayout.replace(m_listScroller, newScroller);
        
        m_listScroller = newScroller;
        
        m_detailsPanel.removeAll(); // Clear the details panel.
        
        forceRepaint(); // try to force a repaint of the tab and its panels.
    }
    
    
    
    
    
    
    
    
    /**
     * Set the ListSelectionListener for the ListPanel
     * 
     * @param listener ListSelectionListener to be attached to the JList in our List Panel.
     */
    public void setListPanelHandler(ListSelectionListener listener)
    {
        // remember the handler.
        
        m_ListPanelHandler = listener;
        
        // Remove all listeners from the component.
        
        ListSelectionListener[] array = m_listPanelContents.getListSelectionListeners();
        
        for (ListSelectionListener rem : array)
        {
            m_listPanelContents.removeListSelectionListener(rem);
        }
        
        // Add the new component.
        
        m_listPanelContents.addListSelectionListener(m_ListPanelHandler);
    }
    
    
    
    
    
    
    /**
     * Set the ActionListener for the ListPanel ADD button.
     * 
     * @param listener ActionListener to be attached to our ADD button in the List Panel.
     */
    public void setAddButtonHandler(ActionListener listener)
    {
        // Remove all actionlisteners registered to the button.
        
        ActionListener[] array = m_listAddButton.getActionListeners();
        
        for (ActionListener rem : array)
        {
            m_listAddButton.removeActionListener(rem);
        }
        
        // Add the new listener.
        
        m_listAddButton.addActionListener(listener);
    }
    
    
    
    
    
    /**
     * Set the ActionListener for the ListPanel REMOVE button.
     * 
     * @param listener ActionListener to be attached to our REMOVE button in the List Panel.
     */
    public void setRemoveButtonHandler(ActionListener listener)
    {
        // Remove all actionlisteners registered to the button.
        
        ActionListener[] array = m_listRemoveButton.getActionListeners();
        
        for (ActionListener rem : array)
        {
            m_listRemoveButton.removeActionListener(rem);
        }
        
        // Add the new listener.
        
        m_listRemoveButton.addActionListener(listener);
    }
            
    
    
    
    
    
    
    
    
    
    
    /**
     * Convenience method. Adds the given component to the given Group object.
     * 
     * @param group      GroupLayout.Group (may be a SequentialGroup or ParallelGroup)
     * 
     * @param component  JComponent to be added.
     */
    private void addFixedSizeComponent(GroupLayout.Group group, JComponent component)
    {
        group.addComponent(

            component,

            GroupLayout.PREFERRED_SIZE,

            GroupLayout.DEFAULT_SIZE,

            GroupLayout.PREFERRED_SIZE
        );
    }

    
    
    
    /**
     * Clear the details panel.
     */
    public void clearDetails()
    {
        m_detailsPanel.removeAll();
    }
    
    
    
    
    /**
     * Set the layout and contents of the Details Panel, given an array of NameValuePair objects.
     * 
     * Each NameValuePair object typically contains a JLabel and a JTextField.
     * 
     * @param array ArrayList<NameValuePair> list of paired components for display. (May be null).
     */
    public void setDetailsNVP(ArrayList<NameValuePair> array)
    {
        // Set the layout for the Details Panel.
        
        m_detailsPanel.removeAll();
        
        if (array == null)
        {
            return;
        }
        
        GroupLayout detailLayout = new GroupLayout(m_detailsPanel);
        
        m_detailsPanel.setLayout(detailLayout);
        
        detailLayout.setAutoCreateGaps(true);
       
        detailLayout.setAutoCreateContainerGaps(true);
        
        
        /* The following tries to explain (in a visual fashion) how GroupLayout works.
         * 
         * Basically you have to add each component twice: once to the horizontal group, once to the vertical group.
         * 
         * The order in which you add them determines how they are arranged.
         * 
         * The use of sequential and parallel groups also determines how they are arranged.
         * 
         * When defining the horizontal group, sequential means left to right (like rows). Parallel means top to bottom (like columns).
         * 
         * 
         *               _
         *               _           _
         *               _           _
         *               _           _
         * 
         *               LABEL
         * 
         *               NAME        VALUE
         * 
         *               NAME        VALUE
         * 
         *               NAME        VALUE
         * 
         * 
         *        horizLayout = sequentialGroup(
         *                                        parallelGroup( label, name, name, name),
         *                                        parallelGroup( value, value, value)
         *                                      )
         * 
         * 
         * 
         * 
         * 
         * 
         * When defining the vertical group, sequential means top to bottom (like columns). Parallel means left to right (like rows).
         * 
         * 
         * 
         *         |        LABEL
         * 
         *         ||       NAME        VALUE
         * 
         *         ||       NAME        VALUE
         * 
         *         ||       NAME        VALUE
         * 
         * 
         *        verticalLayout = sequentialGroup(
         *                                           label,
         *                                           parallelGroup( name, value),
         *                                           parallelGroup( name, value),
         *                                           parallelGroup( name, value)
         *                                         )
         * 
        */
  
        
        
        
        
        // Details Panel - horizontal layout.
        
        GroupLayout.SequentialGroup horizontalSequence = detailLayout.createSequentialGroup();
        
        GroupLayout.ParallelGroup leftColumn  = detailLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        
        GroupLayout.ParallelGroup rightColumn = detailLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        addFixedSizeComponent(leftColumn, m_detailsTitle);
        
        
        
        ListIterator < NameValuePair > iteratorHorizontal = array.listIterator();
        
        while ( iteratorHorizontal.hasNext() )
        {
            NameValuePair nvp = iteratorHorizontal.next();
            
            JComponent nameComp = nvp.getNameComponent();
            
            JComponent valueComp = nvp.getValueComponent();
            
            
            // Add them to their respective columns.
            
            if (nvp.get_NameWidth_IsFixed())
            {
                addFixedSizeComponent(leftColumn, nameComp);
            }
            else
            {
                leftColumn.addComponent(nameComp);
            }

            if (nvp.get_ValueWidth_IsFixed())
            {
                addFixedSizeComponent(rightColumn, valueComp);
            }
            else
            {
                rightColumn.addComponent(valueComp);
            }
        }
        
        horizontalSequence.addGroup(leftColumn);
        
        horizontalSequence.addGroup(rightColumn);
        
        detailLayout.setHorizontalGroup(horizontalSequence);
        
        
        
        
        
        
        // Details panel - vertical layout.
        
        GroupLayout.SequentialGroup nvpColumn = detailLayout.createSequentialGroup();
                
        nvpColumn.addComponent(m_detailsTitle);
        
        
        
        ListIterator < NameValuePair > iteratorVertical = array.listIterator();
        
        while ( iteratorVertical.hasNext() )
        {
            
            // Get name-value pair
            
            NameValuePair nvp = iteratorVertical.next();
            
            JComponent nameComp = nvp.getNameComponent();
            
            JComponent valueComp = nvp.getValueComponent();
            
            
            // Make a new row.
            
            GroupLayout.ParallelGroup nvpRow  = detailLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        
            if (nvp.get_NameHeight_IsFixed())
            {
                addFixedSizeComponent(nvpRow, nameComp);
            }
            else
            {
                nvpRow.addComponent(nameComp);
            }
            
            if (nvp.get_ValueHeight_IsFixed())
            {
                addFixedSizeComponent(nvpRow, valueComp);
            }
            else
            {
                nvpRow.addComponent(valueComp);
            }
            
            nvpColumn.addGroup(nvpRow);
        }
        
        detailLayout.setVerticalGroup(nvpColumn);
        
        //refreshEditable();  // Ensure components are editable / not.
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * Default Constructor. (Not to be used)
     * 
     * @throws Exception 
     */
    public TabWithGroupLayout() throws Exception
    {
        super(); // JPanel
        
        throw new Exception("Object not constructed fully!");
    }
    
    
    
    
    
    
    
    /**
     * Constructor with Arguments.
     */
    public TabWithGroupLayout(String listPanelIDString)
    {
        super(); // JPanel
        
        setListPanelIDString(listPanelIDString);
        
        
        
        
        
        
        // Create List Panel
        
        m_listTitle = new JLabel("List Panel");
        
        m_listPanel = new JPanel();
        
        
        // I can't seem to control the size of the List Panel... oh well I guess it looks ok.
        
        // List panel size constraints.
        
        //        m_listPanelElement_preferredSize = new Dimension(250, 500);
        //
        //        m_listPanelElement_minSize       = new Dimension(100, 100);
        //
        //        m_listPanelElement_maxSize       = new Dimension(250, 500);
        //        
        //        m_listPanel.setPreferredSize(m_listPanelElement_preferredSize);
        //        
        //        m_listPanel.setMinimumSize(m_listPanelElement_minSize);
        //        
        //        m_listPanel.setMaximumSize(m_listPanelElement_maxSize);
        
        
        
        // Create the GroupLayout used by the List Panel.
        
        // This one is much simpler than the Details Panel GroupLayout.
        
        m_listGroupLayout = new GroupLayout(m_listPanel);
        
        m_listPanel.setLayout(m_listGroupLayout);
        
        m_listGroupLayout.setAutoCreateContainerGaps(true);
        
        m_listGroupLayout.setAutoCreateGaps(true);
        
        
        
        m_listPanelContents = makeJListForListPanel();
        
        m_listScroller = new JScrollPane(
                
            m_listPanelContents,
                
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,

            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        
        
        
        JPanel buttonsContainer = new JPanel(new FlowLayout());
        
        m_listAddButton = new JButton("Add");
        
        m_listRemoveButton = new JButton("Remove");
        
        buttonsContainer.add(m_listAddButton);
        
        buttonsContainer.add(m_listRemoveButton);
        
        
        
        m_listGroupLayout.setHorizontalGroup(
            
            m_listGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
           
            .addComponent(m_listTitle)
                
            // .addComponent(m_listScroller, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
               
               .addComponent(m_listScroller)
                
            .addComponent(buttonsContainer)
            
        );
        
        m_listGroupLayout.setVerticalGroup(
           
            m_listGroupLayout.createSequentialGroup()
            
            .addComponent(m_listTitle)
                
            //.addComponent(m_listScroller, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            
            .addComponent(m_listScroller)
                 
            .addComponent(buttonsContainer)
        );
        
        
        
        
        
        
        
        
        
        
        // Create Details Panel
        
        m_detailsPanel = new JPanel();
        
        m_detailsTitle = new JLabel("Details Panel");
        
        //m_detailsPanel.setLayout(new BoxLayout(m_detailsPanel, BoxLayout.Y_AXIS));
        
        //m_detailsPanel.add(m_detailsTitle);
        
        m_detailScroller = new JScrollPane(

            m_detailsPanel,

            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,

            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        
        
        
        
        
        // Create Group Layout.
        
        m_groupLayout = new GroupLayout(this);
        
        setLayout(m_groupLayout);
        
        m_groupLayout.setAutoCreateGaps(true);
        
        m_groupLayout.setAutoCreateContainerGaps(true);
        
        
        
        
        // Define horizontal group.
        
        // Add the ListPanel and JScrollPane to our layout.
        
        m_groupLayout.setHorizontalGroup(
            
            m_groupLayout.createSequentialGroup()
            
            .addComponent(m_listPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

            .addComponent(m_detailScroller) // to contain DetailsPanel
            
        );
        
        
        
        // Define vertical group.
        
        // Add the ListPanel and JScrollPane to our layout.
        
        m_groupLayout.setVerticalGroup(
           
            m_groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
           
            .addComponent(m_listPanel)

            .addComponent(m_detailScroller) // to contain DetailsPanel
        );
        
        //refreshEditable();
    }
}
