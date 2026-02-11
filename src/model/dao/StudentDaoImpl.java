package model.dao;

import db.StudentDb;
import entities.Student;
import model.dto.StudentRequestDto;

import java.util.List;
import java.util.Locale;

public class StudentDaoImpl implements StudentDao {

    private final StudentDb studentDb;

    public StudentDaoImpl(StudentDb studentDb) {
        this.studentDb = studentDb;
    }

    @Override
    public Student save(Student student) {
        studentDb.getStudentsList().add(student);
        return student;
    }

    @Override
    public List<Student> getAll() {
        return studentDb.getStudentsList();
    }

    @Override
    public boolean removeById(Long id) {
        return studentDb.getStudentsList()
                .removeIf(student -> student.getId().equals(id));
    }

    @Override
    public Student updateById(Long id, StudentRequestDto student) {
        for (int i = 0; i<studentDb.getStudentsList().size(); i++){
            if (studentDb.getStudentsList().get(i).getId().equals(id)){
                studentDb.getStudentsList().get(i).setId(id);
                studentDb.getStudentsList().get(i).setFullName(student.fullName());
                studentDb.getStudentsList().get(i).setGender(Student.Gender.valueOf(student.gender().toUpperCase(Locale.ROOT)));

                studentDb.getStudentsList().get(i).setDateOfBirth(student.dateOfBirth());
                return studentDb.getStudentsList().get(i);

            }
        }
        return null;
    }

//    @Override
//    public Student updateById(Long id, StudentRequestDto student) {
//        for(int i =0;i < studentDb.getStudentsList().size();i++){
//            if(studentDb.getStudentsList().get(i).getId().equals(id)){
//                studentDb.getStudentsList().get(i).setId(id);
//                studentDb.getStudentsList().get(i).setFullName(student.getFullName());
//                studentDb.getStudentsList().get(i).setGender(student.getGender());
//                studentDb.getStudentsList().get(i).setDateOfBirth(student.getDateOfBirth());
//                return studentDb.getStudentsList().get(i);
//            }
//        }
//        return null;
//    }

}
