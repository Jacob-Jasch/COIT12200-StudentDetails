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
    public GradeAnalyser(DataSet dataSet) {
        Student[] students = dataSet.getData();
        this.orderedList = Arrays.asList(students);
        createIdHashMap();
    }

    /** 
     * Constructor to create a GradeAnalyser object with a list of students.
     * @param studentResult array of Student objects
     */
    public GradeAnalyser(Student[] studentResult) {
        this.orderedList = Arrays.asList(studentResult);
        createIdHashMap();
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
        // Check if the input is empty
        if (lowerMark.isEmpty() || upperMark.isEmpty()) {
            return new RangeValidation(false, null, "Please enter both lower and upper marks.");
        }
        // Check if the input is a number
        int lower = Integer.parseInt(lowerMark);
        int upper = Integer.parseInt(upperMark);
        if (lower < 0 || upper < 0) {
            return new RangeValidation(false, null, "Marks cannot be negative.");
        }
        // Check if the input is a valid number
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
        // Create a new list to store the students within the range
        ArrayList<Student> result = new ArrayList<Student>();
        // Iterate through the ordered list of students and check if their total marks are within the range
        for (int i = 0; i < orderedList.size(); i++) {
            Student student = orderedList.get(i);
            int tot = student.total();
            // if the total marks are within the range, add the student to the result list
            if (tot >= lowerMark && tot <= upperMark) {
                result.add(student);
            }
        }
        // Convert the result list to an array and return it
        return result.toArray(new Student[0]);
    }

    
    /** 
     * This method is used to get the median mark of the students.
     * @return double the median mark of the students
     * @throws EmptyListException if the list of students is empty
     */
    public double medianMark() throws EmptyListException {
        // Check if the studentHashMap is empty
        if (studentHashMap.isEmpty()) {
            throw new EmptyListException("No students available.");
        }
        // Create a list of students from the studentHashMap values
        ArrayList<Student> list = new ArrayList<>(studentHashMap.values());
        int[] marks = new int[list.size()];
        // Fill the marks array with the total marks of each student
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
        // Check if the studentHashMap is empty
        if (studentHashMap.isEmpty()) {
            throw new EmptyListException("No students available.");
        }

        double total = 0;
        // Create a list of students from the studentHashMap values
        ArrayList<Student> list = new ArrayList<>(studentHashMap.values());
        // Iterate through the list of students and calculate the total marks
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            total = total + student.total();
        }
        // Calculate the average by dividing the total marks by the number of students
        return total / list.size();
    }

    
    /** 
     * This method is used to get the maximum mark of the students.
     * @return int the maximum mark of the students
     * @throws EmptyListException if the list of students is empty
     */
    public int Maximum() throws EmptyListException {
        // Check if the studentHashMap is empty
        if (studentHashMap.isEmpty()) {
            throw new EmptyListException("No students available.");
        }
    
        // Create a list of students from the studentHashMap values
        ArrayList<Student> list = new ArrayList<>(studentHashMap.values());
        int max = list.get(0).total(); // Set to first value to avoid using Integer.MIN_VALUE
    
        // Iterate through the list of students and find the maximum mark
        for (int i = 1; i < list.size(); i++) {
            int mark = list.get(i).total();
            if (mark > max) {
                max = mark;
            }
        }
        // Return the maximum mark
        return max;
    }

    
    /** 
     * This method is used to get the minimum mark of the students.
     * @return int the minimum mark of the students
     * @throws EmptyListException if the list of students is empty
     */
    public int Minimum() throws EmptyListException {
        // Check if the studentHashMap is empty
        if (studentHashMap.isEmpty()) {
            throw new EmptyListException("No students available.");
        }
    
        // Create a list of students from the studentHashMap values
        ArrayList<Student> list = new ArrayList<>(studentHashMap.values());
        int min = list.get(0).total();
    
        // Iterate through the list of students and find the minimum mark
        for (int i = 1; i < list.size(); i++) {
            int mark = list.get(i).total();
            if (mark < min) {
                min = mark;
            }
        }
        // Return the minimum mark
        return min;
    }

    /**
     * This method is used to create a hash map of student IDs.
     */
    private void createIdHashMap() {
        // Create a hash map to store student IDs and their corresponding Student objects
        studentHashMap = new HashMap<>();
        // Iterate through the ordered list of students and add them to the hash map
        for (int i = 0; i < orderedList.size(); i++) {
            Student student = orderedList.get(i);
            studentHashMap.put(student.id().toUpperCase(), student);
        }
    }

}