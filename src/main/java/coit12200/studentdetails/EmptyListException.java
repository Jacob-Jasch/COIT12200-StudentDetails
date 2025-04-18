package coit12200.studentdetails;

/**
 * This class is a custom exception that is thrown when an operation is attempted on an empty list.
 */
public class EmptyListException extends RuntimeException{

    /**
     * Default constructor for EmptyListException.
     * @param message the message to be displayed when the exception is thrown
     */
    public EmptyListException(String message){
        super(message);
    } 
}
