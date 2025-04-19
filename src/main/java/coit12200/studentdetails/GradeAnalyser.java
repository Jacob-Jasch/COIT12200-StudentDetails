package coit12200.studentdetails;

import java.util.ArrayList;
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
     * @param lowerMark the lower mark of the range
     * @param upperMark the upper mark of the range
     * @return RangeValidation an object containing the result of the validation.
     */
    public RangeValidation ValidateRanges(String lowerMark, String upperMark) {
        if (lowerMark.isEmpty() || upperMark.isEmpty()) {
            return new RangeValidation(false, null, "Please enter both lower and upper marks.");
        }
        int lower = Integer.parseInt(lowerMark);
        int upper = Integer.parseInt(upperMark);
        if (lower < 0 || upper < 0) {
            return new RangeValidation(false, null, "Marks cannot be negative.");
        }
        if (lower > upper) {
            return new RangeValidation(false, null, "Lower mark cannot be greater than upper mark.");
        }
        if (lower == upper) {
            return new RangeValidation(false, null, "Lower and upper marks cannot be the same.");
        }
        if (lower > 100 || upper > 100) {
            return new RangeValidation(false, null, "Marks cannot be greater than 100.");
        }
        return new RangeValidation(true, new Range(lower, upper), "Valid");
    }

    
    /**
     * This method is used to get the student records in a specified range of marks.
     * 
     * @param lowerMark the lower mark of the range
     * @param upperMark the upper mark of the range
     * @return Student[] an array of Student objects within the specified range
     */
    public Student[] GetStudentRecordInRange(int lowerMark, int upperMark) {
        ArrayList<Student> result = new ArrayList<Student>();
        for (int i = 0; i < orderedList.size(); i++) {
            Student student = orderedList.get(i);
            int tot = student.total();
            if (tot >= lowerMark && tot <= upperMark) {
                result.add(student);
            }
        }
        return result.toArray(new Student[0]);
    }

    
    /** 
     * This method is used to get the median mark of the students.
     * @return double the median mark of the students
     * @throws EmptyListException if the list of students is empty
     */
    public double medianMark() throws EmptyListException {
        if (studentHashMap.isEmpty()) {
            throw new EmptyListException("No students available.");
        }
    
        ArrayList<Student> list = new ArrayList<>(studentHashMap.values());
        int[] marks = new int[list.size()];
    
        for (int i = 0; i < list.size(); i++) {
            marks[i] = list.get(i).total();
        }
    
        Arrays.sort(marks);
    
        int size = marks.length;
        int middle = size / 2;
    
        if (size % 2 == 0) {
            return (marks[middle - 1] + marks[middle]) / 2.0;
        } else {
            return marks[middle];
        }
    }

    
    /** 
     * This method is used to get the average mark of the students.
     * @return double the average mark of the students
     * @throws EmptyListException if the list of students is empty
     */
    public double averageMark() throws EmptyListException {
        if (studentHashMap.isEmpty()) {
            throw new EmptyListException("No students available.");
        }

        double total = 0;
        ArrayList<Student> list = new ArrayList<>(studentHashMap.values());
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            total = total + student.total();
        }
        return total / list.size();
    }

    
    /** 
     * This method is used to get the maximum mark of the students.
     * @return int the maximum mark of the students
     * @throws EmptyListException if the list of students is empty
     */
    public int Maximum() throws EmptyListException {
        if (studentHashMap.isEmpty()) {
            throw new EmptyListException("No students available.");
        }
    
        ArrayList<Student> list = new ArrayList<>(studentHashMap.values());
        int max = list.get(0).total(); // Set to first value to avoid using Integer.MIN_VALUE
    
        for (int i = 1; i < list.size(); i++) {
            int mark = list.get(i).total();
            if (mark > max) {
                max = mark;
            }
        }
        return max;
    }

    
    /** 
     * This method is used to get the minimum mark of the students.
     * @return int the minimum mark of the students
     * @throws EmptyListException if the list of students is empty
     */
    public int Minimum() throws EmptyListException {
        if (studentHashMap.isEmpty()) {
            throw new EmptyListException("No students available.");
        }
    
        ArrayList<Student> list = new ArrayList<>(studentHashMap.values());
        int min = list.get(0).total();
    
        for (int i = 1; i < list.size(); i++) {
            int mark = list.get(i).total();
            if (mark < min) {
                min = mark;
            }
        }
        return min;
    }

    /**
     * This method is used to create a hash map of student IDs.
     */
    private void createIdHashMap(){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

}