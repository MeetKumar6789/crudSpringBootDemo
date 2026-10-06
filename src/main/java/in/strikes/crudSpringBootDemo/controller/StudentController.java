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

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    //create student
    @PostMapping("/create")
    public ResponseEntity<Student> CreateStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    //read ONE student
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam long id) {
        Student studentResp = studentService.getStudent(id);
        if (studentResp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);
    }


    //getALL students
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getallStudent() {
        List<Student> studentList = studentService.getallStudents();
        if (studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }


    //update student 1
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam long id, @RequestBody Student studentReq) {
        Student studentResp = studentService.updateStudent(id, studentReq);
        if (studentResp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);
    }

    //delete student
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam long id) {
        Boolean isDeleted = studentService.deleteeStudent(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("< - Record Has Been Deleted From DataBase - > ");

    }

    //softDelete
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam long id)
    { boolean isDeleted = studentService.deleteStudentStudentSoftly(id);
        if(!isDeleted)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted ");

    }
}
