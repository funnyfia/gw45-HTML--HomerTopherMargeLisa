//IMPORTANT: THE CLASS NAME DOES NOT CORRESPOND TO FILE NAME
/*
  Specs:
  create class SparseBoundedGrid that uses a "sparse array" implementation
  Solution doesn't need to be a generic class, you may simply use
  ***occupants**** of type Object.
  
  The sparse array is an array of Linked Lists!
  Each linked list entry holds both a grid occupant and a column index
  Each entry in the array list is a linked list or is null of that row is empty

  From the two choices given, I chose to implement the 1st one (with the raw
  list nodes)

  For a grid with r rows and c columns, sparse array has length r and each
  linked list has a maximum length c.
  r = length of sparse array (note to self: NOT arraylist)
  c = MAX length of linked list
  
  Needs to have all methods in the Grid interface:
  E get(Location loc) done
  int getNumCols() done
  int getNumRows() done
  ArrayList<Location> getOccupiedLocations() done
  boolean isValid(Location loc) done
  E remove (Location loc) done(?) I think, I did not test this method...

 */
import info.gridworld.grid.*;
import java.util.*;

public class SparseBoundedGrid<E> extends AbstractGrid<E>{
    
    private SparseGridNode[] nodeArray;
    int cols, rows; 
    
    public SparseBoundedGrid(int r, int c) {
	if (r <= 0 || c <= 0) 
	    throw new IndexOutOfBoundsException("Either the given column or given row is not valid");	
	rows = r; //length of nodeArray (which stores the Nodes)
	cols = c; //MAX length of each LinkedList stored in nodeArray
	nodeArray = new SparseGridNode[rows];
    }
    
    public E get(Location loc) {
	//First thing to do: check if the locus is valid~
	//If invalid, throw exception
	if (!isValid(loc))
	    throw new IndexOutOfBoundsException("The given locus is not valid");
	SparseGridNode temp = nodeArray[loc.getRow()]; //getRow() rather than column because positions in nodeArray are indicated by variable rows
	while(!(temp == null)) {
	    if(loc.getCol() == temp.getColumn()) 
		return (E) temp.getOccupant();// because I declared the other class as Object...
	    temp = temp.getNext(); //remember to increment! I almost forgot T.T
	}
    }
    
    public int getNumRows() {
	return rows;
    }

    public int getNumCols() {
	return cols;
    }
    
    public ArrayList<Location> getOccupiedLocations() {
	ArrayList<Location> allLoci = new ArrayList<Location>();

	//Will go through all of the linkedLists in the nodeArray
	for(int r = 0; r < getNumRows(); r++) {

	    SparseGridNode temp = nodeArray[r]; //keeps track of current Node we're looking at
	    while(temp != null) {
		Location loc = new Location(r, temp.getColumn());
		allLoci.add(loc); //will add the locus to the arrayList to be returned at the end
		temp = temp.getNext();
	    }
	}
	//since we went through all the rows & their corresponding columns, we got all the appropriate loci.
	return allLoci;
    }

    public boolean isValid(Location loc) {
	/* in order to be valid, the location must have a position greater
	   than or equal to 0 for both row and col and must be less than
	   the total length
	 */
	if( loc.getRow() < 0 || loc.getRow() >= getNumRows() || loc.getCol() < 0
	    || loc.getCol >= getNumCols()) 
	    return false;
	else
	    return true;
    
    }
    
    public E remove(Location loc) {
	
	//if it's not a valid location to remove, throw an exception:
	if(!isValid(loc))
	    throw new IndexOutOfBoundsException("The location provided is invalid");
	
	E theOccupant = get(loc); 
	SparseGridNode temp = nodeArray[loc.getRow()];
	
	//because these are nodes, we have to remove the extra link
	//will use my code from LList to model my removal
	
	if(temp != null) {
	    if(temp.getColumn() == loc.getCol() )
		nodeArray[loc.getRow()] = temp.getNext();
	    else {
		SparseGridNode nextLinkFinder = temp.getNext();
		while(nextLinkFinder.getColumn() != loc.getCol()) {
		    nextLinkFinder = nextLinkFinder.getNext();
		    temp = temp.getNext();
		}
		if (nextLinkFinder != null) //because if the nextLinkFinder is null, then you're at the end of the list and there won't be a next object
		    temp.setNext(nextLinkFinder.getNext());

	    }
	}
	return theOccupant;
    }
    

}