package coit12200.studentdetails;

/**
 * This class is used to create a DataSet object that contains student details and marks.
 * It also contains methods to load the data from a table and sort the students by total marks.
 * 
 * @author Jacob Duckworth
 */
public class DataSet {
    private GradeAllocator grader;
    private Student[] students;
    /**This is a predefined set of student details.*/
    private final String[][] studentDetails = {
        {"S20", "David", "Brown"},
        {"S10", "Elizabeth", "Jenkins"},
        {"S35", "Bruce", "Donaldson"}            
    };
    /**This is a predefined set of student marks for the assessments.*/
    private final int[][] studentMarks = {
         {12,9,24},
         {20,28,44},
         {5,16,25},
    };

    /** 
     * Constructor to create a DataSet object with student details and marks.
     * Uses a predefined set of student details and marks.
     */
    public DataSet() {
        grader = new GradeAllocator();
        students = loadFromTable(studentDetails, studentMarks);
        sortByTotalMark();
    }

    /** 
     * Constructor to create a DataSet object with student details and marks.
     * @param details 2D array of student details (id, first name, last name)
     * @param marks 2D array of student marks (assessment 1, assessment 2, assessment 3)
     */
    public DataSet(String[][] details, int[][] marks) {
        grader = new GradeAllocator();
        students = loadFromTable(details, marks);
        sortByTotalMark();
    }

    
    /** 
     * This method is used to access the student data from outside the class.
     * @return student[] array of Student objects
     */
    public Student[] getData() {
        return students;
    }

    
    /** 
     * This method loads the student details and marks into an array of Student objects.
     * @param details
     * @param marks
     * @return Student[]
     */
    private Student[] loadFromTable(String[][] details, int[][] marks) {
        Student[] students = new Student[details.length];
        for (int i = 0; i < details.length; i++) {
            String id = details[i][0];
            String firstName = details[i][1];
            String lastName = details[i][2];

            if (id.isEmpty()) {
                id = "Invalid";
            }
            if (firstName.isEmpty()) {
                firstName = "Invalid";
            }
            if (lastName.isEmpty()) {
                lastName = "Invalid";
            }

            int a1 = marks[i][0];
            int a2 = marks[i][1];
            int a3 = marks[i][2];

            String grade = grader.determineGrade(a1, a2, a3);

            students[i] = new Student(id, firstName, lastName, a1, a2, a3, grade);
        }
        return students;
    }

    /** 
     * This method sorts the students array in descending order based on their total marks using a selection sort.
     */
    private void sortByTotalMark() {
        for (int i = 0; i < students.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < students.length; j++) {
                if (students[j].total() > students[maxIndex].total()) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                Student temp = students[i];
                students[i] = students[maxIndex];
                students[maxIndex] = temp;
            }
        }
    }
}
