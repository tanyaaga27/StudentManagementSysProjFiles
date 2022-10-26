package com.StudentManagementSystem;

import com.google.appengine.api.datastore.*;
import com.google.appengine.repackaged.com.google.datastore.v1.PropertyFilter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/search")
public class seachResultServlet extends HttpServlet {

    DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        String name = req.getParameter("fname");


        Query query = new Query("student").addFilter("FirstName", Query.FilterOperator.EQUAL,name).addSort("RollNo", Query.SortDirection.ASCENDING);

        PreparedQuery pq = ds.prepare(query);
        for(Entity e1 : pq.asIterable())
        {
            try {

                    String fname = e1.getProperty("FirstName").toString();
                    String lname = e1.getProperty("LastName").toString();
                    String rollnum = e1.getProperty("RollNo").toString();
                    String phy = e1.getProperty("Physics").toString();
                    String chem = e1.getProperty("Chemistry").toString();
                    String maths = e1.getProperty("Maths").toString();

                out.println("Name:" + fname + " " + lname);
                out.println("Roll No.:" + rollnum);
                out.println("Physics:" + phy);
                out.println("Chemistry:" + chem);
                out.println("Maths:" + maths);
            }catch(NullPointerException e)
            {
                out.println("Empty fields not allowed!");
                out.println("<a href='index.html'>Try Again</a>");
            }


        }
    }
}
