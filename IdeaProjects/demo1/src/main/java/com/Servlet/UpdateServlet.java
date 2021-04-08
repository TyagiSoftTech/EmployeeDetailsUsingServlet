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
    name = "UpdateServlet",
    urlPatterns = {"/UpdateServlet"}
)
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String s1=request.getParameter("salary");
        int salary = Integer.parseInt(s1);
        String city=request.getParameter("city");

        Emp e=new Emp();
        e.setId(id);
        e.setName(name);
        e.setEmail(email);
        e.setSalary(salary);
        e.setCity(city);

        int status= EmpDao.update(e);
        if(status>0){
            response.sendRedirect("ViewServlet");
        }else{
            out.println("Sorry! unable to update record");
        }

        out.close();
    }

}