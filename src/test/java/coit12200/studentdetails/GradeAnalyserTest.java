package coit12200.studentdetails;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GradeAnalyserTest {

    @Test
    void gradeAnalyserGetOrderedListWithDataSetTest() {
        String[][] studentDetails = {
            {"S20", "David", "Brown"},
            {"S10", "Elizabeth", "Jenkins"},
            {"S35", "Bruce", "Donaldson"}};

        int[][] studentMarks = {
            {12, 9, 24},
            {20, 28, 44},
            {5, 16, 25}};

        Student[] expected = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44,  "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25,  "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24,  "F")};

        DataSet dataSet = new DataSet(studentDetails, studentMarks);
        GradeAnalyser gradeAnalyser = new GradeAnalyser(dataSet);
        assertArrayEquals(expected, gradeAnalyser.getOrderedList().toArray());
    }

    @Test
    void gradeAnalyserGetOrderedListWithStudentListTest() {
        Student[] expected = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44,  "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25,  "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24,  "F")};

        GradeAnalyser gradeAnalyser = new GradeAnalyser(expected);
        assertArrayEquals(expected, gradeAnalyser.getOrderedList().toArray());
    }

    @Test
    public void findWhenFoundTest() {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44,  "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25,  "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24,  "F")
        };
        String id = "S10";
        GradeAnalyser ga = new GradeAnalyser(data);
        Student expResult = new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44,  "HD");
        Student result = ga.find(id);
        assertEquals(expResult, result); 
    }

    @Test
    public void findWhenNotFoundTest() {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44,  "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25,  "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24,  "F")
        };
        String id = "S55";
        GradeAnalyser ga = new GradeAnalyser(data);
        Student expResult = null;
        Student result = ga.find(id);
        assertEquals(expResult, result); 
    }

    @Test
    public void findWhenDuplicateIDTest()
    {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44,  "HD"),
            new Student("S20", "Bruce", "Donaldson", 5, 16, 25,  "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24,  "F")
        };
        String id = "S20";
        GradeAnalyser ga = new GradeAnalyser(data);
        Student expResult = new Student("S20", "David", "Brown", 12, 9, 24,  "F");
        Student result = ga.find(id);
        assertEquals(expResult, result); 
    }

    @Test
    public void findWhenEmptyIDTest()
    {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44,  "HD"),
            new Student("S20", "Bruce", "Donaldson", 5, 16, 25,  "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24,  "F")
        };
        String id = "";
        GradeAnalyser ga = new GradeAnalyser(data);
        Student expResult = null;
        Student result = ga.find(id);
        assertEquals(expResult, result); 
    } 
}