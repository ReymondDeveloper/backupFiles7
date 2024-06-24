package com.example.manytomanyform.service;

import com.example.manytomanyform.model.dto.CourseDTO;
import com.example.manytomanyform.model.entity.Course;
import com.example.manytomanyform.model.mapper.CourseMapper;
import com.example.manytomanyform.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServicelmpl implements CourseService{

    @Autowired
    final CourseRepository courseRepository;

    public CourseServicelmpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> list() {
        return courseRepository.findAll()
                .stream()
                .map(CourseMapper::toDTO)
                .toList();
    }


    @Override
    public List<CourseDTO> getCoursesByIds(List<Long> ids) {
        return courseRepository.findAll()
                .stream()
                .map(CourseMapper::toDTO)
                .toList();
    }

    @Override
    public CourseDTO create(CourseDTO courseDTO) {
        Course course = CourseMapper.fromDTO(courseDTO);
        Course saveCourse = courseRepository.save(course);
        return CourseMapper.toDTO(saveCourse);
    }

    @Override
    public CourseDTO getById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            Course cr = course.get();
            return CourseMapper.toDTO(cr);
        }else{
            return null;
        }
    }

    @Override
    public CourseDTO update(CourseDTO courseDTO) {
        Optional<Course> course = courseRepository.findById(courseDTO.getId());
        if(course.isPresent()){
            Course cr = course.get();
            cr.setCourseName(courseDTO.getCourseName());
            cr.setRoom(courseDTO.getRoom());
            cr.setStudents(courseDTO.getStudents());
            return CourseMapper.toDTO(cr);
        }return null;
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
