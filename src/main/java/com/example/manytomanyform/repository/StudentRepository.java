package com.example.manytomanyform.repository;

import com.example.manytomanyform.model.dto.StudentDTO;
import com.example.manytomanyform.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
