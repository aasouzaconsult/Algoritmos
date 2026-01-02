import java.util.Enumeration;
import java.io.*;
import jds.collection.LinkedList;

class NameList {
	NameList (String n) { name = n; }

	public final String name;
	public LinkedList list = new LinkedList();

	public void add (NameList newItem) {
		list.addElement(newItem);
	}

	public void print () {
		System.out.println("\t" + name);
		Enumeration e = list.elements();
		while (e.hasMoreElements()) {
			NameList nl = (NameList) e.nextElement();
			System.out.println("\t\t" + nl.name);
		}
	}
}

class ClassList {
	public static void main (String [ ] args) {
		try {
			LinkedList students = new LinkedList();
			LinkedList courses = new LinkedList();
				// step 1, read list of students and courses
				// add to lists
			FileReader fin = new FileReader(args[0]);
			BufferedReader in = new BufferedReader(fin);
			String studentName = in.readLine();
			while (studentName != null) {
				String courseName = in.readLine();
				NameList student = findEntry(students, studentName);
				NameList course = findEntry(courses, courseName);
				student.add(course);
				course.add(student);

				studentName = in.readLine();
			}
				// step 2, print the lists
			printList("students", students);
			printList("courses", courses);
		} catch (IOException e) {
			System.out.println("received IOException " + e);
		}

	}

	public static NameList findEntry(LinkedList list, String name) {
		Enumeration e = list.elements();
		while (e.hasMoreElements()) {
			NameList nl = (NameList) e.nextElement();
			if (name.equals(nl.name))
				return nl;
		}
			// not found, make it now
		NameList nl = new NameList(name);
		list.addElement(nl);
		return nl;
	}

	public static void printList(String heading, LinkedList list) {
		System.out.println(heading);
		Enumeration e = list.elements();
		while (e.hasMoreElements()) {
			NameList nl = (NameList) e.nextElement();
			nl.print();
		}
	}
}

