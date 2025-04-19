package coit12200.studentdetails;

/**
 * This class is used to determine the grade of a student based on their marks in three assessments.
 *  
 * @author Jacob Duckworth
 */
public class GradeAllocator {
    public final int maxAssess1 = 20;
    public final int maxAssess2 = 30;
    public final int maxAssess3 = 50;

    /**
     * this method takes in the marks for each assessment and returns the grade
     * based on the total marks.
     * The grade is determined by the following criteria:
     * - HD: 85% and above
     * - D: 75% to 84%
     * - C: 65% to 74%
     * - P: 50% to 64%
     * - SA: 45% to 49% (supplementary)
     * - F: 1% to 49%
     * - AF: 0% (absent fail)
     * 
     * @param a1Mark Assessment 1 mark max 20
     * @param a2Mark Assessment 2 mark max 30
     * @param a3Mark Assessment 3 mark max 50
     * @return String The grade based on the total marks
     */
    public String determineGrade(int a1Mark, int a2Mark, int a3Mark) {
        if (a1Mark < 0 || a1Mark > maxAssess1 || a2Mark < 0 || a2Mark > maxAssess2
                || a3Mark < 0 || a3Mark > maxAssess3) {
            return "Invalid";
        }
        
        int totalMarks = a1Mark + a2Mark + a3Mark;
        String grade = "";

        if (totalMarks >= 85) {
            grade = "HD";
        } else if (totalMarks >= 75 && totalMarks <= 84) {
            grade = "D";
        } else if (totalMarks >= 65 && totalMarks <= 74) {
            grade = "C";
        } else if (totalMarks >= 50 && totalMarks <= 64) {
            grade = "P";
        } else if (totalMarks >= 45 && totalMarks <= 49 && supplementary(a1Mark, a2Mark, a3Mark)) {
            grade = "SA";
        } else if (totalMarks >= 1 && totalMarks <= 49) {
            grade = "F";
        } else if (totalMarks == 0) {
            grade = "AF";
        } else {
            grade = "Invalid";
        }
        return grade;
    }

    /**
     * this method checks if the student is eligible for a supplementary exam.
     * A student is eligible for a supplementary exam if they have failed only one
     * assessment.
     * The method checks if each assessment is below 50% of its maximum marks and
     * counts the number of failed assessments.
     * If only one assessment has failed, the method returns true, indicating that
     * the student is eligible for a supplementary exam.
     * 
     * @param a1Mark Assessment 1 mark max 20
     * @param a2Mark Assessment 2 mark max 30
     * @param a3Mark Assessment 3 mark max 50
     * @return boolean Whether the student is eligible for a supplementary exam or not
     */
    private boolean supplementary(int a1Mark, int a2Mark, int a3Mark) {
        int failedCount = 0;

        // Check if each assessment is below 50% of its maximum marks
        if (a1Mark < maxAssess1 * 0.5) {
            failedCount++;
        }
        if (a2Mark < maxAssess2 * 0.5) {
            failedCount++;
        }
        if (a3Mark < maxAssess3 * 0.5) {
            failedCount++;
        }

        // Return true if only one assessment has failed
        return failedCount == 1;
    }

}
