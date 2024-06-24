package com.example.manytomanyform.model.mapper;

import com.example.manytomanyform.model.dto.StudentDTO;
import com.example.manytomanyform.model.entity.Student;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StudentMapper {

    public StudentDTO toDTO (Student student){
        return StudentDTO.builder()
                .id(student.getId())
                .studentName(student.getStudentName())
                .email(student.getEmail())
                .courses(student.getCourses())
                .build();
    }

    public Student fromDTO (StudentDTO studentDTO){
        final Student student = new Student();
        student.setId(studentDTO.getId());
        student.setStudentName(studentDTO.getStudentName());
        student.setEmail(studentDTO.getEmail());
        student.setCourses(studentDTO.getCourses());
        return student;
    }


}
