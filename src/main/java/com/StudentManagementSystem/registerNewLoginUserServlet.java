package com.StudentManagementSystem;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerNewUser")
public class registerNewLoginUserServlet extends HttpServlet {

    DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        Entity newUser = new Entity("userLogin");
        if(req.getParameter("fname").length()==0||req.getParameter("lname").length()==0||req.getParameter("email").length()==0||req.getParameter("password").length()==0)
        {
            out.println("<html><body>No Empty fields allowed!<br>");
            out.println("<a href ='registerUser.html'>Try Again</a></body></html>");

        }
        else if(req.getParameter("password").length()<4)
        {
            out.print("Length of the password should be 4 or more!");
        }
        else {
            newUser.setProperty("FirstName", req.getParameter("fname"));
            newUser.setProperty("LastName", req.getParameter("lname"));
            newUser.setProperty("email", req.getParameter("email"));
            newUser.setProperty("password", req.getParameter("password"));
            ds.put(newUser);

            out.print("<html><body><h2>Successfully Registered</h2><br>");
            out.print("<a href='afterLogin.html'>Go to Main Page</a><br>");
            out.print("<a href='index.html'>Go to Home Page</a></body></html>");
        }

    }

}
