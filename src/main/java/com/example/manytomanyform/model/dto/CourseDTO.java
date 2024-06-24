package com.example.manytomanyform.model.dto;

import com.example.manytomanyform.model.entity.Course;
import com.example.manytomanyform.model.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseDTO {

    private long id;
    private String courseName;
    private int room;

    private Set<Student> students;
}
