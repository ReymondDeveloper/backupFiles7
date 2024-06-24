package com.example.manytomanyform.model.form;

import jakarta.persistence.NamedEntityGraph;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseForm {

    private String courseName;
    private int room;
    private List<Integer> students;
}
