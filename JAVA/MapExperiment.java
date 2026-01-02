import java.awt.*;

import jds.Map;
import jds.util.IntegerCompare;
import jds.util.TaskTimer;
import jds.util.Reporter;
import jds.util.GraphMaker;
import jds.collection.*;

class MapTester1 extends TaskTimer {

	public MapTester1 (Reporter rep) { super(rep); }

	private Map map;

	public void initialize (int n) {
		map = new MapAdapter(new SortedVector(), new IntegerCompare());
		for (int i = 0; i < n; i++) {
			Integer val = new Integer((int) (10 * n * Math.random()));
			map.set(val, val);
		}
	}

	public void doTask (int n) {
		int j = 0;
		for (int i = 0; i < n; i++) {
			Integer val = new Integer((int) (10 * n * Math.random()));
			if (map.containsKey(val)) map.removeKey(val);
		}
	}
}

class MapTester2 extends TaskTimer {

	public MapTester2 (Reporter rep) { super(rep);
	}

	private Map map;

	public void initialize (int n) {
		map = new MapAdapter(new SkipList(), new IntegerCompare());
		for (int i = 0; i < n; i++) {
			Integer val = new Integer((int) (10 * n * Math.random()));
			map.set(val, val);
		}
	}

	public void doTask (int n) {
		int j = 0;
		for (int i = 0; i < n; i++) {
			Integer val = new Integer((int) (10 * n * Math.random()));
			if (map.containsKey(val)) map.removeKey(val);
		}
	}
}

public class MapExperiment extends Frame {

	public static void main (String [ ] args) {
		MapExperiment world = new MapExperiment(); world.show(); world.run(); }

	public MapExperiment () {
		setTitle("Map Experiment 2");
		setSize(500, 300);
		add("Center", graph);
	}

	private GraphMaker graph = new GraphMaker(10000, 2500);

	public void run () {
		MapTester1 t1 = new MapTester1(graph.getReporter("SortedVector"));
		t1.run(0, 6500, 200);
		MapTester2 t2 = new MapTester2(graph.getReporter("SkipList"));
		t2.run(0, 9000, 200);
	}
}

