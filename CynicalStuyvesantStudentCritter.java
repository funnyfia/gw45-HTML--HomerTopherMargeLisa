/*A new type of Critter has appeared on the scene:
*CynicalStuyvesantStudentCritter Specs:

*The CynicalStuyvesantStudentCritter uses the inherited getActors() method,
*but it processes actors differently: it eats any neighbors that are also
*CynicalStuyvesantStudentCritters (in the hopes of eliminating any competition).
*To do so, the processActors() method is overwritten to make an exception for
*rocks and for every critter except the CynicalStuyvesantStudentCritter;
*other actors will be eaten. The CynicalStuyvesantStudentCritter is similar to
*the ChamelonCritter in that it overrides the makeMove() method: it faces the
*nearest TeacherCritter or AuthorityFigureCritter when moving.

*CynicalStuyvesantStudentCritter Test Cases:

*The getActors(), getMoveLocations(), and selectMoveLocations() methods will be
*inherited, so their behavior has been clearly documented in the documentation
*of the Critter class. The processActors() method will allow every actor except
*for a Rock or a Critter outside of a CynicalStuyvesantStudentCritter to be
*removed from the grid. The makeMove() method will be similar to the 
*ChamelonCritter's makeMove() method: it will set the location to the nearest
*TeacherCritter or AuthorityFigureCritter.
*/
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

import java.awt.Color;
import java.util.ArrayList;

public class CynicalStuyvesantStudentCritter extends Critter {

    public CynicalStuyvesantStudentCritter() {
	setColor(Color.GREEN);
    }

    public void processActors(ArrayList<Actor> actors) {
	for (Actor a : actors) {
	    if ((a instanceof Rock) || ((a instanceof Critter) && (!(a instanceof CynicalStuyvesantStudent)))) {
		a.removeSelfFromGrid();
	    }
	}
    }

    public void makeMove(Location loc) {
	setDirection(getLocation().getDirectionToward(loc));
	super.makeMove(loc);
    }
}
