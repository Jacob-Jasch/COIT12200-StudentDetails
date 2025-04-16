package coit12200.studentdetails;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GradeAllocatorTest {
    
    @Test
    public void validDataDetermineGradeTest() {
        GradeAllocator gradeAllocator = new GradeAllocator();
        
        assertEquals("HD", gradeAllocator.determineGrade(20, 30, 50));
        assertEquals("D", gradeAllocator.determineGrade(20, 30, 30));
        assertEquals("C", gradeAllocator.determineGrade(20, 30, 20));
        assertEquals("P", gradeAllocator.determineGrade(20, 30, 10));
        assertEquals("SA", gradeAllocator.determineGrade(20, 25, 0));
        assertEquals("F", gradeAllocator.determineGrade(20, 20, 0));
        assertEquals("AF", gradeAllocator.determineGrade(0, 0, 0));
    }

    @Test
    public void invalidDataDetermineGradeTest() {
        GradeAllocator gradeAllocator = new GradeAllocator();
        
        assertEquals("Invalid", gradeAllocator.determineGrade(-1, 30, 50));
        assertEquals("Invalid", gradeAllocator.determineGrade(20, -1, 50));
        assertEquals("Invalid", gradeAllocator.determineGrade(20, 30, -1));
        assertEquals("Invalid", gradeAllocator.determineGrade(20, 30, 101));
        assertEquals("Invalid", gradeAllocator.determineGrade(-20, -30, -40));
    }
    
}
