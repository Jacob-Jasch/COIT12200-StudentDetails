package coit12200.studentdetails;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GradeAnalyser {

    private List<Student> orderedList;
    private HashMap<String, Student> studentHashMap = new HashMap<>();
    public record Range(int lower, int upper) {}
    public record RangeValidation(boolean result, Range range, String message) {}

    /** 
     * Constructor to create a GradeAnalyser object with a DataSet object.
     * @param dataSet DataSet object containing student details and marks
     */
    public GradeAnalyser(DataSet dataSet) 
    {
        Student[] students = dataSet.getData();

        this.orderedList = Arrays.asList(students);

        studentHashMap = new HashMap<>();
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            studentHashMap.put(String.valueOf(student.id().toUpperCase()), student);
        }
    }

    /** 
     * Constructor to create a GradeAnalyser object with a list of students.
     * @param studentResult array of Student objects
     */
    public GradeAnalyser(Student[] studentResult) {
        this.orderedList = Arrays.asList(studentResult);

        studentHashMap = new HashMap<>();
        for (int i = 0; i < studentResult.length; i++) {
            Student student = studentResult[i];
            studentHashMap.put(String.valueOf(student.id().toUpperCase()), student);
        }
    }

    
    /** 
     * This method is used to find a student by their ID.
     * 
     * @param id the ID of the student to find
     * @return Student[] an array of Student objects with the matching ID
     */
    public Student find(String id) {
        return studentHashMap.get(id.trim().toUpperCase());
    }

    
    /** 
     * This method is used to return the ordered list of students.
     * 
     * @return List<Student> the ordered list of Student objects
     */
    public List<Student> getOrderedList() {
        return orderedList;
    }    

    
    /** 
     * This method is used to validate the ranges of marks for the students.
     * 
     * @return RangeValidation an object containing the result of the validation.
     */
    public RangeValidation ValidateRanges() {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    
    /**
     * This method is used to get the student records in a specified range of marks.
     * 
     * @param lowerMark the lower mark of the range
     * @param upperMark the upper mark of the range
     * @return Student[] an array of Student objects within the specified range
     */
    public Student[] GetStudentRecordInRange(int lowerMark, int upperMark) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    
    /** 
     * This method is used to get the median mark of the students.
     * @return double the median mark of the students
     */
    public double medianMark() {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    
    /** 
     * This method is used to get the average mark of the students.
     * @return double the average mark of the students
     */
    public double averageMark() {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    
    /** 
     * This method is used to get the maximum mark of the students.
     * @return int the maximum mark of the students
     */
    public int Maximum() {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    
    /** 
     * This method is used to get the minimum mark of the students.
     * @return int the minimum mark of the students
     */
    public int Minimum() {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    /**
     * This method is used to create a hash map of student IDs.
     */
    private void createIdHashMap(){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

}