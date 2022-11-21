package com.StudentManagementSystem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginverify")
public class loginVerifyServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        PrintWriter out = res.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if(email.equals(""))
        {
            out.println("Email Cannot Be Empty.");
            return;
        }
        if(password.equals(""))
        {
            out.println("Please provide password.");
            return;
        }
        Filter emailFilter = new FilterPredicate("email", Query.FilterOperator.EQUAL, email);
        Filter passwordFilter = new FilterPredicate("password", Query.FilterOperator.EQUAL, password);

        Query.CompositeFilter compFilter= Query.CompositeFilterOperator.and(emailFilter,passwordFilter);

        Query q = new Query("userLogin").setFilter(compFilter);

        PreparedQuery pq = datastore.prepare(q);

        int count=0;
        for(Entity ent : pq.asIterable())
        {
            count++;
        }
        if(count>0)
        {
            RequestDispatcher rd = req.getRequestDispatcher("afterLogin.html");
            rd.forward(req, res);

        }
        else
        {
            out.print("<html><body><h2>User does not exist</h2><br>");
            out.print("<a href='registerUser.html'>Register Here</a><br>");
            out.print("<a href='index.html'>Go to Home Page</a></body></html>");

        }



    }

}
