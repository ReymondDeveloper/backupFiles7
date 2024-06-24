package com.example.manytomanyform.service;

import com.example.manytomanyform.model.dto.CourseDTO;
import com.example.manytomanyform.model.dto.StudentDTO;
import com.example.manytomanyform.model.entity.Course;

import java.util.List;

public interface CourseService {

    public List<CourseDTO> list();

    public List<CourseDTO> getCoursesByIds(List<Long> ids);

    public CourseDTO create (CourseDTO courseDTO);
    public CourseDTO getById (Long id);
    public CourseDTO update (CourseDTO courseDTO);
    public void delete (Long id);

}
