package model.dao;

import entities.Student;
import model.dto.StudentRequestDto;

import java.util.List;

public interface StudentDao {

    Student save(Student student);

    List<Student> getAll();

    boolean removeById(Long id);

    Student updateById(Long id, StudentRequestDto student);

    boolean FindById(Long id);


//    Student UpdateById(Long id, StudentRequestDto student);
}
