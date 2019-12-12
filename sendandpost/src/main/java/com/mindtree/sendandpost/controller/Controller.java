package com.mindtree.sendandpost.controller;


	import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.sendandpost.entity.Student;
import com.mindtree.sendandpost.service.StudentService;

	@RestController
	public class Controller {
		
		@PostMapping("/sendData")
	 public void postmsg(@RequestBody Student student) {
		boolean isSent=false;
		isSent=StudentService.sendToService(student);
		 System.out.println("Added!!!"+isSent);
		 
	 }
		
		@GetMapping("/getdata")
		public ArrayList<Student> sendmsg() {
		ArrayList<Student> isGet=StudentService.getData();
		System.out.println("Added1!"+isGet);
		return isGet;
	}
        @PutMapping("/update/{id}")
    	 public boolean updateid(@PathVariable int id) {
    	 boolean isUpdated=StudentService.updateData(id);
    	 if(isUpdated==true) {
    		 System.out.println("Updated!!!!!!");
    	 }
    	 else
    	 {
    		 System.out.println("Not Updated");
    	 }
		return isUpdated;
     }
     @DeleteMapping("/delete/{id}/{name}")
       public boolean delete(@PathVariable int id,@PathVariable String name) {
		boolean isDelete=StudentService.deleteData(id,name);
    	 return isDelete;
    	 
     }
}