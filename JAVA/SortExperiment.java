import java.awt.*;


import jds.SortAlgorithm;
import jds.Indexed;
import jds.util.IntegerCompare;
import jds.util.TaskTimer;
import jds.util.Reporter;
import jds.util.GraphMaker;
import jds.collection.Vector;
import jds.collection.SkipList;
import jds.sort.MergeSort;
import jds.sort.ShellSort;
import jds.sort.Partition;

class SortTest extends TaskTimer {

	public SortTest (Reporter rep, SortAlgorithm alg, int m) {
		super(rep);
		sorter = alg;
		data = new Vector();
	}

	public void initialize (int n) {
		data.setSize(n);
		for (int i = 0; i < n; i++) {
			int d = (int) ( n * Math.random());
			data.setElementAt(new Integer(d), i);
		}
	}

	SortAlgorithm sorter;
	Indexed data;

	public void doTask (int n) {
		sorter.sort(data);
	}
}

public class SortExperiment extends Frame {

	public static void main (String [ ] args) {
		SortExperiment world = new SortExperiment();
	}

	public SortExperiment () {
		setTitle("Quick Sort Experiment");
		setSize(500, 300);
		GraphMaker graph = new GraphMaker(10000, 3000);
		add("Center", graph);
		show();

		SortTest t1 = new SortTest(graph.getReporter("Merge"),
			new MergeSort(new IntegerCompare()), 10000);
		t1.run(100, 10000, 200);
		SortTest t2 = new SortTest(graph.getReporter("Shell"),
			new ShellSort(new IntegerCompare()),
			10000);
		t2.run(100, 10000, 200);
		SortTest t3 = new SortTest(graph.getReporter("Quick"),
			new Partition(new IntegerCompare()), 10000);
		t3.run(100, 10000, 200);
	}
}

