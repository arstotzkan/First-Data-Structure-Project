package partC;

public class DNAbase
{
	private char name;
	private char opposite;

	//constructor
	public DNAbase(char x) throws NotValidDNASequenceException
	{
		this.name = x;
		switch(this.name)
		{
		//if the user's input is different from A,C,G,T the exception is thrown
			case 65:
				this.opposite = 84;
				break;
			case 67:
				this.opposite = 71;
				break;
			case 71:
				this.opposite = 67;
				break;
			case 84:
				this.opposite = 65;
				break;
			default:
				throw new NotValidDNASequenceException("Not a Valid Sequence");

		}
	}

	//methods
	public String toString()
	{
		return String.valueOf(this.name);
	}

    public char getName()
    {
        return this.name;
    }

    public char getOpposite()
    {
        return this.opposite;
    }
}