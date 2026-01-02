import java.util.Enumeration;
import jds.Map;
import jds.FindMin;
import jds.collection.MapAdapter;
import jds.collection.LinkedList;
import jds.collection.SkewHeap;
import jds.util.Comparable;
import jds.util.DefaultComparator;

class WVertex {
		// constructors
	WVertex () { edges = new MapAdapter(new LinkedList()); }
	WVertex (Object n) { name = n; edges = new MapAdapter(new LinkedList()); }

		// data fields 
	public Object name = null;
	protected Map edges;

		// operations 
	public void addEdge (WVertex v, int w) { edges.set (v, new Integer(w)); }
	public String toString () { return name.toString(); }

	public Map dijkstra () { 
		Map distances = new MapAdapter(new LinkedList());
			// initialize queue with outself
		FindMin que = new SkewHeap(new DefaultComparator());
		que.addElement (new Distance(this, 0));
			// pull elements from queue one by one
		while (! que.isEmpty()) {
			Distance top = (Distance) que.getFirst();
			que.removeFirst();
			WVertex newcity = top.destination;
			if (! distances.containsKey(newcity)) {
				distances.set(newcity, new Integer(top.distance));
				Enumeration e = newcity.edges.elements();
				while (e.hasMoreElements()) {
					WVertex newCity = (WVertex) e.nextElement();
					Integer leg = (Integer) newcity.edges.get(newCity);
					que.addElement(new Distance(newCity,
						top.distance + leg.intValue()));
				}
			}
		}
		return distances;
	}

	private class Distance implements Comparable {
		Distance (WVertex to, int d) { destination = to; distance = d;}
		public WVertex destination;
		public int distance;

		public int compareTo (Object to) {
			Distance dto = (Distance) to;
			if (distance < dto.distance) return -1;
			if (distance == dto.distance) return 0;
			return 1;
		}
	}

	public static void main (String [ ] args) {

//	make the initial vertices
WVertex pendleton = new WVertex("pendleton");
WVertex pensacola = new WVertex("pensacola");
WVertex peoria = new WVertex("peoria");
WVertex phoenix = new WVertex("phoenix");
WVertex pierre = new WVertex("pierre");
WVertex pittsburgh = new WVertex("pittsburgh");
WVertex princeton = new WVertex("princeton");
WVertex pueblo = new WVertex("pueblo");

// create the initial links
pendleton.addEdge(phoenix, 4); pendleton.addEdge(pueblo, 8);
pensacola.addEdge(phoenix, 5);
peoria.addEdge(pittsburgh, 5); peoria.addEdge(pueblo, 3);
phoenix.addEdge(peoria, 4); phoenix.addEdge(pittsburgh, 10); phoenix.addEdge(pueblo, 3);
pierre.addEdge(pendleton, 2);
pittsburgh.addEdge(pensacola, 4);
princeton.addEdge(pittsburgh, 2);
pueblo.addEdge(pierre, 3);

	Map reachable = pierre.dijkstra();
	System.out.println("Cities reachable from Pierre");
	Enumeration e = reachable.elements();
	while (e.hasMoreElements()) {
		Object key = e.nextElement();
		Object value = reachable.get(key);
		System.out.println(key + " " + value);
		}
	}
}

