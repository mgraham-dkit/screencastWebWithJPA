package com.example.screencastwebwithjpa;

import java.io.*;
import java.util.List;

import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.EmployeeRepository;
import repositories.EmployeeRepositoryInterface;

@WebServlet(name = "controller", urlPatterns = "/controller")
public class HelloServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EmployeeRepositoryInterface dao = new EmployeeRepository(entityManager);

        List<Employee> employeeList = dao.getAllEmployees();
        HttpSession session = request.getSession();
        session.setAttribute("employeeList", employeeList);

        response.sendRedirect("result.jsp");
    }

    public void destroy() {
    }
}