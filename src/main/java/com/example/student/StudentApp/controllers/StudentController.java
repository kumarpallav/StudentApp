package com.example.student.StudentApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.StudentApp.bean.Student;
import com.example.student.StudentApp.bean.StudentRepository;
class Message{
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
@RestController
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping(path="students", method=RequestMethod.GET)
	public List<Student>getStudents()
	{
		return studentRepository.findAll();
	}
	
	@RequestMapping(path="student",method={RequestMethod.POST} )
	public Message create(@RequestBody Student student)
	{
		Message m= new Message();
		studentRepository.save(student);
		
		m.setMsg("success");
		return m;
	}
	@RequestMapping(path="student",method=RequestMethod.PUT)
	public String updateStudent(@RequestBody Student student)
	{
		studentRepository.save(student);
		return "updated";
	}
	@RequestMapping(path="student/{id}",method=RequestMethod.DELETE)
	public Message deleteStudent(@PathVariable String  id)
	{
		Message m= new Message();
		studentRepository.delete(Long.parseLong(id));
		m.setMsg("deleted");
		return m;
	}

}
