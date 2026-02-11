package db;

import entities.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDb {
    private final List<Student> studentsList;

    public StudentDb(){
        studentsList = new ArrayList<>(){{
            add(new Student( "Kapik Cha",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("Mju Kreung",Student.Gender.FEMALE, LocalDate.now().minusYears(20)));
            add(new Student("Shngor Jrouk",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("Spei Juu",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("Seang Brai",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("Skor Tangmea",Student.Gender.FEMALE, LocalDate.now().minusYears(20)));
            add(new Student("Svay Tram",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("Cha Kvai",Student.Gender.FEMALE, LocalDate.now().minusYears(20)));
            add(new Student("Morn Dot",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("Jek Jean",Student.Gender.FEMALE, LocalDate.now().minusYears(20)));
            add(new Student("Morn Ang",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("Trey Jean",Student.Gender.FEMALE, LocalDate.now().minusYears(20)));
            add(new Student("Ko Dot",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("Jek Sngor",Student.Gender.FEMALE, LocalDate.now().minusYears(20)));
            add(new Student("Pongtea Brai",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("Khor ko",Student.Gender.FEMALE, LocalDate.now().minusYears(20)));
            add(new Student("Somlor Kiri",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("ChaKdav Morn",Student.Gender.FEMALE, LocalDate.now().minusYears(20)));
            add(new Student("Pong Khrouch",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("Numpang Pate",Student.Gender.FEMALE, LocalDate.now().minusYears(20)));
            add(new Student("Jek Namva",Student.Gender.MALE, LocalDate.now().minusYears(20)));
            add(new Student("Jruk Prolit",Student.Gender.FEMALE, LocalDate.now().minusYears(20)));
        }};
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }
}
