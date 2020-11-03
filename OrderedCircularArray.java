/**
 * Class outlines the characteristics and actions that can be performed on an ordered list
 * @author Hemming
 *
 * @param <T> Generic Type
 */
public class OrderedCircularArray<T> implements SortedListADT<T> {
private CellData[] list;
private int front;
private int rear;
private int count;

/**
 * Constructor of class initializes instance variables and creates a list of CellData objects
 */
public OrderedCircularArray() {
	front = 1;
	rear = 0;
	count = 0;
	list = new CellData[5];
}
/**
 * Method inserts an object of type CellData into the list with a specified id and associated value
 * @param id User's specified identifier of type generic
 * @param value User's desired value to be stored in object CellData
 */
public void insert(T id, int value) {
	boolean indicator = true;
	boolean indicator2 = true;
	if (list.length-1 == size() || front == list.length-1) {
		increaseArraySize();
	}
	if (isEmpty()) {
		CellData first = new CellData(id,value);
		list[front] = first;
		indicator2 = false;
	}
	for (int i = 0; i < list.length ; i++) {
		if (list[i] != null && indicator2) {
		if (value > list[i].getValue() && (list[i+1] == null || value < list[i+1].getValue())) {
			for (int k = size()+(front-1); k >= i+1; k--) {
				list[k+1] = list[k];
			}
			CellData newCell = new CellData(id,value);
			list[i+1] = newCell;
			indicator = false;
			break;
		}
		}
	}
	if (indicator && indicator2) {
		for (int j = size(); j > 0; j--) {
			list[j+1] = list[j];
		}
		CellData newCell2 = new CellData(id,value);
		list[front] = newCell2;
	}
	
	rear++;
	count++;
}
/**
 * Method returns value stored at a user specified id
 * @param id User's specified identifier
 * @return list[i].getValue() The value at that given CellData object
 */
public int getValue(T id) throws InvalidDataItemException {
	for (int i=0; i < size() ; i++) {
		if (list[i] != null) {
		if (list[i].getId().equals(id)) {
			return list[i].getValue();
		}
		}
	}
	throw new InvalidDataItemException("Sorry there is not an item in the list with this id");
}

/**
 * Method removes CellData object at a user specified id
 * @param id User's specified identifier
 */
public void remove(T id) throws InvalidDataItemException {
	boolean indicator = true;
	if (size() != 0) {
	for (int i=0; i < list.length ; i++) {
		if(list[i] != null) {
		if (list[i].getId().equals(id)) {			
			for (int k = i; k < (size()+(front - 1)); k++) {
				list[k] = list[k+1];
			}
			break;
		}
		}
	}
	if (size() == 1) {
		list[size()] = null;
	}
	list[size()+1] = null;
	count--;
	indicator = false;
	rear--;
	
	if(indicator) {
		throw new InvalidDataItemException("Sorry there is not an item in the list with this id");
	}
	}
	else {
		throw new InvalidDataItemException("Sorry the list is empty");
	}
}

/**
 * Method changes the value at a given identifier to a new user specified value
 * @param id User's specified id
 * @param newValue User's specified value
 */
public void changeValue(T id, int newValue) throws InvalidDataItemException {
	try {
		remove(id);
		insert(id, newValue);
	}
	catch(InvalidDataItemException e) {
		throw new InvalidDataItemException("Sorry there is not an item in the list with this id");
	}
}

/**
 * Method removes and returns the CellData object with the smallest associated value
 * @return id The id of the CellData object with the smallest associated value
 */
public T getSmallest() throws EmptyListException {
	if (isEmpty()) {
		throw new EmptyListException("Sorry the list is empty");
	}
	T id = (T) list[front].getId();
	remove(id);
	front++;
	for (int i = size(); i >= 1; i--) {
		list[i+1] = list[i];
	}
	rear++;
	list[front-1] = null;
	return id;
}

/**
 * Method determines if the list is empty
 * @return true The list is empty
 * @return false The list is not empty
 */
public boolean isEmpty() {
	if (count == 0) {
		return true;
	}
	return false;
}

/**
 * Method returns the number of CellData objects in the list
 * @return count The number of CellData objects in the list
 */
public int size() {
	return count;
}

/**
 * Method returns the index of the identifier with the smallest associated value (the one at the front of the list)
 * @return front The index of the leading entry in the list
 */
public int getFront() {
	return front;
}

/**
 * Method returns the index of the identifier with the largest associated value (the one at the end of the list)
 * @return rear The index of the last entry in the list
 */
public int getRear() {
	return rear;
}

/**
 * Helper Method that increases the size of the array
 */
private void increaseArraySize() {
	CellData[] Larger_list = new CellData[list.length * 2];
	for (int i = 0 ; i < list.length ; i++) {
		Larger_list[i] = list[i];
	}
	list = Larger_list;
}
}

