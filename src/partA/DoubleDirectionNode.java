package partA;

public class DoubleDirectionNode<T>
{
	private DoubleDirectionNode<T> previous;
	private DoubleDirectionNode<T> next;
	private T content;
	
	//constructors
	
	public DoubleDirectionNode(T item)
	{
		//creates a node not linked to any other nodes
		content = item; 
		previous = null;
		next = null;
	}
	
	public DoubleDirectionNode(T item, DoubleDirectionNode<T> pr, DoubleDirectionNode<T> n )
	{
		//creates a node between pr and n 
		content = item;
		previous = pr;
		next = n;
	}
	
	public T getContent()
	{
		return this.content;
	} 

	public DoubleDirectionNode<T> getPrevious()
	{
		return this.previous;
	}

	public DoubleDirectionNode<T> getNext()
	{
		return this.next;
	}

	public void setPrevious(DoubleDirectionNode<T> pr)
	{
		this.previous = pr;
	}

	public void setNext(DoubleDirectionNode<T> nx)
	{
		this.next = nx;
	}
	
	public void setContent(T item)
	{
		//not really used at all, but why should a job be left half done?
		this.content = item;
	}
}
