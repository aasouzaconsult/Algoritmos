import jds.FindMin;
import jds.collection.Heap;
import jds.util.DefaultComparator;

public class SimulationFramework {

	public void scheduleEvent (Event newEvent) 
		{ eventQueue.addElement(newEvent); }
	
	public void run () {
		while (! eventQueue.isEmpty()) {
			Event nextEvent = (Event) eventQueue.getFirst();
			eventQueue.removeFirst();
			currentTime = nextEvent.time;
			nextEvent.processEvent();
		}
	}

	public int time () { return currentTime; }

	private int currentTime = 0;
	private FindMin eventQueue = new Heap(new DefaultComparator());
}

