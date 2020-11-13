package partC;
import partA.*;
import java.util.Scanner;


public class DNAPalindrome {
  public static void main(String[] args) 
  {

	Scanner scan = new Scanner(System.in);
	StringDoubleEndedQueueImpl<DNAbase> queue;
	
	while(true) //this loop is used in order for the program to run as long as the user wants to
	{	
		queue = new StringDoubleEndedQueueImpl<DNAbase>();
		System.out.println("\nGive a DNA Sequence");
		System.out.println("Press 0 to quit\n");
		String dnaMol = scan.nextLine();
		
		if (dnaMol.equals("0"))
			break;
		
		try
		{
			for (int i = 0; i < dnaMol.length() ;i++) //turning the seqeuence into a list 
			{
				DNAbase tempMol = new DNAbase(dnaMol.charAt(i));
				queue.addLast(tempMol);
				
			}
			
			boolean idk = isWatsonCrickPalindrome(queue);

			if (idk == true)
				System.out.println("\nThis sequence is a Watson-Crick complemented palindrome");
			else
				System.out.println("\nThis sequence is not a Watson-Crick complemented palindrome");


		}

		catch (NotValidDNASequenceException e)
		{
			System.err.println(e.toString());
		}


	}

	scan.close();
  }


  static boolean isWatsonCrickPalindrome(StringDoubleEndedQueueImpl<DNAbase> list)
  {
	  boolean flag = true;
      DoubleDirectionNode <DNAbase> k = list.getFirstNode();
	  DoubleDirectionNode <DNAbase> j = list.getLastNode();
	
	  while (k != list.getLastNode() && flag == true)
	  {

		  	if (k.getContent().getName() != j.getContent().getOpposite() )
				flag = false;
			
			k = k.getNext();
			j = j.getPrevious();
	  }

	  return flag;
  }
}