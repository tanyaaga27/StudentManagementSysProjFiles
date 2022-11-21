<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.google.appengine.api.datastore.Query"%>
     <%@page import="com.google.appengine.api.datastore.PreparedQuery"%>
     <%@page import="com.google.appengine.api.datastore.*"%>
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
    <% String name = request.getParameter("fname");%>
    <h3>Showing results for <%=name %></h3>
    <%
    DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
    Query query = new Query("student").addFilter("FirstName", Query.FilterOperator.EQUAL,name).addSort("RollNo", Query.SortDirection.ASCENDING);
    PreparedQuery pq = ds.prepare(query);
    %>
    <table>
    <tr>
    <th>Name</th>
    <th>Roll No.</th>
    <th>Physics</th>
    <th>Chemistry</th>
    <th>Maths</th>
    <% for(Entity e1 : pq.asIterable()) {%>
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
