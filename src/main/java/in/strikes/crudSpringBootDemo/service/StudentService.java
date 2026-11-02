package in.strikes.crudSpringBootDemo.service;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE STUDENT
    public Student createStudent(Student student) {
        student.setDeleted(false);
        return studentRepository.save(student);
    }

    // GET ONE ACTIVE STUDENT
    public Student getStudent(long id) {
        return studentRepository.findByIdAndIsDeletedFalse(id)
                .orElse(null);
    }

    // GET ALL ACTIVE STUDENTS
    public List<Student> getallStudents() {
        return studentRepository.findByIsDeletedFalse();
    }

    // UPDATE STUDENT
    public Student updateStudent(long id, Student studentReq) {

        Student student = studentRepository
                .findByIdAndIsDeletedFalse(id)
                .orElse(null);

        if (student == null) {
            return null;
        }

        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());

        return studentRepository.save(student);
    }

    // SOFT DELETE STUDENT
    public Student softDeleteStudent(long id) {

        Student student = studentRepository
                .findByIdAndIsDeletedFalse(id)
                .orElse(null);

        if (student == null) {
            return null;
        }

        student.setDeleted(true);

        return studentRepository.save(student);
    }

    // HARD DELETE STUDENT
    public boolean hardDeleteStudent(long id) {

        if (!studentRepository.existsById(id)) {
            return false;
        }

        studentRepository.deleteById(id);

        return true;
    }
}