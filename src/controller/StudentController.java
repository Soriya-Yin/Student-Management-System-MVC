package controller;

import entities.Student;
import exception.StudentException;
import model.dao.StudentDao;
import model.dto.StudentRequestDto;
import model.dto.StudentResponseDto;
import model.service.StudentService;
import view.StudentView;

import java.util.InputMismatchException;
import java.util.Scanner;
import static db.StudentDb.studentsList;

public class StudentController {

    private final StudentView view;
    private final StudentService service;
    private final StudentDao dao;

    public StudentController(StudentView view, StudentService service, StudentDao dao) {
        this.view = view;
        this.service = service;
        this.dao = dao;
    }

    public void create() {
        try {
            StudentRequestDto request = view.displayStudentCreateDto();
            StudentResponseDto response = service.createStudent(request);
            assert response != null;
            view.displaySingleStudent(response);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showAll() {
//        view.displayStudentList(
//                service.getAllStudents(3, 2)
//        );
        Scanner scanner =  new Scanner(System.in);

        try {

            System.out.print("Enter limit of the data that you want to display: ");
            
            int limit = scanner.nextInt();
            int pageNumber = 1;

            int totalPages = (studentsList.size() + limit - 1) / limit;

            while (true) {

                int offset = (pageNumber - 1) * limit;

                view.displayStudentList(

                        service.getAllStudents(offset, limit)

                );
                System.out.println("Page " + pageNumber + " of " + totalPages);

                view.displayPage();

                System.out.print("Choose option: ");
                int option = scanner.nextInt();

                if (option == 1) {
                    pageNumber = service.updatePageNumber(pageNumber + 1, totalPages);

                } else if (option == 2) {
                    pageNumber = service.updatePageNumber(pageNumber - 1, totalPages);

                } else if (option == 0) {
                    break;
                }
            }
        }
        catch (InputMismatchException e){

            System.out.println("Please input number only");
        }
    }

    public void delete() {
        Long id = view.showIdInput();
        if (service.deleteById(id)) {
            System.out.println("[+] Student deleted successfully");
        } else {
            System.out.println("[+] Student fail to deleted");

        }
    }

    public void update() {
        try {
            Long id = view.showIdInput();
            StudentRequestDto requestDto = view.displayStudentCreateDto();
            Student student = dao.updateById(id, requestDto);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

        public void run () {
            while (true) {

                int option = view.showMenuAndGetOption();

                switch (option) {
                    case 1 -> create();
                    case 2 -> showAll();
                    case 3 -> delete();
                    case 4 -> update();
                    case 0 -> {
                        System.out.println("System exiting");
                        System.exit(0);
                    }
                }
            }
        }
    }

