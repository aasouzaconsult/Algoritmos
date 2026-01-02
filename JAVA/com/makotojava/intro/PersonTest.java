package com.makotojava.intro;

import java.util.logging.Logger;
import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void testPerson() {
		Person p = new Person("Gary", "Hou", 42, 173, 82, "Black", "MALE");
		Logger l = Logger.getLogger(Person.class.getName());
		l.info("Name: " + p.getFullName());
		l.info("Age:" + p.getAge());
		l.info("Height(cm):" + p.getHeight());
		l.info("Weight(kg):" + p.getWeight());
		l.info("Eye Color:" + p.getEyeColor());
		l.info("Gender:" + p.getGender());
		assertEquals("Gary Hou", p.getFullName());
		assertEquals(42, p.getAge());
		assertEquals(173, p.getHeight());
		assertEquals(82, p.getWeight());
		assertEquals("Brown", p.getEyeColor());
		assertEquals("MALE", p.getGender());
	}
	
	@Test
	public void testGetFirstName() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetFirstName() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetLastName() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetLastName() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetFullName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAge() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAge() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEyeColor() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEyeColor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGender() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetGender() {
		fail("Not yet implemented");
	}

}
