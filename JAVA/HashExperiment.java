import java.awt.*;

import jds.Indexed;
import jds.util.IntegerCompare;
import jds.util.TaskTimer;
import jds.util.Reporter;
import jds.util.GraphMaker;
import jds.collection.IndexedDeque;
import jds.collection.Vector;
import jds.collection.SkipList;
import jds.collection.LinkedList;
import jds.collection.Hashtable;

class SetInsert extends TaskTimer {

	public SetInsert (Reporter rep) {
		super(rep);
	}

	public void initialize (int n) {
		sk = new SkipList(new IntegerCompare());
	}

	SkipList sk;

	public void doTask (int n) {
		for (int i = 0; i < n; i++) {
			sk.addElement(new Integer(
				(int)(1000 * Math.random())));
			}
	}
}

class Set4Insert extends TaskTimer {

	public Set4Insert (Reporter rep) {
		super(rep);
	}

	public void initialize (int n) {
		sk = new LinkedList();
	}

	LinkedList sk;

	public void doTask (int n) {
		for (int i = 0; i < n; i++) {
			sk.addElement(new Integer(
				(int) (1000 * Math.random())));
			}
	}
}

class Set2Insert extends TaskTimer {

	public Set2Insert (Reporter rep) 
		{ super(rep); }

	public void initialize (int n) {
		sk = new Hashtable(37);
	}

	Hashtable sk;

	public void doTask (int n) {
		for (int i = 0; i < n; i++) {
			sk.addElement(new Integer(
				(int) (1000 * Math.random())));
			}
	}
}

class Set3Insert extends TaskTimer {

	public Set3Insert (Reporter rep) 
		{ super(rep); }

	public void initialize (int n) {
		sk = new Hashtable(37, new IntegerCompare());
	}

	Hashtable sk;

	public void doTask (int n) {
		for (int i = 0; i < n; i++) {
			sk.addElement(new Integer(
				(int) (1000 * Math.random())));
			}
	}
}

public class HashExperiment extends Frame {

	public static void main (String [ ] args) {
		HashExperiment world = new HashExperiment();
	}

	public HashExperiment () {
		setTitle("Hashtable Insertion Experiment");
		setSize(500, 300);
		GraphMaker graph = new GraphMaker(10000, 2500);
		add("Center", graph);
		show();

		Set4Insert t4 = new Set4Insert(graph.getReporter("List"));
		t4.run(200, 10000, 200);
		SetInsert t1 = new SetInsert(graph.getReporter("Skip"));
		t1.run(200, 10000, 200);
		Set2Insert t2 = new Set2Insert(graph.getReporter("Hashtable"));
		t2.run(200, 10000, 200);
		Set3Insert t3 = new Set3Insert(graph.getReporter("Sorted Hashtable"));
		t3.run(200, 10000, 200);
	}
}

