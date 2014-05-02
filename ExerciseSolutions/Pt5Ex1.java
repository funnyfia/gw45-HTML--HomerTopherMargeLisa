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
  E get(Location loc)
  int getNumCols()
  int getNumRows()
  ArrayList<Location> getOccupiedLocations()
  boolean isValid(Location loc)
  E remove (Location loc)

 */
import info.gridworld.grid.*;
import java.util.*;

public class SparseBoundedGrid extends AbstractGrid{

    

    public SparseBoundedGrid(int r, int c) {
	if (r <= 0 || c <= 0) 
	    throw new IndexOutOfBoundsException();
	
    }
    
    
    

}