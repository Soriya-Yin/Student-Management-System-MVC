package model.dto;

import entities.Student;
import lombok.*;

import java.time.LocalDate;


public record StudentRequestDto (
        String fullName,
        String gender,
        LocalDate dateOfBirth
        )
{

    public String getFullName() {
    return this.fullName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getGender() {
    return this.gender;}
}
