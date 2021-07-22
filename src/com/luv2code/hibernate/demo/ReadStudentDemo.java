package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                      .configure()
                                      .addAnnotatedClass(Student.class)
                                      .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Student tempStudent = new Student("Chad","Darby","chaddarby@gamil.com");

            session.beginTransaction();

            session.save(tempStudent);

            session.getTransaction().commit();


            // new code
             session = factory.getCurrentSession();
            session.beginTransaction();

            Student student = session.get(Student.class,tempStudent.getId());

            System.out.println(student);

            session.getTransaction().commit();

            System.out.println("DONE!!!!");


        }finally {
          session.close();
        }

    }
}
