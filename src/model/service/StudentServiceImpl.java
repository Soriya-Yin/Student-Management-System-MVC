package model.service;

import entities.Student;
import exception.StudentException;
import mapper.StudentMapper;
import model.dao.StudentDao;
import model.dto.StudentRequestDto;
import model.dto.StudentResponseDto;
import model.dto.StudentUpdateDto;

import java.time.LocalDate;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDao dao;
    private final StudentMapper mapper;

    public StudentServiceImpl(StudentDao dao , StudentMapper mapper) {
        this.dao= dao;
        this.mapper = mapper;
    }

    @Override
    public StudentResponseDto createStudent(StudentRequestDto requestDto) {

        if(requestDto.dateOfBirth().isAfter(LocalDate.now().minusYears(4))){
            throw new StudentException("Invalid date of birth");
        }

        Student student  = mapper.fromStudentRequestDto(requestDto);

        Student saveStudent =  dao.save(student);

        return mapper.toStudentResponse(saveStudent);
    }

    @Override
    public List<StudentResponseDto> getAllStudents(int offset ,int limit) {
        return dao.getAll().stream()
                .limit(limit)
                .skip(offset)
                .map(mapper::toStudentResponse)
                .toList();
    }

    @Override
    public boolean deleteById(Long id) {
        return dao.removeById(id);
    }

    @Override
    public StudentResponseDto updateById(Long id, StudentUpdateDto updateDto) {

        if (!dao.FindById(id)) {
            throw new StudentException("Student id " + id + " is not in list");
        }

        Student student = mapper.fromStudentUpdate(id, updateDto);

        Student updatedStudent = dao.save(student);

        return mapper.toStudentResponse(updatedStudent);
    }

    @Override
    public int updatePageNumber(int pagenumber, int totalPage) {

        if (pagenumber < 1){

            return 1;
        }
        if (pagenumber > totalPage) {

            return totalPage;

        }
        return pagenumber;
    }

}
