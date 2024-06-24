package com.example.manytomanyform.service;

import com.example.manytomanyform.model.dto.StudentDTO;
import com.example.manytomanyform.model.entity.Student;

import java.util.List;

public interface StudentService {

      public List<StudentDTO> list ();
     public List<StudentDTO> getStudentsByIds(List<Long> ids);


      public StudentDTO create (StudentDTO studentDTO);

      public StudentDTO getByID (Long id);

      public StudentDTO update (StudentDTO studentDTO);
      void deleteById  (Long id);
}
