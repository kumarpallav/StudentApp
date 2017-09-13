package com.example.student.StudentApp.bean;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long >{

}
