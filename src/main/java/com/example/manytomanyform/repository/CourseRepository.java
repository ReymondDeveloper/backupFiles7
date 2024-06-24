package com.example.manytomanyform.repository;

import com.example.manytomanyform.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository <Course,Long> {
}
