package com.example.manytomanyform.model.form;

import jakarta.persistence.NamedEntityGraph;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentForm {

    private String studentName;
    private String email;
    private List<Long> course;

}
