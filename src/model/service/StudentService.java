package model.service;

import model.dto.StudentRequestDto;
import model.dto.StudentResponseDto;
import model.dto.StudentUpdateDto;

import java.util.List;

public interface StudentService {



    StudentResponseDto createStudent(StudentRequestDto studentRequestDto);

    List<StudentResponseDto> getAllStudents(int offset , int limit  );

    boolean deleteById(Long id);

    StudentResponseDto updateById(Long id, StudentUpdateDto student);

    int updatePageNumber(int pagenumber , int totalpage);
}
