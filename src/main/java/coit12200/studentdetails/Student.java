package coit12200.studentdetails;

/**
 * This class is used to represent a student and all of their details.
 * 
 * @author Jacob Duckworth
 */
public record Student(String id, String firstName, String lastName, int a1, int a2, int a3, String grade) {
    
    
    /** 
     * This method returns the total marks of the student by adding all of the marks from the assessments.
     * @return int total marks of the student
     */
    public int total() {
        return a1 + a2 + a3;
    }

    @Override
    public String toString() {
        // Format the output string to display the student details
        return String.format("%s: %-14s%-14s %2d %2d %2d   total: %3d  grade: %2s",
            id, firstName, lastName, a1, a2, a3, total(), grade);
    }
}
