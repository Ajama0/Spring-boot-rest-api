package com.example.demo.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email already exists");
        }
        studentRepository.save(student);

    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void DeleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("does not exist");
        }

        studentRepository.deleteById(studentId);

    }

    public void updateStudent(Long studentId, String studentName, String studentEmail) {
        Optional<Student>studentOptional =
                studentRepository.findById(studentId);

        if(studentOptional.isPresent()){

            Student student = studentOptional.get();

            student.setName(studentName);
            student.setEmail(studentEmail);

            studentRepository.save(student);
        }

        else{
            throw new IllegalStateException("the name and email doesnt exist");
        }
    }
}
