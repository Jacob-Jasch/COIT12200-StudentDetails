package coit12200.studentdetails;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44, "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24, "F")};

        DataSet dataSet = new DataSet(studentDetails, studentMarks);
        GradeAnalyser gradeAnalyser = new GradeAnalyser(dataSet);
        assertArrayEquals(expected, gradeAnalyser.getOrderedList().toArray());
    }

    @Test
    void gradeAnalyserGetOrderedListWithStudentListTest() {
        Student[] expected = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44, "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24, "F")};

        GradeAnalyser gradeAnalyser = new GradeAnalyser(expected);
        assertArrayEquals(expected, gradeAnalyser.getOrderedList().toArray());
    }

    @Test
    public void findWhenFoundTest() {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44, "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24, "F")
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
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44, "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24, "F")
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
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44, "HD"),
            new Student("S20", "Bruce", "Donaldson", 5, 16, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24, "F")
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
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44, "HD"),
            new Student("S20", "Bruce", "Donaldson", 5, 16, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 9, 24, "F")
        };
        String id = "";
        GradeAnalyser ga = new GradeAnalyser(data);
        Student expResult = null;
        Student result = ga.find(id);
        assertEquals(expResult, result); 
    } 

    @Test
    public void averageMarkValidTest() {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44, "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 9, 25, "F")
        };
        GradeAnalyser ga = new GradeAnalyser(data);
        double expResult = (20 + 28 + 44 + 5 + 16 + 25 + 12 + 9 + 25) / (double) data.length;
        double result = ga.averageMark();
        assertEquals(expResult, result); 
    }

    @Test
    public void averageMarkEmptyTest() {
        Student[] data = {};
        GradeAnalyser ga = new GradeAnalyser(data);
        assertThrows(EmptyListException.class, () -> ga.averageMark());
    }

    @Test
    public void averageNegativeTest() {
        GradeAnalyser ga = new GradeAnalyser(new Student[]{
            new Student("S10","E","J",-20,-28,-44,"HD"),
            new Student("S35","B","D", -5,-16,-25,"SA"),
            new Student("S20","D","B", -12,-9,-25,"F")
        });
        assertEquals(-61.3333333333, ga.averageMark(), 1e-9);
    }

    @Test
    public void medianMarkValidTest() {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44, "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 9, 25, "F")
        };
        GradeAnalyser ga = new GradeAnalyser(data);

        double expResult = 46.0;
        double result    = ga.medianMark();
        assertEquals(expResult, result, 0.0001);
    }
    
    @Test
    public void medianMarkEmptyTest() {
        Student[] data = {};
        GradeAnalyser ga = new GradeAnalyser(data);
        assertThrows(EmptyListException.class, () -> ga.medianMark());
    }

    @Test
    public void medianNegativeTest() {
        GradeAnalyser ga = new GradeAnalyser(new Student[]{
            new Student("S10","Elizabeth","Jenkins",-20,-28,-44,"HD"),
            new Student("S35","Bruce","Donaldson", -5,-16,-25,"SA"),
            new Student("S20","David","Brown", -12,-9,-25,"F")
        });
        assertEquals(-46.0, ga.medianMark(), 0.0001);
    }
    

    @Test
    public void maximumValidTest() {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44, "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 9, 25, "F")
        };
        GradeAnalyser ga = new GradeAnalyser(data);

        int expResult = 92;
        int result    = ga.Maximum();
        assertEquals(expResult, result);
    }

    @Test
    public void maximumEmptyTest() {
        Student[] data = {};
        GradeAnalyser ga = new GradeAnalyser(data);
        assertThrows(EmptyListException.class, () -> ga.Maximum());
    }

    @Test
    public void maximumNegativeTest() {
        Student[] data = {
            new Student("S10","Elizabeth","Jenkins",-20,-28,-44,"HD"),
            new Student("S35","Bruce","Donaldson", -5,-16,-25,"SA"),
            new Student("S20","David","Brown", -12,-9,-25,"F")
        };
        GradeAnalyser ga = new GradeAnalyser(data);
    
        int expResult = -46;
        int result    = ga.Maximum();
        assertEquals(expResult, result);
    }

    @Test
    public void minimumValidTest() {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", 20, 28, 44, "HD"),
            new Student("S35", "Bruce", "Donaldson", 5, 16, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 9, 25, "F")
        };
        GradeAnalyser ga = new GradeAnalyser(data);

        int expResult = 46;
        int result    = ga.Minimum();
        assertEquals(expResult, result);
    }

    @Test
    public void minimumEmptyTest() {
        Student[] data = {};
        GradeAnalyser ga = new GradeAnalyser(data);
        assertThrows(EmptyListException.class, () -> ga.Minimum());
    }

    @Test
    public void minimumNegativeTest() {
        Student[] data = {
            new Student("S10","Elizabeth","Jenkins",-20,-28,-44,"HD"),
            new Student("S35","Bruce","Donaldson", -5,-16,-25,"SA"),
            new Student("S20","David","Brown", -12,-9,-25,"F")
        };
        GradeAnalyser ga = new GradeAnalyser(data);
    
        int expResult = -92;
        int result    = ga.Minimum();
        assertEquals(expResult, result);
    }

    @Test
    public void getStudentRecordInRangeValidTest() {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", 10, 10, 15, "HD"),
            new Student("S35", "Bruce", "Donaldson", 15,  26, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 8, 12, "F")
        };
        GradeAnalyser ga = new GradeAnalyser(data);
        int lower = 30;
        int upper = 50;

        Student[] expected = {
            new Student("S10", "Elizabeth", "Jenkins", 10, 10, 15, "HD"),
            new Student("S20", "David", "Brown", 12, 8, 12, "F")
        };

        assertArrayEquals(expected, ga.GetStudentRecordInRange(lower, upper));
    }

    @Test
    public void getStudentRecordInRangeEmptyTest() {
        Student[] data = {};
        GradeAnalyser ga = new GradeAnalyser(data);
        int lower = 30;
        int upper = 50;

        Student[] expected = {};

        assertArrayEquals(expected, ga.GetStudentRecordInRange(lower, upper));
    }

    @Test
    public void getStudentRecordInRangeNegativeTest() {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", -10, -10, -15, "HD"),
            new Student("S35", "Bruce", "Donaldson", -15, -26, -25, "SA"),
            new Student("S20", "David", "Brown", -12, -8, -12, "F")
        };
        GradeAnalyser ga = new GradeAnalyser(data);
        int lower = -50;
        int upper = -30;

        Student[] expected = {
            new Student("S10", "Elizabeth", "Jenkins", -10, -10, -15, "HD"),
            new Student("S20", "David", "Brown", -12, -8, -12, "F")
        };

        assertArrayEquals(expected, ga.GetStudentRecordInRange(lower, upper));
    }

    @Test
    public void getStudentRecordInRangeInvalidTest() {
        Student[] data = {
            new Student("S10", "Elizabeth", "Jenkins", 10, 10, 15, "HD"),
            new Student("S35", "Bruce", "Donaldson", 15, 26, 25, "SA"),
            new Student("S20", "David", "Brown", 12, 8, 12, "F")
        };
        GradeAnalyser ga = new GradeAnalyser(data);
        int lower = 50;
        int upper = 30;

        Student[] expected = {};

        assertArrayEquals(expected, ga.GetStudentRecordInRange(lower, upper));
    }
    
}