/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  Project.java
 * 
 * Purpose:    The data model for this system.
 * 
 *             Contains all the objects which store business data (eg Employee, Consultant, Project, Picture, etc)
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 * 
 *      This class and its component classes are Serializable.
 * 
 *      This is relied upon for saving / loading the model to or from hard disk.
 * 
 * 
 *      Expected Output:
 *      
 *      When printing the contents of the data model to console, see the
 * 
 *      toString() method.
 */


package consultanttool3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.ListIterator;



public class Model implements Serializable
{
    
    /**
     * Linked list of Projects.
     */
    private LinkedList<Project> m_projects;
    
    
    
    /**
     * Linked list of Consultants.
     */
    private LinkedList<Consultant> m_consultants;
    
    
    
    
    
    
    /**
     * Default Constructor.
     */
    public Model()
    {
        initLists();
    }
    
    
    
    
 
    
    
    
    
    
    
    // DELETE THIS
//    /**
//     * Tells a client class what the valid options are for gender.
//     * 
//     * @return String[]
//     */
//    public String[] getGenderOptions()
//    {
//        String[] typeOptions = new String[3];
//        
//        typeOptions[0] = "Female";
//        
//        typeOptions[1] = "Male";
//        
//        typeOptions[2] = "Other";
//        
//        return typeOptions;
//    }
    
    
    
    
    
    /**
     * Returns an ArrayList<String> containing the project short names.
     * 
     * If there are no projects, returns an empty list.
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getProjectNames()
    {
        ArrayList<String> outArr = new ArrayList<String>();
        
        if (m_projects.size() < 1)
        {
            return outArr;
        }
        
        ListIterator<Project> iterator = m_projects.listIterator();
        
        while(iterator.hasNext())
        {
            Project p = iterator.next();
            
            outArr.add(p.getProjectShortName());
        }
        
        return outArr;
    }
    
    
    
    
    
     
    /**
     * Returns an ArrayList<String> containing the consultant names.
     * 
     * If there are no consultants, returns an empty list.
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getConsultantNames()
    {
        ArrayList<String> outArr = new ArrayList<String>();

        if (m_consultants.size() < 1)
        {
            return outArr;
        }

        ListIterator<Consultant> iterator = m_consultants.listIterator();

        while(iterator.hasNext())
        {
            Consultant c = iterator.next();

            outArr.add(c.getName());
        }

        return outArr;
        
    }
    
    
    
    
    /**
     * Retrieves a Project, given its name. Or null if not found.
     * 
     * @param name String value - the name of the Project to search for.
     * 
     * @return Project object or null if not found.
     */
    public Project getProjectByName(String name)
    {
        ListIterator<Project> iterator = m_projects.listIterator();
        
        while(iterator.hasNext())
        {
            Project p = iterator.next();
            
            if (p.getProjectShortName().equals(name))
            {
                return p;
            }
        }
        return null;
    }
    
    
    
    
    
    
    
    /**
     * Retrieves a Consultant, given its name. Or null if not found.
     * 
     * @param name String value - the name of the Consultant to search for.
     * 
     * @return Consultant object or null if not found.
     */
    public Consultant getConsultantByName(String name)
    {
        ListIterator<Consultant> iterator = m_consultants.listIterator();
        
        while(iterator.hasNext())
        {
            Consultant c = iterator.next();
            
            if (c.getName().equals(name))
            {
                return c;
            }
        }
        return null;
    }
    
    
    
    
    
    /**
     * @return true if the model contains no Projects and no Consultants.
     */
    public boolean modelIsEmpty()
    {
        if (m_projects.size() == 0 && m_consultants.size() == 0)
        {
            return true;
        }
        return false;
    }
    
    
    
    
    
    /**
     * Clear the lists.
     */
    public void clear()
    {
        m_projects.clear();
        
        m_consultants.clear();
    }
    
    
    
    
    
    
    /**
     * Called to initialize the lists.
     */
    private void initLists()
    {
        m_projects = new LinkedList<Project>();
        
        m_consultants = new LinkedList<Consultant>();
    }
    
    
    
    
    
    /**
     * Add a project to the model.
     * 
     * @param p Project object
     */
    public final void addProject(Project p) throws ControlException
    {
        if (p == null)
        {
            throw new ControlException("Tried to add null project to the model. Command Rejected.");
        }
        else
        {
            if (m_projects.contains(p))
            {
                throw new ControlException("Model: Duplicate projects not allowed. " + p.getProjectShortName());
            }
            m_projects.add(p);
        }
    }
    
    
    
    /**
     * Remove a project from the model.
     * 
     * @param p Project object
     */
    public final void removeProject(Project p) throws ControlException
    {
        if (p == null)
        {
            throw new ControlException("Tried to REMOVE null project from the model. Command Rejected.");
        }
        else
        {
            m_projects.remove(p);
        }
    }
    
 
    
    
    
    
    /**
     * Given a Project ID, retrieve the project. If not found, returns null.
     * 
     * @param id int value - ID of the project to search for.
     * 
     * @return Project object, or null if not found.
     */
    public Project getProjectByID(int id)
    {
        ListIterator<Project> iterator = m_projects.listIterator();
        
        while(iterator.hasNext())
        {
            Project p = iterator.next();
            
            if(p.getProjectID() == id)
            {
                return p;
            }
        }
        return null;
    }
    
    
    
    
    
    /**
     * Add a Consultant to the model.
     * 
     * @param c Consultant object to add.
     */
    public final void addConsultant(Consultant c) throws ControlException
    {
        if (c == null)
        {
            throw new ControlException("Tried to add null consultant to the model. Command Rejected.");
        }
        else
        {
            if (m_consultants.contains(c))
            {
                throw new ControlException("Model: Duplicate consultants are not allowed. " + c.getName());
            }
            m_consultants.add(c);
        }
    }
    
    
    
    
    
    /**
     * Remove a Consultant from the model.
     * 
     * @param c Consultant object to remove.
     */
    public final void removeConsultant(Consultant c) throws ControlException
    {
        if (c == null)
        {
            throw new ControlException("Tried to REMOVE null consultant from the model. Command Rejected.");
        }
        else
        {
            m_consultants.remove(c);
        }
    }
    
    
    
    
    
    /**
     * Given a Consultant ID, retrieve the Consultant. If not found, returns null.
     * 
     * @param id int value - ID of the Consultant to search for.
     * 
     * @return Consultant object, or null if not found.
     */
    public final Consultant getConsultantByID(int id)
    {
        ListIterator<Consultant> iterator = m_consultants.listIterator();
        
        while(iterator.hasNext())
        {
            Consultant c = iterator.next();
            
            if (c.getId() == id)
            {
                return c;
            }
        }
        return null;
    }
    
    
    
    
    
    /**
     * Given an ID value and a Consultant object,
     * 
     * searches for the stored Consultant with that ID, and replaces it with
     * 
     * the given object.
     * 
     * @param id - int value, the ID to search for.
     * 
     * @param newCons - Consultant object to replace with.
     */
    public final void setConsultantByID(int id, Consultant newCons)
    {
        ListIterator<Consultant> iterator = m_consultants.listIterator();
        
        while(iterator.hasNext())
        {
            Consultant c = iterator.next();
            
            if (c.getId() == id)
            {
                iterator.set(newCons); // replace the consultant with the given object.
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Finds the index of the given consultant.
     * 
     * Searches through all consultants, incrementing a counter each loop.
     * 
     * Once found, returns counter.
     * 
     * If not found, returns -1.
     * 
     * If given consultant is null, returns -1.
     * 
     * 
     * @param searchConsultant Consultant object to find.
     * 
     * @return int value - the index of the given consultant.
     */
    public int getConsultantIndex(Consultant searchConsultant)
    {
        if (searchConsultant == null)
        {
            return -1;
        }
        
        int searchIdx = 0;
        
        ListIterator <Consultant> iterator = m_consultants.listIterator();
        
        while(iterator.hasNext())
        {
            Consultant c = iterator.next();
            
            if (c.getId() == searchConsultant.getId())
            {
                return searchIdx; // found consultant index.
            }
            
            ++searchIdx;
        }
        
        return -1; // not found.
    }
    
    
    
    
    
    
    
    
    /**
     * For debug purposes only.
     * 
     * Generates a bunch of Projects and Consultants.
     */
    public final void generateTestData()
    {
        
        try
        {
            // For test purposes, use the Current time, Default time zone, Default locale.
            
            GregorianCalendar today = (GregorianCalendar)GregorianCalendar.getInstance(); // Today, now
            
            DateInput.setDayOfMonth(
                    
                today,
                
                25
            );
            DateInput.setMonth(
                    
                today,
                
                5
            );
            DateInput.setYear(
                    
                today,
                
                2001
            );
            
            
            
            GregorianCalendar tomorrow = (GregorianCalendar)GregorianCalendar.getInstance(); // Today, now
            
            DateInput.setDayOfMonth(
                    
                tomorrow,
                
                26
            );
            DateInput.setMonth(
                    
                tomorrow,
                
                6
            );
            DateInput.setYear(
                    
                tomorrow,
                
                2002
            );
            
            
            
            GregorianCalendar finDate = (GregorianCalendar)GregorianCalendar.getInstance(); // Today, now
            
            DateInput.setDayOfMonth(
                    
                finDate,
                
                27
            );
            DateInput.setMonth(
                    
                finDate,
                
                7
            );
            DateInput.setYear(
                    
                finDate,
                
                2003
            );
            
            FullTimeConsultant chuckNorris = new FullTimeConsultant(

                "Chuck Norris",

                new Address(71, "Danger Street", "Danger Suburb", 6031),

                Employee.GenderType.MALE,

                Application.getDefaultConsultantPicture(),

                150000
            );

            DateInput.setDayOfMonth(
                    
                chuckNorris.getPicture().getDateTaken(),
                
                26
            );

            DateInput.setMonth(
                    
                chuckNorris.getPicture().getDateTaken(),
                
                4
            );

            DateInput.setYear(
                    
                chuckNorris.getPicture().getDateTaken(),
                
                2001
            );
            
            addConsultant(chuckNorris);


            PartTimeConsultant patrickStrauss = new PartTimeConsultant(

                "Patrick Strauss",

                new Address(72, "Forsaken Avenue", "The Outlands", 6032),

                Employee.GenderType.MALE,

                Application.getDefaultConsultantPicture(),

                30,

                20
            );

            addConsultant(patrickStrauss);






            Project mombasaProject = new Project(

                "Mombasa Project",

                "Hans Zimmer",

                200,

                today,

                tomorrow,

                null,

                "Ongoing search for musical inspiration.",

                chuckNorris
            );

            chuckNorris.registerProject(mombasaProject);

            addProject(mombasaProject);


            Project planetCraftProject = new Project(

                "PlanetCraft Project",

                "That Game Company",

                30,

                today,

                tomorrow,

                null,

                "2d Sidescroller.\n\nWith the advent of Minecraft and Terraria,\nwe have to get on the bandwagon and produce a mining,\nexploring, action / adventure sandbox game.",

                chuckNorris
            );

            chuckNorris.registerProject(planetCraftProject);

            addProject(planetCraftProject);


            Project giantRobotProject = new Project(

                "Giant Robot Project",

                "Spectre Industries",

                900,

                today,

                tomorrow,

                finDate,

                "Spectre Industries has asked us to help them restore\na prewar battle droid to its former working state.\n\nWe expect this project to take a long time and incur\ngreat expense.",

                patrickStrauss
            );
            
            giantRobotProject.setFinished(true);

            patrickStrauss.registerProject(giantRobotProject);

            addProject(giantRobotProject);
        
        }
        catch(ControlException ex)
        {
            System.err.println("ControlException: " + ex.getMessage());
            
            ex.printStackTrace();
        }
    }
    
    
    
    
    
    
    /**
     * For visual debug.
     * 
     * Returns a string describing the linkage of the projects and consultants.
     * 
     * @return String
     */
    public String getProjectLinkage()
    {
        String outStr = new String();
        
        ListIterator<Project> projectIterator = m_projects.listIterator();
        
        while(projectIterator.hasNext())
        {
            Project proj = projectIterator.next();
            
            Consultant c = proj.getConsultant();
            
            
            String consName = "";
            
            if (c != null)
            {
                String conString = c.getName();

                if (conString == null)
                {
                    consName = "namenull";
                }
                else
                {
                    consName = conString;
                }
            }
            else
            {
                consName = "consultant=null";
            }
            
            
            String projShortName = "";
            
            String projString = proj.getProjectShortName();
            
            if (projString == null)
            {
                projShortName = "null";
            }
            else
            {
                projShortName = projString;
            }
            
            
            
            outStr = String.format(
                    
                    "%s%n%s",
                    
                    "PROJ: " + projShortName + " ----> CON: [" + consName + "]",
                    
                    outStr
            );
        }
        
        return outStr;
    }
    
    
    
    
    
    
    
    /**
     * For visual debug.
     * 
     * Returns a string describing the linkage of the consultants and projects.
     * 
     * @return String
     */
    public String getConsultantLinkage()
    {
        String outStr = new String();
        
        ListIterator<Consultant> iterator = m_consultants.listIterator();
        
        while(iterator.hasNext())
        {
            Consultant con = iterator.next();
            

            String conName = "";

            String conString = con.getName();
            
            if (conString == null)
            {
                conName = "null";
            }
            else
            {
                conName = conString;
            }
            
            
            String linkedProjects = "";
            
            ArrayList<Integer> ids = con.getProjectIDList();
            
            ListIterator<Integer> idIterator = ids.listIterator();
            
            while(idIterator.hasNext())
            {
                Project proj = getProjectByID(idIterator.next());
                
                String projName = "";
                
                String projString = proj.getProjectShortName();
                
                if (projString == null)
                {
                    projName = "null";
                }
                else
                {
                    projName = projString;
                }
                
                if (idIterator.hasNext())
                {
                    // Use a comma.
                    linkedProjects = linkedProjects.concat(

                        String.format("%s, ", projName)

                    );
                }
                else
                {
                    // No comma.
                    linkedProjects = linkedProjects.concat(

                        String.format("%s", projName)

                    );
                }
            }
            
            outStr = String.format("%s%n%s",
                    
                outStr,
                
                conName + " projects{" + linkedProjects + "}" 
            );
        }
        return String.format("%s%n", outStr);
    }
    
    
    
    /**
     * Override method - toString
     * 
     * Iterate through all objects and get a string representation of the whole model.
     * 
     * @return String representation of this object.
     */
    @Override
    public String toString()
    {
        String outStr = new String();
        
        ListIterator<Project> projectIterator = m_projects.listIterator();
        
        while(projectIterator.hasNext())
        {
            Project proj = projectIterator.next();
            
            outStr = String.format("%s%s%n", outStr, proj.toString());
        }
        
        ListIterator<Consultant> consultantIterator = m_consultants.listIterator();
        
        while(consultantIterator.hasNext())
        {
            Consultant cons = consultantIterator.next();
            
            outStr = String.format("%s%s%n", outStr, cons.toString());
        }
        
        return outStr;
    }
}