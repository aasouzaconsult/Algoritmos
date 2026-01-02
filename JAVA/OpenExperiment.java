import java.awt.*;

import jds.Indexed;
import jds.util.IntegerCompare;
import jds.util.TaskTimer;
import jds.util.Reporter;
import jds.util.GraphMaker;
import jds.collection.IndexedDeque;
import jds.collection.Vector;
import jds.collection.SkipList;
import jds.collection.OpenHashtable;

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
				(int) (n * Math.random())));
			}
	}
}

class Set2Insert extends TaskTimer {

	public Set2Insert (Reporter rep) 
		{ super(rep); }

	public void initialize (int n) {
		sk = new OpenHashtable(n + 13);
	}

	OpenHashtable sk;

	public void doTask (int n) {
		for (int i = 0; i < n; i++) {
			sk.addElement(new Integer(
				(int) (n * Math.random())));
			}
	}
}

class Set3Insert extends TaskTimer {

	public Set3Insert (Reporter rep) 
		{ super(rep); }

	public void initialize (int n) {
		sk = new OpenHashtable(n + 13);
	}

	OpenHashtable sk;

	public void doTask (int n) {
		for (int i = 0; i < n; i++) {
			sk.addElement(new Integer(
				(int) ((n/2) * Math.random())));
			}
	}
}

public class OpenExperiment extends Frame {

	public static void main (String [ ] args) {
		OpenExperiment world = new OpenExperiment();
	}

	public OpenExperiment () {
		setTitle("Open Addressing Hashtable Insertion Experiment");
		setSize(500, 300);
		GraphMaker graph = new GraphMaker(10000, 2500);
		add("Center", graph);
		show();

		SetInsert t1 = new SetInsert(graph.getReporter("Skip"));
		t1.run(200, 10000, 200);
		Set2Insert t2 = new Set2Insert(graph.getReporter("Hashtable"));
		t2.run(200, 9500, 200);
		Set3Insert t3 = new Set3Insert(graph.getReporter("Half Hashtable"));
		t3.run(200, 7000, 200);
	}
}

