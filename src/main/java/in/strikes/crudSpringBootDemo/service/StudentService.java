package in.strikes.crudSpringBootDemo.service;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    //1 . End pt to listen (/api/students POST)
    public Student createStudent(Student studentRequest) {
        studentRequest.setDeleted(false);
        Student studentResponse = studentRepository.save(studentRequest);

        return studentResponse;

    }

    //get one
    public Student getStudent(Long id) {

        Optional<Student> studnentResp = studentRepository. findByIdAndDeletedIsFalse(id);

        if (studnentResp.isPresent()) {
            return studnentResp.get();
        } else {
            return null;
        }

    }

    //get all
    public List<Student> getallStudents() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList;
    }

    //update 1
    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> studnentExists = studentRepository.findByIdAndDeletedIsFalse(id);

        if (!studnentExists.isPresent()) {
            return null;
        } else {
            Student studentForUpdate = studnentExists.get();
            studentForUpdate.setName(studentReq.getName());

            studentForUpdate.setSubject(studentReq.getSubject());

            studentForUpdate.setRoll_no(studentReq.getRoll_no());

            studentForUpdate.setAge(studentReq.getAge());

            studentForUpdate.setEmail(studentReq.getEmail());
            studentForUpdate.setDeleted(false);
            return studentRepository.save(studentForUpdate);
        }

    }

    //delete method
    public boolean deleteeStudent(Long id) {
        boolean isStudent = studentRepository.existsById(id);
        if (!isStudent) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }

    //soft delete
    public boolean deleteStudentStudentSoftly(Long id)
    {  Optional<Student>existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(!existingStudent.isPresent())
        {
            return false;
        }
        //get
        Student studentToSave = existingStudent.get();
        //update
        studentToSave.setDeleted(true);
        //save
        studentRepository.save(studentToSave);
        return true;
    }


}
