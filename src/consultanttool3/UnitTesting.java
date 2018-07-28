/**
 * Title:      Consultant Tool
 * 
 * Author:     Michael Gell (Student 30276096)
 * 
 * Date:       11 May 2012
 * 
 * File Name:  UnitTesting.java
 * 
 * Purpose:    Perform unit testing for all classes in the data model.
 * 
 * 
 * Assumptions / Conditions
 * 
 *      Form of Input:
 * 
 *      This class generates its own test data. No user interaction is required.
 * 
 *      Just call the UnitTesting.runUnitTests();   The rest is automatic.
 * 
 * 
 *      Expected Output:
 * 
 *      Each test creates some data, performs an action and then determines if the
 * 
 *      action was successful. The result is displayed as each test is completed.
 *
 *      A summary of testing is displayed after all tests have been completed.
 */


package consultanttool3;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.ListIterator;


public class UnitTesting
{
    
    
    /**
     * Boolean variable remains true if all unit tests pass.
     */
    private static boolean allPassed = true;
    
    
    /**
     * ArrayList of the names of unit tests which failed.
     */
    private static ArrayList<String> failedList = new ArrayList<String>();
    
    
    
    /**
     * Display student details at the start of program output.
     */
    private static void displayStudentDetails()
    {
        System.out.println("----------------------------------------");
        System.out.println("Student Details:                        ");
        System.out.println("----------------------------------------");
        System.out.println("                                        ");
        System.out.println("   Name              :  Michael Gell    ");
        System.out.println("   Student Number    :  30276096        ");
        System.out.println("   Mode of Enrolment :  Internal        ");
        System.out.println("                                        ");
        System.out.println("   Tutor Name        :  James Meneghello");
        System.out.println("   Tutorial Day      :  Wednesday       ");
        System.out.println("   Tutorial Time     :  1.30pm          ");
        System.out.println("                                        ");
        System.out.println("                                        ");
    }
    
    
    
    /**
     * Run unit tests here.
     */
    public static void runUnitTests()
    {
        
        
        try
        {
            displayStudentDetails();

            String testName;

            
            
            
            //----------------------------------------------------------------------
            // ADDRESS CLASS
            
            
            
            // Default constructor

            // Should initialise member variables to default values.
            
            testName = "Address   Default constructor";
            
            Address address1 = new Address();
            
            if(
                address1.getStreetNumber() == -1 &&
                    
                address1.getStreetName().equals("no street name")  &&

                address1.getSuburb().equals("no suburb") &&

                address1.getPostCode() == -1
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }
            
            
            
            
            // Constructor with Arguments

            // Should initialise member variables to given values.
            
            testName = "Address   Constructor with Arguments";
            
            Address address2 = new Address(155, "AAA", "BBB", 1555);
            
            if(
                address2.getStreetNumber() == 155 &&
                    
                address2.getStreetName().equals("AAA")  &&

                address2.getSuburb().equals("BBB") &&

                address2.getPostCode() == 1555
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }
            
            
            
            
            
            
            // Copy Constructor

            // Should initialise member variables to given values.
            
            // The Address objects should not be the same object.
            
            testName = "Address   Copy Constructor";
            
            Address address3 = new Address(277, "CCC", "DDD", 2777);
            
            Address address4 = new Address(address3);
            
            if(
                address4.getStreetNumber() == 277 &&
                    
                address4.getStreetName().equals("CCC")  &&

                address4.getSuburb().equals("DDD") &&

                address4.getPostCode() == 2777 &&

                address3 != address4
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }
            
            
            
            
            
            
            
            
            //----------------------------------------------------------------------
            // EMPLOYEE CLASS

            Employee employee1;




            // Default constructor

            // Should initialise member variables to default values.
            
            // Picture should not be null, even if it has no image.

            testName = "Employee   Default constructor";
            
            employee1 = new Employee();

            if(
                employee1.getName().equals("no name")  &&

                employee1.getAddress().getStreetName().equals("no street name") &&

                employee1.getAddress().getStreetNumber() == -1 &&

                employee1.getAddress().getSuburb().equals("no suburb") &&

                employee1.getAddress().getPostCode() == -1 &&

                employee1.getGender().equals(Employee.GenderType.FEMALE) &&

                employee1.getPicture() != null &&

                employee1.getId() != -1
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }






            // Constructor with arguments

            // Should initialise member variables to given values.

            testName = "Employee   Constructor with arguments";

            Address testAddress1 = new Address(777, "888", "999", 1010);
            
            Picture pic = new Picture("Picture.png", (GregorianCalendar)GregorianCalendar.getInstance());

            employee1 = new Employee("Chuck Norris", testAddress1, Employee.GenderType.MALE, pic);

            if(
                employee1.getName().equals("Chuck Norris")  &&

                employee1.getAddress() == testAddress1 &&

                employee1.getGender().equals(Employee.GenderType.MALE) &&

                employee1.getPicture().getFileName().equals("Picture.png") &&

                employee1.getId() != -1
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }







            // Copy constructor

            // Duplicate an object. Check that object values match, but they are not the same object.

            testName = "Employee   Copy Constructor";

            employee1 = new Employee();

            employee1.setName(    "Name"    );

            employee1.setAddress( testAddress1 );

            employee1.setGender(  Employee.GenderType.OTHER  );

            employee1.setPicture(pic);

            Employee employee2 = new Employee(employee1);

            if(
                employee2.getName().equals(employee1.getName())  &&

                employee2.getAddress().equals(employee1.getAddress()) &&

                employee2.getGender().equals(employee1.getGender()) &&

                employee2.getPicture().getFileName().equals(employee1.getPicture().getFileName()) &&

                employee2.getId() == employee1.getId() &&

                employee2 != employee1 // Different objects
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }



            

            // Copy constructor using null Picture.

            // Duplicate an object. Check that object values match, but they are not the same object.

            testName = "Employee   Copy constructor using null Picture.";

            Employee employee7 = new Employee();

            employee7.setName(    "Name"    );

            employee7.setAddress( testAddress1 );

            employee7.setGender(  Employee.GenderType.OTHER  );

            employee7.setPicture(null);

            Employee employee8 = new Employee(employee7);

            try
            {
                if(
                    employee8 != employee7 && // Different objects

                    employee8.getName().equals(employee7.getName())  &&

                    employee8.getAddress().equals(employee7.getAddress()) &&

                    employee8.getGender().equals(employee7.getGender()) &&

                    employee8.getId() == employee7.getId() &&

                    employee8.getPicture().getFileName() == null &&  // Picture should not be null. Filename should be be null.

                    employee7.getPicture().getFileName() == null     // Picture should not be null. Filename should be be null.

                )
                {
                    passed(testName);
                }
                else
                {
                    failed(testName);
                }
            }
            catch(java.lang.NullPointerException ex)
            {
                // Picture should not be null.
                
                // Filename should be null.
                
                failed(testName);
                
                ex.printStackTrace();
            }
            



            
            
            
            
            
            

            // Set and get  - Name

            // Retreived value should match the one given.

            testName = "Employee   Set and get  - Name";

            Employee employee4 = new Employee();

            employee4.setName("Chuck Norris");

            if(
                employee4.getName().equals("Chuck Norris")
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }




            // Set and get  - Address

            // Retreived value should match the one given.

            testName = "Employee   Set and get  - Address";

            Employee employee5 = new Employee();

            employee5.setAddress(testAddress1);

            if(
                employee5.getAddress() == testAddress1
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }






            // Set and get  - Gender

            // Retreived value should match the one given.

            testName = "Employee   Set and get  - Gender";

            Employee employee6 = new Employee();

            employee6.setGender(Employee.GenderType.MALE);

            if(
                employee6.getGender().equals(Employee.GenderType.MALE)
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }





            // Set and get  - Picture

            // Retreived value should match the one given.

            testName = "Employee   Set and get  - Picture";

            Employee employee9 = new Employee();

            pic.setFileName("AwesomePicture.png");

            employee9.setPicture(pic);

            if(
                employee9.getPicture().getFileName().equals("AwesomePicture.png")
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }





            // Static ID counter

            // Check that it is incrementing each time we create an object.

            testName = "Employee   Static ID counter";

            Employee employee11 = new Employee();

            Employee employee12 = new Employee();

            Employee employee13 = new Employee();

            if(
                employee13.getId() - employee11.getId() == 2
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }




            //////////////////////////////////////////////////////////////////////














            //----------------------------------------------------------------------
            // PICTURE CLASS




            // Default constructor

            // Should initialise member variables to default values.

            // Check the filname is null.

            // Check the dateTaken is today:  (YEAR, MONTH, DAY_OF_MONTH)

            testName = "Picture    Default constructor";

            Picture picture1;

            picture1 = new Picture(); // Construct.

            // Check against an object that represents the current date (YEAR, MONTH, DAY_OF_MONTH)

            GregorianCalendar today = (GregorianCalendar)GregorianCalendar.getInstance(); // Current time, Default time zone, Default locale.

            if(
                picture1.getFileName()                       == null &&

                ((GregorianCalendar)picture1.getDateTaken()).get(GregorianCalendar.YEAR)         == today.get(GregorianCalendar.YEAR) &&

                ((GregorianCalendar)picture1.getDateTaken()).get(GregorianCalendar.MONTH)        == today.get(GregorianCalendar.MONTH) &&

                ((GregorianCalendar)picture1.getDateTaken()).get(GregorianCalendar.DAY_OF_MONTH) == today.get(GregorianCalendar.DAY_OF_MONTH)
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }








            // Constructor with arguments

            // Should initialise member variables to given values.

            testName = "Picture    Constructor with arguments";

            Picture futurePicture;

            // Check against an object that represents the current date (YEAR, MONTH, DAY_OF_MONTH)

            GregorianCalendar tomorrow = (GregorianCalendar)GregorianCalendar.getInstance(); // Current time, Default time zone, Default locale.

            // Increment the day.

            tomorrow.roll(GregorianCalendar.DAY_OF_MONTH, true);

            // tomorrow == today + 1 day.

            futurePicture = new Picture("futureImage.png", tomorrow); // Construct a picture taken tomorrow.

            if(
                futurePicture.getFileName().equals("futureImage.png") &&

                ((GregorianCalendar)futurePicture.getDateTaken()).get(GregorianCalendar.YEAR)         == tomorrow.get(GregorianCalendar.YEAR) &&

                ((GregorianCalendar)futurePicture.getDateTaken()).get(GregorianCalendar.MONTH)        == tomorrow.get(GregorianCalendar.MONTH) &&

                ((GregorianCalendar)futurePicture.getDateTaken()).get(GregorianCalendar.DAY_OF_MONTH) == tomorrow.get(GregorianCalendar.DAY_OF_MONTH)
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }







            // Copy Constructor

            // Values of both objects should match.

            // They should be different objects (not equal)

            testName = "Picture    Copy Constructor";

            Picture copyOfFuturePicture = new Picture(futurePicture);

            if(
                copyOfFuturePicture.getFileName().equals(futurePicture.getFileName()) &&

                ((GregorianCalendar)copyOfFuturePicture.getDateTaken()).get(GregorianCalendar.YEAR)         == ((GregorianCalendar)futurePicture.getDateTaken()).get(GregorianCalendar.YEAR) &&

                ((GregorianCalendar)copyOfFuturePicture.getDateTaken()).get(GregorianCalendar.MONTH)        == ((GregorianCalendar)futurePicture.getDateTaken()).get(GregorianCalendar.MONTH) &&

                ((GregorianCalendar)copyOfFuturePicture.getDateTaken()).get(GregorianCalendar.DAY_OF_MONTH) == ((GregorianCalendar)futurePicture.getDateTaken()).get(GregorianCalendar.DAY_OF_MONTH) &&

                copyOfFuturePicture != futurePicture
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }





            // Set and Get: Empty String for filename

            // Set filename to an empty string.

            // Get filename - should be null.

            testName = "Picture    Set and Get: Empty String for filename";

            copyOfFuturePicture.setFileName("");

            if(
                copyOfFuturePicture.getFileName() == null
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }




            // Set and Get - Calendar value.

            // Make a date value and set.

            // Get the date value and check it matches.

            testName = "Picture    Set and Get - Calendar value.";

            GregorianCalendar feb2013 = (GregorianCalendar)GregorianCalendar.getInstance(); // Current time, Default time zone, Default locale.

            // Feb 28, 2013

            feb2013.set(GregorianCalendar.DAY_OF_MONTH, 28);

            feb2013.set(GregorianCalendar.MONTH, 2);

            feb2013.set(GregorianCalendar.YEAR, 2013);


            copyOfFuturePicture.setDateTaken(feb2013);

            if(
                ((GregorianCalendar)copyOfFuturePicture.getDateTaken()).get(GregorianCalendar.DAY_OF_MONTH) == 28 &&

                ((GregorianCalendar)copyOfFuturePicture.getDateTaken()).get(GregorianCalendar.MONTH) == 2 &&

                ((GregorianCalendar)copyOfFuturePicture.getDateTaken()).get(GregorianCalendar.YEAR) == 2013
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }




            

//            // Calendar value - add 1 to Feb 28
//
//            // Check it results in March 1
//
//            testName = "Picture    Feb 28++  ";
//
//            copyOfFuturePicture.getDateTaken().add(GregorianCalendar.DAY_OF_YEAR, 1);
//
//            int day = ((GregorianCalendar)copyOfFuturePicture.getDateTaken()).get(GregorianCalendar.DAY_OF_MONTH);
//
//            int month = ((GregorianCalendar)copyOfFuturePicture.getDateTaken()).get(GregorianCalendar.MONTH);
//
//            int year = ((GregorianCalendar)copyOfFuturePicture.getDateTaken()).get(GregorianCalendar.YEAR);
//
//            if(
//                day   == 1    &&
//
//                month == 3    &&
//
//                year  == 2013
//            )
//            {
//                passed(testName);
//            }
//            else
//            {
//                failed(testName + "   DD: " + day + " MM: " + month + " YYYY: " + year + "   GregorianCalendar - add(DAY_OF_YEAR, 1)  I don't understand this method yet.");
//            }









            // Set and Get: filename

            // Set filename to some kind of string.

            // Get filename - retrieved value should match.

            testName = "Picture    Set and Get: filename \"Mohawk\"";

            copyOfFuturePicture.setFileName("Mohawk");

            if(
                copyOfFuturePicture.getFileName().equals("Mohawk")
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }


            //////////////////////////////////////////////////////////////////////














            //----------------------------------------------------------------------
            // CONSULTANT CLASS



            // Default Constructor.

            testName = "Consultant    Default Constructor";

            Consultant consultant1 = new Consultant();

            if(
                consultant1.getName().equals("no name") &&

                consultant1.getAddress().getStreetNumber() == -1 &&
                    
                consultant1.getAddress().getStreetName().equals("no street name") &&

                consultant1.getAddress().getSuburb().equals("no suburb") &&

                consultant1.getAddress().getPostCode() == -1 &&

                consultant1.getGender().equals(Employee.GenderType.FEMALE) &&

                consultant1.getPicture().getFileName() == null &&
                    
                consultant1.getPicture().getDateTakenStr() != null
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }








            // Constructor with arguments.

            testName = "Consultant    Constructor with arguments, snow leopard, has no projects.";

            today = (GregorianCalendar)GregorianCalendar.getInstance();

            Consultant snowLeopardConsultant = new Consultant(

                "Snow leopard",

                testAddress1,

                Employee.GenderType.FEMALE,

                new Picture("snowleopard.png", today)
            );

            if(

                snowLeopardConsultant.getName().equals("Snow leopard") &&

                snowLeopardConsultant.getAddress() == testAddress1 &&

                snowLeopardConsultant.getGender().equals(Employee.GenderType.FEMALE) &&

                snowLeopardConsultant.getPicture() != null &&

                    
                DateInput.compareDates(snowLeopardConsultant.getPicture().getDateTaken(), today) &&
                

                snowLeopardConsultant.getPicture().getFileName() != null &&

                snowLeopardConsultant.getPicture().getFileName().equals("snowleopard.png")
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }










            // Copy Constructor.

            testName = "Consultant    Copy Constructor.";

            Consultant consultant3 = new Consultant(snowLeopardConsultant);

            if(

                consultant3.getName().equals(snowLeopardConsultant.getName()) &&

                consultant3.getAddress().equals(snowLeopardConsultant.getAddress()) &&

                consultant3.getGender().equals(snowLeopardConsultant.getGender()) &&

                consultant3.getPicture() != null &&

                    
                DateInput.compareDates(consultant3.getPicture().getDateTaken(), snowLeopardConsultant.getPicture().getDateTaken()) &&
                    
                
                consultant3.getPicture().getFileName() != null &&

                consultant3.getPicture().getFileName().equals(snowLeopardConsultant.getPicture().getFileName())
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }








            //----------------------------------------------------------------------
            // PROJECT CLASS


            // Default Constructor.

            testName = "Project    Default Constructor.";

            Project testProject = new Project();

            GregorianCalendar cal = (GregorianCalendar)GregorianCalendar.getInstance(); // Today, now.

//            cal.set(
//
//                1999,      // YEAR
//
//                3,         // MONTH
//
//                18,        // DAY_OF_MONTH
//
//                0, 0, 0
//            );
            
            if(
                testProject.getClientName().equals("no name") &&

                testProject.getCostCharged() == 100 &&

                    
                DateInput.compareDates(testProject.getStartingDate(),           cal) &&

                DateInput.compareDates(testProject.getProposedFinishingDate(),  cal) &&

                DateInput.compareDates(testProject.getActualFinishingDate(),   null) &&
                    

                testProject.getDescription().equals("no description") &&

                testProject.getConsultant() == null
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }







            // Constructor with arguments.

            testName = "Project    Constructor with arguments.";

            today = (GregorianCalendar)GregorianCalendar.getInstance(); // Today, now.

            tomorrow = (GregorianCalendar)GregorianCalendar.getInstance(); // Today, now.

            tomorrow.add(GregorianCalendar.DAY_OF_YEAR, 1);

            testProject = new Project("shortName", "clientName", 100, today, tomorrow, null, "Description", snowLeopardConsultant);

            if(
                testProject.getProjectShortName().equals("shortName") &&

                testProject.getClientName().equals("clientName") &&

                testProject.getCostCharged() == 100 &&

                    
                DateInput.compareDates(testProject.getStartingDate(),             today) &&

                DateInput.compareDates(testProject.getProposedFinishingDate(), tomorrow) &&

                DateInput.compareDates(testProject.getActualFinishingDate(),       null) &&

                    
                testProject.getDescription().equals("Description") &&

                testProject.getConsultant() == snowLeopardConsultant
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }



            
            




            // Copy Constructor

            testName = "Project    Copy Constructor";

            Project testProject2 = new Project(testProject);

            if(
                testProject2.getProjectShortName().equals(testProject.getProjectShortName()) &&

                testProject2.getClientName().equals(testProject.getClientName()) &&

                testProject2.getCostCharged() == testProject.getCostCharged() &&

                
                DateInput.compareDates(testProject2.getStartingDate(),                   testProject.getStartingDate()) &&
                
                DateInput.compareDates(testProject2.getProposedFinishingDate(), testProject.getProposedFinishingDate()) &&
                
                DateInput.compareDates(testProject2.getActualFinishingDate(),     testProject.getActualFinishingDate()) &&
                    
                    
                testProject2.getDescription().equals(testProject.getDescription()) &&

                testProject2.getConsultant() == testProject.getConsultant()
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }







            //----------------------------------------------------------------------
            // FULLTIMECONSULTANT CLASS


            // Default Constructor.

            testName = "FullTimeConsultant    Default Constructor";

            FullTimeConsultant fullTimeConsultant = new FullTimeConsultant();

            if(
                fullTimeConsultant.getName().equals("no name") &&

                fullTimeConsultant.getAddress().getStreetNumber() == -1 &&
                    
                fullTimeConsultant.getAddress().getStreetName().equals("no street name") &&

                fullTimeConsultant.getAddress().getSuburb().equals("no suburb") &&

                fullTimeConsultant.getAddress().getPostCode() == -1 &&

                fullTimeConsultant.getGender().equals(Employee.GenderType.FEMALE) &&

                fullTimeConsultant.getPicture().getFileName() == null &&
                    
                fullTimeConsultant.getPicture().getDateTakenStr() != null &&

                fullTimeConsultant.getAnnualSalary() == 80000
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }







            // Constructor with arguments.

            testName = "FullTimeConsultant    Constructor with arguments.";

            today = (GregorianCalendar)GregorianCalendar.getInstance();

            fullTimeConsultant = new FullTimeConsultant(

                "HoneyBee",

                testAddress1,

                Employee.GenderType.FEMALE,

                new Picture("bee.png", today),

                85000
            );

            if(
                fullTimeConsultant.getName().equals("HoneyBee") &&

                fullTimeConsultant.getAddress() == testAddress1 &&

                fullTimeConsultant.getGender().equals(Employee.GenderType.FEMALE) &&

                fullTimeConsultant.getPicture().getFileName().equals("bee.png") &&

                DateInput.compareDates(fullTimeConsultant.getPicture().getDateTaken(), today) &&
                
                fullTimeConsultant.getAnnualSalary() == 85000
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }






            // Copy Constructor

            testName = "FullTimeConsultant    Copy Constructor.";

            FullTimeConsultant fullTimeConsultant2 = new FullTimeConsultant(fullTimeConsultant);

            if(
                fullTimeConsultant2.getName().equals(fullTimeConsultant.getName()) &&

                fullTimeConsultant2.getAddress().equals(fullTimeConsultant.getAddress()) &&

                fullTimeConsultant2.getGender().equals(fullTimeConsultant.getGender()) &&

                fullTimeConsultant2.getPicture() == fullTimeConsultant.getPicture() &&

                fullTimeConsultant2.getAnnualSalary() == fullTimeConsultant.getAnnualSalary()
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }












            //----------------------------------------------------------------------
            // PARTTIMECONSULTANT CLASS


            // Default Constructor.

            testName = "PartTimeConsultant    Default Constructor.";

            PartTimeConsultant partTimeConsultant = new PartTimeConsultant();

            today = (GregorianCalendar)GregorianCalendar.getInstance();
            
            if(
                partTimeConsultant.getName().equals("no name") &&

                partTimeConsultant.getAddress().getStreetNumber() == -1 &&
                    
                partTimeConsultant.getAddress().getStreetName().equals("no street name") &&

                partTimeConsultant.getAddress().getSuburb().equals("no suburb") &&

                partTimeConsultant.getAddress().getPostCode() == -1 &&

                partTimeConsultant.getGender().equals(Employee.GenderType.FEMALE) &&

                partTimeConsultant.getPicture().getFileName() == null &&
                
                    
                DateInput.compareDates(partTimeConsultant.getPicture().getDateTaken(), today) &&
                    

                partTimeConsultant.getHourlyRate() == 60 &&

                partTimeConsultant.getMaxHours() == 20
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }






            // Constructor with arguments.

            testName = "PartTimeConsultant    Constructor with arguments.";

            today = (GregorianCalendar)GregorianCalendar.getInstance();

            partTimeConsultant = new PartTimeConsultant(

                "beaver",

                testAddress1,

                Employee.GenderType.MALE,

                new Picture("beaver.png", today),

                100,

                16
            );

            if(
                partTimeConsultant.getName().equals("beaver") &&

                partTimeConsultant.getAddress() == testAddress1 &&

                partTimeConsultant.getGender().equals(Employee.GenderType.MALE) &&

                partTimeConsultant.getPicture().getFileName().equals("beaver.png") &&

                DateInput.compareDates(partTimeConsultant.getPicture().getDateTaken(), today) &&

                partTimeConsultant.getHourlyRate() == 100 &&

                partTimeConsultant.getMaxHours() == 16
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }







            // Copy Constructor

            testName = "PartTimeConsultant    Copy Constructor.";

            PartTimeConsultant partTimeConsultant2 = new PartTimeConsultant(partTimeConsultant);

            if(
                partTimeConsultant2.getName().equals(partTimeConsultant.getName()) &&

                partTimeConsultant2.getAddress().equals(partTimeConsultant.getAddress()) &&

                partTimeConsultant2.getGender().equals(partTimeConsultant.getGender()) &&

                partTimeConsultant2.getPicture() == partTimeConsultant.getPicture() &&

                partTimeConsultant2.getHourlyRate() == partTimeConsultant.getHourlyRate() &&

                partTimeConsultant2.getMaxHours() == partTimeConsultant.getMaxHours()
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }





            
            
            
            ////////////////////////////////////////////////////////////////////

            // MODEL CLASS

            
            
            
            
            
            // Default Constructor

            testName = "Model    Default Constructor.";

            Model model = new Model();

            passed(testName);







            // Add a project to the model.

            testName = "Model    Add a project to the model.";

            today = (GregorianCalendar)GregorianCalendar.getInstance(); // Current time, Default time zone, Default locale.

            tomorrow = (GregorianCalendar)GregorianCalendar.getInstance(); // Current time, Default time zone, Default locale.

            // Increment the day.

            tomorrow.roll(GregorianCalendar.DAY_OF_MONTH, true);

            testProject = new Project("shortName", "clientName", 100, today, tomorrow, null, "Description", snowLeopardConsultant);

            int id = testProject.getProjectID();

            model.addProject(testProject);

            Project retrievedProject = model.getProjectByID(id);

            if(
                retrievedProject.getProjectShortName().equals("shortName") &&

                retrievedProject.getClientName().equals("clientName") &&

                retrievedProject.getCostCharged() == 100 &&

                    
                DateInput.compareDates(retrievedProject.getStartingDate(), today) &&

                DateInput.compareDates(retrievedProject.getProposedFinishingDate(), tomorrow) &&

                DateInput.compareDates(retrievedProject.getActualFinishingDate(), null) &&


                retrievedProject.getDescription().equals("Description") &&

                retrievedProject.getConsultant() == snowLeopardConsultant
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }








            // Remove a project from the model.

            testName = "Model    Remove a project from the model.";

            model.removeProject(testProject);

            retrievedProject = model.getProjectByID(id);

            if(
                retrievedProject == null
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }









            // Add a Consultant to the model.

            testName = "Model    Add a Consultant to the model.";

            today = (GregorianCalendar)GregorianCalendar.getInstance();

            snowLeopardConsultant = new Consultant(

                "Snow leopard",

                testAddress1,

                Employee.GenderType.FEMALE,

                new Picture("snowleopard.png", today)
            );
            
            testProject.setConsultant(null);
            
            snowLeopardConsultant.registerProject(testProject);

            id = snowLeopardConsultant.getId();

            model.addConsultant(snowLeopardConsultant);

            Consultant retrievedConsultant = model.getConsultantByID(id);

            if(

                retrievedConsultant.getName().equals(snowLeopardConsultant.getName()) &&

                retrievedConsultant.getAddress().equals(snowLeopardConsultant.getAddress()) &&

                retrievedConsultant.getGender().equals(snowLeopardConsultant.getGender()) &&

                retrievedConsultant.getPicture().getDateTaken().equals(snowLeopardConsultant.getPicture().getDateTaken()) &&

                retrievedConsultant.getPicture().getFileName().equals(snowLeopardConsultant.getPicture().getFileName())
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }





            // Remove a Consultant from the model.

            testName = "Model    Remove a Consultant from the model.";

            model.removeConsultant(snowLeopardConsultant);

            retrievedConsultant = model.getConsultantByID(id);

            if(
                retrievedConsultant == null
            )
            {
                passed(testName);
            }
            else
            {
                failed(testName);
            }








            //---------------------------------------------------------------------------------------------------------
            //---------------------------------------------------------------------------------------------------------
            //---------------------------------------------------------------------------------------------------------
            // SUMMARY OF TESTING

            if (allPassed)
            {
                System.out.printf("%n%nAll Passed.%n%n");
            }
            else
            {
                System.out.printf("%n%nThe following tests failed: ");

                ListIterator<String> iterator = failedList.listIterator();

                while(iterator.hasNext())
                {
                    String failedStr = iterator.next();

                    System.out.printf("%s, ", failedStr);
                }
                System.out.println();

                System.out.println();
            }
        
        
        }
        catch(ControlException ex)
        {
            System.err.println("ControlException: " + ex.getMessage());
            
            ex.printStackTrace();
        }
        
    } // </runUnitTests>
    
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    // Display pass or fail
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
    private static void passed(String testName )
    {
        System.out.printf("Test pass:  %s%n", testName);
    }
    
    
    
    
    
    
    
    //////////////////////////////////////////////////////
    
    private static void failed(String testName )
    {
        System.err.printf("Test FAILED:  %s%n", testName);
        
        allPassed = false;
        
        failedList.add(testName);
    }
    
    
    
}
