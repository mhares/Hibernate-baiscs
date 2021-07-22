package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                      .configure()
                                      .addAnnotatedClass(Student.class)
                                      .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
          int studentId=2;
            session.beginTransaction();
           // Student theStudent= session.get(Student.class,studentId);
         //   System.out.println(theStudent);

            //session.delete(theStudent);
            session.createQuery("delete from Student where id=3").executeUpdate();
            session.getTransaction().commit();

        }finally {
          session.close();
        }

    }
}
