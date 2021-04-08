package com.Servlet;


import com.utility.Emp;
import com.dao.EmpDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "SaveServlet",
    urlPatterns = {"/SaveServlet"}
)
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String s1 = request.getParameter("salary");
        int salary = Integer.parseInt(s1);
        String city = request.getParameter("city");


        Emp e=new Emp();
        e.setName(name);
        e.setEmail(email);
        e.setSalary(salary);
        e.setCity(city);

        int status= EmpDao.save(e);
        if(status>0){
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }else{
            out.println("Sorry! unable to save record");
        }

        out.close();
    }

}