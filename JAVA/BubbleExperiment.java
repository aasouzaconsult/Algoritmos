import java.awt.*;

import jds.util.IntegerCompare;
import jds.util.TaskTimer;
import jds.util.Reporter;
import jds.util.GraphMaker;

class BubbleTime extends TaskTimer {
	BubbleTime (Reporter out) { super(out); }

	public void initialize(int n) {
		data = new double [n]; // create new array
		for (int i = 0; i < n; i++)
			data[i] = n * Math.random();
	}

	public void doTask (int n) {
		bubbleSort(data);
	}

	private double [ ] data;

private void bubbleSort (double [ ] v)
	// exchange the values in the vector v
	// so they appear in ascending order
{
	int n = v.length;
		// find the largest remaining value
		// and place into v[i]
	for (int i = n - 1; i > 0; i--) {

			// move large values to the top
		for (int j = 0; j < i; j++) {

				// if out of order
			if (v[j] > v[j+1]) {
					// then swap
				double temp = v[j];
				v[j] = v[j + 1];
				v[j + 1] = temp;
				}
			}
		}
}

}

class InsertionTime extends TaskTimer {
	InsertionTime (Reporter out) { super(out); }

	public void initialize(int n) {
		data = new double [n]; // create new array
		for (int i = 0; i < n; i++)
			data[i] = n * Math.random();
	}

	public void doTask (int n) {
		insertionSort(data);
	}

	private double [ ] data;

private void insertionSort (double [ ] v)
	// exchange the values in the vector v
	// so they appear in ascending order
{
	int n = v.length;
	for (int i = 1; i < n; i++) {

		// move element v[i] into place
		double element = v[i];
		int j = i - 1;
		while (j >= 0 && element < v[j]) {
				// slide old value up
			v[j+1] = v[j];
				// decrement j
			j = j - 1;
			}
		// place element into position
		v[j+1] = element;
		}
}
}

public class BubbleExperiment extends Frame {

	public static void main (String [ ] args) 
	{ BubbleExperiment world = new BubbleExperiment(); world.show(); world.run(); }

	public BubbleExperiment () {
		setTitle("Bubble Sort and Insertion Sort Comparison");
		setSize(500, 300);
		add("Center", graph);
	}

	private GraphMaker graph = new GraphMaker(5000, 3000);

	public void run () {
		BubbleTime t1 = new BubbleTime(graph.getReporter("Bubble"));
		t1.run(0,5000, 100);
		InsertionTime t2 = new InsertionTime(graph.getReporter("Insertion"));
		t2.run(0, 5000, 100);
	}
}
