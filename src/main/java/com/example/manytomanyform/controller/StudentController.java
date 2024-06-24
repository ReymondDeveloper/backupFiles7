package com.example.manytomanyform.controller;

import com.example.manytomanyform.model.dto.StudentDTO;
import com.example.manytomanyform.model.form.StudentForm;
import com.example.manytomanyform.model.mapper.CourseMapper;
import com.example.manytomanyform.service.CourseService;
import com.example.manytomanyform.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    final StudentService studentService;

    @Autowired
    final CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public List<StudentDTO> list(){
        return studentService.list();
    }



    @PostMapping("/")
    public ResponseEntity<StudentDTO> create (@RequestBody StudentForm studentForm){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName(studentForm.getStudentName());
        studentDTO.setEmail(studentForm.getEmail());

        var courses = courseService.getCoursesByIds(studentForm.getCourse())
                .stream()
                .map(CourseMapper::fromDTO)
                .collect(Collectors.toSet());

        studentDTO.setCourses(courses);

        StudentDTO st =studentService.create(studentDTO);
        if(st != null){
            System.out.println("Created Successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            System.out.println("Error Request Handling");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDTO> update (@PathVariable Long studentId, @RequestBody StudentForm studentForm){
        StudentDTO studentDTO = studentService.getByID(studentId);
        if(studentDTO != null){

            studentDTO.setStudentName(studentForm.getStudentName());
            studentDTO.setEmail(studentForm.getEmail());

            var course = courseService.getCoursesByIds(studentForm.getCourse())
                            .stream()
                            .map(CourseMapper::fromDTO)
                            .collect(Collectors.toSet());
            studentDTO.setCourses(course);

            StudentDTO updateDTO = studentService.update(studentDTO);
            if(updateDTO != null) {
                System.out.println("Successfully Updated");
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else{
                System.out.println("Error Updating");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }else{
            System.out.println(studentId + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{studentId}")
    public StudentForm getById (@PathVariable Long studentId){
        StudentDTO studentDTO = studentService.getByID(studentId);
        if(studentDTO != null){
            StudentForm studentForm = new StudentForm();
            studentForm.setStudentName(studentDTO.getStudentName());
            studentForm.setEmail(studentDTO.getEmail());

            return studentForm;
        }else{
            return null;
        }
    }



    @DeleteMapping("/studentId")
    void delete (Long studentId){
        StudentDTO studentDTO = studentService.getByID(studentId);
        if(studentDTO != null){
            studentService.getByID(studentId);
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Id " + studentId + " not Found");
        }
    }










}
