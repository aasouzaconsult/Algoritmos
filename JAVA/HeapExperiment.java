import java.awt.*;

import jds.Indexed;
import jds.FindMin;
import jds.util.IntegerCompare;
import jds.util.TaskTimer;
import jds.util.Reporter;
import jds.util.GraphMaker;
import jds.collection.IndexedDeque;
import jds.collection.Heap;
import jds.collection.SkewHeap;
import jds.collection.Vector;

class HeapTester extends TaskTimer {
	private FindMin stk;

	public HeapTester (Reporter rep, FindMin s) {
		super(rep);
		stk = s;
	}

	public void doTask (int n) {
		for (int i = 0; i < n; i++) 
			stk.addElement(new Integer(
				(int)(100 * Math.random())));
		for (int i = 0; i < n; i++) 
			stk.removeFirst();
	}
}

public class HeapExperiment extends Frame {

	public static void main (String [ ] args) {
		HeapExperiment world = new HeapExperiment();
	}

	public HeapExperiment () {
		setTitle("Heap Comparison");
		setSize(500, 300);
		GraphMaker graph = new GraphMaker(10000, 2500);
		add("Center", graph);
		show();

		HeapTester t1 = new HeapTester(graph.getReporter("Heap"), 
				new Heap(new IntegerCompare()));
		t1.run(0, 10000, 200);
		HeapTester t2 = new HeapTester(graph.getReporter("Skew"), 
				new SkewHeap(new IntegerCompare()));
		t2.run(0, 10000, 200);
	}
}

