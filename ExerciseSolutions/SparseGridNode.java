//So, the class I'll be instatiating an instance of SparseGridNode in
//doesn't require generics, and uses Objects instead, so I don't have to use
//generics here

public class SparseGridNode {
    private Object occupant;
    private int pos;
    private SparseGridNode next;

    public SparseGridNode(Object occupant, int pos, SparseGridNode next) {
	this.occupant = occupant;
	this.pos = pos;
	this.next = next;
    }

    //I modeled this class after the LLNode we wrote in class :)
    //Get methods:
    public Object getOccupant() {
	return occupant;
    }
    public int getPos() {
	return pos;
    }
    
    public SparseGridNode getNext() {
	return next;
    }
    
    //Set methods;
    public void setOccupant(Object occupant) {
	this.occupant = occupant;
    }
    
    public void setPos(int pos) {
	this.pos = pos;
    }
    
    public void setNext(SparseGridNode next) {
	this.next = next;
    }
}