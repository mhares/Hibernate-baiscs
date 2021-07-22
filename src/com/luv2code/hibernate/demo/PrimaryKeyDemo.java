package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Student tempStudent1 = new Student("mostafa","hares","mostafahares698@gamil.com");
            Student tempStudent2 = new Student("Mohamed","hares","mohamedhares@gamil.com");
            Student tempStudent3 = new Student("Yara","shaban","yarashaban@gamil.com");

            session.beginTransaction();

            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();

        }finally {
            session.close();
        }

    }
}
