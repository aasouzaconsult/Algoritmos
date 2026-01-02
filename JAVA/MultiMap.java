import java.util.Enumeration;
import jds.Map;
import jds.collection.MapAdapter;
import jds.collection.LinkedList;
import jds.collection.SkipList;
import java.util.Comparator;
import jds.util.DefaultComparator;

public class MultiMap implements Map {
	private MapAdapter data;

	MultiMap () {
		data = new MapAdapter(new LinkedList());
		}

	MultiMap (Comparator c) {
		data = new MapAdapter(new SkipList(new DefaultComparator()), c);
		}

	public boolean isEmpty () { return size() == 0; }

	public int size () {
		int count = 0;
		for (Enumeration e = data.elements(); e.hasMoreElements(); ) {
			Object k = e.nextElement();
			Enumeration f = (Enumeration) get(k);
			while (f.hasMoreElements()) {
				count++;
				f.nextElement();
			}
		}
		return count;
	}

	public Enumeration elements () { return data.elements(); }

	public boolean containsKey (Object key) 
		{ return data.containsKey(key); }

	public boolean contains (Object key, Object value) {
		if (data.containsKey(key)) {
			LinkedList ldata = (LinkedList) data.get(key);
			return ldata.containsElement(value);
		}
		return false;
	}

	public Object get (Object key) {
		LinkedList e = (LinkedList) data.get(key);
		return e.elements();
	}

	public void removeKey (Object key) { data.removeKey(key); }

	public void set (Object key, Object value) {
		if (data.containsKey(key)) {
			LinkedList ldata = (LinkedList) data.get(key);
			ldata.addElement(value);
		} else {
			LinkedList ldata = new LinkedList();
			ldata.addElement(value);
			data.set(key, ldata);
		}
	}

	public void remove (Object key, Object value) {
		LinkedList ldata = (LinkedList) data.get(key);
		ldata.removeElement(value);
	}
}
