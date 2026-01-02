import java.awt.*;

import jds.Bag;
import jds.util.IntegerCompare;
import jds.util.TaskTimer;
import jds.util.Reporter;
import jds.util.GraphMaker;
import jds.collection.BinarySearchTree;
import jds.collection.SkipList;
import jds.util.CloseQuit;


class ListInsert extends TaskTimer {

	public ListInsert (Reporter rep) {
		super(rep);
	}

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

	public TreeInsert (Reporter rep) 
		//{ super(200, 10000, 200, rep); }
		{ super(rep); }

	public void initialize (int n) {
		sk = new BinarySearchTree(new IntegerCompare());
	}

	Bag sk;

	public void doTask (int n) {
		for (int i = 0; i < n; i++) {
			sk.addElement(new Integer(i));
			}
	}
}

public class BSTreeExperiment extends Frame {

	public static void main (String [ ] args) {
		BSTreeExperiment world = new BSTreeExperiment();
	}

	public BSTreeExperiment () {
		setTitle("Binary Search Tree Insertion Experiment 2");
		setSize(500, 300);
		GraphMaker graph = new GraphMaker(10000, 2500);
		add("Center", graph);
		addWindowListener(new CloseQuit());
		show();

		ListInsert t1 = new ListInsert(graph.getReporter("SkipList"));
		t1.run(200, 10000, 200);
		TreeInsert t2 = new TreeInsert(graph.getReporter("BSTree"));
		t2.run(200, 1000, 50);
	}
}

