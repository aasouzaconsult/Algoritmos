import java.awt.*;

import jds.Indexed;
import jds.util.IntegerCompare;
import jds.util.TaskTimer;
import jds.util.Reporter;
import jds.util.GraphMaker;
import jds.collection.IndexedDeque;
import jds.collection.Vector;
import jds.collection.SortedVector;
import jds.collection.SortedList;

class MergeTester extends TaskTimer {
	SortedList list1 = null;
	SortedList list2 = null;

	public MergeTester (Reporter rep) {
		super(rep);
	}

	public void initialize (int n) {
		list1 = new SortedList(new IntegerCompare());
		list2 = new SortedList(new IntegerCompare());
		for (int i = 0; i < n; i++) {
			list1.addElement(new Integer(
				(int)(1000 * Math.random())));
			list2.addElement(new Integer(
				(int)(1000 * Math.random())));
		}
	}

	public void doTask (int n) {
		list1.unionWith(list2);
		list1.intersectWith(list2);
	}
}

class MergeTester2 extends TaskTimer {
	SortedVector list1 = null;
	SortedVector list2 = null;

	public MergeTester2 (Reporter rep) {
		super(rep);
	}

	public void initialize (int n) {
		list1 = new SortedVector(new IntegerCompare());
		list2 = new SortedVector(new IntegerCompare());
		for (int i = 0; i < n; i++) {
			list1.addElement(new Integer(
				(int)(1000 * Math.random())));
			list2.addElement(new Integer(
				(int)(1000 * Math.random())));
		}
	}

	public void doTask (int n) {
		list1.unionWith(list2);
		list1.intersectWith(list2);
	}
}

public class MergeExperiment extends Frame {

	public static void main (String [ ] args) {
		MergeExperiment world = new MergeExperiment();
	}

	public MergeExperiment () {
		setTitle("Union/Intersection Exepriment");
		setSize(500, 300);
		GraphMaker graph = new GraphMaker(10000, 500);
		add("Center", graph);
		show();

		MergeTester t1 = new MergeTester(graph.getReporter("OrdList"));
		MergeTester2 t2 = new MergeTester2(graph.getReporter("OrdVec"));
		t1.run(200, 10000, 500);
		t2.run(200, 10000, 500);
	}
}

