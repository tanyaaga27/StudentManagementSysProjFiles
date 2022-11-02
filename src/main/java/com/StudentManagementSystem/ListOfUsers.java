package com.StudentManagementSystem;

import com.google.appengine.api.datastore.Entity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ListOfUsers")
public class ListOfUsers extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        Iterable<Entity> e = UserOps.listOfUsers();
        for(Entity e1 : e)
        {
            String fname = e1.getProperty("FirstName").toString();
            String lname = e1.getProperty("LastName").toString();
            String rollnum = e1.getProperty("RollNo").toString();
            String phy = e1.getProperty("Physics").toString();
            String chem = e1.getProperty("Chemistry").toString();
            String maths = e1.getProperty("Maths").toString();
            out.print("<html><p>Name:");
            out.print(fname+" "+lname+"</p>");
            //out.println("<br>");
            out.print("<html><p>Roll No.:");
            out.print(rollnum+"</p>");
            //out.println("<br>");
            out.print("<html><p>Physics:");
            out.print(phy+"</p>");
            //out.println("<br>");
            out.print("<html><p>Chemistry:");
            out.print(chem+"</p>");
            //out.println("<br>");
            out.print("<html><p>Maths:");
            out.print(maths+"</p>");
            //out.println("<br>");
            out.print("</html>");

        }



    }
}
