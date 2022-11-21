<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.google.appengine.api.datastore.Query"%>
     <%@page import="com.google.appengine.api.datastore.PreparedQuery"%>
     <%@page import="com.google.appengine.api.datastore.*"%>
     <%@page import="java.lang.*"%>
     <%@page import="com.StudentManagementSystem.UserOps"%>
     <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
    table, th, td{
    border:1px solid black;
    }
    table {
      margin-left: auto;
      margin-right: auto;
      border-collapse: collapse;
    }
    </style>
    </head>
    <body style="text-align:center;">
    <% Iterable<Entity> e = UserOps.listOfUsers(); %>

    <table>
    <tr>
    <th>Name</th>
    <th>Roll No.</th>
    <th>Physics</th>
    <th>Chemistry</th>
    <th>Maths</th>
    </tr>
    <% for(Entity e1 : e) {%>
    <tr>
    <td><%=e1.getProperty("FirstName").toString() %> <%=e1.getProperty("LastName").toString() %></td>
    <td><%=e1.getProperty("RollNo").toString() %> </td>
    <td><%=e1.getProperty("Physics").toString() %> </td>
    <td><%=e1.getProperty("Chemistry").toString() %> </td>
    <td><%=e1.getProperty("Maths").toString() %> </td>
    </tr>
    <% } %>
    </tr>
    </table>

    </body>
    </html>