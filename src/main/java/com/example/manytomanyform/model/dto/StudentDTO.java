package com.example.manytomanyform.model.dto;

import com.example.manytomanyform.model.entity.Course;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDTO {

    private long id;
    private String studentName;
    private String email;

    private Set<Course> courses;

}
