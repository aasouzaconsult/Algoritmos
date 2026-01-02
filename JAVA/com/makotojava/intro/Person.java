package com.makotojava.intro;

import java.util.logging.Logger;

public class Person {
	public Person(String firstName, String lastName, int age, int height, int weight, String eyeColor, String gender) {
//		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.eyeColor = eyeColor;
		this.gender = gender;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String value) {
		this.firstName = value;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String value) {
		this.lastName = value;
	}
	
	public String getFullName() {
		return getFirstName().concat(" ").concat(getLastName());
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	// private String name;
	private String firstName;
	private String lastName;
	private int age;
	private int height;
	private int weight;
	private String eyeColor;
	private String gender;
}
