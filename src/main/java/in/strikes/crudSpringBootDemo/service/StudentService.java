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

        Student studentResponse = studentRepository.save(studentRequest);

        return studentResponse;

    }
    //get one
    public Student getStudent(long id)
    {
        Optional<Student> studnentResp= studentRepository.findById(id);

        if(studnentResp.isPresent())
        {
            return studnentResp.get();
        }
        else {return null;}

    }
    //get all
    public List<Student> getallStudents()
    {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    //update 1
    public Student updateStudent(long id , Student studentReq)
    {
        Optional<Student> studnentExists= studentRepository.findById(id);

        if(!studnentExists.isPresent())
        {
            return null;
        }
        else
        {
            Student studentForUpdate = studnentExists.get();
            studentForUpdate.setName(studentReq.getName());

            studentForUpdate.setSubject(studentReq.getSubject());

            studentForUpdate.setRoll_no(studentReq.getRoll_no());

            studentForUpdate.setAge(studentReq.getAge());

            studentForUpdate.setEmail(studentReq.getEmail());

            return studentRepository.save(studentForUpdate);
        }

    }


    //2.  Business logic -> json -> db

    //3.  interact with db

    //4.  response back to client
}
