package com.example.manytomanyform.model.mapper;

import com.example.manytomanyform.model.dto.CourseDTO;
import com.example.manytomanyform.model.entity.Course;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseMapper {

    public Course fromDTO (CourseDTO courseDTO){
        final Course course = new Course();
        course.setId(courseDTO.getId());
        course.setCourseName(courseDTO.getCourseName());
        course.setRoom(courseDTO.getRoom());
        course.setStudents(courseDTO.getStudents());
        return course;
    }

    public CourseDTO toDTO (Course course){
        return CourseDTO.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .room(course.getRoom())
                .students(course.getStudents())
                .build();
    }



}
