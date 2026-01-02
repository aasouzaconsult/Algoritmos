import java.awt.*;
import jds.SortAlgorithm;
import jds.collection.Vector;
import jds.util.VisualVector;
import jds.util.IntegerCompare;
import jds.util.CloseQuit;
import jds.sort.MergeSort;
import jds.sort.*;

class VisualSort extends Frame {
	public static void main (String [ ] args) 
	{ VisualSort world = new VisualSort(); world.show(); world.run(); }

	VisualSort () {
			// set up application
		setTitle("Merge Sort Test");
		setSize(500, 300);

			// create visual panel
		add("Center", vv.getPanel());
		addWindowListener (new CloseQuit());
	}

	private Vector data = new Vector();
	private VisualVector vv = new VisualVector(data);

	private void run () {
			// create initial data
		for (int i = 0; i < 100; i++) {
			int d = (int) (100 * Math.random());
			data.addLast(new Integer(d));
			}

			// now sort
		SortAlgorithm hp = new MergeSort(new IntegerCompare());
		hp.sort(vv);
	}
}

