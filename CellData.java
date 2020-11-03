/**
 * Class outlines the characteristics of a cell with an identifier and contained data
 * @author Hemming
 *
 * @param <T> Generic type
 */
public class CellData<T> {
	private T id;
	private int value;
	
/**
 * Constructor creates cell object initialized with an given object of type generic as an identifier and a specified value
 * @param theld User's desired identifier for cell
 * @param theValue Specified value
 */
	
public CellData(T theld, int theValue) {
	id = theld;
	value = theValue;
}

/**
 * Method returns the value stored in the object type CellData
 * @return value The stored value
 */

public int getValue() {
	return value;
}

/**
 * Method returns identifier of the object type CellData
 * @return id the object being used to identify the CellData object
 */

public T getId() {
	return id;
}

/**
 * Method sets object at a user specified id to a specified value
 * @param newValue User's specified value
 */

public void setValue(int newValue) {
	value = newValue;
}

/**
 * Method sets object's identifier to specified object of type generic
 * @param newId User's specified identifier object
 */

public void setId(T newId) {
	id = newId;
}

}
