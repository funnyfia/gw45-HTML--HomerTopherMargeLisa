/*HTML--HomerTopherMargeLisa
APCS PD 9
HW35 -- GridWorld, Part 4
2014-05-02

class CynicalStuyvesantStudentCritter

BEACUASE: (P.S. I see what you did there with that youtube thing.)
BECAUSE WE ARE EXACTLY THAT!!! We arrived at Stuy fresh-faced and eager, but soon realized that this institution was no middle school cake walk. After being spoiled by easy grades and soft teachers in previous years, we quickly had to adapt or DIE. Now, a few years older, we watch each incoming class and laugh at them. We laugh hard, and we laugh cynically. We laugh as we watch friends turn on each other. We laugh as we watch young, rosy cheeks devole into sallow grey ones. And we also reflect. We reflect on how Stuyvesant has taught us nothing but cynicism and the art of scraping by. So CynicalStuyvesantStudentCritter perfectly embodies the horrors of our lives. We sincerely hope you do not enjoy this.

JK WE LOVE STUY!!!!! Seriously, this was all a joke. We hope you DO enjoy!

A new type of Critter has appeared on the scene:
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

ERRATA:
Just as Mr.Brown advised us, we added TeacherCritter, which this class called for interaction with. Not as hard as it looked!
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
