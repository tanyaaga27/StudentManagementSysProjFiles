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
            //System.out.println(e1);
            String fname = e1.getProperty("FirstName").toString();
            String lname = e1.getProperty("LastName").toString();
            String rollnum = e1.getProperty("RollNo").toString();
            String phy = e1.getProperty("Physics").toString();
            String chem = e1.getProperty("Chemistry").toString();
            String maths = e1.getProperty("Maths").toString();
            out.println("\nName:"+fname+" "+lname+"\n"+"Roll No.:"+rollnum+"\n"+"Physics:"+phy+"\n"+"Chemistry:"+chem+"\n"+"Maths:"+maths+"\n");
        }



    }
}
