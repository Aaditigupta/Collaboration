package com.mindtree.sendandpost.service;

import java.util.ArrayList;

import com.mindtree.sendandpost.dao.StudentDao;
import com.mindtree.sendandpost.entity.Student;

public class StudentService {

static StudentDao sd=new StudentDao();
	public static boolean sendToService(Student student) {
		sd.sendDataToDao(student);
		return true;
	}
	public static ArrayList<Student> getData() {
		ArrayList<Student> studs=sd.getDataToService();
		// TODO Auto-generated method stub
		return studs;
	}
	public static boolean updateData(int id) {
		boolean isUpdated=false;
				isUpdated=sd.updateInDao(id);
		// TODO Auto-generated method stub
		return isUpdated;
	}
	public static boolean deleteData(int id,String name) {
        boolean isDeleted=false;
           isDeleted=sd.deleteInDao(id,name);
		return isDeleted;
	}

}
