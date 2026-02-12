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
//        System.out.println("[+] Enter Full Name: ");
//        String fullName = scanner.nextLine();
//        System.out.println("[+] Enter Gender: ");
//        String gender = scanner.nextLine();
//        System.out.println("[+] Enter Date of Birth(Fornat: YYYY-MM-DD ): ");
//        String dob = scanner.nextLine();
//
//        String[] parts = dob.split("-");
//        int year = Integer.parseInt(parts[0]);
//        int month = Integer.parseInt(parts[1]);
//        int day = Integer.parseInt(parts[2]);
//        LocalDate localDate = LocalDate.of(year, month, day);
//
//        return new StudentRequestDto(fullName, gender, localDate);
        String fullName="" ;
        String gender="";
        LocalDate dateOfBirth = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("[+] Enter Full Name: ");
            fullName = scanner.nextLine();
            if (!fullName.isBlank() && fullName.matches("^[a-zA-Z\\s]+$")) {
                validInput = true;
            } else {
                System.out.println("Invalid! Name must be letters only and not empty.");
            }
        }

        validInput = false;
        while (!validInput) {
            System.out.print("[+] Enter Gender (male/female): ");
            gender = scanner.nextLine().toLowerCase().trim();
            if (gender.equals("male") || gender.equals("female")) {
                validInput = true;
            } else {
                System.out.println("Invalid! Please enter 'male' or 'female'.");
            }
        }


        validInput = false;
        while (!validInput){
            try{
                System.out.print("[+] Enter Date Of Birth(Format yyyy-mm-dd: ");
                String dob = scanner.nextLine();
                String[] parts = dob.split("-");
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int day = Integer.parseInt(parts[2]);
                dateOfBirth = LocalDate.of(year, month, day);
                validInput = true;
            } catch (Exception e){
                System.out.println("Invalid input! ");
                System.out.println("Please input date");
            }
        }


        return new StudentRequestDto(
                fullName, gender, dateOfBirth
        );
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
    public void displayPage(){
        System.out.println("""
                1. Next Page
                2. Previous Page
                0. Back to Main
                """);
    }
    public Long showIdInput(){
        while (true){
            try{
                System.out.print("[+] Enter Student ID: ");
                return Long.parseLong(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Invalid input please try again.");
            }
        }

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

        while (true) {

            try {

                System.out.print("Choose an Option: ");

                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Invalid input! Please input number" + e);
            }
        }
    }

}
