package view;

import model.dto.StudentRequestDto;
import model.dto.StudentResponseDto;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentView {

    private final static Scanner scanner = new Scanner(System.in);

    public StudentRequestDto displayStudentCreateDto() {
        System.out.println("[+] Enter Full Name: ");
        String fullName = scanner.nextLine();
        System.out.println("[+] Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.println("[+] Enter Date of Birth(Fornat: YYYY-MM-DD ): ");
        String dob = scanner.nextLine();

        String[] parts = dob.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        LocalDate localDate = LocalDate.of(year, month, day);

        return new StudentRequestDto(fullName, gender, localDate);
    }

    public void displaySingleStudent(StudentResponseDto responseDto) {
        Table table = new Table(
                4, BorderStyle.CLASSIC
        );
        table.addCell("Student Information", new CellStyle(CellStyle.HorizontalAlign.center), 4);
        table.addCell("ID");
        table.addCell(responseDto.id().toString(), 3);
        table.addCell("Full Name");
        table.addCell(responseDto.fullName(), 3);
        table.addCell("Gender");
        table.addCell(responseDto.gender(), 3);
        table.addCell("Date of Birth");
        table.addCell(responseDto.dateOfBirth().toString(), 3);

        System.out.println(table.render());

    }

    public void displayStudentList(List<StudentResponseDto> students){
        Table table = new Table(
                4,BorderStyle.CLASSIC
        );
        String[] columns = {"ID","Full Name","Gender","Birth of Date"};
        for(String column : columns){
            table.addCell(column);
        }

        students.forEach(student ->{
            table.addCell(student.id().toString());
            table.addCell(student.fullName());
            table.addCell(student.gender());
            table.addCell(student.dateOfBirth().toString());

        });
        System.out.println(table.render());
    }

    public Long showIdInput(){
        System.out.print("[+] Enter Student ID: ");
        return Long.parseLong(scanner.nextLine());
    }

    public int showMenuAndGetOption() {
        System.out.println ("""
                    1.Create Student Data
                    2.Show Student Data
                    3.Delete Student Data
                    4.Update Student Data
                    0.Exit
                    """);
        System.out.print("Please Choose an Option: ");

        return Integer.parseInt(scanner.nextLine());
    }
}
