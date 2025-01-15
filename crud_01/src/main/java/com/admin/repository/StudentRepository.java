package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.model.Student;

//that repository annotation add for that interface is directly connected to database

@Repository     
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
