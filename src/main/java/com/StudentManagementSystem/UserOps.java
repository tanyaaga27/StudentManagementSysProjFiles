package com.StudentManagementSystem;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;

public class UserOps {
    static DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

    public static boolean createOrUpdateUser(String fname, String lname, String rollnum,String phy,String chem,String maths)
    {

        //System.out.println("In create or update user!");
        Entity stud = new Entity("student",rollnum);
        stud.setProperty("FirstName", fname);
        stud.setProperty("LastName", lname);
        stud.setProperty("RollNo", rollnum);
        stud.setProperty("Physics", phy);
        stud.setProperty("Chemistry", chem);
        stud.setProperty("Maths", maths);
        ds.put(stud);
        //System.out.println("The datastore"+ds.put(stud));
        //System.out.println("The key is:"+stud.getKey()+" The kind is:"+stud.getKind());
        return true;

    }
    public static Iterable<Entity> listOfUsers()
    {
        Query q = new Query("student").addSort("RollNo", Query.SortDirection.ASCENDING);
        Iterable<Entity> list = ds.prepare(q).asIterable();
        return list;
    }
}
