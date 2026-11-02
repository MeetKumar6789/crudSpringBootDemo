package in.strikes.crudSpringBootDemo.controller;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE STUDENT
    @PostMapping("/create")
    public ResponseEntity<Student> CreateStudent(
            @RequestBody Student student) {

        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    // READ ONE STUDENT
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(
            @PathVariable long id) {

        Student studentResp = studentService.getStudent(id);

        if (studentResp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);
    }

    // GET ALL ACTIVE STUDENTS
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getallStudent() {

        List<Student> studentList = studentService.getallStudents();

        return ResponseEntity.ok(studentList);
    }

    // UPDATE STUDENT
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable long id,
            @RequestBody Student studentReq) {

        Student studentResp = studentService.updateStudent(id, studentReq);

        if (studentResp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);
    }

    // SOFT DELETE STUDENT
    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<Student> softDeleteStudent(
            @PathVariable long id) {

        Student studentResp = studentService.softDeleteStudent(id);

        if (studentResp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }

    // HARD DELETE STUDENT
    @DeleteMapping("/permanent-delete/{id}")
    public ResponseEntity<Void> hardDeleteStudent(
            @PathVariable long id) {

        boolean deleted = studentService.hardDeleteStudent(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}