import java.awt.*;

import jds.Indexed;
import jds.util.IntegerCompare;
import jds.util.TaskTimer;
import jds.util.Reporter;
import jds.util.GraphMaker;
import jds.collection.IndexedDeque;
import jds.collection.Vector;

class DequeTester extends TaskTimer {
	public DequeTester (Reporter rep, Indexed q) {
		super(rep);
		que = q;
		Object value = new Integer(42); 
		que.setSize(10);
		for (int i = 0; i < 10; i++)
			que.setElementAt(value, i);
	}

	private Indexed que;

	public void doTask (int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++)
				que.setElementAt(que.elementAt(5), j);
		}
	}
}

public class DequeExperiment extends Frame {

	public static void main (String [ ] args) {
		DequeExperiment world = new DequeExperiment();
	}

	public DequeExperiment () {
		setTitle("Deque Experiment testing Indexing ");
		setSize(500, 300);
		GraphMaker graph = new GraphMaker(10000, 500);
		add("Center", graph);
		show();

		DequeTester t1 = new DequeTester(graph.getReporter("Deque"), 
				new IndexedDeque());
		t1.run(0, 10000, 200);
		DequeTester t2 = new DequeTester(graph.getReporter("Vector"), 
				new Vector());
		t2.run(0, 10000, 200);
	}
}

