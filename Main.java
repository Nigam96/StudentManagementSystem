package com.studentapp;

import java.util.*;

public class Main {
	private static List<Student> studentList;
	private static Scanner sc;

	public static void main(String[] args) {
		System.out.println("********** Student Managment System **********");

		studentList = new ArrayList<>();

		sc = new Scanner(System.in);

		while (true) {
			System.out.println("******** Welcome ********");
			System.out.println("Select an Option....");
			System.out.println("1. Register a student");
			System.out.println("2. Find Student with StudentID");
			System.out.println("3. List All Student Information");
			System.out.println("4. List Student Information in Sorted Order");
			System.out.println("5. Exit");

			int option = sc.nextInt();

			switch (option) {
			case 1:
				enrollStudent(sc);
				break;
			case 2:
				findStudentById(sc);
				break;
			case 3:
				printAllstudentData();
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;

			default:
				System.out.println("Invalid Option Selected ... please Enter from the Number shown Above");

			}
		}
	}

	private static void exit() {
		System.out.println("*************** Thank you ***************");
		System.exit(0);
	}

	private static void printAllstudentData() {
		if (studentList.isEmpty()) {
			System.err.println("Student List is Empty !!! No Record Found");
		} else {
			for (Student student : studentList) {
				student.printStudentInfo();
			}
		}

	}

	private static void findStudentById(Scanner sc2) {
		Student studentFound = null; // Explicit Initialization
		System.out.println("Please Enter Student Id : ");
		String studentId = sc2.next();
		try {
			studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
					.findFirst().orElseThrow(() -> new RuntimeException("No Data Found!!!"));

			studentFound.printStudentInfo();
		} catch (RuntimeException e) {
			System.out.println("Student with ID : " + studentId + " Not Found");

		}

	}

	private static void enrollStudent(Scanner sc2) {

		System.out.println("Please Enter Student Name : ");
		String studentName = sc2.next();
		System.out.println("Please Enter Student Age : ");
		int studentAge = sc2.nextInt();
		System.out.println("Please Enter STudent Id : ");
		String studentid = sc2.next();
		Student student1 = new Student(studentName, studentAge, studentid);
		System.out.println("Student Enrolled Succssefully");
		studentList.add(student1);
		while (true) {
			System.out.println("Please Enter the courses you want to enroll....Type Done if you want to Exit");
			String course = sc2.next();
			if (course.equalsIgnoreCase("done")) {
				break;
			}
			student1.enrollCourse(course);
		}
//		student1.printStudentInfo();

	}

	private static void sortByName() {
//		Comparator<Student> studentNameComparator = new Comparator<Student>() {
//			@Override
//			public int compare(Student s1, Student s2) {
//				return s1.getName().compareTo(s2.getName());
//			}
//		};

		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(studentList, studentNameComparator);
		printAllstudentData();
	}

	public static Student searchStudentById(String studentId) {
		Student result = null; // Explicit Initialization
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found!!!"));

		} catch (RuntimeException e) {
			System.out.println("Student with ID : " + studentId + " Not Found");

		}
		return result;

	}
}
