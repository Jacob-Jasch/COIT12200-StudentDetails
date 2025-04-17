package coit12200.studentdetails;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class DataSetTest {

    @Test
    public void getDataThreeElementsTest() {
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
            
        DataSet ds = new DataSet(studentDetails, studentMarks);
        assertArrayEquals(expected, ds.getData());
    }

    @Test
    public void getInvalidDataThreeElementsTest() {
        String[][] studentDetails = {
            {"", "", ""},
            {"S10", "Elizabeth", "Jenkins"},
            {"Word", "Word", "Word"}};

        int[][] studentMarks = {
            {0, 0, 0},
            {-20, -28, -44},
            {999, 999, 999}};

        Student[] expected = {
            new Student("Word", "Word", "Word", 999, 999, 999,  "Invalid"),
            new Student("Invalid", "Invalid", "Invalid", 0, 0, 0,  "AF"),
            new Student("S10", "Elizabeth", "Jenkins", -20, -28, -44,  "Invalid")};
            
        DataSet ds = new DataSet(studentDetails, studentMarks);

        assertArrayEquals(expected, ds.getData());
    }

    @Test
    public void getPredefinedDataTest() {
        Student[] expected = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44,  "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25,  "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24,  "F")};
                
        DataSet ds = new DataSet();

        assertArrayEquals(expected, ds.getData());
    }
}