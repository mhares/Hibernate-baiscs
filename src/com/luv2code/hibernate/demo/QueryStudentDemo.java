package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                      .configure()
                                      .addAnnotatedClass(Student.class)
                                      .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            displayStudent(theStudents);

            System.out.println(); System.out.println(); System.out.println();
            System.out.println("Another Query");
            theStudents = session.createQuery("from Student s where s.lastName='Darby'").getResultList();

            displayStudent(theStudents);

            System.out.println(); System.out.println(); System.out.println();
            System.out.println("Another Query");
            theStudents = session.createQuery("from Student s where s.lastName='Darby' OR s.firstName='Yara'").getResultList();

            displayStudent(theStudents);
            session.getTransaction().commit();

        }finally {
          session.close();
        }

    }

    private static void displayStudent(List<Student> theStudents) {
        for ( Student tempStudent: theStudents) {
            System.out.println(tempStudent);
        }
    }
}
