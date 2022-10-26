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
                String phy;
                String chem;
                String maths;
                if(e1.getProperty("Physics")!=null)
               {
                   phy = e1.getProperty("Physics").toString();
               }
               else
               {
                   phy=null;
               }if(e1.getProperty("Chemistry")!=null)
            {
                chem = e1.getProperty("Chemistry").toString();
            }
            else
            {
                chem=null;
            }
            if(e1.getProperty("Maths")!=null)
            {
                maths = e1.getProperty("Maths").toString();
            }
            else {
                maths = null;
            }

            out.println("Name:"+fname+" "+lname);
            out.println("Roll No.:"+rollnum);
            out.println("Physics:"+phy);
            out.println("Chemistry:"+chem);
            out.println("Maths:"+maths);

        }



    }
}
