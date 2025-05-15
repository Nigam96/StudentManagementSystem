package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentId; // s-01,s-23,s-123
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId) ) {
			this.age = age;
			this.name = name;
			this.studentId = studentId;
			courses = new ArrayList<>();
		}

	}

	public void enrollCourse(String course) {
		if(validCourseName(course)) {
			if (courses!=null & courses.contains(course) ) {
				System.err.println("Student is already enrolled to the course " + course);

			} else {
				courses.add(course);
				System.out.println("Student is enroll to " + course + " Successfully");
			}	
		}
		
	}

	public void printStudentInfo() {
		System.out.println("============== Student Information ==============");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Enrolled For:" + courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	// Validation Methods
	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid Age !!! Entered Age should be between 19 to 35");
			return false;
		}
	}

	public boolean validateName(String name) {
		// Nigam nigam NIGAM niGam
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name !!! Please enter alphabets only");
			return false;
		}

	}

	public boolean validateStudentId(String studentId) {
		String studentRegex = "S-[0-9]+$";
		Pattern studentPattern = Pattern.compile(studentRegex);
		Matcher studentIdMatcher = studentPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid ID !!! ... Use the format Eg ....S-123");
		}
		return false;
	}

	public boolean validCourseName(String course) {
		ArrayList<String> list = new ArrayList<>();
		list.add("DSA");
		list.add("Foundation");
		list.add("Selenium");
		list.add("Java");
		if (!list.contains(course)) {
			System.err.println(course+" is not a valid course !!! Please Enter Valid Course!!!  [DSA,Foundation,Selenium,Java]");
			return false;

		}
		return true;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

}
