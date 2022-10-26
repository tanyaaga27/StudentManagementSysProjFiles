package com.StudentManagementSystem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class registerServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        boolean flag;
        PrintWriter out = res.getWriter();
        if(req.getParameter("fname").equals(""))
        {
            out.println("<h3>Name cannot be Empty</h3>");
            return;
        }
        String fname = req.getParameter("fname");
        if(req.getParameter("lname").equals(""))
        {
            out.println("ERROR : Name cannot be Empty");
            return;
        }
        String lname = req.getParameter("lname");
        if(req.getParameter("rollnum")==null)
        {
            out.println("<h3>Roll No. cannot be Empty</h3>");
            return;
        }
        String rollnum = req.getParameter("rollnum");
        String phy = req.getParameter("phy");
        String chem = req.getParameter("chem");
        String maths = req.getParameter("math");

        flag = UserOps.createOrUpdateUser(fname,lname,rollnum,phy,chem,maths);

        if(flag)
        {
            out.println("<h1>Successfully Registered!</h1><br>");
            out.println("<a href='index.html'>Go To Home Page</a>");

        }
        else
        {
            out.println("<a href ='/details.html'>Try Again!</a>");
        }


    }
}
