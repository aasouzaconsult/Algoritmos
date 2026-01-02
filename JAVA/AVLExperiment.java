import java.awt.*;

import jds.Bag;
import jds.util.IntegerCompare;
import jds.util.TaskTimer;
import jds.util.Reporter;
import jds.util.GraphMaker;
import jds.collection.AVLTree;
import jds.collection.SkipList;
import jds.util.CloseQuit;

class ListInsert extends TaskTimer {

	public ListInsert (Reporter rep) { super(rep); }

	public void initialize (int n) {
		sk = new SkipList(new IntegerCompare());
	}

	Bag sk;

	public void doTask (int n) {
		for (int i = 0; i < n; i++) {
			sk.addElement(new Integer(i));
			}
	}
}

class TreeInsert extends TaskTimer {

	public TreeInsert (Reporter rep) { super(rep); }

	public void initialize (int n) {
		sk = new AVLTree(new IntegerCompare());
	}

	Bag sk;

	public void doTask (int n) {
		for (int i = 0; i < n; i++) {
			sk.addElement(new Integer(i));
			}
	}
}

public class AVLExperiment extends Frame {

	public static void main (String [ ] args) {
		AVLExperiment world = new AVLExperiment();
	}

	public AVLExperiment () {
		setTitle("AVL Tree Insertion Experiment");
		setSize(500, 300);
		GraphMaker graph = new GraphMaker(10000, 2500);
		add("Center", graph);
		addWindowListener(new CloseQuit());
		show();

		ListInsert t1 = new ListInsert(graph.getReporter("SkipList"));
		t1.run(200, 10000, 200);
		TreeInsert t2 = new TreeInsert(graph.getReporter("AVLTree"));
		t2.run(200, 10000, 200);
	}
}

