package partB;

public class NotValidPostfixException extends Exception
{
	/**
	 * Thrown when the user gives not give valid inout
	 */
	private static final long serialVersionUID = 2L;

	//created in case the user gives invalid input
    public NotValidPostfixException(String errorMessage)
    {
        super(errorMessage);
    }
}