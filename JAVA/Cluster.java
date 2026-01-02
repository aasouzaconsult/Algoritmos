import java.awt.*;

import jds.util.VisualVector;
import jds.collection.Vector;
import jds.collection.OpenHashtable;

class Cluster extends Frame {
	public static void main (String [ ] args) {
		Cluster world = new Cluster();
		world.show();
	}

	Vector v = new Vector();

	Cluster () {
		setSize(500, 300); setTitle("Open Hash Table Clustering");
		v.setSize(200);
		OpenHashtable hash = new OpenHashtable(v);
		for (int i = 0; i < 130; i++)
			hash.addElement(new Integer(217 + (int) (500 * Math.random())));

		for (int i = 0; i < 200; i++)
			if (v.elementAt(i) == null) {
				v.setElementAt(new Integer(0), i);
				}

		VisualVector vv = new VisualVector(v);
		add("Center", vv.getPanel());
	}
}

