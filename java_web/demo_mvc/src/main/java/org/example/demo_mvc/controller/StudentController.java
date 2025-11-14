package org.example.demo_mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo_mvc.entity.Student;
import org.example.demo_mvc.service.ClassService;
import org.example.demo_mvc.service.IClassService;
import org.example.demo_mvc.service.IStudentService;
import org.example.demo_mvc.service.StudentService;

import java.io.IOException;

@WebServlet(name = "studentController", value = "/students")
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentService();
    private IClassService classService = new ClassService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                showFormAdd(req,resp);
                break;
            case "delete":
                break;
            default:
                showList(req,resp);

        }


    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("studentList", studentService.findAll());
        try {
            req.getRequestDispatcher("/view/student/list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("studentList", studentService.findAll());
        req.setAttribute("classList", classService.findAll());
        try {
            req.getRequestDispatcher("/view/student/add.jsp").forward(req,resp);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                save(req,resp);
                break;
            case "delete":
                break;
            default:


        }

    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        float score = Float.parseFloat(req.getParameter("score"));
        int classId = Integer.parseInt(req.getParameter("classId"));
        Student student = new Student(name,gender,score,classId);
        studentService.add(student);
        showList(req,resp);
    }
}
