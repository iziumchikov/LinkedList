package List;

public class ListArrayBased implements ListInterface {
	
	private static final int MAX_LIST = 50;
	private Object items[];
	private int numItems;
	
	public ListArrayBased() {
		items = new Object[MAX_LIST];
		numItems = 0;
	}

	public boolean isEmpty() {
		return(numItems == 0);
	}
	
	public int size() {
		return numItems;
	}
	
	public void removeAll() {
		items = new Object[MAX_LIST];
		numItems = 0;
	}
	
	public void add(int index, Object item) 
			throws ListIndexOutOfBoundsException 
	{
		if (numItems > MAX_LIST) {
			throw new ListException("ListException on add");
		}
		
		if(index >= 0 && index <= numItems) {
			for (int pos = numItems; pos >= index; pos--) {
				items[pos+1] = item;
			}
			items[index] = item;
			numItems++;
		}
		
		else {
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on add");
		}
	}
	
	public Object get(int index) 
					  throws ListIndexOutOfBoundsException 
	{
		if (index >= 0 && index < numItems) {
			return items[index];
		}
		
		else {
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on get");
		}
	}
	
	public void remove(int index) 
					   throws ListIndexOutOfBoundsException 
	{
		if (index >= 0 && index < numItems) {
			for (int pos = index + 1; pos <= size(); pos++) {
				items[pos-1] = items[pos];
			}
			numItems--;
		}
		
		else {
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on remove");
		}
	}
}
