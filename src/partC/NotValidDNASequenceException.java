package partC;

public class NotValidDNASequenceException extends Exception
{

	private static final long serialVersionUID = 1L;

	public NotValidDNASequenceException(String errorMessage)
	{
		super(errorMessage);
	}
}