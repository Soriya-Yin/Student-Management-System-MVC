package mapper;

import lombok.Builder;
import model.dto.*;
import entities.Student;


public class StudentMapper {

    public Student fromStudentRequestDto(StudentRequestDto requestDto) {
        return new Student(
                requestDto.fullName(),
                Student.Gender.valueOf(requestDto.gender().toUpperCase()),
                requestDto.dateOfBirth()
        );
    }
    public StudentResponseDto toStudentResponse(Student student) {
        return StudentResponseDto.builder()
                .id(student.getId())
                .fullName(student.getFullName())
                .gender(student.getGender().toString())
                .dateOfBirth(student.getDateOfBirth())
                .build();
    }

    public Student toStudentUpdateDto(Long id,StudentUpdateDto updateDto) {
        Student student = new Student(
                updateDto.fullName(),
                Student.Gender.valueOf(updateDto.gender().toUpperCase()),
                updateDto.dateOfBirth()
        );
        return student;
    }

    public Student fromStudentUpdate(Long id, StudentUpdateDto updateDto){
        Student student = new Student(
                updateDto.fullName(),
                Student.Gender.valueOf(updateDto.gender().toUpperCase()),
                updateDto.dateOfBirth()
        );
        return student;

    }
}
