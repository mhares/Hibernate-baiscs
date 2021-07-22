package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class CreateStudentDemo {
    public static void main(String[] args) throws ParseException {
        SessionFactory factory = new Configuration()
                                      .configure()
                                      .addAnnotatedClass(Student.class)
                                      .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            String theDateOfBirthStr = "31/12/1998";

            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);

            Student tempStudent = new Student("Pauly", "Doe", "paul@luv.com", theDateOfBirth);

            session.beginTransaction();

            session.save(tempStudent);

            System.out.println(tempStudent);
            session.getTransaction().commit();

        }finally {
          session.close();
        }

    }
}
