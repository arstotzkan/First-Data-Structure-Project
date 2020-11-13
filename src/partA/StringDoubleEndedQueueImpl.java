package partA;
import java.io.PrintStream;
import java.util.NoSuchElementException;
//generic class
public class StringDoubleEndedQueueImpl<T> implements StringDoubleEndedQueue<T>
{
	
	private DoubleDirectionNode<T> firstItem;
	private DoubleDirectionNode<T> lastItem;
	private int length;
	
	//constructors 
	public StringDoubleEndedQueueImpl()
	{
		//creates an empty queue
		length = 0;
	}

	public StringDoubleEndedQueueImpl(DoubleDirectionNode<T> node)
	{
		//creates a queue with 1 item
		this.firstItem = node;
		this.lastItem = node; 
		length = 1;
	}

	public StringDoubleEndedQueueImpl(DoubleDirectionNode<T> node1, DoubleDirectionNode<T> node2)
	{
		//creates a queue with 2 items
		this.firstItem = node1;
		this.lastItem = node2;
		length = 2;
		
	}
	
	//methods
	
	public boolean isEmpty()
	{
		if (size() == 0)
			return true;
		else 
			return false;
	}
	
	public void addFirst(T item)
	{
		/*
		adds an item to the end of the queue
		*/

		DoubleDirectionNode<T> tempNode = new DoubleDirectionNode<T>(item);

		if (length != 0)
		{
			tempNode.setNext(this.firstItem);
			firstItem.setPrevious(tempNode);
			this.firstItem = tempNode;
		}

		else
		{
			firstItem = tempNode;
			lastItem = tempNode;
		}

		length++;
	}
	
	public T removeFirst() throws NoSuchElementException
	{
		/*
		removes the first node of the queue
		the second node becomes the first
		*/
		if (isEmpty())
			throw new NoSuchElementException();
		else
		{
			DoubleDirectionNode<T> fst = firstItem;
			this.firstItem.getNext().setPrevious(null);
			this.firstItem = firstItem.getNext();
			fst.setNext(null);
			length--;
			return fst.getContent();
		}
	}
	
	public void addLast(T item)
	{
		/*
		 adds an item to the end of the queue
		 */
		DoubleDirectionNode<T> tempNode = new DoubleDirectionNode<T>(item);

		if (length != 0)
		{
			
			tempNode.setPrevious(this.lastItem);
			lastItem.setNext(tempNode);
			this.lastItem = tempNode;
			
		}

		else
		{
            firstItem = tempNode;
			lastItem = tempNode;
		}

		length++;
	}   
	
	public T removeLast() throws NoSuchElementException
	{
		/*
		removes the final node of the queue
		the second-to-last node becomes the last
		*/
		if (isEmpty())
			throw new NoSuchElementException();
		else
		{
			DoubleDirectionNode<T> lst = lastItem;
			lastItem.getPrevious().setNext(null);
			lastItem = lastItem.getPrevious();
			lst.setNext(null);
			length--;
			return lst.getContent();
		}
	}
	
	public T getFirst()
	{
		/*finds the content of the first node
		 */
		return this.firstItem.getContent();
	}

	public DoubleDirectionNode<T> getFirstNode()
	{	/*
		finds the first node of the queue
		*/
		return this.firstItem;
	}
	
	public T getLast()
	{
		/*
		finds the content of the last node
		*/
		return this.lastItem.getContent();
	}

	public DoubleDirectionNode<T> getLastNode()
	{
		/*
		finds the last node of the queue
		*/
		return this.lastItem;
	}
	
	public void printQueue(PrintStream stream)
	{	
		/*
		prints the queue's items, one at a time
		*/
		DoubleDirectionNode<T> temp = this.firstItem;
		while (temp != null)
		{
			stream.println(temp.getContent());
			temp = temp.getNext();
		}
	}
	
	public int size()
	{
		/*
		returns the queue's length
		*/
		return this.length;
	}
	
}