package controller;

import entities.Student;
import exception.StudentException;
import model.dao.StudentDao;
import model.dto.StudentRequestDto;
import model.dto.StudentResponseDto;
import model.service.StudentService;
import view.StudentView;

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
            view.displaySingleStudent(response);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showAll() {
        view.displayStudentList(
                service.getAllStudents(3, 2)
        );
    }

    public void delete() {
        Long id = view.showIdInput();
//        service.deleteById(id);
        if (service.deleteById(id)) {
            System.out.println();
            System.out.println("[+] Student deleted successfully");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("[+] Student could not be deleted");
            System.out.println();
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

