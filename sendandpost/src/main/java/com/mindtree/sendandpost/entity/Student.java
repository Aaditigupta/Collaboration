package com.mindtree.sendandpost.entity;

public class Student {
private int studentId;
private String studentName;
private  String studentSection;
public Student(int studentId, String studentName, String studentSection) {
	super();
	this.studentId = studentId;
	this.studentName = studentName;
	this.studentSection = studentSection;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentSection() {
	return studentSection;
}
public void setStudentSection(String studentSection) {
	this.studentSection = studentSection;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}



}
