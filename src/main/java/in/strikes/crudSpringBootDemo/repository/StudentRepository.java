package in.strikes.crudSpringBootDemo.repository;

import in.strikes.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByIsDeletedFalse();

    Optional<Student> findByIdAndIsDeletedFalse(Long id);
}