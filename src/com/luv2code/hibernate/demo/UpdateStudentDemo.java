package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                      .configure()
                                      .addAnnotatedClass(Student.class)
                                      .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
          int studentId=8;

            session.beginTransaction();
            Student theStudent= session.get(Student.class,studentId);
            System.out.println(theStudent);
            theStudent.setLastName("Abdo");

            session.getTransaction().commit();

            System.out.println(theStudent);


            // new code
             session = factory.getCurrentSession();
             session.beginTransaction();
             session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();

        }finally {
          session.close();
        }

    }
}
