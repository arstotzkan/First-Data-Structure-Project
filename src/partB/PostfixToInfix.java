package partB;
import partA.*;

import java.util.Scanner;

class PostfixToInfix {
  public static void main(String[] args) 
  {
	StringDoubleEndedQueueImpl<String> queue = new StringDoubleEndedQueueImpl<String>();
	String input = "";
	Scanner scan = new Scanner(System.in);
	while (true) //this loop is used in order for the program to run as long as the user wants to 
	{
		//asking for input
		queue = new StringDoubleEndedQueueImpl<String>();
		System.out.println("\nGive a postfix sequence:");
		System.out.println("(Press 0 to quit)");
		input = scan.nextLine(); 
		
		//condition to kill the program
		if (input.equals("0"))
			break;
		
		//creating the queue
		for(int i = 0; i < input.length(); i++)
		{
			if (input.charAt(i) != 32)
				queue.addLast(String.valueOf(input.charAt(i)));		
		}
		try
		{
			isPostfix(queue);
			String output = toInfix(queue);
			System.out.println(output);
		}
		catch (NotValidPostfixException e)
		{
			System.err.println(e.toString());
		}
		
	}
	scan.close(); 
  }

  static void isPostfix(StringDoubleEndedQueueImpl<String> queue) throws NotValidPostfixException
  {	
	  /*
	   This methods checks whether a sequence is postfix or not
	   If it isn't an exception is thrown
	  */
	int numbers = 0;
	int operators = 0;

	DoubleDirectionNode<String> node = queue.getFirstNode();

	while (node != null )
	{
		String content = (String) node.getContent();
		char temp = content.charAt(0); //it's used in order to check if content is a digit in a more efficient way

		if (node.getContent().equals("-") || node.getContent().equals("+") || node.getContent().equals("*") || node.getContent().equals("/"))
		{
			operators++;
			if (node == queue.getFirstNode() ||node == queue.getFirstNode().getNext() ) //an operator can't be in the first two nodes of a postfix expression
			{	
				throw new NotValidPostfixException("This is not a valid postfix expression: operators were put too early");
			}
		}
		
		else if (temp > 47 && temp < 58 )
			numbers++;

		else //other symbols
        	throw new NotValidPostfixException("This is not a valid postfix expression: it includes characters that arent operators or one digit numbers");


		node = node.getNext();
	}	


	if (numbers != operators + 1) //otherwise there would be too many or too few operators
		throw new NotValidPostfixException("This is not a valid postfix expression: there are too many or too few operators");
	

  }

  public static boolean isDigit(DoubleDirectionNode<String> node)
  {
    boolean flag = true;
    if (node.getContent().equals("+") || node.getContent().equals("-")|| node.getContent().equals("*") || node.getContent().equals("/"))
    {
    	//seperating digits from operators
       flag = false;
    }
    return flag;
  }

  public static String toInfix(StringDoubleEndedQueueImpl<String> queue)
  {
	if (queue.size() == 1) //if the expression is just a digit
		return queue.getFirst();
    
	String infixExpression = "";
	StringDoubleEndedQueueImpl<String> digitQueue = new StringDoubleEndedQueueImpl<String>();
	DoubleDirectionNode<String> node = queue.getFirstNode();
	while (node != null)
	{
		if (isDigit(node))
		{
			digitQueue.addFirst(node.getContent());
		}
		else //if it is an operator
		{
			if (digitQueue.size() > 1)
			{
				String dig1 = digitQueue.getFirst();
				digitQueue.removeFirst();
				String dig2 = digitQueue.getFirst();

				if (digitQueue.size() != 1) //
					digitQueue.removeFirst();

				infixExpression  =  "(" + dig2 + node.getContent() + dig1 + ")";
				digitQueue.addFirst(infixExpression);
			}
		}
		node = node.getNext();
	}
	
	return infixExpression;
		
  } 
}


