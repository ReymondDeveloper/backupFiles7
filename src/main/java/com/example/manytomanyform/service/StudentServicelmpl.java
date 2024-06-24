package com.example.manytomanyform.service;

import com.example.manytomanyform.model.dto.StudentDTO;
import com.example.manytomanyform.model.entity.Student;
import com.example.manytomanyform.model.mapper.StudentMapper;
import com.example.manytomanyform.repository.StudentRepository;
import com.sun.security.auth.UnixNumericUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServicelmpl implements StudentService{

    @Autowired
     StudentRepository studentRepository;

    public StudentServicelmpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDTO> list() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::toDTO)
                .toList();
    }

    @Override
    public List<StudentDTO> getStudentsByIds(List<Long> ids) {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::toDTO)
                .toList();
    }

    @Override
    public StudentDTO create(StudentDTO studentDTO) {
        Student student = StudentMapper.fromDTO(studentDTO);
        Student saveEntity = studentRepository.save(student);
        return StudentMapper.toDTO(saveEntity);
    }

    @Override
    public StudentDTO getByID(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            Student st = student.get();
            return StudentMapper.toDTO(st);
        }else{
            return null;
        }

     }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        Optional<Student> student = studentRepository.findById(studentDTO.getId());
        if (student.isPresent()) {
            Student st = student.get();
            st.setStudentName(studentDTO.getStudentName());
            st.setEmail(studentDTO.getEmail());
            st.setCourses(studentDTO.getCourses());
            Student updateStudent = studentRepository.save(st);

            return StudentMapper.toDTO(updateStudent);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
