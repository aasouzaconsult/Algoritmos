import java.awt.*;

import jds.Indexed;
import jds.util.IntegerCompare;
import jds.util.TaskTimer;
import jds.util.Reporter;
import jds.util.GraphMaker;
import jds.collection.IndexedDeque;
import jds.collection.Vector;
import jds.collection.SortedVector;
import jds.sort.Partition;

class FindTester1 extends TaskTimer {
	Vector vec = null;

	public FindTester1 (Reporter rep) {
		super(rep);
	}

	public void initialize (int n) {
		vec = new Vector();
		vec.setSize(n);
		for (int i = 0; i < n; i++)
			vec.setElementAt(new Integer(
				(int)(1000 * Math.random())), i);
	}

	public void doTask (int n) {
		SortedVector v = new SortedVector(vec, new IntegerCompare());
		Object x = v.findNth(n/2); 
	}
}

class FindTester2 extends TaskTimer {
	Vector vec = null;

	public FindTester2 (Reporter rep) {
		super(rep);
	}

	public void initialize (int n) {
		vec = new Vector();
		vec.setSize(n);
		for (int i = 0; i < n; i++)
			vec.setElementAt(
				new Integer((int) (1000 * Math.random())), i);
	}

	public void doTask (int n) {
		Partition v = new Partition(vec, new IntegerCompare());
		Object x = v.findNth(n/2); 
	}
}

public class FindNExperiment extends Frame {

	public static void main (String [ ] args) {
		FindNExperiment world = new FindNExperiment();
	}

	public FindNExperiment () {
		setTitle("Find Nth Largest Experiment");
		setSize(500, 300);
		GraphMaker graph = new GraphMaker(10000, 2500);
		add("Center", graph);
		show();

		FindTester1 t1 = new FindTester1(graph.getReporter("SortedVector"));
		FindTester2 t2 = new FindTester2(graph.getReporter("Partition")); 
		t2.run(200, 9500, 200);
		t1.run(200, 9000, 200);
	}
}

